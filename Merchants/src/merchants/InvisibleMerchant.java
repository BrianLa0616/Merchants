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
public class InvisibleMerchant extends Merchant1 {
	private int x, y;
	private int level;

	private int price, price2, price3, price4, price5;
	
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
		
		price = 20;
		price2 = 25;
		price3 = 30;
		price4 = 35;
		price5 = 45;
	}

	/**
	 * Draws the Invisible Merchant
	 * 
	 * @param p marker used to draw
	 */
	public void draw(PApplet p) {
		if (visible == true) {
			p.fill(getColor().getRGB());
			p.rect((x + 0.25f) * Tile.TILE_SIZE, (y + 0.25f) * Tile.TILE_SIZE, 0.5f * Tile.TILE_SIZE,
					0.5f * Tile.TILE_SIZE);
		}
	}

	/**
	 * Sets the Invisible Merchant visible
	 * 
	 * @param p Player that owns the Invisible Merchant
	 */
	public void setVisible(Player p) {
		setColor(p.getColor());
		visible = true;
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
					setVisible(p);
					visible = true;
				} else if (level == 2) {
					if (getNumMovesInEnemyLand() > 1) {
						setVisible(p);
						visible = true;
					}

				} else if (level == 3) {
					if (getNumMovesInEnemyLand() > 2) {
						setVisible(p);
						visible = true;
					}
				} else if (level == 4) {
					if (getNumMovesInEnemyLand() > 3) {
						setVisible(p);
						visible = true;
					}
				} else if (level == 5) {
					if (getNumMovesInEnemyLand() > 5) {
						setVisible(p);
						visible = true;
					}
				}

			}
		}
	}

	/**
	 * 
	 * @return cost of an Invisible Merchant
	 */
	public int getPrice() {
		return price;
	}
	
	/**
	 * 
	 * @return price of a level 2 Invisible Merchant
	 */
	public int getPrice2() {
		return price2;
	}
	
	/**
	 * 
	 * @return price of a level 3 Invisible Merchant
	 */
	public int getPrice3() {
		return price3;
	}
	
	/**
	 * 
	 * @return price of a level 4 Invisible Merchant
	 */
	public int getPrice4() {
		return price4;
	}
	
	/**
	 * 
	 * @return price of a level 5 Invisible Merchant
	 */
	public int getPrice5() {
		return price5;
	}

}