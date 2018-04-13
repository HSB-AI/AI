package searchtree.attempt1;

import java.util.ArrayList;
import java.util.List;

public class Node<T>
{
	IState<T> state;	
	List<Node<T>> childs;	
	
	public Node(IState<T> state)
	{
		this.state = state;
		childs = new ArrayList<Node<T>>();
	}
	
	@Override
	public boolean equals(Object obj)
	{
		Node<T> otherNode = (Node<T>) obj;
		
		return state.equals(otherNode.state);
	}
	
	
	
	
	
	
	@Override
	public int hashCode()
	{
		return state.hashCode();
	}
	
	@Override
	public String toString()
	{
		return state.toString(); 
	}	
}