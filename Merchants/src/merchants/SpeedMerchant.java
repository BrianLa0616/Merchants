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
		level = 1;
	}

	/**
	 * 
	 * @return price of a Speed Merchant
	 */
	public int getPrice() {
		return price;
	}

	/**
	 * Ability of a Speed Merchant to move extra spaces, as the level of the
	 * merchant increases, the Speed Merchant can move further
	 * 
	 * @param movement amount of leftover moves for speed merchant
	 * @return new amount of leftover moves for speed merchant
	 */
	public int speed(int movement) {
		if (level == 2) {
			return movement + 1;
		} else if (level == 3) {
			return movement;
		} else if (level == 4) {
			return movement + 2;
		}
		return movement + 3;
	}

}
