package lab_7;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class GA_NQueenAlgo {
	public static final int POP_SIZE = 100;// Population size
	public static final double MUTATION_RATE = 0.03;
	public static final int MAX_ITERATIONS = 1000;
	List<Node> population = new ArrayList<Node>();
	Random rd = new Random();

	// initialize the individuals of the population
	public void initPopulation() {
		for (int i = 0; i < POP_SIZE; i++) {
			Node ni = new Node();
			ni.generateBoard();
			population.add(ni);
		}
	}

	public Node execute() {
		// Enter your code here

		for (int i = 0; i < MAX_ITERATIONS; i++) {
			List<Node> newGeneration = new ArrayList<Node>();
			for (int j = 0; j < POP_SIZE; j++) {
				Node x = getParentByRandomSelection();
				Node y = getParentByRandomSelection();
				Node child = reproduce(x, y);
				if (MUTATION_RATE <= rd.nextDouble()) {
					mutate(child);
				}
				if (child.getH() == 0) {
					return child;
				} else {
					newGeneration.add(child);
				}

			}

			population = newGeneration;

		}
		Collections.sort(population);
		return population.get(0);

	}

	// Mutate an individual by selecting a random Queen and
	// move it to a random row.
	public void mutate(Node node) {
		// Enter your code here
		node.setRow(rd.nextInt(8), rd.nextInt(8));
	}

	// Crossover x and y to reproduce a child
	public Node reproduce(Node x, Node y) {
		Node result = new Node();
		int n = rd.nextInt(1, Node.N - 1);
		for (int i = 0; i < n; i++) {
			result.setRow(i, x.getRow(i));
		}
		for (int i = n; i < Node.N; i++) {
			result.setRow(i, y.getRow(i));
		}
		return result;
	}

	// Select K individuals from the population at random and
	// select the best out of these to become a parent.
	public Node getParentByTournamentSelection() {
		int k = rd.nextInt(population.size());
		Node better = population.get(rd.nextInt(population.size()));
		for (int i = 0; i < k; i++) {
			Node node = population.get(rd.nextInt(population.size()));
			if (node.getH() < better.getH()) {
				better = node;
			}
		}

		return better;
	}

	// Select a random parent from the population
	public Node getParentByRandomSelection() {
		Node node = population.get(rd.nextInt(population.size()));
		return node;
	}

}
