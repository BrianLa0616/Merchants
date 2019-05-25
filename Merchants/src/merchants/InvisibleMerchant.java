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
	private int x, y;
	private int edge;

	private int price[] = { 20, 25, 30, 35, 45 };

	private boolean visible;

	/**
	 * Constructs a new Invisible Merchant at (x, y) with color c
	 * 
	 * @param x coordinate of the Invisible Merchant
	 * @param y coordinate of the Invisible Merchant
	 * @param c Color of the Invisible Merchant
	 */
	public InvisibleMerchant(int x, int y, Color c, int edge) {
		super(x, y, c, edge);
		level = 1;
		visible = false;
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
		setColor(p.getMerchantColor());
		visible = true;
	}

	/**
	 * Whether or not the Invisible Merchant is visible or not to other players, as
	 * the Invisible Merchant rises in levels, it will be able to go further into
	 * other players' lands while still maintaining its invisibility
	 * 
	 * @param level of the Invisible Merchant
	 * @param t     Tile that the Invisible Merchant is currently on
	 * @param p     Player who owns the Invisible Merchant
	 */
	public void invisible(int level, Player p, Tile t) {
		if (x == t.getX() && y == t.getY()) {

			if (p.getTileColor().equals(t.getColor())) {
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
	 * Returns the price of an Invisible Merchant at specified level
	 * 
	 * @param level of the Invisible Merchant
	 * @return price of Invisible Merchant at specified level
	 */
	public int getPrice(int level) {
		return price[level - 1];
	}

}