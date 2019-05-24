package screens;

import java.awt.Color;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import buttons.TextButton;
import other.Auction;
import other.Bid;
import processing.core.PApplet;

/**
 * Represents an Auction Screen where auctions take place
 * 
 * @author Eylam
 *
 */
public class AuctionScreen extends Screen {
	private Auction auction;
	private int winner;
	private ScreenHandler handler;

	private TextButton proceed;

	private ArrayList<TextButton> enterBid, withdraw;

	/**
	 * Creates a new Auction Screen
	 * 
	 * @param handler draws the screen
	 * @param a       new Auction
	 */
	public AuctionScreen(ScreenHandler handler, Auction a) {
		super(handler);
		auction = a;
		enterBid = new ArrayList<TextButton>();
		withdraw = new ArrayList<TextButton>();
		winner = -1;
		this.handler = handler;

		proceed = new TextButton(Screen.DRAWING_WIDTH - 175, 25, 150, 75, Color.WHITE, Color.BLACK, "GET WINNER", 18);
		for (int i = 0; i < auction.getBids().size(); i++) {
			if (auction.getBids().get(i).getPlayer().getBalance() >= auction.getTile().getCost()) {
				enterBid.add(new TextButton(500, 180 + 100 * i, 200, 75, Color.WHITE, Color.BLACK, "ENTER BID", 24));
				withdraw.add(new TextButton(750, 180 + 100 * i, 200, 75, Color.WHITE, Color.BLACK, "WITHDRAW", 24));
			} else {
				enterBid.add(null);
				withdraw.add(null);
			}
		}
	}

	public void setup(PApplet p) {

	}

	/**
	 * Draws the auction window
	 * 
	 * @param p PApplet used to draw
	 */
	public void draw(PApplet p) {
		p.textAlign(PApplet.CENTER);
		p.textSize(60);
		p.fill(Color.BLACK.getRGB());
		p.text("AUCTION", Screen.DRAWING_WIDTH / 2, 100);

		if (winner != -1) {
			p.fill(Color.YELLOW.getRGB());
			p.rect(50, 180 + 100 * winner, 350, 100);
		}

		p.textAlign(PApplet.LEFT);
		p.fill(Color.BLACK.getRGB());

		for (int i = 0; i < auction.getBids().size(); i++) {
			p.text("Player " + (auction.getBids().get(i).getPlayer().getId() + 1) + ": "
					+ auction.getBids().get(i).getAmount(), 50, 230 + 100 * i);

			if (winner == -1) {
				if (auction.getBids().get(i).getPlayer().getBalance() >= auction.getTile().getCost()) {
					enterBid.get(i).draw(p);
					withdraw.get(i).draw(p);
				} else {
					p.textSize(36);
					p.text("Disqualified (not enough money).", 500, 235 + 100 * i);
				}
			}
		}

//		p.text("AUCTION\nFor: " + auctions.get(0).getTile().getCharacteristics(), Screen.DRAWING_WIDTH - 150, 200);		

		proceed.draw(p);
	}

	/**
	 * Determines actions when the mouse is clicked
	 * 
	 * @param p PApplet used to draw
	 */
	public void mousePressed(PApplet p) {
		if (proceed.isPointInButton(p.mouseX, p.mouseY)) {
			ArrayList<Bid> processedBids = new ArrayList<Bid>();
			for (int i = 0; i < auction.getBids().size(); i++) {
				if (auction.getBids().get(i).getPlayer().getBalance() >= auction.getTile().getCost()) {
					processedBids.add(auction.getBids().get(i));
				}
			}

			auction.setBids(processedBids);

			if (winner == -1 && processedBids.size() >= 1) {

				Bid bid = auction.decideWinner();
				for (int i = 0; i < processedBids.size(); i++) {
					if (bid == processedBids.get(i)) {
						winner = i;
					}
				}

				bid.getPlayer().addTile(auction.getTile());
				bid.getPlayer().setBalance(bid.getPlayer().getBalance() - bid.getAmount());

				proceed.setText("EXIT AUCTION");
			} else {
				for (int i = 0; i < handler.getPlayers().size(); i++) {
					if (auction.getTile() == handler.getPlayers().get(i).getTerritory().get(0)) {
						JOptionPane.showMessageDialog(null, "Player " + handler.getPlayers().get(i).getId(),
								"PLAYER LOST", JOptionPane.INFORMATION_MESSAGE);
						handler.getPlayers().remove(i);
					}
				}
				handler.getBoard().getAuction().remove(0);
				if (handler.getBoard().getAuction().size() == 0) {
					handler.proceed(new TransScreen(handler, handler.getPlayers().get(0)));
				} else {
					handler.proceed(new AuctionScreen(handler, handler.getBoard().getAuction().get(0)));
				}
			}
		} else {
			if (winner == -1) {
				for (int i = 0; i < auction.getBids().size(); i++) {
					if (enterBid.get(i) != null && enterBid.get(i).isPointInButton(p.mouseX, p.mouseY)) {
						String input = JOptionPane.showInputDialog("Enter Bid Amount");

						if (input == null || input == "" || !validIntegerInput(input)) {
							return;
						}

						int bidAmount = Integer.parseInt(input);
						if (bidAmount < auction.getBids().get(i).getAmount()) {
							JOptionPane.showMessageDialog(null, "New bids should be larger than previous ones",
									"INVALID MOVE", JOptionPane.ERROR_MESSAGE);
							return;
						}

						if (bidAmount > auction.getBids().get(i).getPlayer().getBalance()) {
							JOptionPane.showMessageDialog(null, "Not enough money", "INVALID MOVE",
									JOptionPane.ERROR_MESSAGE);

							return;
						}

						auction.getBids().get(i).setAmount(bidAmount);
						return;
					} else if (withdraw.get(i) != null && withdraw.get(i).isPointInButton(p.mouseX, p.mouseY)) {
						int choice = JOptionPane.showConfirmDialog(null, "Withdraw from Auction?", "WITHDRAW",
								JOptionPane.YES_NO_OPTION);
						if (choice == 0) {
							auction.getBids().remove(i);
						}

						if (auction.getBids().size() == 0) {
							proceed.setText("EXIT AUCTION");
						}

						return;
					}
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
