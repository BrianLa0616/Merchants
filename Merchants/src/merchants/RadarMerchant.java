package merchants;

import java.awt.Color;

import board.Board;
import board.Tile;
import other.Player;

/**
 * Represents a Radar Merchant
 * 
 * @author Ansen
 *
 */
public class RadarMerchant extends Merchant {
	private int x, y;
	private int level;
	private int edge;

	private int price[] = { 20, 35, 45, 60, 75 };

	private int[] nx = { 0, 1, 1, 1 };
	private int[] ny = { -1, -1, 0, 1, };
	private int[] nx2 = { 0, -1, -1, -1 };
	private int[] ny2 = { 1, 1, 0, -1 };
	private int[] nx3 = { -2, -1, 0, 1, 2 };
	private int[] ny3 = { -2, -2, -2, -2, -2 };
	private int[] nx4 = { -2, -2, -2, 2, 2, 2 };
	private int[] ny4 = { -1, 0, 1, 1, 0, -1 };
	private int[] nx5 = { -2, -1, 0, 1, 2 };
	private int[] ny5 = { 2, 2, 2, 2, 2 };

	/**
	 * Constructs a new Radar Merchant at (x, y) with Color c
	 * 
	 * @param x coordinate of the Radar Merchant
	 * @param y coordinate of the Radar Merchant
	 * @param c Color of the Radar Merchant
	 */
	public RadarMerchant(int x, int y, Color c, int edge) {
		super(x, y, c, edge);
		level = 1;
	}

	/**
	 * Ability of an Radar Merchant to reveal more tiles around them than an average
	 * merchant, as the Radar Merchant's level rises, so does the amount of revealed
	 * tiles around them
	 * 
	 * @param level of the Radar Merchant
	 */
	public void reveal(int level) {
		if (level == 1) {
			for (int i = 0; i < nx.length; i++) {
				for (int j = 0; j < ny.length; j++) {
					getB().uncover(nx2[i], ny2[j]);
					getT().uncover(getOwner().getId());
				}
			}

		} else if (level == 2) {
			for (int i = 0; i < nx2.length; i++) {
				for (int j = 0; j < ny2.length; j++) {
					getB().uncover(nx2[i], ny2[j]);
					getT().uncover(getOwner().getId());
				}
			}
		} else if (level == 3) {
			for (int i = 0; i < nx3.length; i++) {
				for (int j = 0; j < ny3.length; j++) {
					getB().uncover(nx3[i], ny3[j]);
					getT().uncover(getOwner().getId());
				}
			}

		} else if (level == 4) {
			for (int i = 0; i < nx4.length; i++) {
				for (int j = 0; j < ny4.length; j++) {
					getB().uncover(nx4[i], ny4[j]);
					getT().uncover(getOwner().getId());
				}
			}
		}

		for (int i = 0; i < nx5.length; i++) {
			for (int j = 0; j < ny5.length; j++) {
				getB().uncover(nx5[i], ny5[j]);
				getT().uncover(getOwner().getId());
			}
		}

	}

	/**
	 * Returns the price of an Radar Merchant at specified level
	 * 
	 * @param level of the Radar Merchant
	 * @return price of Radar Merchant at specified level
	 */
	public int getPrice(int level) {
		return price[level - 1];
	}

}
