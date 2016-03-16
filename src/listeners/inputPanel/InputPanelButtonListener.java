package listeners.inputPanel;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import dao.DAO;
import data.tiles.Tile;

public class InputPanelButtonListener implements ActionListener {
	private Tile tile;
	
	public InputPanelButtonListener(int id, Image theImage) {
		this.tile = new Tile(id, theImage);
		DAO.addInputTile(id, tile);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// Make curSelected equal to theImage
		DAO.setCurSelectedId(tile.getId());
		DAO.setCurSelectedImage(tile.getTile());
		DAO.getMainWindow().refreshCurSelectedPanel();
	}
	
}
