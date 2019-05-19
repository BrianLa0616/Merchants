package screens;

import java.awt.Color;

import board.Board1;
import buttons.TextButton;
import other.Auction;
import other.Bid;
import processing.core.PApplet;

public class AuctionScreen extends Screen {
	private Auction auction;
	private Board1 board;
	private Bid winner;
	private ScreenHandler handler;

	private TextButton proceed;

	public AuctionScreen(ScreenHandler handler, Board1 board, Auction a) {
		super(handler);
		auction = a;
		winner = auction.decideWinner();
		this.handler = handler;

		proceed = new TextButton(Screen.DRAWING_WIDTH - 175, 25, 150, 75, Color.WHITE, Color.BLACK, "PROCEED", 18);
	}

	public void setup(PApplet p) {
		winner.getPlayer().addTile(auction.getTile());
	}

	public void draw(PApplet p) {
		p.fill(60);
		p.rect(0, 0, 900, 900);

		p.fill(0);
		p.textSize(14);
		p.textAlign(PApplet.LEFT);
		p.text("AUCTION\nFor: " + auction.getTile().getCharacteristics() + "\nWINNER: Player"
				+ (winner.getPlayer().getIndex() + 1), Screen.DRAWING_WIDTH - 150, 200);

		int x = auction.getTile().getX(), y = auction.getTile().getX();
		for (int i = x - 1; i <= x + 1; i++) {
			for (int j = y - 1; j <= y + 1; j++) {
				board.tiles()[i][j].draw(p);
				if (board.merchantAt(board.tiles()[i][j]) != null) {
					board.merchantAt(board.tiles()[i][j]).draw(p);
				}
			}
		}

		proceed.draw(p);
	}

	public void mousePressed(PApplet p) {
		if (proceed.isPointInButton(p.mouseX, p.mouseY)) {
			handler.proceed(new TransScreen(handler, handler.getPlayers().get(0)));
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
