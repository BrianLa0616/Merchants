package merchants;

import java.awt.Color;

/**
 * Represents an Auction Merchant, giving its player a bonus when auctioning for
 * Tiles
 * 
 * @author Ansen
 *
 */
public class AuctionMerchant extends Merchant {

	private int[] price = { 20, 30, 35, 40, 50 };

	/**
	 * Constructs a new Auction Merchant at (x, y) with color c
	 * 
	 * @param x    x-coordinate of auction merchant
	 * @param y    y-coordinate of auction merchant
	 * @param c    Color of merchant
	 * @param edge border color of merchant
	 */
	public AuctionMerchant(int x, int y, Color c, int edge) {
		super(x, y, c, edge);
		level = 1;
	}

	/**
	 * Ability of an Auction Merchant to reduce the amount of money the player has
	 * to pay for their bid
	 * 
	 * @param level of the Auction Merchant
	 * @return percentage decreased
	 */
	public int reduce(int level) {
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