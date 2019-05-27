package merchants;

import java.awt.Color;

/**
 * Represents a Speed Merchant
 * 
 * @author Ansen
 *
 */
public class SpeedMerchant extends Merchant {

	private int price[] = { 20, 30, 35, 40, 45 };

	/**
	 * Constructs a new Speed Merchant at (x, y) with Color c
	 * 
	 * @param x x-coordinate of the Speed Merchant
	 * @param y y-coordinate of the Speed Merchant
	 * @param c Color of the Speed Merchant
	 * @param edge border color of merchant
	 */
	public SpeedMerchant(int x, int y, Color c, int edge) {
		super(x, y, c, edge);
		level = 1;
	}

	/**
	 * Ability of a Speed Merchant to move extra spaces, as the level of the
	 * merchant increases, the Speed Merchant can move further
	 * 
	 * @param level of the Speed Merchant
	 * @return 1 extra movement 
	 */
	public int speed(int level) {
		if (level < 5) {
			return 1;
		}
		return 1;

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
