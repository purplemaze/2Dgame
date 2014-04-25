package se.addoit.rain.level.tile.spawn_level;

import se.addoit.rain.graphics.Screen;
import se.addoit.rain.graphics.Sprite;
import se.addoit.rain.level.tile.Tile;

public class SpawnGrassTile extends Tile{

	public SpawnGrassTile(Sprite sprite) {
		super(sprite);
	}
	
	/**
	 * Render metod
	 */
	public void render (int x, int y, Screen screen) {
		screen.renderTile(x << 4, y << 4, this);  // this, this GrassTile, << 4 konvertar tillbaka till pixel pressision
	}


}
