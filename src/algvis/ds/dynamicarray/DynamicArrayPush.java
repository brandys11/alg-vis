package algvis.ds.dynamicarray;

import algvis.core.Algorithm;
import algvis.core.visual.Array;

public class DynamicArrayPush extends Algorithm {
	private final DynamicArray D;
	private final int X;

	public DynamicArrayPush(DynamicArray D, int x) {
		super(D.panel);
		this.D = D;
		X = x;
	}

	@Override
	public void runAlgorithm() throws InterruptedException {
		setHeader("insert", X);
		
		if(D.A.END == D.A.getSize()) {
			addStep("done"); // zmenit
			
			Array B = new Array(1,D.getZDepth());
			B.END=2*D.A.END;
			addToScene(B);
			pause();
			
			for(D.A.BEGIN = 1; D.A.BEGIN <= D.A.END; D.A.BEGIN++) {
				B.push(D.A.get(D.A.BEGIN-1));
				//addToScene(D.A);
				//addToScene(B);	
				pause();
			}
			D.A = B;
			removeFromScene(B);
			D.A.setState(0);
			D.A.BEGIN = 0;
			addToScene(D.A);
			
			pause();
		}
		D.A.push(X);
		addNote("done");
	}

}