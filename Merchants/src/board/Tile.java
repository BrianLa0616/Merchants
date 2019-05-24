package board;

import java.awt.Color;

import merchants.Merchant;
import other.Player;
import processing.core.PApplet;
import screens.ScreenHandler;

/**
 * Represents a single tile in board
 * 
 * @author Eylam
 *
 */
public class Tile {

	public static final int TILE_SIZE = 60;

	private int x, y, cost;
	private Player owner;
	private boolean[] uncovered;
	private boolean isSelected;
	private Color color;
	private Merchant merchant;
	private boolean isPicked;

	/**
	 * Constructs a new tile at (x, y)
	 * 
	 * @param x    coordinate of the tile
	 * @param y    coordinate of the tile
	 * @param cost of the tile
	 */
	public Tile(int x, int y, int cost) {
		this.x = x;
		this.y = y;
		this.cost = cost;
		owner = null;
		isSelected = false;
		isPicked = false;

		uncovered = new boolean[4];
		for (int i = 0; i < 4; i++) {
			uncovered[i] = false;
		}
	}

	/**
	 * Draws the tiles
	 * 
	 * @param p  marker used to draw the tiles
	 * @param id of the tile
	 */
	public void draw(PApplet p, int id) {

		if (uncovered[id]) {
			if (isSelected) {
				p.fill(Color.YELLOW.getRGB());
			} else if (isPicked) {
				p.fill(225, 155, 255);
			} else {
				if (owner == null) {
					p.noFill();
				} else {
					p.fill(owner.getTileColor().getRGB());
				}
			}

			p.rect(y * Tile.TILE_SIZE, x * Tile.TILE_SIZE, Tile.TILE_SIZE, Tile.TILE_SIZE);
			if (this instanceof Checkpoint && isUncovered(owner.getId())) {
				p.image(p.loadImage("images" + System.getProperty("file.separator") + "blackflag.png"), y * TILE_SIZE + 5,
						x * TILE_SIZE + 5);
			}

			if (merchant != null) {
				merchant.draw(p);
			}
		} else {
			p.fill(Color.DARK_GRAY.getRGB());
			p.rect(y * Tile.TILE_SIZE, x * Tile.TILE_SIZE, Tile.TILE_SIZE, Tile.TILE_SIZE);

		}
	}

	/**
	 * Returns characteristics of tile
	 * 
	 * @return str string informing the coordinates, cost, and who the tile is owned
	 *         by
	 */
	public String getCharacteristics() {
		String str = "Coordinates:\n(" + x + ", " + y + ")\n";

		if (owner == null) {
			str += "Cost: " + cost;
		} else {
			str += "Owned\nCost: " + cost;
		}

		return str;
	}

	/**
	 * @return the x-coordinate of the tile
	 */
	public int getX() {
		return x;
	}

	/**
	 * @return the y-coordinate of the tile
	 */
	public int getY() {
		return y;
	}

	/**
	 * Sets the merchant
	 * 
	 * @param m merchant desired
	 */
	public void setMerchant(Merchant m) {
		merchant = m;
	}

	/**
	 * 
	 * @return merchant currently occupying the tile
	 */
	public Merchant getMerchant() {
		return merchant;
	}

	/**
	 * 
	 * @return the cost to purchase the tile
	 */
	public int getCost() {
		return cost;
	}

	/**
	 * Sets the cost of the tile
	 * 
	 * @param cost the cost to purchase the tile
	 */
	public void setCost(int cost) {
		this.cost = cost;
	}

	/**
	 * 
	 * @return owner of the tile
	 */
	public Player getOwner() {
		return owner;
	}

	/**
	 * Sets the owner of the tile
	 * 
	 * @param owner of the tile
	 */
	public void setOwner(Player owner) {
		if (this.owner != null && this.owner != owner) {
			this.owner.getTerritory().remove(this.owner.getTerritory().indexOf(this));
		}
		this.owner = owner;
		setColor(ScreenHandler.TILE_COLORS[owner.getId()]);
	}

	/**
	 * Whether or not the tile is uncovered for that player
	 * 
	 * @param player desired to check
	 * @return whether or not tile is covered for the player
	 */
	public boolean isUncovered(int player) {
		return uncovered[player];
	}

	/**
	 * Uncovers the tile for that player
	 * 
	 * @param player desired
	 */
	public void uncover(int player) {
		uncovered[player] = true;
	}

	/**
	 * 
	 * @return color of the tile
	 */
	public Color getColor() {
		return color;
	}

	/**
	 * Sets the color of the tile
	 * 
	 * @param color of the tile
	 */
	public void setColor(Color color) {
		this.color = color;
	}

	/**
	 * Selects the tile
	 * 
	 * @param selected if the tile is selected or not
	 */
	public void setSelected(boolean selected) {
		isSelected = selected;
	}

	/**
	 * 
	 * @return isSelected if the tile is chosen or not
	 */
	public boolean getSelected() {
		return isSelected;
	}

	/**
	 * picks/unpicks the tile for an auction
	 * 
	 * @param picked if this tile is currently picked for an auction by the current
	 *               player
	 */
	public void setPicked(boolean picked) {
		isPicked = picked;
	}

	/**
	 * 
	 * @return true if the tile is picked for auction by the current player,
	 *         otherwise false.
	 */
	public boolean isPicked() {
		return isPicked;
	}
}