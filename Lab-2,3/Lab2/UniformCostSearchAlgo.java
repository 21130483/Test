package Lab2;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class UniformCostSearchAlgo implements ISearchAlgo {
//	private PriorityQueue<Node> frontier = new PriorityQueue<Node>(new NodeComparator());
	private PriorityQueue<Node> frontier = new PriorityQueue<Node>(new Comparator<Node>() {

		@Override
		public int compare(Node o1, Node o2) {
			// TODO Auto-generated method stub
			return (int) (o1.getPathCost() - o2.getPathCost());
		}
	});
	private List<String> visited = new ArrayList<String>();

	@Override
	public Node execute(Node root, String goal) {

		if (root.getLabel() == goal) {
			visited.clear();
			frontier.clear();
			System.out.println(root.getPathCost());
			return root;
		} else {
			for (Node node : root.getChildrenNodes()) {
				if (!visited.contains(node.getLabel())) {
					node.setParent(root);
					node.setPathCost(root.getWeightToNodeThat(node) + root.getPathCost());
					frontier.add(node);
				}
			}
			if (frontier.isEmpty()) {
				return null;
			} else {
				return execute(frontier.poll(), goal);
			}

		}
	}

	@Override
	public Node execute(Node root, String start, String goal) {
		Node x = execute(root, start);
		if (x == null) {
			return null;
		} else {
			x.setParent(null);
			x.setPathCost(0);
			return execute(x, goal);
		}
	}

	@Override
	public Node executeTree(Node root, String goal) {
		if (root.getLabel() == goal) {
			visited.clear();
			frontier.clear();
			System.out.println(root.getPathCost());
			return root;
		} else {
			for (Node node : root.getChildrenNodes()) {
				node.setParent(root);
				node.setPathCost(root.getWeightToNodeThat(node) + root.getPathCost());
				frontier.add(node);
			}
			if (frontier.isEmpty()) {
				return null;
			} else {
				return execute(frontier.poll(), goal);
			}

		}
	}

	@Override
	public Node executeTree(Node root, String start, String goal) {
		Node x = execute(root, start);
		if (x == null) {
			return null;
		} else {
			x.setParent(null);
			x.setPathCost(0);
			return execute(x, goal);
		}
	}

	@Override
	public Node execute(Node root, String goal, int limitedDepth) {
//		System.out.println(root.getDepth());
		if (root.getLabel() == goal) {
			visited.clear();
			frontier.clear();
			System.out.println(root.getPathCost());
			return root;
		} else {
			if (root.getDepth() < limitedDepth) {
				for (Node node : root.getChildrenNodes()) {
					if (!visited.contains(node.getLabel())) {
						node.setParent(root);
						node.setDepth(root.getDepth() + 1);
						node.setPathCost(root.getWeightToNodeThat(node) + root.getPathCost());
						frontier.add(node);
					}
				}
			}
			if (frontier.isEmpty()) {
				return null;
			} else {
				return execute(frontier.poll(), goal,limitedDepth);
			}

		}
	}

}
