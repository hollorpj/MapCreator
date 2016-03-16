package data.tiles;

import java.util.Map;
import java.util.TreeMap;

public abstract class AbstractTile {
	private Map<Integer, Tile> tiles;
	
	public AbstractTile() {
		tiles = new TreeMap<Integer, Tile>();
	}
	
	public void setTile(int id, Tile tile) {
		tiles.put(id, tile);
	}
	
	public Tile getTile(int id) {
		return tiles.get(id);
	}
	
	public Map<Integer, Tile> getTiles() {
		return tiles;
	}
}
