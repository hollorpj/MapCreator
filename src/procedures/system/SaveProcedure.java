package procedures.system;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.imageio.ImageIO;

import dao.DAO;
import data.tiles.Tile;

public class SaveProcedure {
	
	public SaveProcedure()  {
		System.out.println("Saing");
		Map<Integer, Tile> outputTiles = DAO.getOutputTiles();
		
		StringBuilder mappingOutput = new StringBuilder();
		BufferedImage imageOutput = new BufferedImage((DAO.getUserPreferences().getOutputWidth() * DAO.getUserPreferences().getScaledTileWidth()), (DAO.getUserPreferences().getOutputHeight() * DAO.getUserPreferences().getScaledTileHeight()), BufferedImage.TYPE_INT_RGB);
		
		int numCols = DAO.getUserPreferences().getOutputWidth();
		int numRows = DAO.getUserPreferences().getOutputHeight();
		
		int tileWidth = DAO.getUserPreferences().getScaledTileWidth();
		int tileHeight = DAO.getUserPreferences().getScaledTileHeight();		
		
		Tile cur;
		int countRow = 0;
		int countCol = 0;
		for (Integer index : outputTiles.keySet()) {
			cur = outputTiles.get(index);
			System.out.println(index + "!@!@!@!");
			
			imageOutput.getGraphics().drawImage(cur.getTile(), (countCol * tileWidth), (countRow * tileHeight), tileWidth, tileHeight, null);
			mappingOutput.append(cur.getId()).append(", ");
			
			countCol++;
			if (countCol == numCols) {
				mappingOutput.replace(mappingOutput.length() - 2, mappingOutput.length(), "");
				countCol = 0;
				countRow++;
				mappingOutput.append(";\n");
				if (countRow == numRows)
					break;				
			}						
		}
		
		saveMap(imageOutput);
		try {
			saveTextMap(mappingOutput.toString());
			saveTiles();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
	
	private void saveMap(BufferedImage imageOutput) {
		try {			
			ImageIO.write(imageOutput, "png", new File(DAO.getSystemPreferences().getOutputMapLocation() + "/mapImage"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Saved");
	}
	
	private void saveTextMap(String text) throws FileNotFoundException {
		PrintWriter pw = new PrintWriter(new File(DAO.getSystemPreferences().getOutputMapLocation() + "/map.txt"));
		pw.write(text);
		pw.close();
	}
	
	private void saveTiles() throws IOException {
		Map<Integer, Tile> tiles = DAO.getInputTiles().getTiles();
		
		int count = 0;
		BufferedImage renderableImage = new BufferedImage(DAO.getUserPreferences().getScaledTileWidth(), DAO.getUserPreferences().getScaledTileHeight(), BufferedImage.TYPE_INT_RGB);
		for (Integer i : tiles.keySet()) {
			renderableImage.getGraphics().drawImage(tiles.get(count).getTile(), 0, 0, null);
			ImageIO.write(renderableImage, "png", new File(DAO.getSystemPreferences().getOutputTileLocation() + "/" +  count));
			count++;
		}
	}
	
}
