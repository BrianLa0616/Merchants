package merchants;

import java.awt.Color;

/**
 * Represents a Money Merchant
 * 
 * @author Ansen
 *
 */
public class MoneyMerchant extends Merchant {
	private int x, y, price;

	/**
	 * Constructs a new Money Merchant at (x, y) with Color c
	 * 
	 * @param x coordinate of the Money Merchant
	 * @param y coordinate of the Money Merchant
	 * @param c Color of the Money Merchant
	 */
	public MoneyMerchant(int x, int y, Color c) {
		super(x, y, c);
	}

	/**
	 * 
	 * @return price of a Money Merchant
	 */
	public int getPrice() {
		return price;
	}

	/**
	 * Sets the price of a Money Merchant
	 * 
	 * @param price to upgrade
	 */
	public void setPrice(int price) {
		this.price = price;
	}

	/**
	 * Ability of an Money Merchant to supply additional money to the player per their turn
	 * 
	 * @param amount of money the player currently has
	 * @return player's new total amount
	 */
	public int reduce(int amount) {
		return amount + 10;
	}
}
