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
	private int edge;

	private int price[] = { 20, 30, 35, 40, 45 };

	/**
	 * Constructs a new Speed Merchant at (x, y) with Color c
	 * 
	 * @param x coordinate of the Speed Merchant
	 * @param y coordinate of the Speed Merchant
	 * @param c Color of the Speed Merchant
	 */
	public SpeedMerchant(int x, int y, Color c, int edge) {
		super(x, y, c, edge);
		level = 1;
	}

	/**
	 * Ability of a Speed Merchant to move extra spaces, as the level of the
	 * merchant increases, the Speed Merchant can move further
	 * 
	 * @param level    of the Speed Merchant
	 * @param movement amount of tiles a speed merchant can currently move
	 * @return new amount of leftover moves for speed merchant
	 */
	public int speed(int level, int movement) {
		if (level < 5) {
			return movement++;
		}
		return movement;
	}

	/**
	 * Returns the price of an Speed Merchant at specified level
	 * 
	 * @param level of the Speed Merchant
	 * @return price of Speed Merchant at specified level
	 */
	public int getPrice(int level) {
		return price[level - 1];
	}

}
