package student;

import java.util.Comparator;

public class NodeComparatorByGnHn implements Comparator<Node>{
	public int compare(Node o1, Node o2) {
		Double g1 = o1.getG();
		Double h1 = o1.getH();
		Double g2 = o2.getG();
		Double h2 = o2.getH();
		Double gh1 = g1+h1;
		Double gh2 = g2+h2;
		int result = gh1.compareTo(gh2);
		if (result == 0)
			return o1.getLabel().compareTo(o2.getLabel());
		else
			return result;
	}
}

