package a.greedy.dijkstar;

import java.util.HashSet;
import java.util.Set;

public class Graph
{
	private Set<Node> nodes = new HashSet<>();
	
	
	public void addNode(Node node)
	{
		nodes.add(node);
	}
	
	
	public Set<Node> nodes()
	{
		return nodes;
	}
	
	
	public void print()
	{
		for ( Node node : nodes )
			System.out.println(node);
	}
}
