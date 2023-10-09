package Lab2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Stack;

public class DepthFirstSearchAlgo implements ISearchAlgo {
	private Stack<Node> frontier = new Stack<Node>();
	private List<String> visited = new ArrayList<String>();

	@Override
	public Node execute(Node root, String goal) {
		while (root.getLabel() != goal) {
			List<Node> list = root.getChildrenNodes();
			Collections.sort(list, new Comparator<Node>() {

				@Override
				public int compare(Node o1, Node o2) {
					// TODO Auto-generated method stub
					return o2.getLabel().compareTo(o1.getLabel());
				}
			});
			for (Node node : list) {
				System.out.println(node.getLabel());
			}
			for (Node node : list) {
				if (!visited.contains(node.getLabel())) {

					node.setParent(root);
					frontier.add(node);
					visited.add(node.getLabel());
				}
			}
			if (frontier.isEmpty()) {
				return null;
			} else {
				root = frontier.pop();
			}
		}
		frontier.clear();
		visited.clear();

		return root;
	}

	@Override
	public Node execute(Node root, String start, String goal) {
		Node x = execute(root, start);
		x.setParent(null);
		return execute(x, goal);
	}

	@Override
	public Node executeTree(Node root, String goal) {
		if (root.getLabel() == goal) {
			frontier.clear();
			return root;
		} else {
			List<Node> list = new ArrayList<Node>();
			Collections.sort(list, new Comparator<Node>() {

				@Override
				public int compare(Node o1, Node o2) {
					// TODO Auto-generated method stub
					return o2.getLabel().compareTo(o1.getLabel());
				}

			});
			for (Node node : list) {
				node.setParent(root);
				frontier.add(node);
			}
			if (frontier.isEmpty()) {
				return null;
			} else {
				return executeTree(frontier.pop(), goal);
			}
		}
	}

	@Override
	public Node executeTree(Node root, String start, String goal) {
		Node x = execute(root, start);
		x.setParent(null);
		return execute(x, goal);
	}

	@Override
	public Node execute(Node root, String goal, int limitedDepth) {
		while (root.getLabel() != goal) {
			List<Node> list = root.getChildrenNodes();
			Collections.sort(list, new Comparator<Node>() {

				@Override
				public int compare(Node o1, Node o2) {
					// TODO Auto-generated method stub
					return o2.getLabel().compareTo(o1.getLabel());
				}
			});
			if (root.getDepth() < limitedDepth) {
				for (Node node : list) {
					if (!visited.contains(node.getLabel())) {
						node.setParent(root);
						node.setDepth(root.getDepth() + 1);
						frontier.add(node);
						visited.add(node.getLabel());
					}
				}
			}
			if (frontier.isEmpty()) {
				return null;
			} else {
				root = frontier.pop();
			}
		}
		frontier.clear();
		visited.clear();

		return root;
	}
}
