/*******************************************************************************
 * Copyright (c) 2012 Jakub Kováč, Katarína Kotrlová, Pavol Lukča, Viktor Tomkovič, Tatiana Tóthová
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 ******************************************************************************/
package algvis.ds.priorityqueues.lazybinomialheap;

import algvis.core.AlgorithmAdapter;
import algvis.core.DataStructure;
import algvis.core.Settings;
import algvis.ds.priorityqueues.MeldablePQButtons;
import algvis.ui.VisPanel;

public class LazyBinHeapPanel extends VisPanel {
	private static final long serialVersionUID = 1997265264400223983L;
	public static Class<? extends DataStructure> DS = LazyBinomialHeap.class;

	public LazyBinHeapPanel(Settings S) {
		super(S);
	}

	@Override
	public void initDS() {
		D = new LazyBinomialHeap(this);
		scene.add(D);
		buttons = new MeldablePQButtons(this);
	}

	@Override
	public void start() {
		super.start();
		pauses = false;
		D.random(7);
		D.start(new AlgorithmAdapter(this) {
			@Override
			public void runAlgorithm() throws InterruptedException {
				((MeldablePQButtons) buttons).activeHeap.setValue(2);
			}
		});
		D.random(3);
		D.start(new AlgorithmAdapter(this) {
			@Override
			public void runAlgorithm() throws InterruptedException {
				((MeldablePQButtons) buttons).activeHeap.setValue(3);
			}
		});
		D.random(5);
		D.start(new AlgorithmAdapter(this) {
			@Override
			public void runAlgorithm() throws InterruptedException {
				((MeldablePQButtons) buttons).activeHeap.setValue(1);
			}
		});
		D.start(new Runnable() {
			@Override
			public void run() {
				pauses = true;
			}
		});
		screen.V.resetView();
	}
}
