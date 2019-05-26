package screens;

import java.awt.Color;

import javax.swing.JOptionPane;

import board.Board;
import board.Checkpoint;
import buttons.TextButton;
import other.Player;
import processing.core.PApplet;
import processing.core.PImage;

/**
 * Represents the home screen when a user first enters the game
 * 
 * @author Eylam
 *
 */
public class IntroScreen extends Screen {
	private TextButton start, instr;
	private ScreenHandler handler;
	private PImage town;

	/**
	 * Creates a new intro screen
	 * 
	 * @param board PApplet that draws the screen
	 */
	public IntroScreen(ScreenHandler board) {
		super(board);
		start = new TextButton(450, 450, 200, 75, Color.WHITE, Color.BLACK, "START", 24);
		instr = new TextButton(450, 550, 200, 75, Color.WHITE, Color.BLACK, "INSTRUCTIONS", 24);
		this.handler = board;

	}

	public void setup(PApplet p) {
	}

	/**
	 * Draws the intro screen
	 * 
	 * @param p PApplet used to draw the screen
	 */
	public void draw(PApplet p) {
		p.textAlign(PApplet.CENTER);
		p.textSize(60);
		p.fill(0);
		p.text("MERCHANTS", Screen.DRAWING_WIDTH / 2, Screen.DRAWING_HEIGHT / 2 - 100);
		start.draw(p);
		instr.draw(p);
	}

	/**
	 * Determines the actions when the mouse is clicked
	 * 
	 * @param p PApplet used to draw
	 */
	public void mousePressed(PApplet p) {
		if (start.isPointInButton(p.mouseX, p.mouseY)) {

			String[] modes = { "Normal (15x15)", "Blitz (10x10)" };
			int x = -1, size = 15;
			while (x < 0 || x > 4) {
				x = JOptionPane.showOptionDialog(null, "Choose the game mode", "MODE", JOptionPane.DEFAULT_OPTION,
						JOptionPane.QUESTION_MESSAGE, null, modes, modes[0]);
				if (x == -1) {
					return;
				}
			}

			if (x == 0) {
				size = 15;
			} else if (x == 1) {
				size = 10;
			} else {
				size = -1;
			}

			handler.setBoard(new Board(handler, size));

			String input;
			do {
				input = JOptionPane.showInputDialog("Enter number of players (2-4)");
				if (input == null || input.equals("")) {
					return;
				}
			} while (!validIntegerInput(input) || Integer.parseInt(input) > 4 || Integer.parseInt(input) < 2);

			int numPlayers = Integer.parseInt(input);

			int[] xvals = { 1, handler.getBoard().size() - 2, handler.getBoard().size() - 2, 1 },
					yvals = { 1, handler.getBoard().size() - 2, 1, handler.getBoard().size() - 2 };

			for (int i = 0; i < numPlayers; i++) {
				handler.getPlayers().add(new Player(xvals[i], yvals[i], ScreenHandler.PLAYER_COLORS[i],
						ScreenHandler.TILE_COLORS[i], i));
				Player player = handler.getPlayers().get(i);

				// adds Tile to player's territory
				handler.getBoard().getTiles()[xvals[i]][yvals[i]] = new Checkpoint(player.initX(), player.initY(),
						player.getTerritory().size() * 10);

				handler.getPlayers().get(i).addTile(handler.getBoard().getTiles()[xvals[i]][yvals[i]]);

				for (int j = -1; j <= 1; j++) {
					for (int k = -1; k <= 1; k++) {
						int nx = xvals[i] + j;
						int ny = yvals[i] + k;
						if (inRange(nx, ny)) {
							handler.getBoard().getTiles()[nx][ny].uncover(player.getId());
						}
					}
				}

				handler.getBoard().getTiles()[xvals[i]][yvals[i]].setMerchant(player.getMerchants().get(0));
				player.getMerchants().get(0).setOwner(player);
				player.getMerchants().get(0).setCoordinates(xvals[i], yvals[i]);

			}

			String[] options = { "25", "45", "75", "100", "endless" };
			int y = -1;
			while (y < 0 || y > 4) {
				y = JOptionPane.showOptionDialog(null, "Choose the duration of the game", "LENGTH",
						JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
				if (y == -1) {
					return;
				}
			}

			if (y >= 0 && y < 4) {
				handler.getBoard().setTotalTurns(Integer.parseInt(options[y]));
			} else {
				handler.getBoard().setTotalTurns(-1);
			}

			handler.proceed(new TransScreen(handler, handler.getPlayers().get(0)));
		} else if (instr.isPointInButton(p.mouseX, p.mouseY)) {
			handler.proceed(new InstructionsScreen(handler));
		}
	}

	public void mouseMoved(PApplet p) {
		// nothing
	}

	public void mouseDragged(PApplet p) {
		// nothing
	}

	public void mouseClicked(PApplet p) {
		// nothing
	}

	public void mouseReleased(PApplet p) {
		// nothing
	}

	public void keyPressed(PApplet p) {
		// nothing
	}

	public void keyReleased(PApplet p) {
		// nothing
	}

	/**
	 * Checks if the entered number is valid
	 * 
	 * @param x entered value
	 * @return true if the input was valid, false otherwise
	 */
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

	/*
	 * Determines whether specified location is within the board
	 */
	private boolean inRange(int x, int y) {
		return x >= 0 && x < handler.getBoard().getTiles().length && y >= 0
				&& y < handler.getBoard().getTiles()[0].length;
	}
}
