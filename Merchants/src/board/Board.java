package board;

import java.awt.Color;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import bla269.shapes.Rectangle;
import merchants.Merchant;
import other.Player;
import processing.core.PApplet;

/**
 * 
 * @author Brian
 *
 *         Represents the game board on which everything happens
 *
 */
public class Board extends PApplet {

	private int stage;
	private static final int menuPage = 1, rulePage = 2, rulePage2 = 3, boardPage = 4, transPage = 5, endPage = 6;
	private Rectangle backBtn;

	private Rectangle nextStageBtn, ruleBtn;

	private Merchant selected;

	// Game fields
	private ArrayList<Player> players = new ArrayList<Player>();
	private int numPlayers, numTurns, curPlayer;
	private Tile[][] tiles = new Tile[15][15];

	/**
	 * Initiates buttons
	 */
	public Board() {
		stage = menuPage;
		nextStageBtn = new Rectangle(150, 150, 200, 75);
		nextStageBtn.setfill(0, 180, 255);
		nextStageBtn.setStroke(0, 180, 255);

		ruleBtn = new Rectangle(150, 250, 200, 75);
		ruleBtn.setfill(0, 180, 255);
		ruleBtn.setStroke(0, 180, 255);

		backBtn = new Rectangle(25, 400, 50, 50);

		selected = null;
		curPlayer = 0;

		for (int i = 0; i < 15; i++) {
			for (int j = 0; j < 15; j++) {
				tiles[i][j] = new Tile(i, j, 0);
			}
		}
	}

	/**
	 * Draws the board
	 */
	public void draw() {
		background(255);
		if (stage == menuPage) {
			nextStageBtn.draw(this);
			ruleBtn.draw(this);
		} else if (stage == rulePage) {
			backBtn.draw(this);
		} else if (stage == rulePage2) {
			backBtn.draw(this);
		} else if (stage == boardPage) {
			nextStageBtn.draw(this);
			ruleBtn.draw(this);
			noFill();
			for (int i = 0; i < 15; i++) {
				for (int j = 0; j < 15; j++) {
					tiles[i][j].draw(this);
				}
			}

			for (Player p : players) {
				for (Merchant m : p.getMerchants()) {
					m.draw(this);
				}
			}

			if (selected != null) {
				for (int i = -1; i <= 1; i++) {
					for (int j = -1; j <= 1; j++) {
						int nx = selected.getX() + i;
						int ny = selected.getY() + j;
						if (inRange(nx, ny)) {
							tiles[nx][ny].setFill(Color.yellow);
						}
					}
				}
			}

		} else if (stage == transPage) {
			nextStageBtn.draw(this);
		} else if (stage == endPage) {

		}

	}

	/**
	 * Checks for clicks and checks if it corresponds to a specific location
	 */
	public void mousePressed() {
		if (stage == menuPage) {
			if (nextStageBtn.isPointInside(mouseX, mouseY)) {
				String input;
				do {
					input = JOptionPane.showInputDialog("Enter number of players. 1-4 players");
					if (input == null || input.equals("")) {
						return;
					}
				} while (!validIntegerInput(input)
						|| !(input.compareTo("0") > 0 && input.compareTo("5") < 0 && input.length() == 1));
				numPlayers = Integer.parseInt(input);

				for (int i = 0; i < numPlayers; i++) {
					input = JOptionPane.showInputDialog("Enter the name for player " + (i + 1));
					if (input == null || input.equals("")) {
						return;
					}

					int x, y;

					do {
						x = (int) (Math.random() * 15);
						y = (int) (Math.random() * 15);
					} while (tiles[x][y].getMerchant() != null);

					players.add(new Player(i, 100, input, new Color((int) (Math.random() * 256),
							(int) (Math.random() * 256), (int) (Math.random() * 256)), new Merchant(x, y)));

					tiles[x][y].setMerchant(players.get(i).getMerchants().get(0));
				}

				do {
					input = JOptionPane.showInputDialog("How many turns should the game last?");
					if (input == null || input.equals("")) {
						return;
					}
				} while (!validIntegerInput(input));
				numTurns = Integer.parseInt(input);

				nextStageBtn = new Rectangle(1000, 100, 50, 50);
				ruleBtn = new Rectangle(1000, 200, 50, 50);

				stage = boardPage;
			} else if (ruleBtn.isPointInside(mouseX, mouseY)) {
				stage = rulePage;
			}
		} else if (stage == rulePage) {
			if (backBtn.isPointInside(mouseX, mouseY)) {
				stage = menuPage;
			}
		} else if (stage == rulePage2) {
			if (backBtn.isPointInside(mouseX, mouseY)) {
				stage = boardPage;
			}
		} else if (stage == boardPage) {
			if (nextStageBtn.isPointInside(mouseX, mouseY)) {
				stage = transPage;
			} else if (ruleBtn.isPointInside(mouseX, mouseY)) {
				stage = rulePage2;
			} else {
				int mx = mouseX / Tile.TILE_SIZE;
				int my = mouseY / Tile.TILE_SIZE;
				if (inRange(mx, my)) {

					if (selected == null) {
						selected = tiles[mx][my].getMerchant();
					} else {

						if (Math.abs(mx - selected.getX()) + Math.abs(my - selected.getY()) == 1) {
							tiles[mx][my].setMerchant(selected);
							tiles[selected.getX()][selected.getY()].setMerchant(null);
							deselect();
							
							tiles[mx][my].getMerchant().setX(mx);
							tiles[mx][my].getMerchant().setY(my);

						} else {
							deselect();
						}

						
					}

				}
			}
		} else if (stage == transPage) {
			if (nextStageBtn.isPointInside(mouseX, mouseY)) {
				stage = boardPage;
			}

		} else if (stage == endPage) {

		}
	}

	private boolean validIntegerInput(String x) {
		if (x.length() == 0)
			return false;
		for (int i = 0; i < x.length(); i++) {
			if (!(x.charAt(i) >= '0' && x.charAt(i) <= '9')) {
				return false;
			}
		}
		return true;
	}

	private boolean inRange(int x, int y) {
		return x >= 0 && x < 15 && y >= 0 && y < 15;
	}
	
	private void deselect() {
		for (int i = -1; i <= 1; i++) {
			for (int j = -1; j <= 1; j++) {
				int nx = selected.getX() + i;
				int ny = selected.getY() + j;
				if (inRange(nx, ny)) {
					tiles[nx][ny].setFill(Color.white);
				}
			}
		}
		selected = null;
	}
}
