import processing.core.PApplet;

import javax.swing.JOptionPane;

import bla269.shapes.Rectangle;

public class Board extends PApplet {

	private int stage;
	private static final int menuPage = 1, rulePage = 2, rulePage2 = 3, boardPage = 4, transPage = 5, endPage = 6;
	private Rectangle backBtn;

	// Menu fields
	private Rectangle startBtn, ruleBtn;

	// Game fields
	private Player[] players = new Player[4];
	private int numPlayers;
	private Tile[][] tiles = new Tile[10][10];

	public Board() {
		stage = menuPage;
		startBtn = new Rectangle(150, 150, 200, 75);
		startBtn.setfill(0, 180, 255);
		startBtn.setStroke(0, 180, 255);

		ruleBtn = new Rectangle(150, 250, 200, 75);
		ruleBtn.setfill(0, 180, 255);
		ruleBtn.setStroke(0, 180, 255);

		backBtn = new Rectangle(25, 400, 50, 50);

	}

	public void draw() {
		background(255);
		if (stage == menuPage) {
			startBtn.draw(this);
			ruleBtn.draw(this);
		} else if (stage == rulePage) {
			backBtn.draw(this);
		} else if (stage == rulePage2) {
			backBtn.draw(this);
		} else if (stage == boardPage) {

			for (int i = 0; i < 10; i++) {
				for (int j = 0; j < 10; j++) {
					line(100 * i, 0, 100 * i, 1000);
					line(0, 100 * i, 1000, 100 * i);
				}
			}
		} else if (stage == transPage) {

		} else if (stage == endPage) {

		}

	}

	public void mousePressed() {
		if (stage == menuPage) {
			if (startBtn.isPointInside(mouseX, mouseY)) {
				String input;
				do {
					input = JOptionPane.showInputDialog("How many players? 1-4 players");
				} while (!validIntegerInput(input) || !(input.compareTo("0") == 1 && input.compareTo("5") == -1));
				numPlayers = Integer.parseInt(input);

				for (int i = 0; i < numPlayers; i++) {
					input = JOptionPane.showInputDialog("Name for player " + (i + 1) + "?");
					players[i] = new Player(i, 100, input);
				}
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

		} else if (stage == transPage) {

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
