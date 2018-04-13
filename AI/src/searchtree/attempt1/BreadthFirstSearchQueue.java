package searchtree.attempt1;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class BreadthFirstSearchQueue<T> implements IExpansionPriorityQueue<T>
{

	private LinkedList<Node<T>> q;
	
	{
		q = new LinkedList<>();
	}
	
	
	@Override
	public void add(Node<T> node)
	{
		q.offerFirst(node);		
	}

	
	@Override
	public void add(List<Node<T>> nodes)
	{
		for ( Node<T> n : nodes )
			q.offerFirst(n);
	}

	
	@Override
	public void remove(Node<T> node)
	{
				
	}

	
	@Override
	public boolean isEmpty()
	{
		return q.isEmpty();
	}

	
	@Override
	public Node<T> nextExploreNode()
	{
		return q.pollFirst();
	}
	
	
	
	
	@Override
	public void print()
	{
		System.out.println(Arrays.toString(q.toArray()));
	}
}
