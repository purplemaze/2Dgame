package se.addoit.rain.level;

import se.addoit.rain.graphics.Screen;
import se.addoit.rain.level.tile.Tile;

/**
 * 
 * @author Daniel
 *
 */

public class Level {
	
	protected int width, height;
	protected int[] tilesint;
	protected int[] tiles;
	public static Level spawn = new SpawnLevel("/levels/spawn.png");
	
	/**
	 * 
	 * @param width
	 * @param height
	 */
	public Level(int width, int height) {
		this.width = width;
		this.height = height;
		tilesint = new int[width * height];
		generateLevel();
	}
	
	/**
	 * 
	 * @param path
	 */
	public Level(String path) {
		loadLevel(path);
		generateLevel();
	}
	
	
	/**
	 * Generates a random level
	 */
	protected void generateLevel() {
		
	}
	
	/**
	 * 
	 * @param path
	 */
	protected void loadLevel(String path) {
		
	}
	
	/**
	 * update
	 */
	public void update() {
		
	}
	
	/**
	 * 
	 */
	@SuppressWarnings("unused")
	private void time() {
		
	}
	
	/**
	 * renderar 
	 * håller koll på pincorners
	 * @param xScroll
	 * @param yScroll
	 * @param screen
	 */
	public void render (int xScroll, int yScroll, Screen screen) {
		screen.setOffset(xScroll, yScroll);
		int x0 = xScroll >> 4;     //x0 är en asymptot längst till vänster , >> 4 = /16 bit..
		int x1 = (xScroll + screen.width + 16) >> 4;  // x1 är en asymptot längst till höger , ska inte vara 16 fixar sen
		int y0 = yScroll >> 4;	// y0 är en asymptot osv..
		int y1 = (yScroll + screen.height + 16) >> 4;
		
		for(int y = y0; y < y1; y++) {
			for(int x = x0; x < x1; x++) {
				getTile(x, y).render(x, y, screen);  // renderar en tile
			}
		}
	} 
	
	/**
	 * getTile method
	 * @param x
	 * @param y
	 * @return tile
	 * Grass = 0xFF00FF00
	 * Flower = 0xFFFFD800
	 * Rock = 0xFF7F6A00
	 */
	public Tile getTile(int x, int y) {
		if(x < 0 || y < 0 || x >= width || y >= height) return Tile.voidTile; // kollar så vi inte är utanför banan, i så fall ritar vi voidTile
		if(tiles[x + y * width] == Tile.col_spawn_floor_1) return Tile.spawn_floor_1;
		if(tiles[x + y * width] == Tile.col_spawn_floor_2) return Tile.spawn_floor_2;
		if(tiles[x + y * width] == Tile.col_spawn_floor_3) return Tile.spawn_floor_3;
		if(tiles[x + y * width] == Tile.col_spawn_floor_4) return Tile.spawn_floor_4;
		if(tiles[x + y * width] == Tile.col_spawn_grass) return Tile.spawn_grass;
		if(tiles[x + y * width] == Tile.col_spawn_bushes) return Tile.spawn_bushes;
		if(tiles[x + y * width] == Tile.col_spawn_tree) return Tile.spawn_tree;
		if(tiles[x + y * width] == Tile.col_spawn_wall) return Tile.spawn_wall;
		if(tiles[x + y * width] == Tile.col_spawn_wall2) return Tile.spawn_wall2;
		if(tiles[x + y * width] == Tile.col_spawn_water) return Tile.spawn_water;
		return Tile.voidTile;
	}
	
	/**
	 * Returnerar grass eller voidTile 
	 * Kanske ta bort den här?
	 * @param x
	 * @param y
	 * @return tile
	 */
	public Tile RamdomGetTile(int x, int y) {
		if(x < 0 || y < 0 || x >= width || y >= height) return Tile.voidTile; // kollar så vi inte är utanför banan, i så fall ritar vi voidTile
		if(tilesint[x + y * width] == 0) return Tile.grass;
		if(tilesint[x + y * width] == 1) return Tile.rock;
		if(tilesint[x + y * width] == 2) return Tile.flower;
		return Tile.voidTile;
	}

}
