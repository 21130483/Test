package game_alphabeta_student;

public class Test {
	public static void main(String[] args) {
//		Node A = new Node("A");
//
//		Node B = new Node("B");
//		Node C = new Node("C");
//		Node D = new Node("D");
//		A.addChild(B);
//		A.addChild(C);
//		A.addChild(D);
//
//		Node E = new Node("E", 3);
//		Node F = new Node("F", 12);
//		Node G = new Node("G", 8);
//		B.addChild(E);
//		B.addChild(F);
//		B.addChild(G);
//
//		Node H = new Node("H", 2);
//		Node I = new Node("I", 4);
//		Node J = new Node("J", 6);
//		C.addChild(H);
//		C.addChild(I);
//		C.addChild(J);
//
//		Node K = new Node("K", 14);
//		Node L = new Node("L", 5);
//		Node M = new Node("M", 2);
//		D.addChild(K);
//		D.addChild(L);
//		D.addChild(M);
//		
//		ISearchAlgo minimaxsearchalgo = new MiniMaxSearchAlgo();
//		minimaxsearchalgo.execute(A);

		// alphabeta
		Node A = new Node("A");

		Node B = new Node("B");
		Node C = new Node("C");
		Node D = new Node("D", 0);
		Node E = new Node("E");
		A.addChild(B);
		A.addChild(C);
		A.addChild(D);
		A.addChild(E);

		Node F = new Node("F");
		Node G = new Node("G", -5);
		B.addChild(F);
		B.addChild(G);

		Node H = new Node("H", 3);
		Node I = new Node("I", 8);
		Node J = new Node("J");
		C.addChild(H);
		C.addChild(I);
		C.addChild(J);

		Node K = new Node("K");
		Node L = new Node("L", 2);
		Node M = new Node("M");
		E.addChild(K);
		E.addChild(L);
		E.addChild(M);

		Node N = new Node("N", 4);
		Node O = new Node("O");
		F.addChild(N);
		F.addChild(O);

		Node P = new Node("P", 9);
		Node Q = new Node("Q", -6);
		Node R = new Node("R", 0);
		J.addChild(P);
		J.addChild(Q);
		J.addChild(R);

		Node S = new Node("S", 3);
		Node T = new Node("T", 5);
		K.addChild(S);
		K.addChild(T);

		Node U = new Node("U", -7);
		Node V = new Node("V", -9);
		M.addChild(U);
		M.addChild(V);

		Node W = new Node("W", -3);
		Node X = new Node("X", -5);
		O.addChild(W);
		O.addChild(X);
		ISearchAlgo alphabeta = new AlphaBetaSearchAlgo();
		ISearchAlgo alphabetaRighttoLeft = new AlphaBetaRightToLeftSearchAlgo();
		alphabetaRighttoLeft.execute(A);
	}
}
