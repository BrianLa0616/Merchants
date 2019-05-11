package board;

import processing.core.PApplet;

import java.awt.Color;

import javax.swing.JOptionPane;

import bla269.shapes.Rectangle;
import merchants.Merchant;
import other.Player;

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

	// Game fields
	private Player[] players = new Player[4];
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
			for (int i = 0; i < 16; i++) {
				for (int j = 0; j < 16; j++) {
					line(Tile.TILE_SIZE * i, 0, Tile.TILE_SIZE * i, 900);
					line(0, Tile.TILE_SIZE * i, 900, Tile.TILE_SIZE * i);
				}
			}
			for(Player p: players) {
				for(Merchant m: p.getMerchants()) {
					m.draw(this);
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

					players[i] = new Player(i, 100, input, new Color((int) (Math.random()*256), (int) (Math.random()*256), (int) (Math.random()*256)), 0, 0); // TODO x and y

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
			}
		} else if (stage == transPage) {
			if (nextStageBtn.isPointInside(mouseX, mouseY)) {
				String input;
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
}
