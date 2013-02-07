package algvis.core;

import java.awt.Color;
import java.awt.geom.Rectangle2D;

import algvis.core.visual.VisualElement;
import algvis.ui.view.View;

public class Coin extends VisualElement {

	public Color color;
	public volatile int x;
	public volatile int y;
	public int tox;
	public int toy;

	protected int steps;
	public static final int STEPS = 10;
	public static final int RADIUS = 7;

	public int state = VISIBLE;
	public static final int INVISIBLE = 0;
	public static final int VISIBLE = 1;

	public Coin(int zDepth, int x, int y, Color c) {
		super(zDepth);
		this.x = x;
		this.y = y;
		color = c;
	}

	@Override
	public void draw(View v) {
		if (state == VISIBLE) {
			v.setColor(color);
			v.fillCircle(x, y, Coin.RADIUS);
			v.setColor(Color.BLACK);
			v.drawCircle(x, y, Coin.RADIUS);
		}
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
		final int r = Coin.RADIUS + 1;
		return new Rectangle2D.Double(x - r, y - r, 2 * r, 2 * r);
	}
}
