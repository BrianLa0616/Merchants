package buttons;

import java.awt.Color;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;

import processing.core.PApplet;

/**
 * Represents another type of button with different characteristics, adjusted
 * for personal preference of some developers.
 */
public class SButton {

	public static final int RECTANGLE = 1, CIRCLE = 2, GHOST = 3;
	private String name;
	private int buttonShape, textSize, edgeCurve;
	private double x, y, width, height;
	private boolean isActive;
	private Color color, highlightColor;
	private Rectangle2D.Double rectangleButton;
	private Ellipse2D.Double circleButton;

	/**
	 * Creates a new SButton object with the following parameters, and a light blue
	 * background color
	 * 
	 * @param name     the display text of the button
	 * @param textSize the text's font size
	 * @param shape    the general shape of the button (rectangle, circle, or ghost)
	 * @param x        the x-coordinate of the button
	 * @param y        the y-coordinate of the button
	 * @param width    the width of the button
	 * @param height   the height of the button
	 */
	public SButton(String name, int textSize, int shape, double x, double y, double width, double height) {
		this.name = name;
		this.buttonShape = shape;
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		color = new Color(135, 206, 255);
		highlightColor = new Color(38, 38, 38);
		this.textSize = textSize;
		edgeCurve = 25;
		rectangleButton = new Rectangle2D.Double(x, y, width, height);

	}

	/**
	 * Creates a new SButton object with the following parameters
	 * 
	 * @param name     the display text of the button
	 * @param textSize the text's font size
	 * @param shape    the general shape of the button (rectangle, circle, or ghost)
	 * @param x        the x-coordinate of the button
	 * @param y        the y-coordinate of the button
	 * @param width    the width of the button
	 * @param height   the height of the button
	 * @param col      the background color of the button
	 */
	public SButton(String name, int textSize, int shape, double x, double y, double width, double height, Color col) {
		this.name = name;
		this.buttonShape = shape;
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		color = col;
		highlightColor = new Color(38, 38, 38);
		this.textSize = textSize;
		edgeCurve = 25;
		rectangleButton = new Rectangle2D.Double(x, y, width, height);

	}

	/**
	 * Draws this button on a PApplet
	 * 
	 * @param marker the PApplet onto which the button will be drawn
	 */
	public void draw(PApplet marker) {

		marker.fill(color.getRed(), color.getGreen(), color.getBlue());

		if (buttonShape == RECTANGLE) {
			rectangleButton = new Rectangle2D.Double(x, y, width, height);
			marker.rect((float) x, (float) y, (float) width, (float) height, edgeCurve);
		}

		if (buttonShape == CIRCLE) {
			circleButton = new Ellipse2D.Double(x - width / 2, y - height / 2, width, height);
			marker.ellipse((float) x, (float) y, (float) width, (float) height);
		}

		if (buttonShape == GHOST) {
			rectangleButton = new Rectangle2D.Double(x, y, width, height);
			int margin = 4;
			marker.fill(highlightColor.getRed(), highlightColor.getGreen(), highlightColor.getBlue());
			marker.rect((float) (x - margin), (float) (y - margin), (float) (width + margin * 2),
					(float) (height + margin * 2));
			marker.fill(38, 38, 38);
			marker.noStroke();
			marker.rect((float) x, (float) y, (float) width, (float) height);
		}

		marker.fill(255);
		marker.textSize(textSize);
		marker.textAlign(marker.CENTER, marker.CENTER);
		if (buttonShape == RECTANGLE) {
			marker.text(name, (float) (x + width / 2), (float) (y + height / 2));
		}

		if (buttonShape == CIRCLE) {
			marker.text(name, (float) (x), (float) (y));
		}
	}

	/**
	 * @param x the x-coordinate of the point
	 * @param y the y-coordinate of the point
	 * @return true if the point (x, y) is inside this button, otherwise false
	 */
	public boolean isPointInside(double x, double y) {
		if (buttonShape == RECTANGLE) {
			return rectangleButton.contains(new Point2D.Double(x, y));
		}

		if (buttonShape == CIRCLE) {
			return circleButton.contains(new Point2D.Double(x, y));
//			double centerX = this.x + width / 2, centerY = this.y + height / 2;
//			if ((Math.pow((x - centerX), 2) / Math.pow((width / 2), 2))
//					+ (Math.pow((y - centerY), 2) / Math.pow((height / 2), 2)) <= 1) {
//				return true;
//			} else{
//				return false;
//			}
		}

		if (buttonShape == GHOST) {
			return rectangleButton.contains(new Point2D.Double(x, y));
		}

		return false;
	}

	// GETTERS AND SETTERS

	/**
	 * @return the x-coordinate of the button
	 */
	public double getX() {
		return x;
	}

	/**
	 * Sets the x-coordinate of the button
	 * 
	 * @param x the new x-value
	 */
	public void setX(double x) {
		this.x = x;
	}

	/**
	 * @return the y-coordinate of the button
	 */
	public double getY() {
		return y;
	}

	/**
	 * Sets the y-coordinate of the button
	 * 
	 * @param y the new y-value
	 */
	public void setY(double y) {
		this.y = y;
	}

	/**
	 * @return the width of the button
	 */
	public double getWidth() {
		return width;
	}

	/**
	 * Sets the width of the button
	 * 
	 * @param width the new width value
	 */
	public void setWidth(double width) {
		this.width = width;
	}

	/**
	 * @return the height of the button
	 */
	public double getHeight() {
		return height;
	}

	/**
	 * Sets the height of the button
	 * 
	 * @param height the new height value
	 */
	public void setHeight(double height) {
		this.height = height;
	}

	/**
	 * @return true if the button is currently clickable by the user, otherwise
	 *         false
	 */
	public boolean getIsActive() {
		return isActive;
	}

	/**
	 * Sets the button's status in terms of being clickable
	 * 
	 * @param isActive true if this button is clickable, otherwise false
	 */
	public void setIsActive(boolean isActive) {
		this.isActive = isActive;
	}

	/**
	 * @return the color of the button
	 */
	public Color getColor() {
		return color;
	}

	/**
	 * Sets the button's color
	 * 
	 * @param color the new color value
	 */
	public void setColor(Color color) {
		this.color = color;
	}

	/**
	 * @return the color of the button in ghost form
	 */
	public Color getHighlightColor() {
		return highlightColor;
	}

	/**
	 * Sets the button's "glow" color in ghost form
	 * 
	 * @param highlightColor the new "glow" color
	 */
	public void setHighlightColor(Color highlightColor) {
		this.highlightColor = highlightColor;
	}

	/**
	 * @return the display text of this button
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the display text of this button
	 * 
	 * @param name the new text value
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the font size of the text
	 */
	public int getTextSize() {
		return textSize;
	}

	/**
	 * Sets the font size of the text
	 * 
	 * @param textSize the new font size value
	 */
	public void setTextSize(int textSize) {
		this.textSize = textSize;
	}

	/**
	 * Sets the intensity in which the corners of the rectangular SButton curve
	 * 
	 * @param edgeCurve the new curve-intensity value
	 */
	public void setEdgeCurve(int edgeCurve) {
		this.edgeCurve = edgeCurve;
	}

}