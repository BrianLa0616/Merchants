package screens;

import processing.core.PApplet;

/**
 * Represents a screen that temporarily is run on the main PApplet of the
 * program.
 * 
 * @author Eylam
 */
public abstract class Screen {

	/**
	 * Width of the standard window, in pixels
	 */
	public static final int DRAWING_WIDTH = 1100;

	/**
	 * Height of the standard window, in pixels
	 */
	public static final int DRAWING_HEIGHT = 1030;

	/**
	 * Creates a new Screen object
	 */
	public Screen() {
	}

	/**
	 * Sets up the necessary properties for this Screen's GUI
	 * 
	 * @param p PApplet used to draw
	 */
	public abstract void setup(PApplet p);

	/**
	 * Draws this Screen's GUI
	 * 
	 * @param p PApplet used to draw
	 */
	public abstract void draw(PApplet p);

	/**
	 * Handles mouse press inputs
	 * 
	 * @param p PApplet used for mouse
	 */
	public abstract void mousePressed(PApplet p);

	/**
	 * Handles mouse movement input
	 * 
	 * @param p PApplet used for mouse
	 */
	public abstract void mouseMoved(PApplet p);

	/**
	 * Handles mouse dragging (pressing and moving) input
	 * 
	 * @param p PApplet used for mouse
	 */
	public abstract void mouseDragged(PApplet p);

	/**
	 * Handles mouse click (short press) input
	 * 
	 * @param p PApplet used for mouse
	 */
	public abstract void mouseClicked(PApplet p);

	/**
	 * Handles mouse release input
	 * 
	 * @param p PApplet used for mouse
	 */
	public abstract void mouseReleased(PApplet p);

	/**
	 * Handles keyboard-related presses as input
	 * 
	 * @param p PApplet used for keyboard
	 */
	public abstract void keyPressed(PApplet p);

	/**
	 * Handles keyboard-related releases of keys as input
	 * 
	 * @param p PApplet used to keyboard
	 */
	public abstract void keyReleased(PApplet p);

}
