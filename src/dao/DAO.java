package dao;

import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.Map;

import javax.imageio.ImageIO;

import data.tiles.InputTiles;
import data.tiles.OutputTiles;
import data.tiles.Tile;
import preferences.Property;
import preferences.SystemPreferences;
import preferences.UserPreferences;
import view.windows.B_MainWindow;

public class DAO {
	private static SystemPreferences sysPreferences;
	private static UserPreferences userPreferences;
	private static Property propertiesAccess;
	private static Image curSelectedImage;
	private static int curSelectedId;
	private static B_MainWindow mainWindow;
	private static InputTiles inputTiles;
	private static OutputTiles outputTiles;
	
	public static void addInputTile(int id, Tile tile) {
		if (inputTiles == null)
			inputTiles = new InputTiles();
		inputTiles.setTile(id, tile);
	}
	
	public static InputTiles getInputTiles() {
		return inputTiles;
	}
	
	public static void addOutputTile(int id, Tile tile) {
		if (outputTiles == null)
			outputTiles = new OutputTiles();
		outputTiles.addTile(id, tile);
	}
	
	public static Map<Integer, Tile> getOutputTiles() {
		return outputTiles.getTiles();
	}
	
	public static void setMainWindow(B_MainWindow main) {
		mainWindow = main;
	}
	
	public static void refreshCurSelectedPanel() {
		mainWindow.refreshCurSelectedPanel();
	}
	
	public static B_MainWindow getMainWindow() {
		return mainWindow;
	}
	
	public static UserPreferences getUserPreferences() {
		if (userPreferences == null)
			userPreferences = new UserPreferences();
		return userPreferences;
	}
	
	public static void buildProperties() {
		try {
			propertiesAccess = new Property();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static String getProperty(String key) {
		return propertiesAccess.getProperty(key);
	}
	
	public static SystemPreferences getSystemPreferences() {
		if (sysPreferences == null)
			sysPreferences = new SystemPreferences();
		return sysPreferences;
	}
	
	public static void setCurSelectedImage(Image image) {
		curSelectedImage = image;
	}
	
	public static void setCurSelectedId(int id) {
		curSelectedId = id;
	}
	
	public static int getCurSelectedId() {
		return curSelectedId;
	}
	
	public static Image getCurSelectedImage()  {
		// Remove this later - move to SysPref
		if (curSelectedImage == null) {
			try {
				curSelectedImage = ImageIO.read(new File(getSystemPreferences().getMissingImageLocation()));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return curSelectedImage;
	}
}
