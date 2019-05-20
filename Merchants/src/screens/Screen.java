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
	 * Creates a new Screen object with the following parameters
	 * 
	 * @param width  the width of the screen
	 * @param height the height of the screen
	 */
	public Screen(ScreenHandler board) {
		this.board = board;
	}

	public abstract void setup(PApplet p);

	public abstract void draw(PApplet p);

	public abstract void mousePressed(PApplet p);

	public abstract void mouseMoved(PApplet p);

	public abstract void mouseDragged(PApplet p);

	public abstract void mouseClicked(PApplet p);

	public abstract void mouseReleased(PApplet p);

	public abstract void keyPressed(PApplet p);

	public abstract void keyReleased(PApplet p);

}
