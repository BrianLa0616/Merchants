package board;

/**
 * 
 * @author Eylam
 * 
 *         Represents a Tile that a player's merchants can teleport to.
 * 
 */
public class Checkpoint extends Tile {

	private int id;
	private int x, y;
	private int price;

	/**
	 * Creates a new Checkpoint object with the following parameters
	 * 
	 * @param x    the x-coordinate of the checkpoint
	 * @param y    the y-coordinate of the checkpoint
	 * @param type the tile type of the checkpoint
	 */
	public Checkpoint(int x, int y, int type, int id, int price) {
		super(x, y, type);
		this.id = id; // index in player's checkpts array
		this.price = 50 * price; // proportional with player's amount of checkpts
	}

	/**
	 * @return x coordinate of checkpoint
	 */
	public int getX() {
		return x;
	}

	/**
	 * Sets the x coordinate of the checkpoint
	 * 
	 * @param x coordinate of the checkpoint
	 */
	public void setX(int x) {
		this.x = x;
	}

	/**
	 * @return y coordinate of the checkpoint
	 */
	public int getY() {
		return y;
	}

	/**
	 * Sets the y coordinate of the checkpoint
	 * 
	 * @param y coordinate of the checkpoint
	 */
	public void setY(int y) {
		this.y = y;
	}

}