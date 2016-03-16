package view.panels.outputPanel;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import dao.DAO;
import listeners.outputPanel.OutputPanelButtonListener;

public class B_DataGeneratorOutputPanel extends A_DataOfOutputPanel {
	
	public B_DataGeneratorOutputPanel() {
		super();
		List<Image> tiles = initializeTiles();
		try {
			generateButtons(tiles);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private List<Image> initializeTiles() {
		List<Image> output = new ArrayList<Image>();
		
		int size = DAO.getUserPreferences().getOutputWidth() * DAO.getUserPreferences().getOutputHeight();
		System.out.println(size);
		Image defaultImage;
		defaultImage = DAO.getCurSelectedImage();
		
		
		for (int i = 0; i < size; i++) {
			output.add(defaultImage.getScaledInstance(DAO.getUserPreferences().getScaledTileWidth(), DAO.getUserPreferences().getScaledTileHeight(), Image.SCALE_SMOOTH));			
		}
		
		return output;
	}
	
	private void generateButtons(List<Image> images) throws IOException {
		int count = images.size();
		
		JButton cur;
		for (int i = 0; i < count; i++) {
			
			cur = new JButton(new ImageIcon(images.get(i)));
			cur.setBorder(BorderFactory.createEmptyBorder());
			cur.setSize(DAO.getUserPreferences().getScaledTileWidth(), DAO.getUserPreferences().getScaledTileHeight());
			cur.addActionListener(new OutputPanelButtonListener(i, cur));
			super.addTileButton(cur);
		}
	}
}
