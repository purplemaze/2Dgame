package se.addoit.rain;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

import se.addoit.rain.entity.mob.Player;
import se.addoit.rain.graphics.Screen;
import se.addoit.rain.input.Keyboard;
import se.addoit.rain.level.*;

/**
 * The main class for the game
 * @author TheChernoProject http://www.thecherno.com
 * @author Daniel Cserhalmi
 * Version 1
 * Thx to TheChernoProject
 */

public class Game extends Canvas implements Runnable {  

	private static final long serialVersionUID = 1L; // java konvention
	
	public static int width = 300; //static means it will always be 300
	public static int height = width / 16 * 9; // ger aspekt ration 16 * 9
	public static int scale = 2;
	public static String title = "2friends presents a game..";
	
	private Thread thread; //Thread �r en subprocess
	private JFrame frame; // JFrame fr�n swing biblioteket
	private Keyboard key;
	private Level level;
	private Player player;
	private boolean running = false;
	
	private Screen screen;
	
	private BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
	private int[] pixels = ((DataBufferInt)image.getRaster().getDataBuffer()).getData();
	
	
	
	/**
	 * Konstruktorn, skapar ett nytt Dimension objekt samt s�tter PerferredSize och ny frame.
	 * Anv�nder sig av Screen klassen
	 */
	public Game() {
		Dimension size = new Dimension(width * scale, height * scale); //nytt Dimension objekt
		setPreferredSize(size); //metod i Canvas
		
		screen = new Screen(width, height);
		frame = new JFrame();
		key = new Keyboard();
		level = Level.spawn;
		TileCoordinate playerSpawn = new TileCoordinate(13, 63);
		player = new Player(playerSpawn.x(), playerSpawn.y(), key);
		player.init(level);
		addKeyListener(key);

	}
	
	/**
	 * Metod som startar en ny tr�d av "Game"
	 */
	public synchronized void start() { // synchronized h�ller koll p� v�r tr�d
		running = true;
		thread  = new Thread(this, "Display");  // this g�r att den nya tr�den �r den h�r instansen av game med parametern "Display"
		thread.start();
	}
	
	/**
	 * Metod som stoppar en tr�d av "Game" 
	 */
	public synchronized void stop() { // synchronized h�ller koll p� v�r tr�d
		running = false;
		try{
			thread.join();
		} catch(InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Run method "startar" spelet 
	 */
	public void run() {
		// r�knar ut hur m�nga g�nger vi ska anv�nda update()
		long lastTime = System.nanoTime();
		long timer  = System.currentTimeMillis();
		final double ns = 1000000000.0 / 60.0;
		double delta = 0;
		
		int frames = 0; // Hur m�nga frames kan vi rendera?
		int updates = 0; // Ska vara 60(per sekund) n�r vi skriver ut
		
		requestFocus(); //S�tter fukos p� spelet
		
		while(running) { //s�tts till true av start() s�tts till false av stop()
			long now = System.nanoTime();
			delta += (now-lastTime) / ns; //skillnaden i tid
			lastTime = now; // uppdaterar lastTime 
			while (delta >= 1) {
				update(); //eller tick som �r en vanlig spelkonvention 
				updates++;
				delta --;
			}
			render();
			frames ++;
			
			if(System.currentTimeMillis() - timer > 1000 ) {
				timer += 1000;
				frame.setTitle(title + "  |  " + updates + " ups, " + frames + " fps");
				updates = 0;
				frames = 0;
					
			}
			
		}
		stop();
	}
	

	
	/**
	 * uppdaterar spelet
	 */
	public void update() {
		key.update();
		player.update();

	}
	
	/**
	 * renderar spelet
	 */
	public void render() {
		BufferStrategy bs = getBufferStrategy();
		if(bs == null) {
			createBufferStrategy(3); // ger oss 3 buffers
			return;
		}
		
		screen.clear();
		int xScroll = player.x - screen.width / 2;
		int yScroll = player.y - screen.height / 2;
		level.render(xScroll, yScroll, screen);
		player.render(screen);
		
		for (int i = 0; i < pixels.length; i++) {
			pixels[i] = screen.pixels[i];
		}
		
		Graphics g = bs.getDrawGraphics();
		g.drawImage(image, 0, 0, getWidth(), getHeight(), null);
		g.setColor(Color.WHITE);
		g.setFont(new Font("Verdana", 0, 50));
		//g.drawString("X: " + player.x + ", Y: " + player.y, 350, 300 );
		g.dispose(); // "kastar" all grafik som inte anv�nds
		bs.show(); // visar n�sta tillg�ngliga frame
		
	}
	
	/**
	 * Javas main metod, h�r startar programmet
	 */
	public static void main(String[] args) {
		Game game = new Game();
		game.frame.setIconImage(new ImageIcon("test.jpg").getImage()); //fungerar bara om Ikonen ligger i "root" mappen i det h�r fallet \Rain
		game.frame.setResizable(false); 
		game.frame.setTitle(Game.title);
		game.frame.add(game);
		game.frame.pack(); 
		game.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // avslutar processen n�r man st�nger f�nstret
		game.frame.setLocationRelativeTo(null);
		game.frame.setVisible(true); //visar v�r frame
		
		game.start(); //startar spelet genom att anropa v�r metod start()
	}
	
}
