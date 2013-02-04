package algvis.ds.dynamicarray;

import java.awt.Color;

import algvis.core.Algorithm;
import algvis.core.Array;

public class DynamicArrayPop extends Algorithm {
	private Array A;
	DynamicArray D;

	public DynamicArrayPop(DynamicArray D) {
		super(D.panel);
		this.A = D.A;
		this.D = D;
	}

	@Override
	public void runAlgorithm() throws InterruptedException {
		setHeader("delete"); // change		

		if (A.isEmpty()) {
			addNote("done"); // change
		} else {

			D.stackN.capacity = 6;

			addToScene(D.stackN);
			pause();
			addStep("done"); // change

			for (int i = 0; i < 3; i++) {
				D.stackN.coins.set(i, Color.ORANGE);
			}

			pause();
			addStep("done"); // change

			for (int i = 0; i < 3; i++) {
				D.stackN.capacity--;
				D.stackM.push(Color.ORANGE);
			}

			D.stackN.coins.set(2, Color.BLUE);
			pause();
			addStep("done"); // change

			D.stackN.capacity--;
			D.stackC.push(Color.ORANGE);

			pause();
			addStep("done"); // change

			D.stackN.coins.set(1, Color.BLUE);
			D.stackN.coins.set(0, Color.BLUE);

			pause();
			addStep("done"); // change

			D.stackN.capacity--;
			D.stackN.capacity--;

			A.pop();

			if (A.isEmpty()) {
				A.state = Array.INVISIBLE;
			} else if (A.capacity / 4 == A.getSize()) {
				addStep("done"); // change

				Array B = new Array(5, 0, 250);
				B.capacity = A.capacity / 2;

				for (int i = D.stackM.capacity - 1; i >= D.stackM.capacity
						- B.capacity; i--) {
					D.stackM.coins.set(i, Color.BLUE);
				}

				addToScene(B);
				pause();
				addStep("done"); // change

				for (int i = 0; i < B.capacity; i++) {
					D.stackM.pop();
				}

				for (A.begin = 1; A.begin <= A.getSize(); A.begin++) {
					D.stackC.coins.set(D.stackC.capacity - 1, Color.BLUE);
					B.push(A.get(A.begin - 1));
					pause();
					D.stackC.pop();
				}

				A.state = Array.INVISIBLE;
				A.begin = 0;
				A.goTo(0, 250);
				A.capacity = A.capacity / 2;
				pause();
				A.state = Array.VISIBLE;
				B.state = Array.INVISIBLE;
				removeFromScene(B);
				A.goTo(0, 150);
			}
			addNote("done");
		}
	}
}
