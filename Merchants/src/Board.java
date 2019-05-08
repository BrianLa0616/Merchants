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

		} else if (stage == transPage) {

		} else if (stage == endPage) {

		}

	}

	public void mousePressed() {
		if (stage == menuPage) {
			if (startBtn.isPointInside(mouseX, mouseY)) {
				String input;
				input = JOptionPane.showInputDialog("How many players? 1-4 players");
				numPlayers = Integer.parseInt(input);
				for (int i = 0; i < numPlayers; i++) {
					input = JOptionPane.showInputDialog("Name for player " + i + "?");
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

}
