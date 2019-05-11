package merchants;

import java.awt.Color;

/**
 * Represents a Speed Merchant
 * 
 * @author Ansen
 *
 */
public class SpeedMerchant extends Merchant {
	private int x, y, price;
	private int level;

	/**
	 * Constructs a new Speed Merchant at (x, y) with Color c
	 * 
	 * @param x coordinate of the Speed Merchant
	 * @param y coordinate of the Speed Merchant
	 * @param c Color of the Speed Merchant
	 */
	public SpeedMerchant(int x, int y, Color c) {
		super(x, y, c);
	}

	/**
	 * 
	 * @return price of a Speed Merchant
	 */
	public int getPrice() {
		return price;
	}

	/**
	 * Sets the price of a Speed Merchant
	 * 
	 * @param price to upgrade
	 */
	public void setPrice(int price) {
		this.price = price;
	}

	/**
	 * Ability of a Speed Merchant to move extra spaces
	 * 
	 * @param movement amount of leftover moves for speed merchant
	 * @return new amount of leftover moves for speed merchant
	 */
	public int speed(int movement) {
		return movement + 2;

	}

}
