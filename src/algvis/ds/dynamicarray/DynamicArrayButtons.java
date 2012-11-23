package algvis.ds.dynamicarray;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.Vector;

import javax.swing.JPanel;
import algvis.internationalization.IButton;
import algvis.ui.Buttons;
import algvis.ui.VisPanel;


public class DynamicArrayButtons extends Buttons {
	private static final long serialVersionUID = -5243676195282879059L;
	
	private IButton pushB;	
	private IButton popB;

	public DynamicArrayButtons(VisPanel panel) {
		super(panel);
	}
	
	@Override
	public void actionButtons(JPanel P) {
		pushB = new IButton("button-push");
		pushB.setMnemonic(KeyEvent.VK_I);
		pushB.addActionListener(this);

		popB = new IButton("button-pop");
		popB.setMnemonic(KeyEvent.VK_D);
		popB.addActionListener(this);

		P.add(pushB);
		P.add(popB);
	}
	
	@Override
	public void actionPerformed(ActionEvent evt) {
		super.actionPerformed(evt);
		
		if (evt.getSource() == pushB) {
			if (panel.history.canRedo())
				panel.newAlgorithmPool();
			Vector<Integer> args = I.getNonEmptyVI();
			for (int x : args) {
				D.insert(x);
			}
		} else if (evt.getSource() == popB) {
			if (panel.history.canRedo())
				panel.newAlgorithmPool();
				((DynamicArray) D).pop();
		}
	}
}



