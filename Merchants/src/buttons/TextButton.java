package buttons;

import java.awt.Color;

import processing.core.PApplet;
import processing.core.PConstants;

/**
 * Subclass of Button. Represents an adjusted TextButton with rounded corners
 * for the rectangle that is the button's clickable window.
 */
public class TextButton extends Button {
	private Color tcol, bcol;
	private String text;
	private int size;

	/**
	 * Creates a new TextButton object with the following parameters.
	 * 
	 * @param x      the x-coordinate of the button
	 * @param y      the y-coordinate of the button
	 * @param width  the width of the button
	 * @param height the height of the button
	 * @param tcol   the color of the button's text
	 * @param bcol   the color of the button
	 * @param text   the text to be displayed inside the button
	 * @param size   the font size of the text
	 */
	public TextButton(float x, float y, float width, float height, Color tcol, Color bcol, String text, int size) {
		super(x, y, width, height);

		this.tcol = tcol;
		this.bcol = bcol;
		this.text = text;
		this.size = size;
	}

	/**
	 * Draws this button on a PApplet
	 * 
	 * @param p the PApplet onto which the button will be drawn
	 */
	public void draw(PApplet p) {
		p.pushMatrix();
		p.pushStyle();

		p.fill(bcol.getRed(), bcol.getGreen(), bcol.getBlue());
		p.rect(x, y, width, height, 25);
		p.fill(tcol.getRed(), tcol.getGreen(), tcol.getBlue());
		p.textSize(size);
		p.textAlign(PConstants.CENTER, PConstants.CENTER);
		p.text(text, x + width / 2, y + height / 2 - 10);
		p.popMatrix();
		p.popStyle();
	}

	/**
	 * Sets the color of the button's display text given RGB values
	 * 
	 * @param btnR the new red value of the color
	 * @param btnG the new green value of the color
	 * @param btnB the new blue value of the color
	 */
	public void setTColor(int btnR, int btnG, int btnB) {
		tcol = new Color(btnR, btnG, btnB);
	}

	/**
	 * Sets the color of the button's display text given a Color object
	 * 
	 * @param newc the new color of the text
	 */
	public void setTColor(Color newc) {
		tcol = newc;

	}

	/**
	 * Sets the button's color given RGB values
	 * 
	 * @param r the new red value of the color
	 * @param g the new green value of the color
	 * @param b the new blue value of the color
	 */
	public void setBColor(int r, int g, int b) {
		bcol = new Color(r, g, b);
	}

	/**
	 * Sets the button's color given a Color object
	 * 
	 * @param newc the new color of the button
	 */
	public void setBColor(Color newc) {
		bcol = newc;
	}

	/**
	 * @return the font size of the button's display text
	 */
	public int getSize() {
		return size;
	}

	/**
	 * Sets the font size of the button's display text
	 * 
	 * @param size the new font size value
	 */
	public void setSize(int size) {
		this.size = size;
	}

	/**
	 * @return the color of the button
	 */
	public Color getBColor() {
		return bcol;
	}

	/**
	 * @return the color of the button's display text
	 */
	public String getText() {
		return text;
	}
	
	/**
	 * 
	 * @param text the new text
	 */
	public void setText(String text) {
		this.text = text;
	}
}
