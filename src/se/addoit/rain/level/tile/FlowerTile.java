package se.addoit.rain.level.tile;

import se.addoit.rain.graphics.Screen;
import se.addoit.rain.graphics.Sprite;

public class FlowerTile extends Tile {

	public FlowerTile(Sprite sprite) {
		super(sprite);

	}
	
	/**
	 * Render metod
	 */
	public void render (int x, int y, Screen screen) {
		screen.renderTile(x << 4, y << 4, this);  // this, this GrassTile, << 4 konvertar tillbaka till pixel pressision
	}

}
