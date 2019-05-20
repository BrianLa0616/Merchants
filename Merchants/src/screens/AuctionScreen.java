package screens;

import java.awt.Color;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import buttons.TextButton;
import other.Auction;
import other.Bid;
import processing.core.PApplet;

public class AuctionScreen extends Screen {
	private Auction auction;
	private int winner;
	private ScreenHandler handler;

	private TextButton proceed;

	private ArrayList<TextButton> enterBid, withdraw;

	public AuctionScreen(ScreenHandler handler, Auction a) {
		super(handler);
		auction = a;
		enterBid = new ArrayList<TextButton>();
		withdraw = new ArrayList<TextButton>();
		winner = -1;
		this.handler = handler;

		proceed = new TextButton(Screen.DRAWING_WIDTH - 175, 25, 150, 75, Color.WHITE, Color.BLACK, "GET WINNER", 18);
	}

	public void setup(PApplet p) {

		for (int i = 0; i < auction.getBids().size(); i++) {
			enterBid.add(new TextButton(200, 200 + 100 * i, 200, 75, Color.WHITE, Color.BLACK, "ENTER BID", 24));
			withdraw.add(new TextButton(250, 200 + 100 * i, 200, 75, Color.WHITE, Color.BLACK, "WITHDRAW", 24));
		}
	}

	public void draw(PApplet p) {
		p.textAlign(PApplet.CENTER);
		p.textSize(60);
		p.text("AUCTION", Screen.DRAWING_WIDTH / 2, 100);

		if (winner != -1) {
			p.fill(Color.YELLOW.getRGB());
			p.rect(50, 180 + 100 * winner, 150, 275 + 100 * winner);
		}

		p.textAlign(PApplet.LEFT);

		for (int i = 0; i < auction.getBids().size(); i++) {
			p.text("Player " + auction.getBids().get(i).getPlayer().getId() + ": "
					+ auction.getBids().get(i).getAmount(), 50, 200 + 100 * i);
			enterBid.get(i).draw(p);
			withdraw.get(i).draw(p);
		}

//		p.text("AUCTION\nFor: " + auctions.get(0).getTile().getCharacteristics(), Screen.DRAWING_WIDTH - 150, 200);		

		proceed.draw(p);
	}

	public void mousePressed(PApplet p) {
		if (proceed.isPointInButton(p.mouseX, p.mouseY)) {
			if (winner == -1) {
				Bid bid = auction.decideWinner();
				for (int i = 0; i < auction.getBids().size(); i++) {
					if (bid == auction.getBids().get(i)) {
						winner = i;
					}
				}
				proceed.setText("EXIT AUCTION");
			} else {
				handler.getAuction().remove(0);
				if (handler.getAuction().size() == 0) {
					handler.proceed(new TransScreen(handler, handler.getPlayers().get(0)));
				} else {
					handler.proceed(new AuctionScreen(handler, handler.getAuction().get(0)));
				}
			}
		} else {
			for (int i = 0; i < auction.getBids().size(); i++) {
				if (enterBid.get(i).isPointInButton(p.mouseX, p.mouseY)) {
					String input = JOptionPane.showInputDialog("Enter Bid Amount");
					
					if (input == null || input == "" || !validIntegerInput(input)) {
						return;
					}
					
					int bidAmount = Integer.parseInt(input);
					if (bidAmount < auction.getBids().get(i).getAmount()) {
						JOptionPane.showMessageDialog(null, "New bids should be larger than previous ones", "INVALID MOVE", JOptionPane.ERROR_MESSAGE);
						return;
					}
					
					auction.getBids().get(i).setAmount(bidAmount);
					return;
				} else if (withdraw.get(i).isPointInButton(p.mouseX, p.mouseY)) {
					int choice = JOptionPane.showConfirmDialog(null, "Withdraw from Auction?", "WITHDRAW", JOptionPane.YES_NO_OPTION);
					if (choice == 0) {
						auction.getBids().remove(i);
					} 
					
					return;
				}
			}
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
