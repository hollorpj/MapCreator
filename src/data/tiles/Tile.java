package data.tiles;

import java.awt.Image;

public class Tile {	
	private int id;
	private Image image;	
	
	public Tile(int id, Image image) {
		this.id = id;
		this.image = image;
	}
	
	public Image getTile() {
		return image;
	}
	
	public int getId() {
		return id;
	}

}
