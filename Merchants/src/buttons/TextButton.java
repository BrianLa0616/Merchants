package buttons;

import processing.core.PApplet;

/**
 * Subclass of Button. Represents a button with text inside it, meant to be
 * clicked on
 */
public class TextButton extends Button {
	private float textX, textY;
	private int btnR, btnG, btnB, textR, textG, textB;
	private String text;

	/**
	 * Creates a new TextButton object with the following parameters
	 * 
	 * @param x      the x-coordinate of the button
	 * @param y      the y-coordinate of the button
	 * @param width  the width of the button
	 * @param height the height of the button
	 * @param textX  the x-coordinate of the text
	 * @param textY  the y-coordinate of the text
	 * @param btnR   the red value of the button's color
	 * @param btnG   the green value of the button's color
	 * @param btnB   the blue value of the button's color
	 * @param textR  the red value of the text's color
	 * @param textG  the green value of the text's color
	 * @param textB  the blue value of the text's color
	 * @param text   the text to be displayed in the button
	 */
	public TextButton(float x, float y, float width, float height, float textX, float textY, int btnR, int btnG,
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
	 * @param mouseX the x-coordinate of the button
	 * @param mouseY the y-coordinate of the button
	 * @return true if the point (mouseX, mouseY) is inside the button, otherwise
	 *         false
	 */
	public boolean isInBounds(int mouseX, int mouseY) {
		return mouseX > x && mouseX < x + width && mouseY > y && mouseY < y + height;
	}

	/**
	 * Sets the button's color given RGB values
	 * 
	 * @param btnR the new red of the color
	 * @param btnG the new green of the color
	 * @param btnB the new blue value of the color
	 */
	public void setColor(int btnR, int btnG, int btnB) {
		this.btnR = btnR;
		this.btnG = btnG;
		this.btnB = btnB;
	}

}
