package merchants;

import java.awt.Color;

import board.Tile;

/**
 * Represents a Radar Merchant
 * 
 * @author Ansen
 *
 */
public class RadarMerchant extends Merchant1 {
	private int x, y, price;
	private int level;

	/**
	 * Constructs a new Radar Merchant at (x, y) with Color c
	 * 
	 * @param x coordinate of the Radar Merchant
	 * @param y coordinate of the Radar Merchant
	 * @param c Color of the Radar Merchant
	 */
	public RadarMerchant(int x, int y, Color c) {
		super(x, y, c);
		level = 1;
	}

	/**
	 * 
	 * @return price of a Radar Merchant
	 */
	public int getPrice() {
		return price;
	}

	/**
	 * Ability of an Radar Merchant to reveal more tiles around them than an average
	 * merchant, as the Radar Merchant's level rises, so does the amount of revealed
	 * tiles around them
	 * 
	 * @param t Tiles revealed around them
	 */
	public void reveal(Tile t) {
		if (level == 2) {
			
		} else if (level == 3) {
		} else if (level == 4) {
		}
	}

}
