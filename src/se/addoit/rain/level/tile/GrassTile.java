package se.addoit.rain.level.tile;

import se.addoit.rain.graphics.Screen;
import se.addoit.rain.graphics.Sprite;

/**
 * 
 * @author Daniel
 * @version 1
 */

public class GrassTile extends Tile{

	/**
	 * Konstruktor för GrassTile
	 * @param sprite
	 */
	public GrassTile(Sprite sprite) {
		super(sprite); // super constructor from Tile class

	}
	
	/**
	 * Render metod
	 */
	public void render (int x, int y, Screen screen) {
		screen.renderTile(x << 4, y << 4, this);  // this, this GrassTile, << 4 konvertar tillbaka till pixel pressision
	}

}
