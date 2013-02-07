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

			D.newstack.capacity = 6;

			addToScene(D.newstack);
			pause();
			addStep("done"); // change

			for (int i = 0; i < 4; i++) {
				D.newstack.set(i, Color.ORANGE);
			}
			pause();
			addStep("done"); // change

			A.pop();
			D.pushstack.pop();
			D.popstack.pop();
			D.newstack.capacity -= 2;

			pause();
			addStep("done"); // change

			if (A.isEmpty()) {

				for (int i = 0; i < 4; i++) {
					D.newstack.set(i, Color.BLUE);
				}
				addStep("done"); // change
				pause();
				A.state = Array.INVISIBLE;
				D.newstack.capacity = 0;
			} else {
				D.newstack.set(3, Color.BLUE);
				D.newstack.set(2, Color.BLUE);
				pause();

				if ((D.A.capacity / 2 > D.A.getSize())
						&& (D.popstack.get(D.A.capacity / 2 - D.popstack.size()
								- 1).capacity < 2)) {
					D.popstack.get(D.A.capacity / 2 - D.popstack.size() - 1)
							.push(Color.ORANGE);
					addStep("done"); // change
				} else {
					addStep("done"); // change
				}
				D.newstack.capacity--;

				pause();

				if ((D.A.capacity / 2 > D.A.getSize())
						&& (D.popstack.get(D.A.capacity / 2 - D.popstack.size()
								- 1).capacity < 2)) {
					D.popstack.get(D.A.capacity / 2 - D.popstack.size() - 1)
							.push(Color.GREEN);
					addStep("done"); // change
				} else {
					addStep("done"); // change
				}
				D.newstack.capacity--;
				pause();

				D.newstack.set(1, Color.BLUE);
				D.newstack.set(0, Color.BLUE);
				D.newstack.capacity = 0;
				addStep("done"); // change
				pause();
			}
			if (A.capacity / 4 == A.getSize() && !A.isEmpty()) {
				addStep("done"); // change

				Array B = new Array(5, 0, 250);
				B.capacity = A.capacity / 2;

				for (int i = 0; i < D.popstack.size(); i++) {
					D.popstack.get(i).set(1, Color.BLUE);
				}
				addStep("done"); // change
				pause();

				for (int i = 0; i < D.popstack.size(); i++) {
					D.popstack.get(i).pop();
				}
				addToScene(B);
				pause();

				for (D.A.begin = 0; D.A.begin < D.A.capacity / 4; D.A.begin++) {
					D.popstack.get(D.A.begin).set(
							D.popstack.get(D.A.begin).capacity - 1, Color.BLUE);
					pause();
					B.push(D.A.get(D.A.begin));
					D.popstack.get(D.A.begin).pop();

				}

				D.A.state = Array.INVISIBLE;
				D.A.begin = 0;
				D.A.goTo(0, 250);
				D.A.capacity = D.A.capacity / 2;
				pause();
				D.A.state = Array.VISIBLE;
				B.state = Array.INVISIBLE;
				removeFromScene(B);
				D.A.goTo(0, 150);

				for (int i = 0; i < D.pushstack.size(); i++) {
					D.pushstack.get(i).clear();
				}
			}
			addNote("done");
		}
	}
}
