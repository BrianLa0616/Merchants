package merchants;

import java.awt.Color;

/**
 * Represents an Invisible Merchant
 * 
 * @author Ansen
 */
public class InvisibleMerchant extends Merchant {
	private int x, y, price;
	private int level;
	private boolean visible;

	/**
	 * Constructs a new Invisible Merchant at (x, y) with color c
	 * 
	 * @param x coordinate of the Invisible Merchant
	 * @param y coordinate of the Invisible Merchant
	 * @param c Color of the Invisible Merchant
	 */
	public InvisibleMerchant(int x, int y, Color c) {
		super(x, y, c);
		level = 1;
	}

	/**
	 * 
	 * @return cost of an Invisible Merchant
	 */
	public int getPrice() {
		return price;
	}

	/**
	 * Sets the price of an Invisible Merchant
	 * 
	 * @param price cost to upgrade to an Invisible Merchant
	 */
	public void setPrice(int price) {
		this.price = price;
	}

	/**
	 * Whether or not the Invisible Merchant is visible or not to other players
	 * 
	 * @param isVisible to other players
	 */
	public void setVisibility(boolean isVisible) {
		visible = isVisible;
		// as the level goes up, the invisible merchant can travel further into enemy
		// territory while still being invisible to other players
	}

}
