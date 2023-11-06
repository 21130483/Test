package student;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class LocalSearch implements IPuzzleAlgo {
	private PriorityQueue<Node> frontier = new PriorityQueue<Node>(new PuzzleUtils().HeuristicComparatorByH);
	private List<Node> visited = new ArrayList<Node>();

	public Node execute(Puzzle model) {
		Node init = model.getInitialState();
		init.setH(model.computeH2(init));
		init.setG(0);
		frontier.add(init);
		visited.add(init);
		int count = 0;
		while (!frontier.isEmpty()) {
			count++;
			System.out.println(frontier.peek());
			Node node = frontier.poll();
			frontier.clear();
			if (node.getH() == 0) {
				System.out.println("Count :" + count);
				System.out.println("G :" + node.getG());
				return node;
			}

			List<Node> children = model.getSuccessors(node);
			for (Node node2 : children) {
				if (!frontier.contains(node2) && !visited.contains(node2)) {
					node2.setH(model.computeH2(node2));
					node2.setG(node.getG() + 1);
					frontier.add(node2);
					visited.add(node2);
				}
			}

		}
		return null;
	}

}