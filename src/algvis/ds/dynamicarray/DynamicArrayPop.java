package algvis.ds.dynamicarray;

import algvis.core.Algorithm;
import algvis.core.Array;

public class DynamicArrayPop extends Algorithm {
	private final Array A;

	public DynamicArrayPop(DynamicArray D) {
		super(D.panel);
		this.A = D.A;
	}

	@Override
	public void runAlgorithm() throws InterruptedException {
		setHeader("delete"); // change
		if (A.isEmpty()) {
			addNote("done"); // change
		} else {
			
			A.pop();	
			if(A.capacity == 1 || A.capacity == 2) {}			
			else if (A.capacity/4 == A.getSize()){
				addStep("done"); // change
				
				Array B = new Array(5, 0, 200);
				B.capacity=A.capacity/2;
				addToScene(B);
				pause();
				
				for(A.begin = 1; A.begin <= A.getSize(); A.begin++) {
					B.push(A.get(A.begin-1));	
					pause();
				}
				
				A.state = Array.INVISIBLE;
				A.begin = 0;
				A.goTo(0, 200);	
				A.capacity=A.capacity/2;
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
