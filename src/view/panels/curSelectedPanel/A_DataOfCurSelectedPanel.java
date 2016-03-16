package view.panels.curSelectedPanel;

import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import dao.DAO;

public class A_DataOfCurSelectedPanel {
	private Image image;
	
	public A_DataOfCurSelectedPanel() {
		try {
			System.out.println(DAO.getSystemPreferences().getMissingImageLocation());
			image = ImageIO.read(new File(DAO.getSystemPreferences().getMissingImageLocation()));			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public Image getCurSelectedImage() {
		return image.getScaledInstance(DAO.getUserPreferences().getScaledTileWidth(), DAO.getUserPreferences().getScaledTileHeight(), Image.SCALE_SMOOTH);
	}
	
	public void setCurSelctedImage(Image image) {
		this.image = image;
	}
}
