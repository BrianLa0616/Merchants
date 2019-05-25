package other;

import java.awt.Color;
import java.util.ArrayList;

import board.Tile;
import merchants.AuctionMerchant;
import merchants.Merchant;

public class Player {
	private ArrayList<Tile> territory;
	private ArrayList<Merchant> merchants;
	private Color merchantColor, tileColor;

	private int merchantEdge;
	private int balance;

	private int initX, initY, id;

	/**
	 * Creates a new Player with the following characteristics:
	 * 
	 * @param x            the starting point's x-coordinate
	 * @param y            the starting point's y-coordinate
	 * @param mechantColor the merchant's color, to be used for marking all of its
	 *                     merchants
	 * @param tileColor    the tile's color, to be used for marking all of its tiles
	 * @param index        id of player
	 */
	public Player(int x, int y, Color merchantColor, Color tileColor, int index) {
		initX = x;
		initY = y;
		this.id = index;
		
		merchantEdge = 0;

		balance = 100;
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

	public void addTile(Tile t) {
		territory.add(t);
		t.setOwner(this);
	}

	/**
	 * Places a bid in an auction for a tile on the map.
	 * 
	 * @param a   the auction for the desired tile.
	 * @param bid the amount this player is willing to pay in the auction.
	 */
	public void placeBid(Auction a, int bid) {
		int bonus = 0;
		for (Merchant m : getMerchants()) {
			if (m instanceof AuctionMerchant) {
				bonus += ((AuctionMerchant) m).auction(m.getLevel());
			}
		}

		a.addBid(new Bid(this, bid));
	}

	/* ----------ACCESSORS---------- */

	public void setBalance(int x) {
		balance = x;
	}

	public int getBalance() {
		return balance;
	}

	public int getId() {
		return id;
	}

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

	public Color getMerchantColor() {
		return merchantColor;
	}

	public Color getTileColor() {
		return tileColor;
	}

	public int getMerchantEdge() {
		return merchantEdge;
	}

}
