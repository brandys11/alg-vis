package algvis.core;

import java.awt.Color;
import java.awt.geom.Rectangle2D;
import java.util.Hashtable;
import java.util.Stack;

import algvis.core.visual.VisualElement;
import algvis.ui.Fonts;
import algvis.ui.view.View;

public class Array extends VisualElement {
	protected Stack<Integer> list;

	public int begin;
	public int capacity;

	public volatile int x;
	public volatile int y;
	public int tox;
	public int toy;

	public Array(int zDepth, int x, int y) {
		super(zDepth);
		list = new Stack<Integer>();
		begin = 0;
		capacity = 2;
		this.x = x;
		this.y = y;
	}

	public int state = VISIBLE;
	public static final int INVISIBLE = 0;
	public static final int VISIBLE = 1;

	public static final int RADIUS = 10;
	public static final int STEPS = 10;
	protected int steps;

	public int getSize() {
		return list.size();
	}

	public int get(int i) {
		return list.get(i);
	}

	public void push(int x) {
		list.push(x);
	}

	public void pop() {
		if (!list.isEmpty()) {
			list.pop();
		}
	}

	public boolean isEmpty() {
		return list.isEmpty();
	}

	public void draw(View v) {
		if (state == VISIBLE) {
			drawArray(v);
			v.setColor(Color.BLACK);
			for (int n = begin; n < list.size(); n++) {
				drawKey(v, n, 2 * n * Array.RADIUS, y);
			}
		}
	}

	protected void drawKey(View v, int i, int kx, int ky) {
		v.drawString(list.get(i).toString(), kx, ky, Fonts.NORMAL);

	}

	protected void drawArray(View v) {
		for (int n = 0; n < capacity; n++) {
			if (n < list.size() && n >= begin) {
				v.setColor(Color.YELLOW);
			} else {
				v.setColor(Color.lightGray);
			}
			v.fillSqr(2 * n * Array.RADIUS, y, Array.RADIUS);
			v.setColor(Color.BLACK);
			v.drawSquare(2 * n * Array.RADIUS, y, Array.RADIUS);
		}
		v.setColor(Color.RED);
		v.fillRect(capacity * Array.RADIUS - Array.RADIUS, y, 1, Array.RADIUS);
		v.setColor(Color.BLUE);
		if (capacity != 2)
			v.fillRect(capacity / 2 * Array.RADIUS - Array.RADIUS, y, 1,
					Array.RADIUS);
	}

	public void goTo(int tox, int toy) {
		this.tox = tox;
		this.toy = toy;
		this.steps = STEPS;
	}

	public void move() {
		if (steps > 0) {
			x += (tox - x) / steps;
			y += (toy - y) / steps;
			--steps;
		}
	}

	@Override
	public Rectangle2D getBoundingBox() {
		return new Rectangle2D.Double(x - RADIUS, y - RADIUS, 2 * RADIUS
				* capacity, 2 * RADIUS);
	}

	@Override
	public void endAnimation() {
		// ?
	}

	@Override
	public boolean isAnimationDone() {
		// ?
		return false;
	}

	@Override
	public void storeState(Hashtable<Object, Object> state) {
		super.storeState(state);
		// HashtableStoreSupport.store(state, hash + "key", key);
		// ...
	}

	@Override
	public void restoreState(Hashtable<?, ?> state) {
		super.restoreState(state);
		// ...
	}
}
