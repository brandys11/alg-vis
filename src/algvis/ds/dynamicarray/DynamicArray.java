package algvis.ds.dynamicarray;

import java.awt.geom.Rectangle2D;
import java.util.ConcurrentModificationException;
import algvis.core.Array;
import algvis.core.Bank;
import algvis.core.DataStructure;
import algvis.internationalization.Languages;
import algvis.ui.VisPanel;
import algvis.ui.view.Alignment;
import algvis.ui.view.ClickListener;
import algvis.ui.view.View;

public class DynamicArray extends DataStructure implements ClickListener {
	public static String adtName = "dynamicarray";
	public static String dsName = "dynamicarray";

	Array A;
	Bank B;

	public DynamicArray(VisPanel panel) {
		super(panel);
		panel.screen.V.setDS(this);
		panel.screen.V.align = Alignment.LEFT;
		A = new Array(zDepth, 0, 100);
		B = new Bank(zDepth, 10, 10, 0);
	}

	@Override
	public String getName() {
		return dsName;
	}

	@Override
	public String stats() {
		return Languages.getString("size") + ": " + A.getSize() + ";   ";
	}

	@Override
	public void insert(int x) {
		start(new DynamicArrayPush(this, x));

	}

	public void pop() {
		start(new DynamicArrayPop(this));

	}

	@Override
	public void clear() {
		A = new Array(zDepth, 0, 100);
		B.value = 0;
		A.state = Array.INVISIBLE;
		panel.scene.add(this);
		//setStats();
	}

	@Override
	public void draw(View v) {
		B.draw(v);
		A.draw(v);
	}

	@Override
	public void move() throws ConcurrentModificationException {
		if (!A.isEmpty()) {
			A.move();
		}
	}

	@Override
	public Rectangle2D getBoundingBox() {
		return A.isEmpty() == true ? null : A.getBoundingBox();
	}

	@Override
	public void mouseClicked(int x, int y) {
		// TODO Auto-generated method stub

	}
}