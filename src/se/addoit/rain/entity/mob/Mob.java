package se.addoit.rain.entity.mob;

import se.addoit.rain.entity.Entity;
import se.addoit.rain.graphics.Sprite;

/**
 * Mob klass
 * Subklass till Entity, det är en enhet
 * Absrakt klass
 * @author Daniel
 *
 */
public abstract class Mob extends Entity {
	
	protected Sprite sprite; //protected innebär att bara subklasser/paketet kan komma åt
	protected int dir = 0; // 0 is up, 1 is east, 2 is south, 3 is west
	protected boolean moving = false;
	protected boolean walking = false;
	
	/**
	 * Move method
	 * Upddaterar direktion, dir 
	 * Flyttar moben/enhet om ingne kollison uppstår
	 */
	public void move(int xa, int ya) {
		if(xa > 0) dir = 1;
		if(xa < 0) dir = 3;
		if(ya > 0) dir = 2;
		if(ya < 0) dir = 0;
				
		
		if(!collision(0, ya)) {
			y += ya;
		}
		
		if(!collision(xa, 0)) {
			x += xa;
		}

	}
	
	/**
	 * Update method
	 */
	public void update() {
		
	}
	
	/**
	 * Collison method
	 * @return
	 */
	private boolean collision(int xa, int ya) {
		boolean solid = false;
		if (level.getTile((x + xa) / 16, (y + ya) / 16).solid()) solid = true;
		return solid;
	}
	
	/**
	 * Render method
	 */
	public void render() {
		
	}

}
