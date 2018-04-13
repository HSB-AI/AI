package searchtree.attempt1;

import java.util.HashSet;

public class BreadthFirstSearch
{

	public static void main(String[] args)
	{
		Node<String> S = new Node<>(new StringState("S"));		
		Node<String> G = new Node<>(new StringState("G"));
		
		
		Node<String> a = new Node<>(new StringState("a"));
		Node<String> b = new Node<>(new StringState("b"));
		Node<String> c = new Node<>(new StringState("c"));
		Node<String> d = new Node<>(new StringState("d"));
		Node<String> e = new Node<>(new StringState("e"));
		Node<String> f = new Node<>(new StringState("f"));
		Node<String> h = new Node<>(new StringState("h"));
		Node<String> p = new Node<>(new StringState("p"));
		Node<String> q = new Node<>(new StringState("q"));
		Node<String> r = new Node<>(new StringState("r"));
		
		
		S.childs.add(d);
		S.childs.add(e);
		S.childs.add(p);
				
		
		b.childs.add(a);
		
		c.childs.add(a);			
		
		d.childs.add(b);
		d.childs.add(c);
		d.childs.add(e);
		
		e.childs.add(h);
		e.childs.add(r);
		
		f.childs.add(c);
		f.childs.add(G);
		
		h.childs.add(q);	
	
		p.childs.add(q);
		
		r.childs.add(f);
		
		
		BreadthFirstSearchQueue<String> queue = new BreadthFirstSearchQueue<>();
		queue.add(S);
		SearchTreeUtil.treeSearch(queue, new HashSet<>(), G);
		
//		queue.print();
	}

}
