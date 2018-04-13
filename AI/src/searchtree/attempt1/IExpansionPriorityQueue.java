package searchtree.attempt1;

import java.util.List;

public interface IExpansionPriorityQueue<T>
{
	public void print();
	public void add(Node<T> node);
	public void add(List<Node<T>> nodes);
	public void remove(Node<T> node);
	public boolean isEmpty();
	public Node<T> nextExploreNode();
}
