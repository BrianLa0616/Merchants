package board;

import processing.core.PApplet;

/**
 * 
 * @author Eylam
 * 
 *         Represents a Tile that a player's merchants can teleport to.
 * 
 */
public class Checkpoint extends Tile {


	/**
	 * Creates a new Checkpoint object with the following parameters
	 * 
	 * @param x    the x-coordinate of the checkpoint
	 * @param y    the y-coordinate of the checkpoint
	 */
	public Checkpoint(int x, int y, int price) {
		super(x, y, price);
	}

	public void draw(PApplet p, int id) {
		super.draw(p, id);
		//Draw the tile with checkpoint image
	}
	
	public String getCharacteristics() {
		return super.getCharacteristics() + "\nCheckpoint";
	}
}