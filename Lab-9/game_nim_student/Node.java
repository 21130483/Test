package game_nim_student;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class Node {
	private List<Integer> data = new ArrayList<Integer>();
	private List<Node> children = new ArrayList<Node>();
	private List<Node> bestChildren = new ArrayList<Node>();

	public void add(Integer val) {
		this.data.add(val);
	}

	public void addAll(List<Integer> data) {
		this.data.addAll(data);
	}

	// Get children of the current nodes
	public List<Node> getSuccessors() {
		List<Node> result = new ArrayList<Node>();
		Set<List<Integer>> check = new HashSet<List<Integer>>();
		for (int i = 0; i < data.size(); i++) {
			int currInt = data.get(i);
			int count = currInt / 2 - (currInt % 2 == 0 ? 1 : 0);
			List<Integer> children = new ArrayList<Integer>();
			for (int j = 0; j < data.size(); j++) {
				if (i != j) {
					children.add(data.get(j));
				}
			}
			for (int x = 1; x <= count; x++) {
				List<Integer> child = new ArrayList<Integer>();
				child.addAll(children);
				int bag1 = currInt - x;
				int bag2 = x;
				child.add(bag1);
				child.add(bag2);
				if (!check.contains(child)) {
					Node node = new Node();
					node.addAll(child);
					check.add(child);
					result.add(node);
					this.children.add(node);
				}

			}

		}
		return result;
	}

	// Check whether a node is terminal or not
	public boolean isTerminal() {
		if (getSuccessors().isEmpty()) {
			return true;
		}
		return false;
	}

	public static final Comparator<Integer> DESCOMPARATOR = new Comparator<Integer>() {

		@Override
		public int compare(Integer o1, Integer o2) {
			return o2.compareTo(o1);
		}
	};

	@Override
	public String toString() {
		Collections.sort(this.data, DESCOMPARATOR);
		return this.data.toString();
	}

	public List<Integer> getData() {
		return data;
	}

	public void setData(List<Integer> data) {
		this.data = data;
	}

	public List<Node> getBestChildren() {
		return bestChildren;
	}

	public void setBestChildren(List<Node> bestChildren) {
		this.bestChildren = bestChildren;
	}

	public void addBestChildren(Node bestchild) {
		bestChildren.add(bestchild);
	}

	public void clearBestChildren() {
		bestChildren.clear();
	}

	public void bestWay(Node node) {
		List<Node> childs = new ArrayList<Node>();
		System.out.print(node.getData());
		childs.addAll(node.getBestChildren());
		while (!childs.isEmpty()) {
			System.out.print(" -> ");
			Set<List<Integer>> check = new HashSet<List<Integer>>();
			List<Node> newGeneration = new ArrayList<Node>();
			for (Node child : childs) {
				System.out.print(child.getData() + " ");
				for (Node grandChild : child.getBestChildren()) {
					if (!check.contains(grandChild.getData())) {
						check.add(grandChild.getData());
						newGeneration.add(grandChild);
					}
				}
			}
			childs.clear();
			childs.addAll(newGeneration);
		}
	}

}
