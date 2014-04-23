package acceleo.adfg.services;

import adfg.Connection;;

public class ConnectionServices {

	public String dataType(Connection channel){
		Class type=channel.getSource().getType();
		return (type==null)?"Capsule":type.getName();
	}
	
}
