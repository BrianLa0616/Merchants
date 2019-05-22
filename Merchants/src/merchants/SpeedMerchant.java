package merchants;

import java.awt.Color;

/**
 * Represents a Speed Merchant
 * 
 * @author Ansen
 *
 */
public class SpeedMerchant extends Merchant1 {
	private int x, y;
	private int level;

	private int price, price2, price3, price4, price5;

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

		price = 20;
		price2 = 30;
		price3 = 35;
		price4 = 40;
		price5 = 45;
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
		return price;
	}

	/**
	 * 
	 * @return price of a level 2 Speed Merchant
	 */
	public int getPrice2() {
		return price2;
	}

	/**
	 * 
	 * @return price of a level 3 Speed Merchant
	 */
	public int getPrice3() {
		return price3;
	}

	/**
	 * 
	 * @return price of a level 4 Speed Merchant
	 */
	public int getPrice4() {
		return price4;
	}

	/**
	 * 
	 * @return price of a level 5 Speed Merchant
	 */
	public int getPrice5() {
		return price5;
	}

}
