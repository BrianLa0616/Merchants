package merchants;

import java.awt.Color;

import board.Tile;
import processing.core.PApplet;

/**
 * walks around and purchases land, or auctions
 * 
 * @author eylam
 *
 */
public class Merchant {
	
	private int x, y, speed;
	
	private Color color;

	/**
	 * 
	 * @param x x value
	 * @param y y value
	 */
	public Merchant(int x, int y, Color c) {
		this.x = x;
		this.y = y;
		color = c;
		speed = 2;
	}


	public void move(int direction) {
		
	}

	public boolean isAdjacent(Tile t) {
		
		return false;
	}

	public void purchaseLand() {

	}

	public int proposeAuction(int amount) {
		return amount;
	}

	public void goToCheckpt(int id) {

	}
	
	public void draw(PApplet p)
	{
		p.fill(color.getRed(), color.getGreen(), color.getBlue());
		p.rect((x+0.25f)*Tile.TILE_SIZE, (y+0.25f)*Tile.TILE_SIZE, 0.5f*Tile.TILE_SIZE, 0.5f*Tile.TILE_SIZE);
	}
	
	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
	}
}