package buttons;

import processing.core.PApplet;

/**
 * Subclass of Button1. Represents a button with text inside it, with adjusted
 * characteristics compared to TextButton for personal preference of some
 * coders.
 */
public class TextButton1 extends Button1 {
	private float textX, textY;
	private int btnR, btnG, btnB, textR, textG, textB;
	private String text;

	/**
	 * Creates a new TextButton1 object with the following parameters.
	 * 
	 * @param x      the x-coordinate of the button
	 * @param y      the y-coordinate of the button
	 * @param width  the width of the button
	 * @param height the height of the button
	 * @param textX  the x-coordinate of the button's text
	 * @param textY  the y-coordinate of the button's text
	 * @param btnR   the red value of the button's color
	 * @param btnG   the green value of the button's color
	 * @param btnB   the blue value of the button's color
	 * @param textR  the red value of the text's color
	 * @param textG  the green value of the text's color
	 * @param textB  the blue value of the text's color
	 * @param text   the text to be displayed inside the button
	 */
	public TextButton1(float x, float y, float width, float height, float textX, float textY, int btnR, int btnG,
			int btnB, int textR, int textG, int textB, String text) {
		super(x, y, width, height);
		this.textX = textX;
		this.textY = textY;
		this.btnR = btnR;
		this.btnG = btnG;
		this.btnB = btnB;
		this.textR = textR;
		this.textG = textG;
		this.textB = textB;
		this.text = text;
	}

	/**
	 * Draws the button on a PApplet
	 * 
	 * @param p the PApplet onto which the button will be drawn
	 */
	public void draw(PApplet p) {
		p.fill(btnR, btnG, btnB);
		p.rect(x, y, width, height);
		p.fill(textR, textG, textB);
		p.text(text, textX, textY);
	}

	/**
	 * @param mouseX the x-coordinate of the point
	 * @param mouseY the y-coordinate of the point
	 * @return true if the point (mouseX, mouseY) is inside the button, otherwise
	 *         false
	 */
	public boolean isInBounds(int mouseX, int mouseY) {
		return mouseX > x && mouseX < x + width && mouseY > y && mouseY < y + height;
	}

	/**
	 * Sets the button's color given RGB values
	 * 
	 * @param btnR the new red value of the color
	 * @param btnG the new green value of the color
	 * @param btnB the new blue value of the color
	 */
	public void setColor(int btnR, int btnG, int btnB) {
		this.btnR = btnR;
		this.btnG = btnG;
		this.btnB = btnB;
	}

	/**
	 * Sets the text of the button
	 * 
	 * @param s the new text value
	 */
	public void setText(String s) {
		text = s;
	}

	/**
	 * Sets the width of the button
	 * 
	 * @param w the new width value
	 */
	public void setWidth(float w) {
		width = w;
	}

	/**
	 * Sets the height of the button
	 * 
	 * @param the new height value
	 */
	public void setHeight(float h) {
		height = h;
	}

}
