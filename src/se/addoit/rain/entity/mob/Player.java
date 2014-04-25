package se.addoit.rain.entity.mob;

import se.addoit.rain.graphics.Screen;
import se.addoit.rain.graphics.Sprite;
import se.addoit.rain.input.Keyboard;

/**
 * Player klassen
 * Subklass till Entuty
 * @author Daniel
 * @version 1
 */

public class Player extends Mob {
	
	private Keyboard input;
	private Sprite sprite;
	private int animate = 0;
	private boolean walking = false;
	private boolean running = false; 
	
	/**
	 * Konstruktor 1, tänkt för default "spawn"
	 */
	public Player(Keyboard input) {
		this.input = input;
		sprite = Sprite.player_forward;
		
	}
	
	
	/**
	 * Konstruktor 2, tänkt för "spawn" på bestämd plats
	 * @param x
	 * @param y
	 */
	public Player(int x, int y, Keyboard input) {
		this.x = x;
		this.y = y;
		this.input = input;
		sprite = Sprite.player_forward;
	}
	
	/**
	 * Update method
	 */
	public void update() {
		int xa = 0, ya = 0;
		if (animate < 7500) animate++; 
		else animate = 0;
		//walk
		if(input.up) ya--;
		if(input.down) ya++;
		if(input.left) xa--;
		if(input.right) xa++;
		
		//run
		if(input.up && input.space) {
			ya = ya - 2;
			running = true;
		}else if(input.down && input.space) {
			ya = ya + 2;
			running = true;
		}else if(input.left && input.space) {
			xa = xa - 2;
			running = true;
		}else if(input.right && input.space) {
			xa = xa + 2;
			running = true;
		}else {
			running = false;
		}
		
		
		if(xa != 0 || ya != 0) {
			move(xa, ya);
			walking = true;
		}else {
			walking = false;
		}
		
	}
	
	/**
	 * Render method
	 */
	public void render(Screen screen) {
		boolean flip = false;
		if(dir == 0) {
			sprite = Sprite.player_forward;
			if(walking) { //checks if walking
				if(animate % 20 > 10) {
					sprite = Sprite.player_forward_1;
				}else {
					sprite = Sprite.player_forward_2;
				}
			}
			if(running) { //checks if running
				if(animate % 20 > 10) {
					sprite = Sprite.player_forward_run_1;
				}else {
					sprite = Sprite.player_forward_run_2;
				}
			
			}
		}
		if(dir == 1) { 
			sprite = Sprite.player_right;
			if(walking) {
				if(animate % 20 > 10) {
					sprite = Sprite.player_right_1;
				}else {
					sprite = Sprite.player_right_2;
				}
			}
			if(running) {
				if(animate % 20 > 10) {
					sprite = Sprite.player_right_run_1;
				}else {
					sprite = Sprite.player_right_run_2;
				}
			}
		}
		if(dir == 2) {
			sprite = Sprite.player_backward;
			if(walking) {
				if(animate % 20 > 10) {
					sprite = Sprite.player_backward_1;
				}else {
					sprite = Sprite.player_backward_2;
				}
			}
			if(running) {
				if(animate % 20 > 10) {
					sprite = Sprite.player_backward_run_1;
				}else {
					sprite = Sprite.player_backward_run_2;
				}
			}
		}
		if(dir == 3) { 
			sprite = Sprite.player_left;
			if(walking) {
				if(animate % 20 > 10) {
					sprite = Sprite.player_left_1;
				}else {
					sprite = Sprite.player_left_2;
				}
			}
			if(running) {
				if(animate % 20 > 10) {
					sprite = Sprite.player_left_run_1;
				}else {
					sprite = Sprite.player_left_run_2;
				}
			}
		}
		screen.renderPlayer(x- 16, y- 16, sprite, flip, flip); //  -16 för att centrera då hela är 32x32

		
	}

}
