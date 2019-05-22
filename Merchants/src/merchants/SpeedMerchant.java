package merchants;

import java.awt.Color;

/**
 * Represents a Speed Merchant
 * 
 * @author Ansen
 *
 */
public class SpeedMerchant extends Merchant {
	private int x, y;
	private int level;

	private int price[] = { 20, 30, 35, 40, 45 };

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
	 * Ability of a Speed Merchant to move extra spaces, as the level of the
	 * merchant increases, the Speed Merchant can move further
	 * 
	 * @param movement amount of tiles a speed merchant can currently move
	 * @return new amount of leftover moves for speed merchant
	 */
	public int speed(int movement) {
		if (level < 5) {
			return movement++;
		}
		return movement;
	}

	/**
	 * 
	 * @return price of a Speed Merchant
	 */
	public int getPrice() {
		return price[0];
	}

	/**
	 * 
	 * @return price of a level 2 Speed Merchant
	 */
	public int getPrice2() {
		return price[1];
	}

	/**
	 * 
	 * @return price of a level 3 Speed Merchant
	 */
	public int getPrice3() {
		return price[2];
	}

	/**
	 * 
	 * @return price of a level 4 Speed Merchant
	 */
	public int getPrice4() {
		return price[3];
	}

	/**
	 * 
	 * @return price of a level 5 Speed Merchant
	 */
	public int getPrice5() {
		return price[4];
	}

}
