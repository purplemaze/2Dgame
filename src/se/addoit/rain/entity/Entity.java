package se.addoit.rain.entity;

import java.util.Random;


import se.addoit.rain.graphics.Screen;
import se.addoit.rain.level.Level;

/**
 * Abstrakt klass för alla enheter
 * 
 * @author Daniel
 * @version 1
 */
public abstract class Entity {
	
	public int x, y;
	private boolean removed  = false;
	protected Level level;
	protected final Random random = new Random();
	
	
	/**
	 * Update method
	 */
	public void update() {
		
		
	}
	
	/**
	 * Render method
	 * @param screen
	 */
	public void render(Screen screen) {
		
	}
	
	/**
	 * Remove 
	 */
	public void remove() {
		//Remove from level
		removed = true;
	}
	
	public void init(Level level) {
		this.level = level;
	}
	
	public boolean isRemoved() {
		return removed;
	}
}
