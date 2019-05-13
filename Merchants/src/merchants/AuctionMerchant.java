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

	public void upgrade() {
		level++;
	}

	/**
	 * Ability of an Auction Merchant to add money to the player's bid without the
	 * player needing to pay the amount, as the merchant's level rises, the
	 * additional amount received will also rise merchant's level
	 * 
	 * @param amount player bids
	 * @return new player bid after added money
	 */
	public int auction(int amount) {
		if (level == 2) {
			return amount + 15;
		} else if (level == 3) {
			return amount + 20;
		} else if (level == 4) {
			return amount + 25;
		}
		return amount + 35;
	}

}