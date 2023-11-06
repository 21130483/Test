package student;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BFSSearch implements IPuzzleAlgo {
	Queue<Node> frontaier = new LinkedList<Node>();
	List<Node> visited = new ArrayList<Node>();

	@Override
	public Node execute(Puzzle model) {
		Node init = model.getInitialState();
		init.setH(model.computeH1(init));
		init.setG(0);
		frontaier.add(init);
		visited.add(init);
		int count=0;
		while (!frontaier.isEmpty()) {
			count++;
//			System.out.println(count);
			Node node = frontaier.poll();
			if (node.getH() == 0) {
				System.out.println("Count :" + count);
				System.out.println("G :" + node.getG());
				return node;
			}
			List<Node> children = model.getSuccessors(node);
			for (Node node2 : children) {
				if(!frontaier.contains(node2) && !visited.contains(node2)) {
					node2.setH(model.computeH1(node2));
					node2.setG(node.getG()+1);
					frontaier.add(node2);
					visited.add(node2);
				}
			}

		}
		return null;
	}

}
