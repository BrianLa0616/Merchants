package merchants;

import java.awt.Color;

import board.Tile;
import board.Tile1;
import processing.core.PApplet;

public class Merchant1 {

	private int x, y, speed;

	private Color color;

	public Merchant1(int x, int y, Color color) {
		this.x = x;
		this.y = y;

		this.color = color;
		speed = 2;
	}

	public void move(int dirX, int dirY) {
		this.x += dirX;
		this.y += dirY;
	}

	public boolean isAdjacent(Tile t) {
		if ((x + 1) == t.getX() && (y + 1) == t.getY()) {
			return true;
		} else if ((x + 1) == t.getX() && (y - 1) == t.getY()) {
			return true;
		} else if ((x - 1) == t.getX() && (y + 1) == t.getY()) {
			return true;
		} else if ((x - 1) == t.getX() && (y - 1) == t.getY()) {
			return true;
		}
		return false;
	}

	public void draw(PApplet p) {
		p.fill(color.getRGB());
		p.rect((x + 0.25f) * Tile1.TILE_SIZE, (y + 0.25f) * Tile1.TILE_SIZE, 0.5f * Tile1.TILE_SIZE,
				0.5f * Tile1.TILE_SIZE);
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

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}
}