package board;

import java.awt.Color;

import merchants.Merchant1;
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
	private Merchant1 merchant;

	public Tile1(int x, int y, int cost) {
		this.x = x;
		this.y = y;
		this.cost = cost;
		owner = null;
		isSelected = false;

		uncovered = new boolean[4];
		for (int i = 0; i < 4; i++) {
			uncovered[i] = false;
		}
	}

	public void draw(PApplet p, int id) {

		if (uncovered[id]) {
			if (isSelected) {
				p.fill(Color.yellow.getRGB());
			} else {
				if (owner == null) {
					p.noFill();
				} else {
					p.fill(owner.getTileColor().getRGB());
				}
			}

			p.rect(y * Tile.TILE_SIZE, x * Tile.TILE_SIZE, Tile.TILE_SIZE, Tile.TILE_SIZE);
			if (merchant != null) {
				merchant.draw(p);
			}
		} else {
			p.fill(Color.DARK_GRAY.getRGB());
			p.rect(y * Tile.TILE_SIZE, x * Tile.TILE_SIZE, Tile.TILE_SIZE, Tile.TILE_SIZE);

		}
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

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public void setMerchant(Merchant1 m) {
		merchant = m;
	}

	public Merchant1 getMerchant() {
		return merchant;
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
		setColor(ScreenHandler.TILE_COLORS[owner.getId()]);
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
	
	public boolean getSelected() {
		return isSelected;
	}

}