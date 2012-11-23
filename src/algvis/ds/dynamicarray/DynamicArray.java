package algvis.ds.dynamicarray;

import java.awt.geom.Rectangle2D;
import java.util.ConcurrentModificationException;
import algvis.core.DataStructure;
import algvis.core.visual.Array;
import algvis.internationalization.Languages;
import algvis.ui.VisPanel;
import algvis.ui.view.Alignment;
import algvis.ui.view.ClickListener;
import algvis.ui.view.View;

public class DynamicArray extends DataStructure implements ClickListener  {
	public static String adtName = "dynamicarray";
    public static String dsName = "dynamicarray"; 
    
    Array A;
    
	public DynamicArray(VisPanel panel) {
		super(panel);
		panel.screen.V.setDS(this);
		panel.screen.V.align = Alignment.LEFT;
		A = new Array(0,zDepth);
	}

	@Override
	public String getName() {
		return dsName;
	}

	@Override
	public String stats() {
		return Languages.getString("size") + ": 0;   "
				+ Languages.getString("height") + ": 0;   #"
				+ Languages.getString("excess") + ": 0";
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
		A = new Array(0,zDepth);
		panel.scene.clear();
		panel.scene.add(this);
		//setStats();
	}

	@Override
	public void draw(View v) {
		if (!A.isEmpty()) {
			A.draw(v);
		}	
	}

	@Override
	public void move() throws ConcurrentModificationException {
		if (!A.isEmpty()) {
			A.moveArray();
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