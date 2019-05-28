package other;

import java.awt.Color;
import java.util.ArrayList;

import board.Tile;
import merchants.Merchant;

/**
 * Represents a Player in the game
 * 
 * @author Eylam
 *
 */
public class Player {
	private ArrayList<Tile> territory;
	private ArrayList<Merchant> merchants;
	private Color merchantColor, tileColor;

	private int merchantEdge;
	private int balance, income;

	private int initX, initY, id;

	/**
	 * Creates a new Player with the following characteristics:
	 * 
	 * @param x             the starting point's x-coordinate
	 * @param y             the starting point's y-coordinate
	 * @param merchantColor the merchant's color, to be used for marking all of its
	 *                      merchants
	 * @param tileColor     the tile's color, to be used for marking all of its
	 *                      tiles
	 * @param index         id of player
	 */
	public Player(int x, int y, Color merchantColor, Color tileColor, int index) {
		initX = x;
		initY = y;
		this.id = index;

		merchantEdge = 0;

		balance = 100;
		income = 0;
		this.merchantColor = merchantColor;
		this.tileColor = tileColor;
		territory = new ArrayList<Tile>();
		merchants = new ArrayList<Merchant>();
		merchants.add(new Merchant(initX, initY, merchantColor, merchantEdge));
	}

	/**
	 * Adds a regular Merchant at the player's starting tile.
	 */
	public void addMerchant() {
		Merchant m = new Merchant(initX, initY, merchantColor, merchantEdge);
		merchants.add(m);
		m.setOwner(this);
		m.setNumMoves(m.getSpeed());
		territory.get(0).setMerchant(m);
	}

	/**
	 * Adds a merchant of any type and any location to the player's collection of
	 * merchants.
	 * 
	 * @param m the Merchant to be added, containing the location and type.
	 */
	public void addMerchant(Merchant m) {
		m.setColor(merchantColor);
		m.setEdge(m.getEdge());
		merchants.add(m);
		m.setOwner(this);
		m.setNumMoves(m.getSpeed());
		territory.get(0).setMerchant(m);
	}

	/**
	 * Adds a tile to the player's total territory
	 * 
	 * @param t Tile being added
	 */
	public void addTile(Tile t) {
		territory.add(t);
		t.setOwner(this);
	}

	/**
	 * Checks if player equals specified object
	 * 
	 * @param other Object player being compared to
	 */
	public boolean equals(Object other) {
		if (!(other instanceof Player)) {
			return false;

		} else {
			Player obj = (Player) other;
			return obj.id == this.id;
		}

	}

	/**
	 * Sets the balance of the player
	 * 
	 * @param x amount of balance being set to
	 */
	public void setBalance(int x) {
		balance = x;
	}

	/**
	 * 
	 * @return balance of the player
	 */
	public int getBalance() {
		return balance;
	}

	/**
	 * 
	 * @return id of the player
	 */
	public int getId() {
		return id;
	}

	/**
	 * 
	 * @return territory ArrayList of all tiles the player owns in their territory
	 */
	public ArrayList<Tile> getTerritory() {
		return territory;
	}

	/**
	 * 
	 * @return merchants ArrayList of all merchants the player owns
	 */
	public ArrayList<Merchant> getMerchants() {
		return merchants;
	}

	/**
	 * 
	 * @return initX x coordinate of player spawn location
	 */
	public int initX() {
		return initX;
	}

	/**
	 * 
	 * @return initY y coordinate of player spawn location
	 */
	public int initY() {
		return initY;
	}

	/**
	 * 
	 * @return merchantColor of the merchant
	 */
	public Color getMerchantColor() {
		return merchantColor;
	}

	/**
	 * 
	 * @return tileColor color of the tile
	 */
	public Color getTileColor() {
		return tileColor;
	}

	/**
	 * 
	 * @return merchantEdge color of the border of each merchant, different colors
	 *         represent different types of merchants
	 */
	public int getMerchantEdge() {
		return merchantEdge;
	}

	/**
	 * 
	 * @return the player's turn-based income from tiles
	 */
	public int getIncome() {
		return income;
	}

	/**
	 * Sets the turn-based income from tiles
	 * 
	 * @param income the new income value
	 */
	public void setIncome(int income) {
		this.income = income;
	}
}
