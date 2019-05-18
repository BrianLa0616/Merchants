package other;

import java.awt.Color;
import java.util.ArrayList;

import board.Tile;
import merchants.Merchant;

public class Player1 {
	private ArrayList<Tile> territory;
	private ArrayList<Merchant> merchants;
	private Color color;

	private int initX, initY;

	/**
	 * Creates a new Player with the following characteristics:
	 * 
	 * @param x     the starting point's x-coordinate
	 * @param y     the starting point's y-coordinate
	 * @param color the player's color, to be used for marking all of its territory
	 *              and merchants
	 */
	public Player1(int x, int y, Color color) {
		initX = x;
		initY = y;

		this.color = color;

		territory = new ArrayList<Tile>();
		merchants = new ArrayList<Merchant>();
		merchants.add(new Merchant(initX, initY));
		merchants.get(0).setColor(color);
	}

	/**
	 * Adds a regular Merchant at the player's starting tile.
	 */
	public void addMerchant() {
		Merchant m = new Merchant(initX, initY);
		m.setColor(color);
		merchants.add(m);
	}

	/**
	 * Adds a merchant of any type and any location to the player's collection of
	 * merchants.
	 * 
	 * @param m the Merchant to be added, containing the location and type.
	 */
	public void addMerchant(Merchant m) {
		m.setColor(color);
		merchants.add(m);
	}

	/**
	 * Places a bid in an auction for a tile on the map.
	 * 
	 * @param a   the auction for the desired tile.
	 * @param bid the amount this player is willing to pay in the auction.
	 */
	public void placeBid(Auction a, int bid) {
		a.addBid(new Bid(this, bid));
	}

	/* ----------ACCESSORS---------- */

	public ArrayList<Tile> getTerritory() {
		return territory;
	}

	public ArrayList<Merchant> getMerchants() {
		return merchants;
	}

	public int initX() {
		return initX;
	}

	public int initY() {
		return initY;
	}

	public Color getColor() {
		return color;
	}
}
