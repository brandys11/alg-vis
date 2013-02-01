package algvis.ds.dynamicarray;

import algvis.core.Algorithm;
import algvis.core.Array;
import algvis.core.Bank;
import algvis.core.Coin;

public class DynamicArrayPop extends Algorithm {
	private Array A;
	private Bank bank;

	public DynamicArrayPop(DynamicArray D) {
		super(D.panel);
		this.A = D.A;
		bank = D.B;
	}

	@Override
	public void runAlgorithm() throws InterruptedException {
		setHeader("delete"); // change		
		addToScene(bank);

		if (A.isEmpty()) {
			addNote("done"); // change
		} else {
			int cx = bank.x + 45;
			Coin C = new Coin(0, cx, bank.y, 6);
			addToScene(C);
			pause();
			addStep("done"); // change
			C.state = Coin.INVISIBLE;
			bank.change(C.value);

			C.value = -2;
			addToScene(C);
			C.state = Coin.VISIBLE;
			pause();
			C.state = Coin.INVISIBLE;
			bank.change(C.value);
			A.pop();

			if (A.isEmpty()) {
				A.state = Array.INVISIBLE;
			} else if (A.capacity / 4 == A.getSize()) {
				addStep("done"); // change

				Array B = new Array(5, 0, 200);
				B.capacity = A.capacity / 2;
				C.value = -A.capacity;
				C.state = Coin.VISIBLE;
				addToScene(B);
				pause();
				C.state = Coin.INVISIBLE;
				bank.change(C.value);

				for (A.begin = 1; A.begin <= A.getSize(); A.begin++) {
					C.value = -1;
					C.state = Coin.VISIBLE;
					bank.change(C.value);
					B.push(A.get(A.begin - 1));
					pause();
					C.state = Coin.INVISIBLE;
				}

				A.state = Array.INVISIBLE;
				A.begin = 0;
				A.goTo(0, 200);
				A.capacity = A.capacity / 2;
				pause();
				A.state = Array.VISIBLE;
				B.state = Array.INVISIBLE;
				removeFromScene(B);
				A.goTo(0, 100);
			}
			addNote("done");
		}
	}
}
