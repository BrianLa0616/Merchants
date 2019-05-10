package board;

/**
 * 
 * @author Eylam
 *
 *         Represents a tile on the game board, that can be purchased and made
 *         into a Checkpoint.
 *
 */
public class Tile {

	private int x, y, type, cost, income, owner;

	/**
	 * 
	 * @param x    the x-coordinate of the tile
	 * @param y    the y-coordinate of the tile
	 * @param type the type of the tile (land, sea, etc.)
	 */
	public Tile(int x, int y, int type) {
		this.setX(x);
		this.setY(y);
		this.setType(type);
	}

	/**
	 * @return the x-coordinate of the tile
	 */
	public int getX() {
		return x;
	}

	/**
	 * @param x the x-coordinate of the checkpoint
	 */
	public void setX(int x) {
		this.x = x;
	}

	/**
	 * 
	 * @return the y-coordinate of the tile
	 */
	public int getY() {
		return y;
	}

	/**
	 * 
	 * @param y the y-coordinate of the tile
	 */
	public void setY(int y) {
		this.y = y;
	}

	/**
	 * 
	 * @return the tile type
	 */
	public int getType() {
		return type;
	}

	/**
	 * 
	 * @param type the tile tpye
	 */
	public void setType(int type) {
		this.type = type;
	}

	/**
	 * 
	 * @return the cost to purchase the tile
	 */
	public int getCost() {
		return cost;
	}

	/**
	 * 
	 * @param cost the cost to purchase the tile
	 */
	public void setCost(int cost) {
		this.cost = cost;
	}

	/**
	 * 
	 * @return the income the tile provides to its player
	 */
	public int getIncome() {
		return income;
	}

	/**
	 * 
	 * @param income the income the tile provides to its player
	 */
	public void setIncome(int income) {
		this.income = income;
	}

	/**
	 * 
	 * @return the player who owns this tile
	 */
	public int getOwner() {
		return owner;
	}

	/**
	 * 
	 * @param owner the player who owns this tile
	 */
	public void setOwner(int owner) {
		this.owner = owner;
	}
}
