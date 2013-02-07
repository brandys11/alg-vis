package algvis.ds.dynamicarray;

import java.awt.Color;
import java.awt.geom.Rectangle2D;
import java.util.ConcurrentModificationException;
import java.util.Stack;

import algvis.core.Array;
import algvis.core.CStack;
import algvis.core.DataStructure;
import algvis.internationalization.Languages;
import algvis.ui.VisPanel;
import algvis.ui.view.Alignment;
import algvis.ui.view.ClickListener;
import algvis.ui.view.View;

public class DynamicArray extends DataStructure implements ClickListener {
	public static String adtName = "dynamicarray";
	public static String dsName = "dynamicarray";

	public Array A;
	CStack newstack;
	public Stack<CStack> pushstack;
	public Stack<CStack> popstack;

	public DynamicArray(VisPanel panel) {
		super(panel);
		panel.screen.V.setDS(this);
		panel.screen.V.align = Alignment.LEFT;
		A = new Array(zDepth, 0, 150);
		A.state = Array.INVISIBLE;
		pushstack = new Stack<>();
		popstack = new Stack<>();
		newstack = new CStack(zDepth, 0, 0, CStack.RADIUS * 2 + 5, 0);
		for (int i = 0; i < 6; i++) {
			newstack.push(Color.BLUE);
			newstack.capacity = 0;
		}
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
		pushstack = new Stack<>();
		popstack = new Stack<>();
		newstack.capacity = 0;
		for (int i = 0; i < 6; i++) {
			newstack.set(i, Color.BLUE);
		}
		A.state = Array.INVISIBLE;
		panel.scene.add(this);
		//setStats();
	}

	@Override
	public void draw(View v) {
		newstack.draw(v);
		for (CStack stack : pushstack) {
			stack.draw(v);
		}
		for (CStack stack : popstack) {
			stack.draw(v);
		}
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