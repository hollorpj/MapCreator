package data.tiles;

public class OutputTiles extends AbstractTile {	
	public OutputTiles() {
		super();
	}
	
	public void addTile(int id, Tile tile) {
		getTiles().put(id, tile);
	}
}
