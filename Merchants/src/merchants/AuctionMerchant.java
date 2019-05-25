package merchants;

import java.awt.Color;

/**
 * Represents an auction merchant
 * 
 * @author Ansen
 *
 */
public class AuctionMerchant extends Merchant {
	private int x, y;
	private int edge;

	private int[] price = { 20, 30, 35, 40, 50 };

	/**
	 * Constructs a new Auction Merchant at (x, y) with color c
	 * 
	 * @param x coordinate of auction merchant
	 * @param y coordinate of auction merchant
	 */
	public AuctionMerchant(int x, int y, Color c, int edge) {
		super(x, y, c, edge);
		level = 1;
	}

	/**
	 * Ability of an Auction Merchant to add money to the player's bid without the
	 * player needing to pay the amount, as the merchant's level rises, the
	 * additional amount received will also rise merchant's level
	 * 
	 * @param level of the Auction Merchant
	 * @return new player bid after added money
	 */
	public int auction(int level) {
		if (level == 1) {
			return 10;
		} else if (level == 2) {
			return 15;
		} else if (level == 3) {
			return 20;
		} else if (level == 4) {
			return 25;
		}
		return 35;
	}

	/**
	 * Returns the price of an Auction Merchant at specified level
	 * 
	 * @param level of the Auction Merchant
	 * @return price of Auction Merchant at specified level
	 */
	public int getPrice(int level) {
		return price[level - 1];
	}

}