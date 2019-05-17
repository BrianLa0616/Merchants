package buttons;

import processing.core.PApplet;
import processing.core.PImage;

/**
 * Subclass of Button. Represents a button with an image inside it.
 */
public class ImageButton extends Button {
	private PImage image;

	/**
	 * Creates a new ImageButton object given the following parameters
	 * 
	 * @param image  the image to be displayed as the button
	 * @param x      the x-coordinate of the button
	 * @param y      the y-coordinate of the button
	 * @param width  the width of the button
	 * @param height the height of the button
	 */
	public ImageButton(PImage image, float x, float y, float width, float height) {
		super(x, y, width, height);
		this.image = image;
	}

	/**
	 * Draws the button as its image on a PApplet
	 * 
	 * @param p the PApplet onto which the ImageButton will be drawn on
	 */
	public void draw(PApplet p) {
		p.image(image, getX(), getY(), width, height);
	}
}