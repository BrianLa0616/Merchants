package screens;

import java.awt.Color;

import buttons.TextButton;
import other.Player;
import processing.core.PApplet;

/**
 * Represents the transition screen in between turns
 * 
 * @author Eylam
 *
 */
public class EndScreen extends Screen {
	private ScreenHandler handler;
	private TextButton playAgain;
	private Player player;

	/**
	 * Creates a new transition screen
	 * 
	 * @param board  draws the window
	 * @param player currently on
	 */
	public EndScreen(ScreenHandler board, Player player) {
		super(board);
		this.player = player;
		playAgain = new TextButton(450, 500, 200, 75, Color.WHITE, Color.BLACK, "PLAY AGAIN", 24);
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
		p.text("Player " + (player.getId() + 1) + " Won!", Screen.DRAWING_WIDTH / 2, Screen.DRAWING_HEIGHT / 2 - 100);
		playAgain.draw(p);
	}

	/**
	 * Actions taken after the mouse is pressed
	 * 
	 * @param p PApplet used to draw
	 */
	public void mousePressed(PApplet p) {
		if (playAgain.isPointInButton(p.mouseX, p.mouseY)) {
			handler.restart();
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
