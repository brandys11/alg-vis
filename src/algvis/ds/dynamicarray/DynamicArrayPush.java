package algvis.ds.dynamicarray;

import java.awt.Color;

import algvis.core.Algorithm;
import algvis.core.Array;
import algvis.core.CStack;

public class DynamicArrayPush extends Algorithm {
	DynamicArray D;
	private final int X;

	public DynamicArrayPush(DynamicArray D, int x) {
		super(D.panel);
		this.D = D;
		X = x;
	}

	@Override
	public void runAlgorithm() throws InterruptedException {
		setHeader("insert", X); // change
		addStep("done"); // change

		addToScene(D.newstack);
		D.newstack.capacity = 6;
		pause();

		if (D.A.isEmpty()) {
			for (int i = 0; i < 2; i++) {
				D.newstack.set(i, Color.ORANGE);
			}
			addStep("done"); // change
			pause();
			D.A.state = Array.VISIBLE;
			D.newstack.capacity -= 4;
			pause();
			D.newstack.set(1, Color.BLUE);
			D.newstack.set(0, Color.BLUE);

			addStep("done"); // change
			pause();

			D.A.push(X);
			D.pushstack.add(new CStack(0, D.A.x, D.A.y - 40, 0, -8));
			D.popstack.add(new CStack(0, D.A.x, D.A.y - 80, 0, -8));
			D.newstack.capacity = 0;

		} else {

			if (D.A.capacity == D.A.getSize()) {
				addStep("done"); // change
				Array B = new Array(5, 0, 250);
				B.capacity = 2 * D.A.capacity;

				for (int i = 0; i < D.newstack.capacity; i++) {
					D.newstack.set(i, Color.ORANGE);
				}
				pause();
				for (int i = 0; i < D.pushstack.size(); i++) {
					D.pushstack.get(i).set(1, Color.BLUE);
				}
				addStep("done"); // change
				pause();

				for (int i = 0; i < D.pushstack.size(); i++) {
					D.pushstack.get(i).pop();
				}
				addToScene(B);
				pause();
				for (D.A.begin = 0; D.A.begin < D.A.capacity; D.A.begin++) {
					D.pushstack.get(D.A.begin)
							.set(D.pushstack.get(D.A.begin).capacity - 1,
									Color.BLUE);
					pause();
					B.push(D.A.get(D.A.begin));
					D.pushstack.get(D.A.begin).pop();

				}

				D.A.state = Array.INVISIBLE;
				D.A.begin = 0;
				D.A.goTo(0, 250);
				D.A.capacity = 2 * D.A.capacity;
				pause();
				B.state = Array.INVISIBLE;
				D.A.state = Array.VISIBLE;
				removeFromScene(B);
				D.A.goTo(0, 150);
				pause();

				for (int i = 4; i < D.newstack.capacity; i++) {
					D.newstack.set(i, Color.BLUE);
				}

				for (int i = 0; i < D.popstack.size(); i++) {
					D.popstack.get(i).clear();
				}
			}

			for (int i = 0; i < 4; i++) {
				D.newstack.set(i, Color.ORANGE);
			}
			addStep("done"); // change
			pause();

			D.newstack.capacity -= 2;
			D.A.push(X);
			D.pushstack.add(new CStack(0, D.A.x + 2 * Array.RADIUS
					* (D.A.getSize() - 1), D.A.y - 40, 0, -8));
			D.popstack.add(new CStack(0, D.A.x + 2 * Array.RADIUS
					* (D.A.getSize() - 1), D.A.y - 80, 0, -8));

			pause();
			D.newstack.set(3, Color.BLUE);
			D.newstack.set(2, Color.BLUE);
			pause();

			if (D.pushstack.get(D.A.getSize() - 1).capacity < 2) {
				D.pushstack.get(D.A.getSize() - 1).push(Color.ORANGE);
				addStep("done"); // change
			} else {
				addStep("done"); // change
			}
			D.newstack.capacity--;
			pause();

			if (D.A.capacity - D.A.getSize() >= 0
					&& (D.A.capacity - D.A.getSize() < D.A.capacity / 2)
					&& D.pushstack.get(D.A.capacity - D.A.getSize()).capacity < 2) {
				D.pushstack.get(D.A.capacity - D.A.getSize())
						.push(Color.ORANGE);
				addStep("done"); // change
			} else {
				addStep("done"); // change
			}
			D.newstack.capacity--;

			pause();
			D.newstack.set(1, Color.BLUE);
			D.newstack.set(0, Color.BLUE);
			addStep("done"); // change
			pause();

			if (D.pushstack.get(D.A.getSize() - 1).capacity < 2) {
				D.pushstack.get(D.A.getSize() - 1).push(Color.GREEN);
				addStep("done"); // change
			} else {
				addStep("done"); // change
			}

			D.newstack.capacity--;
			pause();

			if (D.A.capacity - D.A.getSize() >= 0
					&& (D.A.capacity - D.A.getSize() < D.A.capacity / 2)
					&& D.pushstack.get(D.A.capacity - D.A.getSize()).capacity < 2) {
				D.pushstack.get(D.A.capacity - D.A.getSize()).push(Color.GREEN);
				addStep("done"); // change
			} else {
				addStep("done"); // change
			}
			D.newstack.capacity = 0;
		}

		addNote("done");
	}

}