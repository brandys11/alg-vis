package algvis.ds.dynamicarray;

import algvis.core.Algorithm;
import algvis.core.Array;
import algvis.core.Bank;
import algvis.core.Coin;

public class DynamicArrayPush extends Algorithm {
	private Array A;
	private Bank bank;
	private final int X;

	public DynamicArrayPush(DynamicArray D, int x) {
		super(D.panel);
		this.A = D.A;
		bank = D.B;
		X = x;
	}

	@Override
	public void runAlgorithm() throws InterruptedException {
		int cx = bank.x + 45;
		setHeader("insert", X); // change

		Coin C = new Coin(0, cx, bank.y, 6);

		addToScene(bank);
		addToScene(C);
		pause();
		addStep("done"); // change
		C.state = Coin.INVISIBLE;
		bank.change(C.value);
		if (A.isEmpty()) {
			C.value = -2;
			C.state = Coin.VISIBLE;
			A.state = Array.VISIBLE;
			pause();
			C.state = Coin.INVISIBLE;
			bank.change(C.value);
		} else if (A.capacity == A.getSize()) {
			addStep("done"); // change
			Array B = new Array(5, 0, 200);
			B.capacity = 2 * A.capacity;

			C.value = -A.capacity;
			C.state = Coin.VISIBLE;
			addToScene(B);
			pause();
			C.state = Coin.INVISIBLE;
			bank.change(C.value);

			pause();
			for (A.begin = 1; A.begin <= A.capacity; A.begin++) {
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
			A.capacity = 2 * A.capacity;
			pause();
			B.state = Array.INVISIBLE;
			A.state = Array.VISIBLE;
			removeFromScene(B);
			A.goTo(0, 100);
			pause();
		}

		C.value = -2;
		C.state = Coin.VISIBLE;
		pause();
		C.state = Coin.INVISIBLE;
		bank.change(C.value);

		A.push(X);
		addNote("done");
	}

}