package merchants;

import board.Tile;

public class Merchant {
	private int x, y;

	public Merchant(int x, int y) {
		this.x = x;
		this.y = y;
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

	public void move() {
		//
	}

	public boolean isAdjacent(Tile t) {
		//
		return false;
	}
}