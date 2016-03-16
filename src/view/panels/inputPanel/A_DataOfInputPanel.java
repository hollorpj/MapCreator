package view.panels.inputPanel;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;

public class A_DataOfInputPanel {
	private List<JButton> tiles;
	
	public A_DataOfInputPanel() {
		this.tiles = new ArrayList<JButton>();
	}
	
	public void addTileButton(JButton button) {
		this.tiles.add(button);
	}
	
	public void removeTileButton(int id) {
		this.tiles.remove(id);
	}
	
	public JButton getTileButton(int id) {
		return tiles.get(id);
	}
	
	public List<JButton> getTileButtons() {
		return tiles;
	}
	
	public void clearTileButtons() {
		this.tiles.clear();
	}
	
}
