package board;

import java.awt.Color;

import merchants.Merchant;
import processing.core.PApplet;

/**
 * 
 * @author Eylam
 *
 *         Represents a tile on the game board, that can be purchased and made
 *         into a Checkpoint.
 *
 */
public class Tile {

	public static final int TILE_SIZE = 60;

	private int x, y, type, cost, income, owner;
	private Merchant merchant;
	private boolean covered;
	private Color color;

	/**
	 * 
	 * @param x    the x-coordinate of the tile
	 * @param y    the y-coordinate of the tile
	 * @param type the type of the tile (land, sea, etc.)
	 */
	public Tile(int x, int y, int type) {
		this.x = x;
		this.y = y;
		this.type = type;
		merchant = null;
		covered = false;
		color = null;
		owner = -1;
	}

	/**
	 * @return the x-coordinate of the tile
	 */
	public int getX() {
		return x;
	}

	/**
	 * 
	 * @return the y-coordinate of the tile
	 */
	public int getY() {
		return y;
	}

	public void draw(PApplet p) {

		if (merchant != null) {
			merchant.draw(p);
		}
		

		if (color == null) {
			p.noFill();
		} else {
			p.fill(color.getRGB());
		}
		
		p.rect(x * Tile.TILE_SIZE, y * Tile.TILE_SIZE, Tile.TILE_SIZE, Tile.TILE_SIZE);

	}

	/**
	 * 
	 * @return the tile type
	 */
	public int getType() {
		return type;
	}

	/**
	 * 
	 * @param type the tile tpye
	 */
	public void setType(int type) {
		this.type = type;
	}

	/**
	 * 
	 * @return the cost to purchase the tile
	 */
	public int getCost() {
		return cost;
	}

	/**
	 * 
	 * @param cost the cost to purchase the tile
	 */
	public void setCost(int cost) {
		this.cost = cost;
	}

	/**
	 * 
	 * @return the income the tile provides to its player
	 */
	public int getIncome() {
		return income;
	}

	/**
	 * 
	 * @param income the income the tile provides to its player
	 */
	public void setIncome(int income) {
		this.income = income;
	}

	/**
	 * 
	 * @return the player who owns this tile
	 */
	public int getOwner() {
		return owner;
	}

	/**
	 * 
	 * @param owner the player who owns this tile
	 */
	public void setOwner(int owner) {
		this.owner = owner;
	}

	public Merchant getMerchant() {
		return merchant;
	}

	public void setMerchant(Merchant merchant) {
		this.merchant = merchant;
	}

	public boolean isCovered() {
		return covered;
	}

	public void uncover() {
		covered = false;
	}

	public void setFill(Color c) {
		color = c;
	}

}