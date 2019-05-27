package board;

import other.Player;
import processing.core.PApplet;

/**
 * Represents a Tile that a player's merchants can teleport to. 
 * 
 * @author Eylam
 * 
 */
public class Checkpoint extends Tile {

	/**
	 * Creates a new Checkpoint object with the following parameters
	 * 
	 * @param x x-coordinate of the checkpoint
	 * @param y y-coordinate of the checkpoint
	 * @param price price of checkpoint
	 */
	public Checkpoint(int x, int y, int price) {
		super(x, y, price);
	}

	/**
	 * Draws the checkpoint
	 * 
	 * @param p PApplet used to draw
	 * @param id id of the checkpoint
	 * @param player Player that owns the checkpoint 
	 */
	public void draw(PApplet p, int id, Player player) {
		super.draw(p, id, player);
	}

	/**
	 * 
	 * @return characteristics of the checkpoint
	 */
	public String getCharacteristics() {
		return super.getCharacteristics() + "\nCheckpoint";
	}
}