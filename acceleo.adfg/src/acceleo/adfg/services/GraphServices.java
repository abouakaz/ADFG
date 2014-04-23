package acceleo.adfg.services;

import org.apache.commons.lang.StringUtils;

import adfg.Graph;

public class GraphServices {

	public String GraphType(Graph graph){
		return StringUtils.capitalize(graph.getName());
	}
}
