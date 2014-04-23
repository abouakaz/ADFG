package acceleo.adfg.services;

import java.util.Iterator;

import org.eclipse.emf.common.util.EList;
import org.apache.commons.lang.StringUtils;

import adfg.Actor;
import adfg.InputPort;
import adfg.OutputPort;
import adfg.Port;
import adfg.Channel;
import adfg.LossyChannel;

public class ActorServices {

	public String ActorType(Actor actor){
		return StringUtils.capitalize(actor.getName());
	}
	
	public String getParameterNames(Actor actor){
		String res="";
		EList ports=actor.getPorts();
		Iterator it=ports.iterator();
		while(it.hasNext()){
			Port port=(Port)it.next();
			if(port instanceof OutputPort){
				OutputPort output=(OutputPort)port;
				if(output.getConnection()==null) res+=" ";
				else
				if(output.getConnection() instanceof Channel){
					res+="channel"+((Channel)output.getConnection()).getId();
				}
				else res+="lchannel"+((LossyChannel)output.getConnection()).getId();
			}
			else{
				InputPort input=(InputPort)port;
				if(input.getConnection()==null) res+=" ";
				else
				if(input.getConnection() instanceof Channel){
					res+="channel"+((Channel)input.getConnection()).getId();
				}
				else res+="lchannel"+((LossyChannel)input.getConnection()).getId();
			}
			if(it.hasNext()) res+=", ";
		}
		res="new Connection[]{"+res+"}";
		return res;
	}

}
