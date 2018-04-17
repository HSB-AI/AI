package a.greedy.dijkstar;

import java.util.HashMap;
import java.util.LinkedList;

public class Node
{
	
	/******************************************************************************************
	 * 	MEMEBERS
	 *****************************************************************************************/
	
	private String name;
	
	private int g;									// sum of edge costs to this node
	
	private int h;									// heuristic
	
	private HashMap<Node, Integer> adjacentNodes;	// adjacent nodes and their edge costs (g) to them
	
	private LinkedList<Node> shortestPath;			// shortest path to THIS node (from the source node that was used)
		
	


	/******************************************************************************************
	 * 	CONSTRUCTORS
	 *****************************************************************************************/	
	
	
	private Node(String name, int h, boolean source)		// A* node constructor
	{
		this.name = name;
		this.g = source ? 0 : Integer.MAX_VALUE;
		this.h = h;
	}
	
	
	
	
	// Greedy node getter
	public static Node greedy(String name, int h)
	{
		return new Node(name, h, true);
	}
	
	
	
	
	// Dijkstra node getter for non-source nodes
	public static Node dijkstra(String name)
	{
		return new Node(name, 0, false);
	}
	
	// Dijkstra node getter
	public static Node dijkstra(String name, boolean source)
	{
		return new Node(name, 0, source);
	}
	
	
	
	
	// A* node getter for non-source-nodes	
	public static Node aStar(String name, int h)
	{
		return new Node(name, h, false);
	}
	
	// A* node getter
	public static Node aStar(String name, int h, boolean source)
	{
		return new Node(name, h, source);
	}
	
	
	
	
	// Initialization-Block (executes after implicit super-call in constructor)
	// these collections are always required so they are initialized
	// regardless of which constructor was used to create the node
	{
		adjacentNodes = new HashMap<>();
		shortestPath = new LinkedList<>();
	}

	
	
	
	/******************************************************************************************
	 * 	METHODS
	 *****************************************************************************************/
	
	public String name()
	{
		return name;
	}
	
	
	public void g(int g)
	{
		this.g = g;
	}
	
	
	public int g()
	{
		return g;
	}
	
	
	// heuristics are not changeable
	public int h()
	{
		return h;
	}
	
	
	public int f()
	{
		return  g + h;
	}
	
	
	public HashMap<Node, Integer> adjacentNodes()
	{
		return adjacentNodes;
	}
			
	
	// add OR update if present!
	public void putAdjacent(Node node, int g)	// for Dijkstra & A* (both use edges costs)
	{
		adjacentNodes.put(node, g);
	}
	
	
	public void putAdjacent(Node node)			// for Greedy (uses only heuristics, cost to neighbors doesn't matter)
	{
		adjacentNodes.put(node, 0);
	}
	
	
	public LinkedList<Node> shortestPath()
	{
		return shortestPath;
	}
	
	
	public void shortestPath(LinkedList<Node> shortestPath)
	{
		this.shortestPath = shortestPath;
	}
	
		
	
	
	/******************************************************************************************
	 * 	COLLECTIONS FRAMEWORK COMPATIBILITY & PRINTABLILITY
	 *****************************************************************************************/
	
	@Override
	public boolean equals(Object node)
	{
		return name.equals(((Node)node).name);
	}
	
	
	@Override
	public int hashCode()
	{
		return name.hashCode();
	}
	
	
	@Override
	public String toString()
	{
		StringBuilder sb = new StringBuilder();
		
		sb.append("shortest path of " + name + ": ");
		for ( Node node : shortestPath )
			sb.append(node.name + " ");		
		
		return sb.toString();
	}
	
}
