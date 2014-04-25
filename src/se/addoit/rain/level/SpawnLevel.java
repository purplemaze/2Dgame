package se.addoit.rain.level;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;


/**
 * SpwanLevel klass
 * subklass till level
 * @author Daniel
 * @version 1
 */
public class SpawnLevel extends Level{
	
	/**
	 * Konstruktor
	 * @param path
	 */
	public SpawnLevel(String path) {
		super(path);
	}
	
	/**
	 * 
	 */
	protected void loadLevel(String path) {
		try {
			BufferedImage image = ImageIO.read(SpawnLevel.class.getResource(path));
			int w = width = image.getWidth();
			int h = height = image.getHeight();
			tiles = new int[w * h];
			image.getRGB(0, 0, w, h, tiles, 0, w);
			
		} catch(IOException e) {
			e.printStackTrace();
			System.out.println("Exception! Could not load level file!");
			
		}
	}
	
	/**
	 * Generates the level
	 * A pixel represents a tile
	 * Grass = 0xFF00FF00
	 * Flower = 0xFFFFD800
	 * Rock = 0xFF7F6A00
	 */
	protected void generateLevel() {

	}

}
