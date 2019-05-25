package screens;

import processing.core.PApplet;

/**
 * Represents a screen that temporarily is run on the main PApplet of the
 * program.
 * 
 * @author Eylam
 */
public abstract class Screen {

	public static final int DRAWING_WIDTH = 1100;
	public static final int DRAWING_HEIGHT = 1030;

	private ScreenHandler board;

	/**
	 * 
	 * @param board PApplet that draws the window
	 */
	public Screen(ScreenHandler board) {
		this.board = board;
	}

	/**
	 * Sets up
	 * @param p PApplet used to draw
	 */
	public abstract void setup(PApplet p);

	/**
	 * Draws
	 * @param p PApplet used to draw
	 */
	public abstract void draw(PApplet p);

	/**
	 * @param p PApplet used for mouse
	 */
	public abstract void mousePressed(PApplet p);

	/**
	 * 
	 * @param p PApplet used for mouse
	 */
	public abstract void mouseMoved(PApplet p);

	/**
	 * 
	 * @param p PApplet used for mouse
	 */
	public abstract void mouseDragged(PApplet p);

	/**
	 * 
	 * @param p PApplet used for mouse
	 */
	public abstract void mouseClicked(PApplet p);

	/**
	 * 
	 * @param p PApplet used for mouse
	 */
	public abstract void mouseReleased(PApplet p);

	/**
	 * 
	 * @param p PApplet used for keyboard
	 */
	public abstract void keyPressed(PApplet p);

	/**
	 * 
	 * @param p PApplet used to keyboard
	 */
	public abstract void keyReleased(PApplet p);

}
