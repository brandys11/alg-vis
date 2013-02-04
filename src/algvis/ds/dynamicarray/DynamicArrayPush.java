package algvis.ds.dynamicarray;

import java.awt.Color;

import algvis.core.Algorithm;
import algvis.core.Array;

public class DynamicArrayPush extends Algorithm {
	DynamicArray D;
	private Array A;
	private final int X;

	public DynamicArrayPush(DynamicArray D, int x) {
		super(D.panel);
		this.D = D;
		this.A = D.A;
		X = x;
	}

	@Override
	public void runAlgorithm() throws InterruptedException {
		setHeader("insert", X); // change

		D.stackN.capacity = 6;
		addToScene(D.stackN);
		pause();
		addStep("done"); // change

		for (int i = 0; i < 4; i++) {
			D.stackN.coins.set(i, Color.ORANGE);
		}
		pause();
		addStep("done"); // change

		for (int i = 0; i < 2; i++) {
			D.stackN.capacity--;
			D.stackM.push(Color.ORANGE);
		}

		D.stackN.coins.set(2, Color.BLUE);
		D.stackN.coins.set(3, Color.BLUE);

		pause();
		addStep("done"); // change

		for (int i = 0; i < 2; i++) {
			D.stackN.capacity--;
			D.stackC.push(Color.ORANGE);
		}

		pause();
		addStep("done"); // change

		if (A.isEmpty()) {
			D.stackM.coins.set(D.stackM.capacity - 1, Color.BLUE);
			D.stackM.coins.set(D.stackM.capacity - 2, Color.BLUE);
			A.state = Array.VISIBLE;
			pause();
			addStep("done"); // change
			D.stackM.pop();
			D.stackM.pop();
		} else if (A.capacity == A.getSize()) {
			addStep("done"); // change
			Array B = new Array(5, 0, 250);
			B.capacity = 2 * A.capacity;

			for (int i = D.stackM.capacity - 1; i >= D.stackM.capacity
					- A.capacity; i--) {
				D.stackM.coins.set(i, Color.BLUE);
			}
			addToScene(B);
			pause();
			addStep("done"); // change

			for (int i = 0; i < A.capacity; i++) {
				D.stackM.pop();
			}

			for (A.begin = 1; A.begin <= A.capacity; A.begin++) {
				D.stackC.coins.set(D.stackC.capacity - 1, Color.BLUE);
				B.push(A.get(A.begin - 1));
				pause();
				D.stackC.pop();
			}

			A.state = Array.INVISIBLE;
			A.begin = 0;
			A.goTo(0, 250);
			A.capacity = 2 * A.capacity;
			pause();
			B.state = Array.INVISIBLE;
			A.state = Array.VISIBLE;
			removeFromScene(B);
			A.goTo(0, 150);
			pause();
		}

		D.stackN.coins.set(1, Color.BLUE);
		D.stackN.coins.set(0, Color.BLUE);

		pause();
		addStep("done"); // change

		D.stackN.capacity--;
		D.stackN.capacity--;

		A.push(X);
		addNote("done");
	}

}