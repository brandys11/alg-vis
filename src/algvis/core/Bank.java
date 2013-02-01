package algvis.core;

import java.awt.Color;
import java.awt.geom.Rectangle2D;

import algvis.core.visual.VisualElement;
import algvis.ui.Fonts;
import algvis.ui.view.View;

public class Bank extends VisualElement {

	public int value;
	public volatile int x;
	public volatile int y;
	public int tox;
	public int toy;
	protected int steps;

	public static final int STEPS = 10;
	public static final int RADIUS = 20;

	public Bank(int zDepth, int x, int y, int value) {
		super(zDepth);
		this.x = x;
		this.y = y;
		this.value = value;
	}

	@Override
	public void draw(View v) {
		v.setColor(Color.ORANGE);
		v.fillCircle(x, y, Bank.RADIUS);
		v.setColor(Color.BLACK);
		v.drawCircle(x, y, Bank.RADIUS);
		v.drawString(Integer.toString(value), x, y, Fonts.LARGE);
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

	public void change(int x) {
		value += x;
	}

	@Override
	protected Rectangle2D getBoundingBox() {
		final int r = Bank.RADIUS + 1;
		return new Rectangle2D.Double(x - r, y - r, 2 * r, 2 * r);
	}
}
