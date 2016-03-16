package listeners.outputPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import dao.DAO;
import data.tiles.Tile;

public class OutputPanelButtonListener implements ActionListener {
	private int id;
	private JButton button;	
	
	public OutputPanelButtonListener(int id, JButton button) {
		this.id = id;
		this.button = button;
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		DAO.addOutputTile(id, new Tile(DAO.getCurSelectedId(), DAO.getCurSelectedImage()));
		button.setIcon(new ImageIcon(DAO.getCurSelectedImage()));
		System.out.println(DAO.getCurSelectedId() + "!!");
	}

}
