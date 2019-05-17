package buttons;

import bla269.shapes.Rectangle;
import processing.core.PApplet;

/**
 * Represents a general button in a game or menu, to be clicked on.
 */
public abstract class Button {
	protected float x, y, width, height;

	/**
	 * Creates a new Button object with the given parameters
	 * 
	 * @param x      the x-coordinate of the button
	 * @param y      the y-coordinate of the button
	 * @param width  the width of the button
	 * @param height the height of the button
	 */
	public Button(float x, float y, float width, float height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}

	/**
	 * Draws the button on a PApplet
	 * 
	 * @param p the PApplet onto which the button will be drawn
	 */
	public abstract void draw(PApplet p);

	/**
	 * @param px the x-coordinate of the point
	 * @param py the y-coordinate of the point
	 * @return true if the point (px, py) is inside the button, otherwise false
	 */
	public boolean isPointInButton(float px, float py) {
		return px >= x && px <= x + width && py >= y && py <= y + height;
	}

	/**
	 * @return the x-coordinate of the button
	 */
	public float getX() {
		return x;
	}

	/**
	 * @return the y-coordinate of the button
	 */
	public float getY() {
		return y;
	}

	/**
	 * @return the width of the button
	 */
	public float getWidth() {
		return width;
	}

	/**
	 * @return the height of the button
	 */
	public float getHeight() {
		return height;
	}

	/**
	 * Sets the button's x-coordinate
	 * 
	 * @param x the new x-value
	 */
	public void setX(float x) {
		this.x = x;
	}

	/**
	 * Sets the button's y-coordinate
	 * 
	 * @param y the new y-value
	 */
	public void setY(float y) {
		this.y = y;
	}

	/**
	 * Sets the button's width
	 * 
	 * @param width the new width value
	 */
	public void setWidth(float width) {
		this.width = width;
	}

	/**
	 * Sets the button's height
	 * 
	 * @param height the new height value
	 */
	public void setHeight(float height) {
		this.height = height;
	}

	/**
	 * @return a Rectangle object that encompasses the button, having the same
	 *         coordinates and dimensions
	 */
	public Rectangle getRectangle() {
		return new Rectangle(x, y, width, height);
	}
}