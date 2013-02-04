package algvis.core;

import java.awt.Color;
import java.awt.geom.Rectangle2D;
import java.util.Stack;

import algvis.core.visual.VisualElement;
import algvis.ui.view.View;

public class CStack extends VisualElement {

	public Stack<Color> coins;
	public int space;
	public int capacity;

	public volatile int x;
	public volatile int y;
	public int tox;
	public int toy;

	protected int steps;
	public static final int STEPS = 10;
	public static final int RADIUS = 10;

	public CStack(int zDepth, int x, int y, int space) {
		super(zDepth);
		this.x = x;
		this.y = y;
		this.space = space;
		capacity = 0;
		coins = new Stack<>();
	}

	@Override
	public void draw(View v) {
		int tx = x;
		for (int i = 0; i < capacity; i++) {
			v.setColor(coins.get(i));
			v.fillCircle(tx, y, CStack.RADIUS);
			v.setColor(Color.BLACK);
			v.drawCircle(tx, y, CStack.RADIUS);
			tx += space;
		}
	}

	public void push(Color C) {
		coins.push(C);
		capacity++;
	}

	public Color pop() {
		if (!coins.isEmpty()) {
			capacity--;
			return coins.pop();
		}
		return null;
	}

	public void goTo(int tox, int toy) {
		this.tox = tox;
		this.toy = toy;
		this.steps = STEPS;
	}

	@Override
	public void move() {
		if (steps > 0) {
			x += (tox - x) / steps;
			y += (toy - y) / steps;
			--steps;
		}
	}

	@Override
	protected Rectangle2D getBoundingBox() {
		final int r = CStack.RADIUS + 1;
		return new Rectangle2D.Double(x - r, y - r, 2 * r, 2 * r);
	}
}
