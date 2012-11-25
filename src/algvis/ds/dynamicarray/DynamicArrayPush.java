package algvis.ds.dynamicarray;

import algvis.core.Algorithm;
import algvis.core.Array;

public class DynamicArrayPush extends Algorithm {
	private Array A;
	private final int X;

	public DynamicArrayPush(DynamicArray D, int x) {
		super(D.panel);
		this.A = D.A;
		X = x;
	}

	@Override
	public void runAlgorithm() throws InterruptedException {
		setHeader("insert", X); // change
		
		if(A.capacity == A.getSize()) {
			addStep("done"); // change
			Array B = new Array(5, 0, 200);
			B.capacity=2*A.capacity;
			addToScene(B);
			pause();
			
			for(A.begin = 1; A.begin <= A.capacity; A.begin++) {
				B.push(A.get(A.begin-1));	
				pause();
			}
			
			A.state = Array.INVISIBLE;
			A.begin = 0;
			A.goTo(0, 200);		
			A.capacity=2*A.capacity;
			pause();
			B.state = Array.INVISIBLE;
			A.state = Array.VISIBLE;
			removeFromScene(B);
			A.goTo(0, 100);
			pause();
		}
		A.push(X);
		addNote("done");
	}

}