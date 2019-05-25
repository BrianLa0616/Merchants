package merchants;

import java.awt.Color;

/**
 * Represents a Money Merchant
 * 
 * @author Ansen
 *
 */
public class MoneyMerchant extends Merchant {
	private int x, y;
	private int edge;

	private int price[] = { 20, 30, 40, 50, 70 };

	/**
	 * Constructs a new Money Merchant at (x, y) with Color c
	 * 
	 * @param x coordinate of the Money Merchant
	 * @param y coordinate of the Money Merchant
	 * @param c Color of the Money Merchant
	 */
	public MoneyMerchant(int x, int y, Color c, int edge) {
		super(x, y, c, edge);
		level = 1;
	}

	/**
	 * Ability of an Money Merchant to supply additional money to the player per
	 * their turn, as the merchant's level rises, the amount the player receives
	 * also rises
	 * 
	 * @param level of the Money Merchant
	 * @return player's new total amount
	 */
	public int add(int level) {
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
	 * Returns the price of an Money Merchant at specified level
	 * 
	 * @param level of the Money Merchant
	 * @return price of Money Merchant at specified level
	 */
	public int getPrice(int level) {
		return price[level - 1];
	}

}
