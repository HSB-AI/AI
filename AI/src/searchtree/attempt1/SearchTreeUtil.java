package searchtree.attempt1;

import java.util.Set;

public final class SearchTreeUtil
{	
	private SearchTreeUtil() {}

//	/*TODO: return path instead of node*/
//	public static <T> Node<T> treeSearch(Node<T> root, IExpansionPriorityQueue queue, IState<T> goalState)
//	{
//		Node<T> nextExploreNode;
//		
//		while ( true )
//		{
//			if ( root.childs == null )
//				return null;
//					
//			queue.add(root.childs);
//			
//			nextExploreNode = queue.nextExploreNode();
//			
//			if ( root.state.equals(goalState) )
//				return root;	
//			else
//				
//		}
//	}
	
	
	/*TODO: return path instead of node*/
	public static <T> void treeSearch(IExpansionPriorityQueue<T> queue, Set<Node<T>> closed, Node<T> goalState)
	{
		queue.print();
		
		if ( queue.isEmpty() )
			return;
		 
        Node<T> nextExploreNode = queue.nextExploreNode();
        
        System.out.println("nextExploreNode: " + nextExploreNode);
 
        if ( nextExploreNode.equals(goalState) )
        	return;
        
        if ( !closed.contains(nextExploreNode) )
        {
        	closed.add(nextExploreNode);
        	if ( nextExploreNode.childs != null )
        		queue.add(nextExploreNode.childs);
        }
 
        treeSearch(queue, closed, goalState);
	}
	
}
