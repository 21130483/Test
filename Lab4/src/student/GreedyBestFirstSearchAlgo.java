package student;

import java.util.List;
import java.util.PriorityQueue;

public class GreedyBestFirstSearchAlgo implements IInformedSearchAlgo {
	PriorityQueue<Node> frontier = new PriorityQueue<Node>(new NodeComparatorByHn());

	@Override
	public Node execute(Node root, String goal) {
		if (root.getLabel() != goal) {
			List<Node> list = root.getChildrenNodes();
			for (Node node : list) {
//				if (!frontier.contains(node)) {
					node.setParent(root);
					frontier.add(node);
//				}
			}
			if (frontier.isEmpty()) {
				return null;
			}
			
			return execute(frontier.poll(), goal);
			
		} else {
			frontier.clear();
			return root;
		}
	}

	@Override
	public Node execute(Node root, String start, String goal) {
		Node x =execute(root, start);
		x.setParent(null);
		return execute(x, goal);
	}

	@Override
	public Node executetask4(Node root, String start, String goal) {
		Node x =execute(root, start);
		x.setParent(null);
		x.setG(0);
		return execute(x, goal);
	}

}
