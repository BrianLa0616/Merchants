package merchants;

import java.awt.Color;

/**
 * Represents an auction merchant
 * 
 * @author Ansen
 *
 */
public class AuctionMerchant extends Merchant {
	private int x, y, price;
	private int level;

	/**
	 * Constructs a new Auction Merchant at (x, y) with color c
	 * 
	 * @param x coordinate of auction merchant
	 * @param y coordinate of auction merchant
	 */
	public AuctionMerchant(int x, int y, Color c) {
		super(x, y, c);
		level = 1;
	}

	/**
	 * 
	 * @return price of an Auction Merchant
	 */
	public int getPrice() {
		return price;
	}

	/**
	 * Sets the price of an Auction Merchant
	 * 
	 * @param price to upgrade
	 */
	public void setPrice(int price) {
		this.price = price;
	}

	/**
	 * Ability of an Auction Merchant to add money to the player's bid without the
	 * player needing to pay the amount, additional amount added depends on the
	 * merchant's level
	 * 
	 * @param amount player bids
	 * @return new player bid after added money
	 */
	public int auction(int amount) {
		if (level == 1) {
			return amount + 15;
		} else if (level == 2) {
			return amount + 20;
		} else if (level == 3) {
			return amount + 25;
		} else if (level == 4) {
			return amount + 30;
		}
		return amount + 40;
	}

}