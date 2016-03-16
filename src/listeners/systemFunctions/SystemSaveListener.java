package listeners.systemFunctions;

import java.awt.KeyEventDispatcher;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;

import view.panels.savePanel.SavePanel;

public class SystemSaveListener implements KeyEventDispatcher {
	private List<Integer> keysPressed;
	private int keyCount;
	
	public SystemSaveListener() {
		System.out.println("Saver");
		keysPressed = new ArrayList<Integer>();
		keyCount = 0;
	}

	@Override
	public boolean dispatchKeyEvent(KeyEvent e) {
		if (e.getID() == KeyEvent.KEY_PRESSED) {
			System.out.println("Pressed" + e.getKeyChar());
			keysPressed.add(e.getKeyCode());
			keyCount++;
		} else if (e.getID() == KeyEvent.KEY_RELEASED) {
			keyCount--;
			System.out.println(keyCount);
			if (keyCount == 0) {
				if (keysPressed.contains(KeyEvent.VK_CONTROL) && keysPressed.contains(KeyEvent.VK_S)) {
					System.out.println("Procedure");
					JFrame saveWindow = new JFrame();
					saveWindow.add(new SavePanel().getSavePanel());
					saveWindow.pack();
					saveWindow.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
					saveWindow.setVisible(true);
					//new SaveProcedure();
				} else if (keysPressed.contains(KeyEvent.VK_B)) {
					System.out.println("Faux pas");
				}
				keysPressed.clear();
				keyCount = 0;
			}			
		} else if (e.getID() == KeyEvent.KEY_TYPED) {
			System.out.println("Pressed ");
		}
		return false;
	}

}
