package view.panels.outputPanel;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;

public class A_DataOfOutputPanel {
	private List<JButton> tileButtons;
	
	public A_DataOfOutputPanel() {
		this.tileButtons = new ArrayList<JButton>();
	}
	
	public void addTileButton(JButton tile) {
		tileButtons.add(tile);
	}
	
	public JButton getTileButton(int id) {
		return tileButtons.get(id);
	}
	
	public List<JButton> getTileButtons() {
		return tileButtons;
	}
}
