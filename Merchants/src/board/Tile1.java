package board;

import java.awt.Color;

import other.Player1;
import processing.core.PApplet;
import screens.ScreenHandler;

public class Tile1 {

	public static final int TILE_SIZE = 60;

	private int x, y, cost;
	private Player1 owner;
	private boolean[] uncovered;
	private boolean isSelected;
	private Color color;

	public Tile1(int x, int y, int cost) {
		this.x = x;
		this.y = y;
		this.cost = cost;
		color = null;
		owner = null;
		isSelected = false;

		uncovered = new boolean[4];
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public void draw(PApplet p) {
		if (isSelected) {
			p.fill(Color.yellow.getRGB());
		} else {
			if (color == null) {
				p.noFill();
			} else {
				p.fill(color.getRGB());
			}
		}

		p.rect(x * Tile.TILE_SIZE, y * Tile.TILE_SIZE, Tile.TILE_SIZE, Tile.TILE_SIZE);
	}

	public String getCharacteristics() {
		String str = "Coodrinates:\n(" + x + ", " + y + ")\n";

		if (owner == null) {
			str += "Cost: " + 20;
		} else {
			str += "Owned\nCost: " + 30;
		}

		return str;
	}

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}

	public Player1 getOwner() {
		return owner;
	}

	public void setOwner(Player1 owner) {
		this.owner = owner;
		setColor(ScreenHandler.TILE_COLORS[owner.getIndex()]);
	}

	public boolean isUncovered(int player) {
		return uncovered[player];
	}

	public void uncover(int player) {
		uncovered[player] = true;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public void setSelected(boolean selected) {
		isSelected = selected;
	}

}