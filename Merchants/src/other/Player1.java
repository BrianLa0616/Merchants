package other;

import java.awt.Color;
import java.util.ArrayList;

import board.Tile1;
import merchants.Merchant;
import merchants.Merchant1;

public class Player1 {
	private ArrayList<Tile1> territory;
	private ArrayList<Merchant1> merchants;
	private Color merchantColor, tileColor;
	
	private int money;

	private int initX, initY, id;

	/**
	 * Creates a new Player with the following characteristics:
	 * 
	 * @param x     the starting point's x-coordinate
	 * @param y     the starting point's y-coordinate
	 * @param mechantColor the merchant's color, to be used for marking all of its merchants
	 * @param tileColor the tile's color, to be used for marking all of its tiles
	 * @param index id of player
	 */
	public Player1(int x, int y, Color merchantColor, Color tileColor, int index) {
		initX = x;
		initY = y;
		this.id = index;

		money = 100;
		this.merchantColor = merchantColor;
		this.tileColor = tileColor;
		territory = new ArrayList<Tile1>();
		merchants = new ArrayList<Merchant1>();
		merchants.add(new Merchant1(initX, initY, merchantColor));
	}

	/**
	 * Adds a regular Merchant at the player's starting tile.
	 */
	public void addMerchant() {
		Merchant1 m = new Merchant1(initX, initY, merchantColor);
		merchants.add(m);
	}

	/**
	 * Adds a merchant of any type and any location to the player's collection of
	 * merchants.
	 * 
	 * @param m the Merchant to be added, containing the location and type.
	 */
	public void addMerchant(Merchant1 m) {
		m.setColor(merchantColor);
		merchants.add(m);
	}

	public void addTile(Tile1 t) {
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
		a.addBid(new Bid(this, bid));
	}

	/* ----------ACCESSORS---------- */

	public void setMoney(int x) {
		money = x;
	}
	
	public int getMoney() {
		return money;
	}
	
	public int getId() {
		return id;
	}

	public ArrayList<Tile1> getTerritory() {
		return territory;
	}

	public ArrayList<Merchant1> getMerchants() {
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
}
