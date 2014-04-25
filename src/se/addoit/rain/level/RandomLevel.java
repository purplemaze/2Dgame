package se.addoit.rain.level;

import java.util.Random;

/**
 * 
 * @author Daniel
 *
 */

public class RandomLevel extends Level {  
	
	private static final Random random = new Random();

	public RandomLevel(int width, int height) {
		super(width, height);  //refers to the extending constructor
		
	}
	
	protected void generateLevel() {
		for(int y = 0; y < height; y++) {
			for(int x = 0; x < width; x++) {
				tilesint[x + y * width] = random.nextInt(4);
			}
		}
	}

}
