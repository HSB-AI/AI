package a_greedy_dijkstar;

import a_greedy_dijkstar.AGreddyDijkstar.SearchType;
import a_greedy_dijkstar.entities.Graph;
import a_greedy_dijkstar.entities.Node;

public class TestGraphs {

	public static void main(String[] args)
	{
		dequeueGoalStopTestGraph();
		aStarTest();
	}

	
	
	private static void dequeueGoalStopTestGraph()
	{
		Node s = Node.aStar("s", 3, true);
		Node a = Node.aStar("a", 2);
		Node b = Node.aStar("b", 1);
		Node g = Node.aStar("g", 0);
		
		s.putAdjacent(a, 2);
		s.putAdjacent(b, 2);	

		a.putAdjacent(g, 2);
		
		b.putAdjacent(g, 3);
		
		Graph graph = new Graph();		
		graph.addNode(s);
		graph.addNode(a);
		graph.addNode(b);
		graph.addNode(g);
		
		AGreddyDijkstar.graphSearch(SearchType.A_Star, graph, s, null);
		System.out.println("--- Stop on goal dequeue test ----------------------");
		graph.print();
	}
	
	
	private static void aStarTest()
	{
		Node s = Node.aStar("s", 7, true);
		Node a = Node.aStar("a", 6);
		Node b = Node.aStar("b", 4);
		Node c = Node.aStar("c", 2);
		Node g = Node.aStar("g", 0);
		
		s.putAdjacent(a, 1);
		s.putAdjacent(b, 4);
		
		a.putAdjacent(b, 2);
		a.putAdjacent(c, 5);
		a.putAdjacent(g, 12);
		
		b.putAdjacent(c, 2);
		
		c.putAdjacent(g, 3);
		
		Graph graph = new Graph();
		
		graph.addNode(s);
		graph.addNode(a);
		graph.addNode(b);
		graph.addNode(c);
		graph.addNode(g);
		
		AGreddyDijkstar.graphSearch(SearchType.A_Star, graph, s, null);
		System.out.println("--- A* test ----------------------");
		graph.print();
	}
	
}
