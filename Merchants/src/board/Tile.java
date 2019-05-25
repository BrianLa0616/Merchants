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

		uncovered = new boolean[5];
		for (int i = 0; i < 4; i++) {
			uncovered[i] = false;
		}
		uncovered[4] = true;
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
					p.fill(Color.WHITE.getRGB());;
				} else {
					p.fill(owner.getTileColor().getRGB());
				}
			}

			p.rect(y * Tile.TILE_SIZE, x * Tile.TILE_SIZE, Tile.TILE_SIZE, Tile.TILE_SIZE);
			if (this instanceof Checkpoint && isUncovered(owner.getId())) {
				p.image(p.loadImage("images" + System.getProperty("file.separator") + "blackflag.png"),
						y * TILE_SIZE + 5, x * TILE_SIZE + 5);
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
	 * Draws the tile
	 * @param p Papplet used to draw
	 * @param id id of the player that is drawing
	 * @param x x-coordinate of tile
	 * @param y y-coordinate of tile
	 */
	public void draw(PApplet p, int id, int x, int y) {
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
				p.image(p.loadImage("images" + System.getProperty("file.separator") + "blackflag.png"),
						y * TILE_SIZE + 5, x * TILE_SIZE + 5);
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
	 * @return str String informing the coordinates, cost, and who the tile is owned
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
	 * @return x-coordinate of the tile
	 */
	public int getX() {
		return x;
	}

	/**
	 * @return y-coordinate of the tile
	 */
	public int getY() {
		return y;
	}

	/**
	 * Sets tile's x-coordinate
	 * 
	 * @param x The new x value
	 */
	public void setX(int x) {
		this.x = x;
	}

	/**
	 * Sets tile's y-coordinate
	 * 
	 * @param y The new y value
	 */
	public void setY(int y) {
		this.y = y;
	}

	/**
	 * Sets the merchant
	 * 
	 * @param m Merchant desired
	 */
	public void setMerchant(Merchant m) {
		merchant = m;
	}

	/**
	 * 
	 * @return Merchant currently occupying the tile
	 */
	public Merchant getMerchant() {
		return merchant;
	}

	/**
	 * 
	 * @return Cost to purchase the tile
	 */
	public int getCost() {
		return cost;
	}

	/**
	 * Sets the cost of the tile
	 * 
	 * @param cost Cost to purchase the tile
	 */
	public void setCost(int cost) {
		this.cost = cost;
	}

	/**
	 * 
	 * @return The owner of the tile
	 */
	public Player getOwner() {
		return owner;
	}

	/**
	 * Sets the owner of the tile
	 * 
	 * @param owner The owner of the tile
	 */
	public void setOwner(Player owner) {
		if (this.owner != null && this.owner != owner) {
			this.owner.getTerritory().remove(this.owner.getTerritory().indexOf(this));
		}
		this.owner = owner;
	}

	/**
	 * Whether or not the tile is uncovered for that player
	 * 
	 * @param player The player that is desired to check
	 * @return true if tile is uncovered, false otherwise
	 */
	public boolean isUncovered(int player) {
		return uncovered[player];
	}

	/**
	 * Uncovers the tile for that player
	 * 
	 * @param player Player desired
	 */
	public void uncover(int player) {
		uncovered[player] = true;
	}

	/**
	 * 
	 * @return Color of the tile
	 */
	public Color getColor() {
		return color;
	}

	/**
	 * Sets the color of the tile
	 * 
	 * @param color Color of the tile
	 */
	public void setColor(Color color) {
		this.color = color;
	}

	/**
	 * Sets the state of tile to selected
	 * 
	 * @param selected state of tile
	 */
	public void setSelected(boolean selected) {
		isSelected = selected;
	}

	/**
	 * 
	 * @return true if the tile is selected. false otherwise
	 */
	public boolean getSelected() {
		return isSelected;
	}

	/**
	 * picks/unpicks the tile for an auction
	 * 
	 * @param picked State of the tile
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

	/**
	 * @return an exact replica of this tile
	 */
	public Tile clone() {
		Tile t = new Tile(x, y, cost);
		t.setColor(getColor());
		t.setMerchant(merchant);
		t.setPicked(isPicked);
		t.setOwner(owner);
		for (int i = 0; i < uncovered.length; i++) {
			if (isUncovered(i)) {
				uncover(i);
			}
		}
		t.setSelected(isSelected);

		return t;
	}
}