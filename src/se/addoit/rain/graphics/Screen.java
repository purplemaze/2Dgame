package se.addoit.rain.graphics;

import java.util.Random;

import se.addoit.rain.entity.mob.Player;
import se.addoit.rain.level.tile.Tile;

/**
 * Screen klass
 * @author Daniel
 * @version 1
 * �r ansvarig f�r att rendera tiles osv..
 * har tv� metoder render() och clear()
 */

public class Screen {
	
	public int width, height;
	public int[] pixels;
	public final int MAP_SIZE = 64;
	public final int MAP_SIZE_MASK = MAP_SIZE - 1;
	public int xOffset, yOffset;
	public int[] tiles = new int[MAP_SIZE * MAP_SIZE];
	private Random random = new Random();

	
	/**
	 * Konstruktor f�r screen
	 * @param width
	 * @param height
	 */
	public Screen(int width, int height) {
		this.width = width;
		this.height = height;
		pixels = new int[width * height]; // 50400 pixels
		setTiles();
	}
	
	/**
	 * Skapar tiles med random f�rg
	 */
	private void setTiles() {
		
		for (int i = 0; i <  MAP_SIZE *  MAP_SIZE; i++) {
			tiles[i] = random.nextInt(0xffffff);
		}
	}
	
	/**
	 * Nolst�ller sk�rmen
	 */
	public void clear() {
		for (int i = 0; i < pixels.length; i++) {
			pixels[i] = 0;
		}
	}

	
	/**
	 * Renderar tile
	 * @param xp  som �r x postitionen f�r "tilen" p� kartan
	 * @param yp  som �r y postitionen f�r "tilen" p� kartan
	 * @param tile som ska renderas
	 */
	public void renderTile(int xp, int yp, Tile tile ) {
		xp -= xOffset;
		yp -= yOffset;
		for(int y = 0; y < tile.sprite.SIZE; y++) {
			int ya = y + yp;  //y absolut v�rde beroende p� offset(yp)
			for(int x = 0; x < tile.sprite.SIZE; x++) {
				int xa = x + xp;  //y absolut v�rde beroende p� offset(xp)
				if(xa < - tile.sprite.SIZE || xa >= width || ya < 0 || ya >= height) break; // renderar endast det som "syns" p� sk�rmen  ist�llet f�r 0 - tile.sprite.SIZE
				if(xa < 0) xa = 0;
				pixels[xa + ya * width] = tile.sprite.pixels[x + y * tile.sprite.SIZE];
			}
		}
	}
	
	/**
	 * Renderar player
	 * om man skickar in xFlip eller yFlip kan man v�nda p� animationer ist�llet f�r att rita alla bilder
	 * @param xp
	 * @param yp
	 * @param sprite
	 * @param xFlip
	 * @param yFlip
	 */
	public void renderPlayer(int xp, int yp, Sprite sprite, boolean xFlip, boolean yFlip) {
		xp -= xOffset;
		yp -= yOffset;
		for(int y = 0; y < 32; y++) {
			int ya = y + yp;  //y absolut v�rde beroende p� offset(yp)
			int ys = y;
			if(yFlip) ys = 31 - y;  // om man vill v�nda p� animationerna 
			for(int x = 0; x < 32; x++) {
				int xa = x + xp;  //y absolut v�rde beroende p� offset(xp)
				int xs = x;
				if(xFlip) xs = 31 - x;  // om man vill v�nda p� animationerna 
				if(xa < - 32 || xa >= width || ya < 0 || ya >= height) break; // renderar endast det som "syns" p� sk�rmen  ist�llet f�r 0 - tile.sprite.SIZE
				if(xa < 0) xa = 0;
				int color = sprite.pixels[xs + ys * 32];
				if(color != 0x00000000) pixels[xa + ya * width] = color;
				
			}
		}
	}
	
	/**
	 * Sets offset 
	 * @param xOffset
	 * @param yOffset
	 */
	public void setOffset(int xOffset, int yOffset) {
		this.xOffset = xOffset;
		this.yOffset = yOffset;
	}
}
