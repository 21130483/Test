package student;

import java.util.Arrays;
import java.util.List;

public class TestAStar {
	public static void main(String[] args) {
		Node s = new Node("S", 8);
		Node b = new Node("B", 4);
		Node a = new Node("A", 4);
		Node c = new Node("C", 4);
		Node d = new Node("D", 3.5);
		Node e = new Node("E", 1);
		Node f = new Node("F", 1);
		Node g = new Node("G", 0);

		s.addEdge(b, 3);
		s.addEdge(a, 2);
		a.addEdge(c, 3);
		b.addEdge(d, 3);
		b.addEdge(c, 1);
		c.addEdge(e, 3);
		c.addEdge(d, 1);
		d.addEdge(f, 2);
		f.addEdge(g, 1);
		e.addEdge(g, 2);

		IInformedSearchAlgo greedy = new GreedyBestFirstSearchAlgo();
//		Node res = greedy.execute(s, g.getLabel());
//		Node res = greedy.execute(a, g.getLabel());
//		Node res = greedy.execute(s, a.getLabel(), g.getLabel());

		AStarSearchAlgo aStar = new AStarSearchAlgo();
//		Node res = aStar.execute(d, g.getLabel());
//		Node res = aStar.execute(s, b.getLabel(), g.getLabel());

//		System.out.println(NodeUtils.printPath(res));
//
		System.out.println(aStar.isAdmissibleH(s, g.getLabel()));
		
//		List<Node> n1 = Arrays.asList(d);
//		List<Node> n2 = Arrays.asList(d);
//		n1.get(0).setParent(c);
//		System.out.println(n1.get(0).getParent());
//		System.out.println(n2.get(0).getParent());
	}
}
