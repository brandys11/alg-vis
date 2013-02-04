package algvis.ds.dynamicarray;

import java.awt.Color;
import java.awt.geom.Rectangle2D;
import java.util.ConcurrentModificationException;

import algvis.core.Array;
import algvis.core.CStack;
import algvis.core.DataStructure;
import algvis.internationalization.Languages;
import algvis.ui.Fonts;
import algvis.ui.VisPanel;
import algvis.ui.view.Alignment;
import algvis.ui.view.ClickListener;
import algvis.ui.view.View;

public class DynamicArray extends DataStructure implements ClickListener {
	public static String adtName = "dynamicarray";
	public static String dsName = "dynamicarray";

	Array A;
	CStack stackM;
	CStack stackC;
	CStack stackN;

	public DynamicArray(VisPanel panel) {
		super(panel);
		panel.screen.V.setDS(this);
		panel.screen.V.align = Alignment.LEFT;
		A = new Array(zDepth, 0, 150);
		A.state = Array.INVISIBLE;
		stackN = new CStack(zDepth, 0, 0, CStack.RADIUS * 2 + 5);
		for (int i = 0; i < 6; i++) {
			stackN.push(Color.BLUE);
		}
		stackN.capacity = 0;
		stackC = new CStack(zDepth, 50, 50, CStack.RADIUS);
		stackM = new CStack(zDepth, 50, 100, CStack.RADIUS);
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
		A = new Array(zDepth, 0, 150);
		stackN.capacity = 0;
		stackC = new CStack(zDepth, 50, 50, CStack.RADIUS);
		stackM = new CStack(zDepth, 50, 100, CStack.RADIUS);
		A.state = Array.INVISIBLE;
		panel.scene.add(this);
		//setStats();
	}

	@Override
	public void draw(View v) {
		stackN.draw(v);
		stackM.draw(v);
		stackC.draw(v);
		A.draw(v);
		v.drawString("Copy: ", 0, 50, Fonts.LARGE);
		v.drawString("Resize: ", 0, 100, Fonts.LARGE);
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