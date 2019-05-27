package merchants;

import java.awt.Color;
import java.util.ArrayList;

import board.Board;
import board.Tile;

/**
 * Represents a Radar Merchant
 * 
 * @author Ansen
 *
 */
public class RadarMerchant extends Merchant {
	private int price[] = { 20, 35, 45, 60, 75 };

	private ArrayList<int[]> nx;
	private ArrayList<int[]> ny;

	/**
	 * Constructs a new Radar Merchant at (x, y) with Color c
	 * 
	 * @param x    coordinate of the Radar Merchant
	 * @param y    coordinate of the Radar Merchant
	 * @param c    Color of the Radar Merchant
	 * @param edge border color of merchant
	 */
	public RadarMerchant(int x, int y, Color c, int edge) {
		super(x, y, c, edge);
		level = 1;

		nx = new ArrayList<int[]>();
		ny = new ArrayList<int[]>();
		nx.add(new int[] { -1, 0, 1 });
		ny.add(new int[] { -2, -2, -2 });
		nx.add(new int[] { 2, 2, 2 });
		ny.add(new int[] { -2, -1, 0 });
		nx.add(new int[] { 2, 2, 1 });
		ny.add(new int[] { 1, 2, 2 });
		nx.add(new int[] { 0, -1, -2 });
		ny.add(new int[] { 2, 2, 2 });
		nx.add(new int[] { -2, -2, -2, -2 });
		ny.add(new int[] { 1, 0, -1, -2 });

	}

	/**
	 * Ability of an Radar Merchant to reveal more tiles around them than an average
	 * merchant, as the Radar Merchant's level rises, so does the amount of revealed
	 * tiles around them
	 * 
	 * @param level of the Radar Merchant
	 * @param b     board that is being affected
	 * @param t     tile that is being revealed
	 */
	public void reveal(int level, Board b, Tile t) {

		for (int i = 0; i < level; i++) {
			for (int j = 0; j < nx.get(i).length; j++) {
				b.uncoverA(nx.get(i)[j] + t.getX(), ny.get(i)[j] + t.getY());
//				t.uncover(getOwner().getId());
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
