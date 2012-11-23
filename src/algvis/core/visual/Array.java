package algvis.core.visual;

import java.awt.Color;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.Hashtable;
import algvis.core.visual.VisualElement;
import algvis.ui.Fonts;
import algvis.ui.view.View;

public class Array extends VisualElement {
	protected ArrayList<Integer> List;
	public int BEGIN;
	public int END;
	
	public volatile int x = 0;
	public volatile int y = 100;
	public int tox;
	public int toy;
	
	public int state = OLD;
	public static final int OLD = 0;
	public static final int NEW = 1;
	
	public Array(int state,int zDepth) {
		super(zDepth);
		this.state = state;
		List = new ArrayList<Integer>();
		BEGIN = 0;
		END = 1;
		if (state == NEW) {
			y = 200;
		}
	}
	
	public static final int SIZE = 10;

	/* ... */
	protected int steps;

	public static final int STEPS = 10;
	
	/* ... */
	
	public int getSize() {
		return List.size();
	}
	
	public int get(int i) {
		return List.get(i);
	}
	
	public void setState(int s) {
		if (s == OLD) {
			state = OLD;
			y = 100;
		}
		else {
			state = NEW;
			y = 200;
		}
	}
	
	public void push(int x) {
		List.add(x);	
	}
	
	public void pop() {
		if (!List.isEmpty()) {
			List.remove(List.size()-1);			
		}
	}
	
	public boolean isEmpty() {
		if (List.isEmpty()) return true;
		else return false;
	}

	public void draw(View v) {
		drawArray(v);
		v.setColor(Color.BLACK);
		for(int n = BEGIN; n < List.size(); n++) {	
			drawKey(v, n, 2* n * SIZE, y);
		}
	}
	
	protected void drawKey(View v, int i, int kx, int ky) {
			v.drawString(List.get(i).toString(), kx, ky, Fonts.NORMAL);
	}

	protected void drawArray(View v) {
		for(int n = 0; n < END; n++) {
			if(n < List.size() && n >= BEGIN) {
				v.setColor(Color.YELLOW);
			}
			else {
				v.setColor(Color.lightGray);
			}
			v.fillSqr(2* n * SIZE , y , SIZE);
			v.setColor(Color.BLACK);
			v.drawSquare(2* n * SIZE , y , SIZE);
		}
	}
	
	public void goTo(int tox, int toy) {
		this.tox = tox;
		this.toy = toy;
		this.steps = STEPS;
	}

	public void move() {	
		// ?
	}
	
	
	public void moveArray() {
		move();
	}

	@Override
	public Rectangle2D getBoundingBox() {
		// ?
		int r = 1;
		return new Rectangle2D.Double(x - r, y - r, 2 * r, 2 * r); 
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
		//HashtableStoreSupport.store(state, hash + "key", key);
		// ...
	}

	@Override
	public void restoreState(Hashtable<?, ?> state) {
		super.restoreState(state);
		// ...
	}
}
