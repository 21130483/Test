package game_nim_student;

public class MinimaxAlgo {
	public void execute(Node node) {
		int v = minValue(node);
		node.bestWay(node);
	}

	// function MAX-VALUE(state) returns a utility value
	// if TERMINAL-TEST(state) then return UTILITY(state)
	// v <- Integer.MIN_VALUE
	// for each s in SUCCESSORS(state) do
	// v <- MAX(v, MIN-VALUE(s))
	// return v
	public int maxValue(Node node) {
		int max = Integer.MIN_VALUE;
		if (!node.isTerminal()) {
			for (Node child : node.getSuccessors()) {
//				max = Math.max(minValue(child), max);
				if (minValue(child) > max) {
					node.clearBestChildren();
					max = minValue(child);
					node.addBestChildren(child);

				} else if (minValue(child) == max) {
					node.addBestChildren(child);
				}
			}
		}
		return max;
	}

	// function MIN-VALUE(state) returns a utility value
	// if TERMINAL-TEST(state) then return UTILITY(state)
	// v <- Integer.MAX_VALUE
	// for each s in SUCCESSORS(state) do
	// v <- MIN(v, MAX-VALUE(s))
	// return v
	public int minValue(Node node) {
		int min = Integer.MAX_VALUE;
		if (!node.isTerminal()) {
			for (Node child : node.getSuccessors()) {
				min = Math.min(maxValue(child), min);
				if (maxValue(child) < min) {
					node.clearBestChildren();
					min = maxValue(child);
					node.addBestChildren(child);
				} else if (maxValue(child) == min) {
					node.addBestChildren(child);

				}
			}
		}
		return min;
	}
}
