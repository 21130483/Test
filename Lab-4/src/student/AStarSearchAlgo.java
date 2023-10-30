package student;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class AStarSearchAlgo implements IInformedSearchAlgo {
	PriorityQueue<Node> frontier = new PriorityQueue<Node>(new NodeComparatorByGnHn());

	@Override
	public Node execute(Node root, String goal) {
		if (root.getLabel() != goal) {
			List<Node> list = root.getChildrenNodes();
			for (Node node : list) {
				if (!frontier.contains(node)) {
					node.setG(root.getG() + root.getWeighttoNodeThat(node));
					node.setParent(root);
					frontier.add(node);
				} else {
					Double gHold = node.getG();
					Double gHnew = root.getG() + root.getWeighttoNodeThat(node);
					if (gHold > gHnew) {
						node.setG(gHnew);
						node.setParent(root);
					}

				}
			}
			if (frontier.isEmpty()) {
				return null;
			}
			return execute(frontier.poll(), goal);

		} else {
			frontier.clear();
			System.out.println(root.getG());
			return root;
		}
	}

	@Override
	public Node execute(Node root, String start, String goal) {
		Node x = execute(root, start);
		x.setParent(null);
		return execute(x, goal);
	}


	public boolean isAdmissibleH(Node root, String goal) {
		Queue<Node> queue = new LinkedList<Node>();
		List<String> visited = new ArrayList<String>();
		queue.add(root);
		while (!queue.isEmpty()) {
			Node start = queue.poll();
			start.setG(0);
			Node node = execute(start, goal);
			if (start.getH() > node.getG()) {
				return false;
			}
			for (Node node2 : start.getChildrenNodes()) {
				if (!visited.contains(node2.getLabel())) {
					queue.add(node2);
					visited.add(node2.getLabel());
				}
			}
		}
		return true;
	}

	@Override
	public Node executetask4(Node root, String start, String goal) {
		Node x = execute(root, start);
		x.setParent(null);
		x.setG(0);
		return execute(x, goal);
	}
	
}
