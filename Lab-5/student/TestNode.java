package student;

import java.util.Arrays;
import java.util.List;

public class TestNode {

	public static void main(String[] args) {
		Puzzle p = new Puzzle();
		p.readInput("C:\\Users\\phuoc\\eclipse-workspace\\Lab5\\src\\txt\\PuzzleMap.txt",
				"C:\\Users\\phuoc\\eclipse-workspace\\Lab5\\src\\txt\\PuzzleGoalState.txt");

		Node initialState = p.getInitialState();
		Node tmp = new Node(initialState);
//		System.out.println(initialState.equals(tmp));
		Node goalState = p.getGoalState();
//		System.out.println(p.getInitialState());
//		System.out.println("H: " + initialState.getH());
//		System.out.println(Arrays.toString(initialState.getWhiteTilePosition()));
//		System.out.println(p.getGoalState());
//		Node re = p.moveWhiteTile(initialState, 'r');
//
//		System.out.println(re);
//		System.out.println(re.getH());
//		System.out.println(initialState);
//		System.out.println(Arrays.toString(re.getWhiteTilePosition()));
//		System.out.println(p.computeH(initialState, goalState));

//		System.out.println(p.getInitialState());
//		System.out.println(p.getGoalState());
		//
//		List<Node> children = p.getSuccessors(initialState);
//		System.out.println("Size: " + children.size());
//		for (Node child : children) {
//		 System.out.println(child.getH()+" "+p.computeH(child) );
		
		IPuzzleAlgo greedybestfirstsearch = new GreedyBestFirstSearch();
//		System.out.println(greedybestfirstsearch.execute(p));
		
		IPuzzleAlgo astarsearch = new AStarSearch();
//		System.out.println(astarsearch.execute(p));
//		}
		
		IPuzzleAlgo bfssearch = new BFSSearch();
//		System.out.println(bfssearch.execute(p));
		
		IPuzzleAlgo dfssearch = new DFSSearch();
//		System.out.println(dfssearch.execute(p));
		
		IPuzzleAlgo localsearch = new LocalSearch();
//		System.out.println(localsearch.execute(p));
	}
}
