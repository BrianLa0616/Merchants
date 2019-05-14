package buttons;

import java.awt.Color;

import processing.core.PApplet;

/**
 * Subclass of Button. TextButton variant to be used with Ayush's part of the
 * code, adjusted from TextButton for personal preference of use
 */
public class AyushTextButton extends Button {
	private float textX, textY;
	private Color tcol, bcol;
	private String text;
	private int size;

	/**
	 * Creates a new AyushTextButton with the following parameters
	 * 
	 * @param x      the x-coordinate of the button
	 * @param y      the y-coordinate of the button
	 * @param width  the width of the button
	 * @param height the height of the button
	 * @param textX  the x-coordinate of the button's text
	 * @param textY  the y-coordinate of the button's text
	 * @param tcol   the color of the text
	 * @param bcol   the color of the button
	 * @param text   the text to be displayed in the button
	 * @param size   the size of the text
	 */
	public AyushTextButton(float x, float y, float width, float height, float textX, float textY, Color tcol,
			Color bcol, String text, int size) {
		super(x, y, width, height);
		this.textX = textX;
		this.textY = textY;
		this.tcol = tcol;
		this.bcol = bcol;
		this.text = text;
		this.size = size;
	}

	/**
	 * Draws the button on a PApplet
	 * 
	 * @param PApplet to have the button drawn on
	 */
	public void draw(PApplet p) {
		p.fill(bcol.getRed(), bcol.getGreen(), bcol.getBlue());
		p.rect(x, y, width, height);
		p.fill(tcol.getRed(), tcol.getGreen(), tcol.getBlue());
		p.textSize(size);
		p.text(text, textX, textY);
	}

	/**
	 * Sets the text color given RGB values
	 * 
	 * @param btnR the red value of the new color
	 * @param btnG the green value of the new color
	 * @param btnB the blue value of the red color
	 */
	public void setTColor(int btnR, int btnG, int btnB) {
		tcol = new Color(btnR, btnG, btnB);
	}

	/**
	 * Sets the text color given a Color object
	 * 
	 * @param newc the Color object containing the new color
	 */
	public void setTColor(Color newc) {
		tcol = newc;

	}

	/**
	 * Sets the button's color given RGB values
	 * 
	 * @param r the red value of the new color
	 * @param g the green value of the new color
	 * @param b the blue value of the new color
	 */
	public void setBColor(int r, int g, int b) {
		bcol = new Color(r, g, b);
	}

	/**
	 * Sets the button's color given a Color object
	 * 
	 * @param newc the Color object containing the new color
	 */
	public void setBColor(Color newc) {
		bcol = newc;
	}

	/**
	 * @return the font size of the text
	 */
	public int getSize() {
		return size;
	}

	/**
	 * Sets the size of the text given a new font size
	 * 
	 * @param size the new font size
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
	 * @return the text of the button
	 */
	public String getText() {
		return text;
	}
}
