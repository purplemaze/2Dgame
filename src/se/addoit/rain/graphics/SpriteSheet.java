package se.addoit.rain.graphics;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;


public class SpriteSheet {
	
	private String path;
	public final int SIZE;
	public int[] pixels;
	
	public static SpriteSheet tiles = new SpriteSheet("/textures/sheets/spritesheet.png", 256);
	public static SpriteSheet player = new SpriteSheet("/textures/sheets/spritesheet_player.png", 256);
	public static SpriteSheet spawn_level = new SpriteSheet("/textures/sheets/spawnlevel.png", 64);
	
	/**
	 * 
	 * @param path
	 * @param size
	 */
	public SpriteSheet(String path, int size) {
		this.path= path;
		this.SIZE = size;
		pixels = new int[SIZE * SIZE];
		loadImage();
	}


	/**
	 * Loads the image
	 */
	private void loadImage() {
		try {
			BufferedImage image = ImageIO.read(SpriteSheet.class.getResource(path));
			int w = image.getWidth();
			int h = image.getHeight();
			image.getRGB(0, 0, w, h, pixels, 0, w);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
