package acceleo.adfg.services;

import adfg.Channel;
import adfg.Connection;
import adfg.InputPort;
import adfg.OutputPort;
import adfg.Port;

public class PortServices {
	
	static public String portType(Port port){
		Class type=port.getType();
		return (type==null)?"Capsule":type.getSimpleName();
	}
	
	static public boolean connectionType(Port port){
		Connection connection=null;
		if(port instanceof OutputPort) 
			connection=((OutputPort) port).getConnection();
		else connection=((InputPort)port).getConnection();
		return (connection instanceof Channel)? true:false;
	}

	
}
