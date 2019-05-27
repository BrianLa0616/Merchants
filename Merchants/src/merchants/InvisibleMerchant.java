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
	private int edge;

	private int price[] = { 20, 25, 30, 35, 45 };

	private boolean visible;

	/**
	 * Constructs a new Invisible Merchant at (x, y) with color c
	 * 
	 * @param x    coordinate of the Invisible Merchant
	 * @param y    coordinate of the Invisible Merchant
	 * @param c    Color of the Invisible Merchant
	 * @param edge border color of merchant
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
	 * @param current Player who's current turn
	 */
	public void draw(PApplet p, Player current) {

		if (visible == true || current.equals(getOwner())) {
			p.noFill();
			p.stroke(getEdge());
			p.rect((super.getY() + 0.25f) * Tile.TILE_SIZE, (super.getX() + 0.25f) * Tile.TILE_SIZE, 0.5f * Tile.TILE_SIZE,
					0.5f * Tile.TILE_SIZE);
			p.stroke(0);
		}

	}

	/**
	 * Whether or not the Invisible Merchant is visible or not to other players, as
	 * the Invisible Merchant rises in levels, it will be able to go further into
	 * other players' lands while still maintaining its invisibility
	 * 
	 * @param level of the Invisible Merchant
	 * @param t     Tile that the Invisible Merchant is currently on
	 * @return
	 */
	public boolean isVisible(int level, Tile t) {
		if (t.getOwner() == null) {
			visible = false;
		} else if (!(t.getOwner().equals(getOwner()))) {
			if (level == 1) {
				visible = true;

			} else if (level == 2) {
				if (getNumMovesInEnemyLand() > 1) {
					visible = true;

				}
			} else if (level == 3) {
				if (getNumMovesInEnemyLand() > 2) {
					visible = true;

				}
			} else if (level == 4) {
				if (getNumMovesInEnemyLand() > 3) {
					visible = true;
				}
			} else if (level == 5) {
				if (getNumMovesInEnemyLand() > 5) {
					visible = true;
				}
			}

		}
		return visible;

	}

	/**
	 * Sets the Invisible Merchant visible
	 * 
	 */
	public void setVisible() {
		visible = true;
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