package se.addoit.rain.level.tile;

import se.addoit.rain.graphics.Screen;
import se.addoit.rain.graphics.Sprite;
import se.addoit.rain.level.tile.spawn_level.SpawnBushesTile;
import se.addoit.rain.level.tile.spawn_level.SpawnFloorTile;
import se.addoit.rain.level.tile.spawn_level.SpawnGrassTile;
import se.addoit.rain.level.tile.spawn_level.SpawnTreeTile;
import se.addoit.rain.level.tile.spawn_level.SpawnWallTile;
import se.addoit.rain.level.tile.spawn_level.SpawnWaterTile;
/**
 * Superklass för GrassTile och VoidTile
 * @author Daniel
 * @version 1
 *
 */

public class Tile {
	
	public int x, y;
	public Sprite sprite;
	
	//create tiles
	public static Tile grass = new GrassTile(Sprite.grass);
	public static Tile rock = new RockTile(Sprite.rock);
	public static Tile flower = new RockTile(Sprite.flower);
	public static Tile voidTile = new VoidTile(Sprite.voidSprite);
	
	//Spawn level
	public static Tile spawn_grass = new SpawnGrassTile(Sprite.spawn_grass);
	public static Tile spawn_wall = new SpawnWallTile(Sprite.spawn_wall);
	public static Tile spawn_wall2 = new SpawnWallTile(Sprite.spawn_wall2);
	public static Tile spawn_bushes = new SpawnBushesTile(Sprite.spawn_bushes);
	public static Tile spawn_tree = new SpawnTreeTile(Sprite.spawn_tree);
	public static Tile spawn_water = new SpawnWaterTile(Sprite.spawn_water);
	public static Tile spawn_floor_1 = new SpawnFloorTile(Sprite.spawn_floor_1);
	public static Tile spawn_floor_2 = new SpawnFloorTile(Sprite.spawn_floor_2);
	public static Tile spawn_floor_3 = new SpawnFloorTile(Sprite.spawn_floor_3);
	public static Tile spawn_floor_4 = new SpawnFloorTile(Sprite.spawn_floor_4);
	
	public final static int col_spawn_grass = 0xff00ff00;
	public final static int col_spawn_bushes = 0; //unused
	public final static int col_spawn_wall = 0xff808080;
	public final static int col_spawn_wall2 = 0xff7f3300;
	public final static int col_spawn_tree = 0xff007f0e; //unused
	public final static int col_spawn_water = 0xff00ffff; //unused
	public final static int col_spawn_floor_1 = 0xffff6A00;
	public final static int col_spawn_floor_2 = 0xffff4511; //unused
	public final static int col_spawn_floor_3 = 0xffb200ff; //unused
	public final static int col_spawn_floor_4 = 0xff57007f; //unused
	
	/**
	 * Tile constructor
	 * @param sprite
	 */
	public Tile(Sprite sprite) {
		this.sprite = sprite;
	}
	
	/**
	 * Render method
	 * @param x
	 * @param y
	 * @param screen
	 */
	public void render (int x, int y, Screen screen) {
		
	}
	
	/**
	 * Is the tile solid?
	 * Default solid
	 * @return false
	 */
	public boolean solid() {
		return false;
	}

}
