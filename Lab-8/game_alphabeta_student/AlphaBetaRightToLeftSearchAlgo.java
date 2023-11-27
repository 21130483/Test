package game_alphabeta_student;

import java.util.Stack;

public class AlphaBetaRightToLeftSearchAlgo implements ISearchAlgo {

	// function ALPHA-BETA-SEARCH(state) returns an action
	// inputs: state, current state in game
	// v <- MAX-VALUE(state, Integer.MIN_VALUE , Integer.MAX_VALUE)
	// return the action in SUCCESSORS(state) with value v
	@Override
	public void execute(Node node) {
		maxValue(node, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}

	// function MAX-VALUE(state, alpha, beta) returns a utility value
	// if TERMINAL-TEST(state) then return UTILITY(state)
	// v <- MIN_VALUE;
	// for each s in SUCCESSORS(state) do
	// v <- MAX(v, MIN-VALUE(s, alpha, beta))
	// if v >= beta then return v
	// alpha <- MAX(alpha, v)
	// return v

	public int maxValue(Node node, int alpha, int beta) {
		if (node.isTerminal()) {
			System.out.println(node.getLabel() + " : " + node.getValue());
			return node.getValue();
		} else {
			int max = Integer.MIN_VALUE;
			boolean notCut = true;
			Stack<Node> stack = new Stack<Node>();
			for (Node child : node.getChildren()) {
				stack.add(child);
			}
//			for (Node child : stack) {
			while (!stack.isEmpty()) {
				Node child = stack.pop();
				if (notCut) {
					int minChild = minValue(child, alpha, beta);
					if (minChild > max) {
						max = minChild;
						node.setGoodWay(child.getLabel());
						if (max >= beta) {
//								System.out.println("cut");
//								break;
							notCut = false;
						} else {
							System.out.println("alpha = " + max);
							alpha = max;
						}
					}
				} else {
					System.out.println("Cut " + child.getLabel());
				}

			}
			System.out.println(node.getLabel() + " : " + max);
			return max;
		}
	}
	// function MIN-VALUE(state, alpha , beta) returns a utility value
	// if TERMINAL-TEST(state) then return UTILITY(state)
	// v <- Integer.MAX_VALUE
	// for each s in SUCCESSORS(state) do
	// v <- MIN(v, MAX-VALUE(s, alpha , beta))
	// if v <= alpha then return v
	// beta <- MIN(beta ,v)
	// return v

	public int minValue(Node node, int alpha, int beta) {
		if (node.isTerminal()) {
			System.out.println(node.getLabel() + " : " + node.getValue());
			return node.getValue();
		} else {
			int min = Integer.MAX_VALUE;
			boolean notCut = true;
			Stack<Node> stack = new Stack<Node>();
			for (Node child : node.getChildren()) {
				stack.add(child);
			}
//			for (Node child : node.getChildren()) {
			while (!stack.isEmpty()) {
				Node child = stack.pop();
				if (notCut) {
					int maxChild = maxValue(child, alpha, beta);
					if (maxChild < min) {
						min = maxChild;
						node.setGoodWay(child.getLabel());
						if (min <= alpha) {
//								System.out.println("cut");
//								break;
							notCut = false;
						} else {
							System.out.println("beta = " + min);
							beta = min;
						}
					}
				} else {
					System.out.println("Cut " + child.getLabel());
				}

			}
			System.out.println(node.getLabel() + " : " + min);
			return min;
		}
	}

}
