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
	 * @param amount of money the player currently has
	 * @return player's new total amount
	 */
	public int reduce(int amount) {
		if (level == 2) {
			return amount + 15;
		} else if (level == 3) {
			return amount + 20;
		} else if (level == 4) {
			return amount + 25;
		}
		return amount + 35;
	}

	/**
	 * 
	 * @return price of a Money Merchant
	 */
	public int getPrice() {
		return price[0];
	}

	/**
	 * 
	 * @return price of a level 2 Money Merchant
	 */
	public int getPrice2() {
		return price[1];
	}

	/**
	 * 
	 * @return price of a level 3 Money Merchant
	 */
	public int getPrice3() {
		return price[2];
	}

	/**
	 * 
	 * @return price of a level 4 Money Merchant
	 */
	public int getPrice4() {
		return price[3];
	}

	/**
	 * 
	 * @return price of a level 5 Money Merchant
	 */
	public int getPrice5() {
		return price[4];
	}

}
