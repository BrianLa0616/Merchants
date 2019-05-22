package merchants;

import java.awt.Color;

import board.Checkpoint;
import board.Tile;
import board.Tile1;
import other.Player;
import processing.core.PApplet;

/**
 * Represents a regular merchant
 * 
 * @author Ansen
 *
 */
public class Merchant {

	private int x, y, speed;
	private int level;
	private int r, g, b;
	private int cost;
	private int numMovesInEnemyLand;

	private Tile t;
	private Player p;

	/**
	 * Constructs a new merchant
	 * 
	 * @param x coordinate of merchant
	 * @param y coordinate of merchant
	 */
	public Merchant(int x, int y) {
		this.x = x;
		this.y = y;
		r = 255;
		g = 255;
		b = 255;
		color = new Color(r, g, b);
		speed = 2;
		level = 0;
		t = null;
		p = null;
		numMovesInEnemyLand = 0;
	}

	/**
	 * Constructs a new merchant at (x, y) and Color c
	 * 
	 * @param x coordinate of merchant
	 * @param y coordinate of merchant
	 * @param c Color of the merchant
	 */
	public Merchant(int x, int y, Color c) {
		this.x = x;
		this.y = y;
		color = c;
		speed = 2;
		level = 0;
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

		if (p.getR() != t.getR() || p.getG() != t.getG() || p.getB() != t.getB()) {
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
		if (amount > 30) {
			t.setColor(p.getColor());
			return amount - 30;
		}
		return amount;
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
	 * @param c id of checkpoint
	 */
	public void goToCheckpt(Checkpoint c) {
		x = c.getX();
		y = c.getY();
	}

	/**
	 * Draws a new merchant
	 * 
	 * @param p Marker to draw things
	 */
	public void draw(PApplet p) {
		p.fill(color.getRGB());
		p.rect((x + 0.25f) * Tile1.TILE_SIZE, (y + 0.25f) * Tile1.TILE_SIZE, 0.5f * Tile1.TILE_SIZE,
				0.5f * Tile1.TILE_SIZE);
	}

	/**
	 * Upgrades the level of the merchant, max level 5
	 */
	public void upgrade() {
		if (level < 5)
			level++;
	}

	
	public void setTile(Tile t) {
		this.t = t;
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
	 * @return the current level of the merchant
	 */
	public int getLevel() {
		return level;
	}

	/**
	 * Sets the level of the merchant
	 * 
	 * @param level desired of merchant
	 */
	public void setLevel(int level) {
		this.level = level;
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
	 * @return r value of RGB color of merchant
	 */
	public int getR() {
		return r;
	}

	/**
	 * Sets the r value of RGB color of merchant
	 * 
	 * @param r r value of RGB
	 */
	public void setR(int r) {
		this.r = r;
	}

	/**
	 * 
	 * @return g value of RGB color of merchant
	 */
	public int getG() {
		return g;
	}

	/**
	 * Sets the g value of RGB color of merchant
	 * 
	 * @param g value of RGB color of merchant
	 */
	public void setG(int g) {
		this.g = g;
	}

	/**
	 * 
	 * @return b value of RGB color of merchant
	 */
	public int getB() {
		return b;
	}

	/**
	 * Sets the b value of RGB color of merchant
	 * 
	 * @param b value of RGB color of merchant
	 */
	public void setB(int b) {
		this.b = b;
	}

	protected int getNumMovesInEnemyLand() {
		return numMovesInEnemyLand;
	}
	

}