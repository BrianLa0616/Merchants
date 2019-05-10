package merchants;

import board.Tile;

/**
 * walks around and purchases land, or auctions
 * 
 * @author eylam
 *
 */
public class Merchant {
	private int x, y, speed;

	/**
	 * 
	 * @param x x value
	 * @param y y value
	 */
	public Merchant(int x, int y) {
		this.x = x;
		this.y = y;
		speed = 2;
	}

//	public int getX() {
//		return x;
//	}
//
//	public int getY() {
//		return y;
//	}
//
//	public void setX(int x) {
//		this.x = x;
//	}
//
//	public void setY(int y) {
//		this.y = y;
//	}
//
//	public void move(int direction) {
//		//
//	}
//
//	public boolean isAdjacent(Tile t) {
//		//
//		return false;
//	}
//
//	public void purchaseLand() {
//
//	}
//
//	public int proposeAuction(int amount) {
//		return amount;
//	}
//
//	public void goToCheckpt(int id) {
//
//	}
}