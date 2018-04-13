package a.greedy.dijkstar;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Map.Entry;
import java.util.Set;

public class AGreddyDijkstar
{
	
	private AGreddyDijkstar() {}
	
	
	
	
	
	public enum SearchType
	{
		GREEDY,
		DIJKSTRA,
		A_Star;
	}
	
	
	
	public static void graphSearchGreedy(Graph graph, Node source, Node target)
	{
		graphSearch(SearchType.GREEDY, graph, source, target);
	}
	
	
	
	public static void graphSearchDijkstra(Graph graph, Node source, Node target)
	{
		graphSearch(SearchType.DIJKSTRA, graph, source, target);
	}
	
	
	
	public static void graphSearchAStar(Graph graph, Node source, Node target)
	{
		graphSearch(SearchType.A_Star, graph, source, target);
	}
	
		
	
	public static void graphSearch(SearchType searchType, Graph graph, Node source, Node target)
	{		
		// when a node gets popped from the graph its children go here
		Set<Node> exploreCandidates = new HashSet<>(); 
		
		// when a candidate is visited it is moved here (updates are still possible in case that nodes is reached again with lower cost)
		// also often called closed list (although it's actually a set)
		Set<Node> exploredNodes = new LinkedHashSet<>();	
					
		
		Node currentNode;
		Node adjacentNode;
		int adjacentCost;	// edge cost to the neighbor! 		

		exploreCandidates.add(source);
		
		do
		{			
			currentNode = nextLeastCostNode(exploreCandidates);										// pick least cost candidate from list and
			exploreCandidates.remove(currentNode);													// remove from it
			exploredNodes.add(currentNode);															// add him to "already visited" list
			
			if ( target != null && currentNode.equals(target) )
			{
				currentNode.shortestPath().addLast(currentNode);
				return;
			}
			
			for ( Entry<Node, Integer> adjacent : currentNode.adjacentNodes().entrySet() )			// for every of his child nodes
			{
				adjacentNode = adjacent.getKey();
				adjacentCost = adjacent.getValue();
				
				if ( !exploredNodes.contains(adjacentNode) )										// if current child is not explored
				{
					exploreCandidates.add(adjacentNode);											// then make it a candidate
					minimumCostToAdjacent(currentNode, adjacentNode, adjacentCost, searchType);		// and calculate the cost to that child node
				}
			}
		}
		while ( exploreCandidates.size() != 0 );
		
		
		// Append last node in path if the path is not empty
		LinkedList<Node> shortestPathToNode;
		for ( Node node : graph.nodes() )
		{
			shortestPathToNode = node.shortestPath();
			if ( shortestPathToNode.size() != 0 )
			{
				shortestPathToNode.addLast(node);
			}
		}
	}
	
	
	
	private static void minimumCostToAdjacent(Node currentNode, Node adjacentNode, int adjacentCost, SearchType searchType)
	{		
		int new_g = currentNode.f() - currentNode.h() + adjacentCost;
		
		if
		(
			(
				(searchType == SearchType.A_Star || searchType == SearchType.DIJKSTRA)
				&&
				new_g < adjacentNode.g()
			)
			||
			(
				searchType == SearchType.GREEDY
				&&
				adjacentNode.h() < currentNode.h()
			)
		)
		{
			if ( searchType == SearchType.A_Star || searchType == SearchType.DIJKSTRA )
				adjacentNode.g(new_g);
			
			LinkedList<Node> newShortestPathToAdjacentNode = new LinkedList<>(currentNode.shortestPath());
			newShortestPathToAdjacentNode.addLast(currentNode);
			adjacentNode.shortestPath(newShortestPathToAdjacentNode);
		}
	}
	
	
	
	private static Node nextLeastCostNode(Set <Node> exploreCandidates)
	{
	    Node leastCostNode = null;
	    int leastCostNodeCost = Integer.MAX_VALUE;
	    
	    for ( Node node: exploreCandidates )
	    {
	        int nodeDistance = node.f();
	        if ( nodeDistance < leastCostNodeCost )
	        {
	            leastCostNodeCost = nodeDistance;
	            leastCostNode = node;
	        }
	    }
	    
	    return leastCostNode;
	}
	
}
