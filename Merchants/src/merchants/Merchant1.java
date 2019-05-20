package merchants;

import java.awt.Color;

import board.Tile1;
import other.Player1;
import processing.core.PApplet;

/**
 * Represents a regular merchant
 * 
 * @author Ansen
 *
 */
public class Merchant1 {

	private int x, y, speed;
	private int numMovesInEnemyLand;

	private Color color;
	private Tile1 t;
	private Player1 p;

	/**
	 * Constructs a new merchant
	 * 
	 * @param x     coordinate of merchant
	 * @param y     coordinate of merchant
	 * @param color Color of the merchant
	 */
	public Merchant1(int x, int y, Color color) {
		this.x = x;
		this.y = y;

		this.color = color;
		speed = 2;
		numMovesInEnemyLand = 0;

		p = null;
		t = null;
	}

	/**
	 * Moves the merchant
	 * 
	 * @param dirX x direction that merchant is moving
	 * @param dirY y direction that merchant is moving
	 */
	public void move(int dirX, int dirY) {
		this.x += dirX;
		this.y += dirY;

		if (p.getTileColor().equals(t.getColor())) {
			numMovesInEnemyLand++;
		} else
			numMovesInEnemyLand = 0;
	}

	/**
	 * Determines whether the merchant is next to a certain tile
	 * 
	 * @param t tile position being compared to
	 * @return true if the merchant is adjacent to the specified tile, false
	 *         otherwise
	 */
	public boolean isAdjacent(Tile1 t) {
		if ((x + 1) == t.getX() && (y + 1) == t.getY()) {
			return true;
		} else if ((x + 1) == t.getX() && (y - 1) == t.getY()) {
			return true;
		} else if ((x - 1) == t.getX() && (y + 1) == t.getY()) {
			return true;
		} else if ((x - 1) == t.getX() && (y - 1) == t.getY()) {
			return true;
		}
		return false;
	}

	/**
	 * Draws a new merchant
	 * 
	 * @param p Marker to draw things
	 */
	public void draw(PApplet p) {
		p.fill(color.getRGB());
		p.rect((y + 0.25f) * Tile1.TILE_SIZE, (x + 0.25f) * Tile1.TILE_SIZE, 0.5f * Tile1.TILE_SIZE,
				0.5f * Tile1.TILE_SIZE);
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
	 * @param x coordinate desired for merchant
	 */
	public void setX(int x) {
		this.x = x;
	}

	/**
	 * Sets the y coordinate of merchant
	 * 
	 * @param y coordinate desired for merchant
	 */
	public void setY(int y) {
		this.y = y;
	}

	/**
	 * 
	 * @return the amount of tiles the merchant can travel
	 */
	public int getSpeed() {
		return speed;
	}

	/**
	 * Sets the amount of tiles a merchant can travel
	 * 
	 * @param speed the desired speed of the merchant
	 */
	public void setSpeed(int speed) {
		this.speed = speed;
	}

	/**
	 * 
	 * @return the color of the merchant
	 */
	public Color getColor() {
		return color;
	}

	/**
	 * Sets the color of the merchant
	 * 
	 * @param color desired to set
	 */
	public void setColor(Color color) {
		this.color = color;
	}
	
	/**
	 * 
	 * @return the player that owns the merchant
	 */
	public Player1 getOwner() {
		return p;
	}
	
	/**
	 * 
	 * @param p player that becomes the owner
	 */
	public void setOwner(Player1 p) {
		this.p = p;
	}

	/**
	 * 
	 * @return number of moves the merchant has taken in the territory of other
	 *         players'
	 */
	protected int getNumMovesInEnemyLand() {
		return numMovesInEnemyLand;
	}
}