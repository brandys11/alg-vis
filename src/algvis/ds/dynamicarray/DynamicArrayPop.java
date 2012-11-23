package algvis.ds.dynamicarray;

import algvis.core.Algorithm;

public class DynamicArrayPop extends Algorithm {
	private final DynamicArray D;

	public DynamicArrayPop(DynamicArray D) {
		super(D.panel);
		this.D = D;
	}

	@Override
	public void runAlgorithm() throws InterruptedException {
		// nedokoncene
		D.A.pop();
		if(D.A.END/4 == D.A.getSize()) {
			D.A.END = D.A.END/2;
		}
		addToScene(D.A);
	}

}
