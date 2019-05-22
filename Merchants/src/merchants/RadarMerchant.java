package merchants;

import java.awt.Color;

import board.Board1;
import board.Tile;
import board.Tile1;
import other.Player1;

/**
 * Represents a Radar Merchant
 * 
 * @author Ansen
 *
 */
public class RadarMerchant extends Merchant1 {
	private int x, y;
	private int level;
	
	private int price, price2, price3, price4, price5;

	private int[] nx = { 0, 1, 1, 1, 0, -1, -1, -1 };
	private int[] ny = { -1, -1, 0, 1, 1, 1, 0, -1 };
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
	public RadarMerchant(int x, int y, Color c) {
		super(x, y, c);
		level = 1;
		
		price = 20;
		price2 = 35;
		price3 = 45;
		price4 = 60;
		price5 = 75;
	}


	/**
	 * Ability of an Radar Merchant to reveal more tiles around them than an average
	 * merchant, as the Radar Merchant's level rises, so does the amount of revealed
	 * tiles around them
	 * 
	 * @param b board revealed around them
	 */
	public void reveal() {
		if (level == 2) {
			for (int i = 0; i < nx.length; i++) {
				for (int j = 0; j < ny.length; j++) {
					getB().uncover(nx[i], ny[j]);
					getT().uncover(getP().getId());
				}
			}
		} else if (level == 3) {
			for (int i = 0; i < nx.length; i++) {
				for (int j = 0; j < ny.length; j++) {
					getB().uncover(nx[i], ny[j]);
					getT().uncover(getP().getId());
				}
			}
			for (int i = 0; i < nx3.length; i++) {
				for (int j = 0; j < ny3.length; j++) {
					getB().uncover(nx3[i], ny3[j]);
					getT().uncover(getP().getId());
				}
			}

		} else if (level == 4) {
			for (int i = 0; i < nx.length; i++) {
				for (int j = 0; j < ny.length; j++) {
					getB().uncover(nx[i], ny[j]);
					getT().uncover(getP().getId());
				}
			}
			for (int i = 0; i < nx3.length; i++) {
				for (int j = 0; j < ny3.length; j++) {
					getB().uncover(nx3[i], ny3[j]);
					getT().uncover(getP().getId());
				}
			}
			for (int i = 0; i < nx4.length; i++) {
				for (int j = 0; j < ny4.length; j++) {
					getB().uncover(nx4[i], ny4[j]);
					getT().uncover(getP().getId());
				}
			}
		}
		for (int i = 0; i < nx.length; i++) {
			for (int j = 0; j < ny.length; j++) {
				getB().uncover(nx[i], ny[j]);
				getT().uncover(getP().getId());
			}
		}
		for (int i = 0; i < nx3.length; i++) {
			for (int j = 0; j < ny3.length; j++) {
				getB().uncover(nx3[i], ny3[j]);
				getT().uncover(getP().getId());
			}
		}
		for (int i = 0; i < nx4.length; i++) {
			for (int j = 0; j < ny4.length; j++) {
				getB().uncover(nx4[i], ny4[j]);
				getT().uncover(getP().getId());
			}
		}

		for (int i = 0; i < nx5.length; i++) {
			for (int j = 0; j < ny5.length; j++) {
				getB().uncover(nx5[i], ny5[j]);
				getT().uncover(getP().getId());
			}
		}

	}
	
	/**
	 * 
	 * @return price of a Radar Merchant
	 */
	public int getPrice() {
		return price;
	}
	
	/**
	 * 
	 * @return price of a level 2 Radar Merchant
	 */
	public int getPrice2() {
		return price2;
	}
	
	/**
	 * 
	 * @return price of a level 3 Radar Merchant
	 */
	public int getPrice3() {
		return price3;
	}
	
	/**
	 * 
	 * @return price of a level 4 Radar Merchant
	 */
	public int getPrice4() {
		return price4;
	}
	
	/**
	 * 
	 * @return price of a level 5 Radar Merchant
	 */
	public int getPrice5() {
		return price5;
	}

}
