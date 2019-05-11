package merchants;

import java.awt.Color;

import board.Tile;
import processing.core.PApplet;

/**
 * Represents a regular merchant
 * 
 * @author Ansen
 *
 */
public class Merchant {

	private int x, y, speed;

	private Color color;

	/**
	 * Constructs a new merchant at (x, y) with color c
	 * 
	 * @param x x coordinate of merchant
	 * @param y y coordinate of merchant
	 * @param c color of merchant
	 */
	public Merchant(int x, int y, Color c) {
		this.x = x;
		this.y = y;
		color = c;
		speed = 2;
	}

	/**
	 * Moves the merchant
	 * 
	 * @param direction of movement
	 */
	public void move(int direction) {

	}

	/**
	 * Determines whether the merchant is next to a certain tile
	 * 
	 * @param t tile position being compared to
	 * @return true if the merchant is adjacent to the specified tile, false otherwise
	 */
	public boolean isAdjacent(Tile t) {
		if ((x + 1) == t.getX() && y == t.getY()) {
			return true;
		} else if (x == t.getX() && (y + 1) == t.getY()) {
			return true;
		} else if ((x - 1) == t.getX() && y == t.getY()) {
			return true;
		} else if (x == t.getX() && (y - 1) == t.getY()) {
			return true;
		}
		return false;
	}

	/**
	 * Purchases the land the merchant is currently on
	 * 
	 * @param amount of money the player currently has
	 * @return new amount player has
	 */
	public int purchaseLand(int amount) {

		return amount - 30;
	}

	/**
	 * Proposes an auction for a certain land
	 * 
	 * @param amount of money bidding
	 * @return the amount of bidded money
	 */
	public int proposeAuction(int amount) {
		return amount;
	}

	/**
	 * Teleports the merchant to a checkpoint
	 * 
	 * @param id of checkpoint
	 */
	public void goToCheckpt(int id) {

	}

	/**
	 * Draws a new merchant
	 * 
	 * @param p Marker to draw things
	 */
	public void draw(PApplet p) {
		p.fill(color.getRed(), color.getGreen(), color.getBlue());
		p.rect((x + 0.25f) * Tile.TILE_SIZE, (y + 0.25f) * Tile.TILE_SIZE, 0.5f * Tile.TILE_SIZE,
				0.5f * Tile.TILE_SIZE);
	}

	/**
	 * 
	 * @return x coordinate of merchant
	 */
	public int getX() {
		return x;
	}

	/**
	 * 
	 * @return y coordinate of merchant
	 */
	public int getY() {
		return y;
	}

	/**
	 * Sets the x coordinate of merchant
	 * 
	 * @param x coordinate of merchant
	 */
	public void setX(int x) {
		this.x = x;
	}

	/**
	 * Sets the y coordinate of merchant
	 * 
	 * @param y coordinate of merchant
	 */
	public void setY(int y) {
		this.y = y;
	}
}