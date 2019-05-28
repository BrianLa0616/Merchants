package screens;

import java.awt.Color;
import java.util.ArrayList;

import board.Board;
import other.Player;
import processing.core.PApplet;
import processing.core.PImage;

/**
 * Represents a Screen Handler which draws the screens
 * 
 * @author Eylam
 *
 */
public class ScreenHandler extends PApplet {
	/**
	 * The colors for each player's assets
	 */
	public static final Color[] PLAYER_COLORS = { new Color(200, 0, 0), new Color(0, 0, 200), new Color(200, 100, 0),
			new Color(50, 255, 50) };

	/**
	 * The colors for each player's territory
	 */
	public static final Color[] TILE_COLORS = { new Color(255, 50, 50), new Color(50, 50, 255), new Color(255, 155, 55),
			new Color(50, 255, 50) };

	private Screen currScreen;
	private ArrayList<Player> players;
	private PImage background;

	private int currPlayer;
	private Board board;

	/**
	 * Creates a new ScreenHandler with the current screen as the start menu screen,
	 * and initializes the board tiles
	 */
	public ScreenHandler() {
		currScreen = new IntroScreen(this);
		players = new ArrayList<Player>();

		currPlayer = 0;
		board = null;
		currScreen.setup(this);
	}

	/**
	 * Sets the background to the town image
	 */
	public void setup() {
		background = loadImage("images" + System.getProperty("file.separator") + "town.png");
	}

	/**
	 * Draws the screen
	 */
	public void draw() {
		background(255);
		image(background, 0, 0);

		currScreen.draw(this);
	}

	/**
	 * Moves on to the next screen specified
	 * 
	 * @param s Screen desired to proceed to
	 */
	public void proceed(Screen s) {
		currScreen = s;
	}

	/**
	 * 
	 * @return players
	 */
	public ArrayList<Player> getPlayers() {
		return players;
	}

	/**
	 * 
	 * @return board
	 */
	public Board getBoard() {
		return board;
	}

	/**
	 * 
	 * @return currPlayer current player
	 */
	public int getCurrentPlayer() {
		return currPlayer;
	}

	/**
	 * Restarts the board
	 */
	public void restart() {
		players.clear();
		board = null;
		currPlayer = 0;
		currScreen = new IntroScreen(this);

	}

	/**
	 * Sets the board to another desired board
	 * 
	 * @param b board being set to
	 */
	public void setBoard(Board b) {
		board = b;
		board.setup(this);
	}

	/**
	 * Wrapper for the current screen's mousePressed
	 */
	public void mousePressed() {
		currScreen.mousePressed(this);
	}

	/**
	 * Wrapper for the current screen's mouseMoved
	 */
	public void mouseMoved() {
		currScreen.mouseMoved(this);
	}

	/**
	 * Wrapper for the current screen's mouseDragged
	 */
	public void mouseDragged() {
		currScreen.mouseDragged(this);
	}

	/**
	 * Wrapper for the current screen's mouseCLicked
	 */
	public void mouseClicked() {
		currScreen.mouseClicked(this);
	}

	/**
	 * Wrapper for the current screen's mouseReleased
	 */
	public void mouseReleased() {
		currScreen.mouseReleased(this);
	}

	/**
	 * Wrapper for the current screen's keyPressed
	 */
	public void keyPressed() {
		currScreen.keyPressed(this);
	}

	/**
	 * Wrapper for the current screen's keyReleased
	 */
	public void keyReleased() {
		currScreen.keyReleased(this);
	}
}
