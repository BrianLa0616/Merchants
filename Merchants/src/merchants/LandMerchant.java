package merchants;

import java.awt.Color;

/**
 * Represents a Land Merchant
 * 
 * @author Ansen
 *
 */
public class LandMerchant extends Merchant {
	private int x, y, price;
	private int level;

	/**
	 * Constructs a new Land Merchant at (x, y) with Color c
	 * 
	 * @param x coordinate of the Land Merchant
	 * @param y coordinate of the Land Merchant
	 * @param c Color of the Land Merchant
	 */
	public LandMerchant(int x, int y, Color c) {
		super(x, y, c);
		level = 1;
	}

	/**
	 * 
	 * @return price of an Land Merchant
	 */
	public int getPrice() {
		return price;
	}

	/**
	 * Ability of an Land Merchant to reduce the price of land, as the merchant's
	 * level rises, the amount of money reduced from the land will also grow
	 * 
	 * @param cost of land
	 * @return new price of land after reduction
	 */
	public int reduce(int cost) {
		if (level == 2) {
			return cost - 15;
		} else if (level == 3) {
			return cost - 20;
		} else if (level == 4) {
			return cost - 25;
		}
		return cost - 35;
	}
}
