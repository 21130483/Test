package lab_7;

public class Test {
	public static void main(String[] args) {
		GA_NQueenAlgo algo = new GA_NQueenAlgo();
		algo.initPopulation();
		Node node = algo.execute();
		node.displayBoard();
		System.out.println(node.getH());
	}
}
