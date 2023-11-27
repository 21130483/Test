package game_alphabeta_student;

import java.util.Collections;
import java.util.List;

public class MiniMaxSearchAlgo implements ISearchAlgo {

	// function MINIMAX-DECISION(state) returns an action
	// inputs: state, current state in game
	// v <- MAX-VALUE(state)
	// return the action in SUCCESSORS(state) with value v
	@Override
	public void execute(Node node) {
		maxValue(node);
	}

	// function MAX-VALUE(state) returns a utility value
	// if TERMINAL-TEST(state) then return UTILITY(state)
	// v <- Integer.MIN_VALUE
	// for each s in SUCCESSORS(state) do
	// v <- MAX(v, MIN-VALUE(s))
	// return v
	public int maxValue(Node node) {
//		System.out.println(node.getLabel());
		if (node.isTerminal()) {
			System.out.println(node.getLabel()+" : "+node.getValue());
			return node.getValue();
		} else {
			int max = Integer.MIN_VALUE;
			for (Node child : node.getChildren()) {
				int minChild = minValue(child);
				if (minChild > max) {
					max = minChild;
					node.setGoodWay(child.getLabel());
				}
			}
			System.out.println(node.getLabel()+" : "+max);
			return max;
		}

	}
	// function MIN-VALUE(state) returns a utility value
	// if TERMINAL-TEST(state) then return UTILITY(state)
	// v <- Integer.MAX_VALUE
	// for each s in SUCCESSORS(state) do
	// v <- MIN(v, MAX-VALUE(s))
	// return v

	public int minValue(Node node) {
//		System.out.println(node.getLabel());
		if (node.isTerminal()) {
			System.out.println(node.getLabel()+" : "+node.getValue());
			return node.getValue();
		} else {
			int min = Integer.MAX_VALUE;
			for (Node child : node.getChildren()) {
				int maxChild = maxValue(child);
				if (maxChild < min) {
					min = maxChild;
					node.setGoodWay(child.getLabel());
				}
			}
			System.out.println(node.getLabel()+" : "+min);
			return min;
		}
	}
}
