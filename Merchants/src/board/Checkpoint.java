package board;

/**
 * 
 * @author Eylam
 * 
 *         Represents a Tile that a player's merchants can teleport to.
 * 
 */
public class Checkpoint extends Tile {

	private int owner, id;

	/**
	 * Creates a new Checkpoint object with the following parameters
	 * 
	 * @param x    the x-coordinate of the checkpoint
	 * @param y    the y-coordinate of the checkpoint
	 * @param type the tile type of the checkpoint
	 */
	public Checkpoint(int x, int y, int type) {
		super(x, y, type);
	}

}
