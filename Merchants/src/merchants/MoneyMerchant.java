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
	private int level;

	private int price[] = { 20, 30, 40, 50, 70 };

	/**
	 * Constructs a new Money Merchant at (x, y) with Color c
	 * 
	 * @param x coordinate of the Money Merchant
	 * @param y coordinate of the Money Merchant
	 * @param c Color of the Money Merchant
	 */
	public MoneyMerchant(int x, int y, Color c) {
		super(x, y, c);
		level = 1;
	}

	/**
	 * Ability of an Money Merchant to supply additional money to the player per
	 * their turn, as the merchant's level rises, the amount the player receives
	 * also rises
	 * 
	 * @param sum of money the player currently has
	 * @return player's new total amount
	 */
	public double add(double sum) {
		if (level == 2) {
			return sum + 15;
		} else if (level == 3) {
			return sum + 20;
		} else if (level == 4) {
			return sum + 25;
		}
		return sum + 35;
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
