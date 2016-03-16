package view.panels.inputPanel;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import dao.DAO;
import listeners.inputPanel.InputPanelButtonListener;
import preferences.UserPreferences;

public class B_DataGeneratorInputPanel extends A_DataOfInputPanel {
	
	public B_DataGeneratorInputPanel() {
		try {
			List<Image> tiles = generateTiles();
			buildButtonsFromTiles(tiles);
		} catch (IOException e) {}
	}
	
	// need to change to cscale output
	private List<Image> generateTiles() throws IOException {
		// Output is list of buttons that will be clicked on scren later
		List<Image> output = new ArrayList<Image>();
		
		// Input of tiles is single image - needs to be splt into tiles
		UserPreferences userPreferences = DAO.getUserPreferences();		
		File tileRawFile = new File(userPreferences.getResourceFolder() + "/Tilesets/" + userPreferences.getSelectedTileset());		
		BufferedImage tileRaw = ImageIO.read(tileRawFile);
		
		// Time to split!
		int numRows = userPreferences.getInputHeight();
		int numCols = userPreferences.getInputWidth();
		
		int heightTile = (int) (tileRaw.getHeight(null) / numRows);
		int widthTile = (int) (tileRaw.getWidth(null) / numCols);
		
		int scaledHeight = userPreferences.getScaledTileHeight();
		int scaledWidth = userPreferences.getScaledTileWidth();
		
		
		BufferedImage cur;
		BufferedImage scaled;
		
		for (int i = 0; i < numRows; i++) {
			for (int j = 0; j < numCols; j++) {
				// Parses tile from tilesheet
				cur = tileRaw.getSubimage((widthTile * j), (heightTile * i), widthTile, heightTile);
				// Creates scaled instance of parsed tile
				scaled = new BufferedImage(scaledWidth, scaledHeight, BufferedImage.TYPE_INT_RGB);
				scaled.getGraphics().drawImage(cur.getScaledInstance(scaledWidth, scaledHeight, Image.SCALE_SMOOTH), 0, 0, null);				
				
				output.add(scaled);
			}
		}		
		
		return output;
	}
	
	private void buildButtonsFromTiles(List<Image> tiles) {		
		JButton cur;
		int len = tiles.size();
		for (int i = 0; i < len; i++) {
			cur = new JButton(new ImageIcon(tiles.get(i)));
			cur.addActionListener(new InputPanelButtonListener(i, tiles.get(i)));
			
			super.addTileButton(cur);
		}
	}
}
