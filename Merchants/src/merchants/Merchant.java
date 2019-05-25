package merchants;

import java.awt.Color;

import board.Board;
import board.Tile;
import other.Player;
import processing.core.PApplet;

/**
 * Represents a regular merchant
 * 
 * @author Ansen
 *
 */
public class Merchant {

	private int x, y, totalMoves, numMoves;
	private int numMovesInEnemyLand;
	protected int level;
	private int price;

	private Color color;
	private int edge;
	private Board b;
	private Tile t;
	private Player p;

	/**
	 * Constructs a new merchant
	 * 
	 * @param x     coordinate of merchant
	 * @param y     coordinate of merchant
	 * @param color Color of the merchant
	 * @param edge  border color of the merchant
	 */
	public Merchant(int x, int y, Color color, int edge) {
		this.x = x;
		this.y = y;

		this.color = color;
		totalMoves = 2;
		numMoves = 0;
		numMovesInEnemyLand = 0;
		level = 0;
		price = 20;

		this.edge = edge;

		b = null;
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
	public boolean isAdjacent(Tile t) {
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
		p.stroke(edge);
		p.rect((y + 0.25f) * Tile.TILE_SIZE, (x + 0.25f) * Tile.TILE_SIZE, 0.5f * Tile.TILE_SIZE,
				0.5f * Tile.TILE_SIZE);
		p.stroke(0);
	}

	public boolean equals(Merchant m) {
		if (x == m.getX() && y == m.getY() && edge == m.getEdge() && color == m.getColor()) {
			return true;
		}
		return false;
	}

	public int getEdge() {
		return edge;
	}

	public int setEdge(int edge) {
		this.edge = edge;
		return edge;
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
	 * Sets the x and y coordinates of merchant
	 * 
	 * @param x x-coordinate of merchant
	 * @param y y-coordinate of merchant
	 */
	public void setCoordinates(int x, int y) {
		this.x = x;
		this.y = y;
		numMoves++;
	}

	/**
	 * 
	 * @return the amount of tiles the merchant can travel
	 */
	public int getSpeed() {
		return totalMoves;
	}

	/**
	 * Sets the amount of tiles a merchant can travel
	 * 
	 * @param speed the desired speed of the merchant
	 */
	public void setSpeed(int speed) {
		totalMoves = speed;
	}

	/**
	 * 
	 * @param numMoves number of moves that is being set
	 */
	public void setNumMoves(int numMoves) {
		this.numMoves = numMoves;
	}

	/**
	 * 
	 * @return number of moves
	 */
	public int getNumMoves() {
		return numMoves;
	}

	/**
	 * 
	 * @return true if merchant can move more this turn. False otherwise
	 */
	public boolean movable() {
		return numMoves < totalMoves;
	}

	/**
	 * 
	 * @return number of moves left for this turn
	 */
	public int getMovesLeft() {
		return totalMoves - numMoves;
	}

	/**
	 * Refreshes attributes of Merchant such as number of times moved
	 */
	public void newTurn() {
		numMoves = 0;
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
	public Player getOwner() {
		return p;
	}

	/**
	 * 
	 * @param p player that becomes the owner
	 */
	public void setOwner(Player p) {
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

	/**
	 * 
	 * @return b board
	 */
	public Board getB() {
		return b;
	}

	/**
	 * 
	 * @return t tile
	 */
	public Tile getT() {
		return t;
	}

	/**
	 * 
	 * @return level of merchant
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
	 * @return total number of moves
	 */
	public int getTotalMoves() {
		return totalMoves;
	}

	/**
	 * @param level level of merchant
	 * @return price of a regular merchant
	 */
	public int getPrice(int level) {
		return price;
	}

}