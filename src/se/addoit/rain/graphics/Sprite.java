package se.addoit.rain.graphics;

public class Sprite {

	public final int SIZE;
	private int x, y;
	public int[]pixels;
	private SpriteSheet sheet;
	
	//tile sprite
	public static Sprite grass = new Sprite(16, 0, 0, SpriteSheet.tiles); //creates grass and puts it in tiles
	public static Sprite rock = new Sprite(16, 0, 1, SpriteSheet.tiles); //creates grass and puts it in tiles
	public static Sprite flower = new Sprite(16, 2, 0, SpriteSheet.tiles); //creates grass and puts it in tiles
	public static Sprite voidSprite = new Sprite(16, 0x1B87E0); //creates a void sprite with the color 0x1B87E0
	
	//Spawn Level Sprites here:
	
	public static Sprite spawn_grass = new Sprite(16, 0, 0, SpriteSheet.spawn_level);
	public static Sprite spawn_wall = new Sprite(16, 1, 0, SpriteSheet.spawn_level);
	public static Sprite spawn_wall2 = new Sprite(16, 0, 2, SpriteSheet.spawn_level);
	public static Sprite spawn_bushes = new Sprite(16, 2, 0, SpriteSheet.spawn_level);
	public static Sprite spawn_tree = new Sprite(16, 3, 0, SpriteSheet.spawn_level);
	public static Sprite spawn_water = new Sprite(16, 0, 1, SpriteSheet.spawn_level);
	public static Sprite spawn_floor_1 = new Sprite(16, 1, 1, SpriteSheet.spawn_level);
	public static Sprite spawn_floor_2 = new Sprite(16, 2, 1, SpriteSheet.spawn_level);
	public static Sprite spawn_floor_3 = new Sprite(16, 1, 2, SpriteSheet.spawn_level);
	public static Sprite spawn_floor_4 = new Sprite(16, 2, 2, SpriteSheet.spawn_level);
	
	
	//Player sprite 32 bit:
	public static Sprite player_forward = new Sprite(32, 0, 3, SpriteSheet.player);
	public static Sprite player_backward = new Sprite(32, 0, 1, SpriteSheet.player);
	public static Sprite player_left = new Sprite(32, 0, 2, SpriteSheet.player);
	public static Sprite player_right = new Sprite(32, 0, 4, SpriteSheet.player);
	
	//player movement sprite 32 bit
	public static Sprite player_forward_1 = new Sprite(32, 2, 3, SpriteSheet.player);
	public static Sprite player_forward_2 = new Sprite(32, 3, 3, SpriteSheet.player);
	
	public static Sprite player_forward_run_1 = new Sprite(32, 1, 3, SpriteSheet.player);
	public static Sprite player_forward_run_2 = new Sprite(32, 4, 3, SpriteSheet.player);
	
	public static Sprite player_backward_1 = new Sprite(32, 2, 1, SpriteSheet.player);
	public static Sprite player_backward_2 = new Sprite(32, 3, 1, SpriteSheet.player);
	
	public static Sprite player_backward_run_1 = new Sprite(32, 1, 1, SpriteSheet.player);
	public static Sprite player_backward_run_2 = new Sprite(32, 4, 1, SpriteSheet.player);
	
	public static Sprite player_left_1 = new Sprite(32, 2, 2, SpriteSheet.player);
	public static Sprite player_left_2 = new Sprite(32, 3, 2, SpriteSheet.player);
	
	public static Sprite player_left_run_1 = new Sprite(32, 1, 2, SpriteSheet.player);
	public static Sprite player_left_run_2 = new Sprite(32, 4, 2, SpriteSheet.player);
	
	public static Sprite player_right_1 = new Sprite(32, 2, 4, SpriteSheet.player);
	public static Sprite player_right_2 = new Sprite(32, 3, 4, SpriteSheet.player);
	
	public static Sprite player_right_run_1 = new Sprite(32, 1, 4, SpriteSheet.player);
	public static Sprite player_right_run_2 = new Sprite(32, 4, 4, SpriteSheet.player);
	
	/**
	 * The 1st Constructor for Sprite 
	 * @param size
	 * @param x
	 * @param y
	 * @param sheet
	 */
	public Sprite(int size, int x, int y, SpriteSheet sheet) {
		this.SIZE = size;
		pixels = new int[SIZE * SIZE];
		this.x = x * size;
		this.y = y * size;
		this.sheet = sheet;
		loadImage();	
	}
	
	/**
	 * The 2nd Constructor for Sprite 
	 * @param size
	 * @param color
	 */
	public Sprite(int size, int color) {
		this.SIZE = size;
		pixels = new int[SIZE * SIZE];
		setColor(color); 

	}
	
	private void setColor(int color) {
		for(int i = 0; i < SIZE*SIZE; i++) {
			pixels[i] = color;
		}
		
	}

	/**
	 * Loads the sprite
	 */
	private void loadImage() {
		
		for(int y = 0; y < SIZE; y++) {
			for(int x = 0; x < SIZE; x++) {
				pixels[x + y * SIZE] = sheet.pixels[(x + this.x) + (y + this.y)* sheet.SIZE];
			}
		}
		
	}
	
	
}
