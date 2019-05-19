package screens;

import java.awt.Color;

import javax.swing.JOptionPane;

import buttons.TextButton;
import other.Player1;
import processing.core.PApplet;

public class IntroScreen extends Screen {
	private TextButton start;
	private ScreenHandler handler;

	public IntroScreen(ScreenHandler board) {
		super(board);
		start = new TextButton(450, 450, 200, 75, Color.WHITE, Color.BLACK, "START", 24);
		this.handler = board;
	}

	public void setup(PApplet p) {
		// nothing
	}

	public void draw(PApplet p) {
		p.textAlign(PApplet.CENTER);
		p.textSize(60);
		p.fill(0);
		p.text("MERCHANTS", Screen.DRAWING_WIDTH / 2, Screen.DRAWING_HEIGHT / 2 - 100);
		start.draw(p);
	}

	public void mousePressed(PApplet p) {
		if (start.isPointInButton(p.mouseX, p.mouseY)) {

			String input;
			do {
				input = JOptionPane.showInputDialog("Enter number of players (2-4)");
				if (input == null || input.equals("")) {
				}
			} while (!validIntegerInput(input) || Integer.parseInt(input) > 4 || Integer.parseInt(input) < 2);

			int numPlayers = Integer.parseInt(input);

			int[] xvals = { 1, 13, 13, 1 }, yvals = { 1, 13, 1, 13 };

			for (int i = 0; i < numPlayers; i++) {
				handler.getPlayers().add(new Player1(xvals[i], yvals[i], ScreenHandler.PLAYER_COLORS[i], i));
			}

			handler.proceed(new TransScreen(handler, handler.getPlayers().get(0)));
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
}
