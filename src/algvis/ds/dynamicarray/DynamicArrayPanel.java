package algvis.ds.dynamicarray;

import algvis.core.DataStructure;
import algvis.core.Settings;
import algvis.ui.VisPanel;

public class DynamicArrayPanel extends VisPanel {
	private static final long serialVersionUID = -9071300127530100549L;
	public static Class<? extends DataStructure> DS = DynamicArray.class;

	public DynamicArrayPanel(Settings S) {
		super(S);
	}

	@Override
	public void initDS() {
		D = new DynamicArray(this);
		scene.add(D);
		buttons = new DynamicArrayButtons(this);
	}

	@Override
	public void start() {
		super.start();
		D.random(8);
	}
}
