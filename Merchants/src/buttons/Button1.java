package buttons;

import processing.core.PApplet;

/**
 * Represents a different kind of button for personal preference between coders
 */
public abstract class Button1 {
	protected float x, y, width, height;

	/**
	 * Creates a new Button object with the given parameters
	 * 
	 * @param x      the x-coordinate of the button
	 * @param y      the y-coordinate of the button
	 * @param width  the width of the button
	 * @param height the height of the button
	 */
	public Button1(float x, float y, float width, float height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}

	/**
	 * Draws the button on a PApplet
	 * 
	 * @param p the PApplet onto which the button will be drawn on
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
	 * Sets the x-coordinate of the button
	 * 
	 * @param x the new x-value
	 */
	public void setX(float x) {
		this.x = x;
	}

	/**
	 * Sets the y-coordinate of the button
	 * 
	 * @param y the new y-value
	 */
	public void setY(float y) {
		this.y = y;
	}

	/**
	 * Sets the width of the button
	 * 
	 * @param width the new width value
	 */
	public void setWidth(float width) {
		this.width = width;
	}

	/**
	 * Sets the height of the button
	 * 
	 * @param height the new height value
	 */
	public void setHeight(float height) {
		this.height = height;
	}
}
