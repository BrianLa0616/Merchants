package merchants;

import java.awt.Color;

import board.Tile;
import other.Player;
import processing.core.PApplet;

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
		visible = false;
	}

	/**
	 * 
	 * @return cost of an Invisible Merchant
	 */
	public int getPrice() {
		return price;
	}

	/**
	 * Upgrades the level of the merchant
	 */
	public void upgrade() {
		if (level < 5)
			level++;
	}

	/**
	 * Sets the Invisible Merchant visible
	 * 
	 * @param p Player that owns the Invisible Merchant
	 */
	public void isVisible(Player p) {
		setR(p.getR());
		setG(p.getG());
		setB(p.getB());
	}

	/**
	 * Sets the Invisible Merchant invisible
	 * 
	 * 
	 */
	public void isInvisible() {

	}

	/**
	 * Whether or not the Invisible Merchant is visible or not to other players, as
	 * the Invisible Merchant rises in levels, it will be able to go further into
	 * other players' lands while still maintaining its invisibility
	 * 
	 * @param t Tile that the Invisible Merchant is currently on
	 * @param p Player who owns the Invisible Merchant
	 */
	public void invisible(Player p, Tile t) {
		if (x == t.getX() && y == t.getY()) {
			if (p.getR() != t.getR() || p.getG() != t.getG() || p.getB() != t.getB()) {
				if (level == 1) {
					isVisible(p);
					visible = true;
				} else if (level == 2) {

				}

			}
		}

	}
}