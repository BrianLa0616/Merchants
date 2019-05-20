package screens;

import java.awt.Color;

import buttons.TextButton;
import other.Player1;
import processing.core.PApplet;

/**
 * Represents the transition screen in between turns
 * 
 * @author Eylam
 *
 */
public class TransScreen extends Screen {
	private ScreenHandler handler;
	private TextButton next;
	private Player1 player;

	/**
	 * Creates a new transition screen
	 * 
	 * @param board
	 * @param player currently on
	 */
	public TransScreen(ScreenHandler board, Player1 player) {
		super(board);
		this.player = player;
		next = new TextButton(450, 500, 200, 75, Color.WHITE, Color.BLACK, "READY", 24);
		handler = board;
	}

	public void setup(PApplet p) {
		// nothing
	}

	/**
	 * Draws the transition screen and its contents
	 * 
	 * @param p PApplet used to draw
	 */
	public void draw(PApplet p) {
		p.textAlign(PApplet.CENTER);
		p.fill(0);
		p.textSize(60);
		p.text("Player " + (player.getId() + 1), Screen.DRAWING_WIDTH / 2, Screen.DRAWING_HEIGHT / 2 - 100);
		p.textSize(36);
		p.text("START TURN", Screen.DRAWING_WIDTH / 2, Screen.DRAWING_HEIGHT / 2 - 50);
		next.draw(p);
	}

	/**
	 * Actions taken after the mouse is pressed
	 * 
	 * @param p PApplet used to draw
	 */
	public void mousePressed(PApplet p) {
		if (next.isPointInButton(p.mouseX, p.mouseY)) {
			handler.getBoard().setPlayer(player);
			handler.proceed(handler.getBoard());
		}
	}

	public void mouseMoved(PApplet p) {

	}

	public void mouseDragged(PApplet p) {

	}

	public void mouseClicked(PApplet p) {

	}

	public void mouseReleased(PApplet p) {

	}

	public void keyPressed(PApplet p) {

	}

	public void keyReleased(PApplet p) {

	}
}
