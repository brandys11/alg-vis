package algvis.core;

import java.awt.Color;
import java.awt.geom.Rectangle2D;
import java.util.Stack;

import algvis.core.visual.VisualElement;
import algvis.ui.view.View;

public class CStack extends VisualElement {

	public Stack<Coin> coins;
	public int capacity;

	public volatile int x;
	public volatile int y;
	public int tox;
	public int toy;
	public int px = 0;
	public int py = 0;

	protected int steps;
	public static final int STEPS = 10;
	public static final int RADIUS = 10;

	public CStack(int zDepth, int x, int y, int px, int py) {
		super(zDepth);
		this.x = x;
		this.y = y;
		capacity = 0;
		coins = new Stack<>();
		this.px = px;
		this.py = py;
	}

	public CStack(int zDepth, int x, int y) {
		super(zDepth);
		this.x = x;
		this.y = y;
		capacity = 0;
		coins = new Stack<>();
	}

	@Override
	public void draw(View v) {
		for (int i = 0; i < capacity; i++) {
			coins.get(i).draw(v);
		}
	}

	public void push(Coin C) {
		coins.push(C);
		capacity++;
	}

	public void push(Color C) {
		coins.push(new Coin(0, x + px * coins.size() - 1, y + py * coins.size()
				- 1, C));
		capacity++;
	}

	public Coin pop() {
		if (!coins.isEmpty()) {
			capacity--;
			return coins.pop();
		}
		return null;
	}

	public void clear() {
		coins.clear();
		capacity = 0;
	}

	public void set(int i, Color C) {
		coins.get(i).color = C;
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
