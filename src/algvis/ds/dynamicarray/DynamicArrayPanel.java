package algvis.ds.dynamicarray;

import algvis.core.DataStructure;
import algvis.core.Settings;
import algvis.ui.VisPanel;
import algvis.ui.view.LayoutListener;


public class DynamicArrayPanel extends VisPanel {
	
	public static Class<? extends DataStructure> DS = DynamicArray.class;
	
	public DynamicArrayPanel(Settings S) {
		super(S);
	}

	@Override
	public void initDS() {
		D = new DynamicArray(this);
		buttons = new DynamicArrayButtons(this);
		D.random(20);
	}
}

