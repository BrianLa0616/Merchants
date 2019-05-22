package board;

import java.awt.Color;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import buttons.TextButton;
import merchants.Merchant1;
import other.Auction;
import other.Bid;
import other.Player1;
import processing.core.PApplet;
import processing.core.PConstants;
import screens.AuctionScreen;
import screens.Screen;
import screens.ScreenHandler;
import screens.TransScreen;

/**
 * Represents the game board
 * 
 * @author Brian
 *
 */
public class Board1 extends Screen {
	private Player1 player;
	private ScreenHandler handler;
	private ArrayList<Auction> auctions;
	private Tile1[][] tiles;
	private Tile1 selectedT;
	private Merchant1 selectedM;

	private TextButton endTurn;

	/**
	 * Creates a new board
	 * 
	 * @param board
	 */
	public Board1(ScreenHandler board) {
		super(board);
		this.handler = board;
		player = null;
		selectedT = null;
		selectedM = null;

		auctions = new ArrayList<Auction>();
		tiles = new Tile1[15][15];
		for (int i = 0; i < 15; i++) {
			for (int j = 0; j < 15; j++) {
				tiles[i][j] = new Tile1(i, j, 15 + (int) (Math.random() * 10));
			}
		}

		endTurn = new TextButton(Screen.DRAWING_WIDTH - 175, 25, 150, 75, Color.WHITE, Color.BLACK, "END\nTURN", 18);
	}

	/**
	 * Sets the player within the board
	 * 
	 * @param player desired to set
	 */
	public void setPlayer(Player1 player) {
		this.player = player;
	}

	public void setup(PApplet p) {
		// nothing
	}

	/**
	 * Draws the board
	 * 
	 * @param p PApplet used to draw
	 */
	public void draw(PApplet p) {
		for (Tile1[] ts : tiles) {
			for (Tile1 t : ts) {

				t.draw(p, player.getId());
			}
		}

		if (selectedM != null) {
			p.fill(0);
			p.textSize(14);
			p.textAlign(PApplet.LEFT);
			String display = "Merchant: ";
			display += "\nMoves left: " + selectedM.getMovesLeft();

			p.text(display, Screen.DRAWING_WIDTH - 150, 200);

		} else if (selectedT != null) {
			p.fill(0);
			p.textSize(14);
			p.textAlign(PApplet.LEFT);
			String display = selectedT.getCharacteristics();

			p.text(display, Screen.DRAWING_WIDTH - 150, 200);
		}

		endTurn.draw(p);
	}

	/**
	 * Determines actions taken after the mouse has been pressed
	 * 
	 * @param p PApplet used to draw
	 */
	public void mousePressed(PApplet p) {
		if (endTurn.isPointInButton(p.mouseX, p.mouseY)) {
			refreshMerchants();
			if (player.getId() + 1 == handler.getPlayers().size()) {
				if (auctions.size() == 0) {
					handler.proceed(new TransScreen(handler, handler.getPlayers().get(0)));
				} else {
					handler.proceed(new AuctionScreen(handler, auctions.get(0)));
				}
			} else {
				handler.proceed(new TransScreen(handler, handler.getPlayers().get(player.getId() + 1)));
			}
		} else {
			int mx = p.mouseY / Tile1.TILE_SIZE, my = p.mouseX / Tile1.TILE_SIZE;

			if (inRange(mx, my) && tiles[mx][my].isUncovered(player.getId())) {
				if (selectedT == null) { // if nothing is selected
					selectedT = tiles[mx][my];

					if (selectedT.getMerchant() != null) {
						selectedM = selectedT.getMerchant();
						if (selectedM.getOwner() == player && selectedM.movable()) {
							switchHighlight(mx, my, true);
						}
					} else {
						tiles[mx][my].setSelected(true);
					}
				} else if (selectedM != null) { // if merchant and tile are selected

					if (selectedT == tiles[mx][my]) { // if same tile pressed
						if (p.mouseButton == PConstants.LEFT) {
							selectedM = null;
							tiles[mx][my].setSelected(true);
							switchHighlight(mx, my, false);
						} else {
							if (player.getMoney() < tiles[mx][my].getCost()) {
								JOptionPane.showMessageDialog(null, "Not enough money", "INVALID MOVE",
										JOptionPane.ERROR_MESSAGE);
								return;
							}

							Auction a = new Auction(tiles[mx][my]);
							a.addBid(new Bid(player, tiles[mx][my].getCost()));
							addAuction(a);

							JOptionPane.showMessageDialog(null, "Successfully entered auction", "AUCTION",
									JOptionPane.INFORMATION_MESSAGE);
							switchHighlight(selectedT.getX(), selectedT.getY(), false);
							selectedT = null;
							selectedM = null;
						}
					} else { // if different tile is pressed
						if (Math.abs(mx - selectedT.getX()) + Math.abs(my - selectedT.getY()) == 1
								&& p.mouseButton == PConstants.LEFT && tiles[mx][my].getMerchant() == null
								&& selectedM.movable() && selectedM.getOwner() == player) { // moving

							switchHighlight(selectedM.getX(), selectedM.getY(), false);
							selectedT.setMerchant(null);
							tiles[mx][my].setMerchant(selectedM);
							selectedM.setCoordinates(mx, my);
							selectedM = null;
							selectedT = null;

							uncover(mx, my);
						} else if (Math.abs(mx - selectedT.getX()) <= 1 && Math.abs(my - selectedT.getY()) <= 1
								&& p.mouseButton == PConstants.RIGHT) { // auctioning
							if (player.getMoney() < tiles[mx][my].getCost()) {
								JOptionPane.showMessageDialog(null, "Not enough money", "INVALID MOVE",
										JOptionPane.ERROR_MESSAGE);
								return;
							}

							Auction a = new Auction(tiles[mx][my]);
							a.addBid(new Bid(player, tiles[mx][my].getCost()));
							addAuction(a);
							JOptionPane.showMessageDialog(null, "Successfully entered auction", "AUCTION",
									JOptionPane.INFORMATION_MESSAGE);
							switchHighlight(selectedT.getX(), selectedT.getY(), false);
							selectedT = null;
							selectedM = null;
						} else {
							switchHighlight(selectedT.getX(), selectedT.getY(), false);
							selectedT = null;
							selectedM = null;
						}
					}

				} else if (selectedT != null) {
					// if tile is only selected
					if (selectedT == tiles[mx][my]) {
						tiles[mx][my].setSelected(false);
						selectedT = null;
					} else {
						selectedT.setSelected(false);
						selectedT = tiles[mx][my];
						if (selectedT.getMerchant() != null) {
							selectedM = selectedT.getMerchant();
							if (selectedM.movable() && selectedM.getOwner() == player) {
								switchHighlight(mx, my, true);
							}
						} else {
							selectedT.setSelected(true);
						}
					}

				}

			} else {
				if (selectedT != null) {
					tiles[selectedT.getX()][selectedT.getY()].setSelected(false);
				}
				if (selectedM != null) {
					switchHighlight(selectedM.getX(), selectedM.getY(), false);
				}
				selectedT = null;
				selectedM = null;

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
	 * 
	 * @return tiles in the board
	 */
	public Tile1[][] getTiles() {
		return tiles;
	}

	/**
	 * Adds a new auction
	 * 
	 * @param a Auction desired to add
	 */
	public void addAuction(Auction a) {
		for (int i = 0; i < auctions.size(); i++) {
			if (a.getTile() == auctions.get(i).getTile()) {
				auctions.get(i).addBid(a.getBids().get(0));
				return;
			}
		}

		auctions.add(a);
	}

	/**
	 * 
	 * @return auctions that are currently happening
	 */
	public ArrayList<Auction> getAuction() {
		return auctions;
	}

	/*
	 * Determines whether the specified location is within the board
	 * 
	 */
	private boolean inRange(int x, int y) {
		return x >= 0 && x < tiles.length && y >= 0 && y < tiles[0].length;
	}

	/*
	 * Highlights where the player can move within the board
	 * 
	 * 
	 */
	private void switchHighlight(int x, int y, boolean state) {
		int[] dx = { 0, 0, -1, 1 };
		int[] dy = { 1, -1, 0, 0 };

		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if (inRange(nx, ny)) {
				tiles[nx][ny].setSelected(state);
			}
		}
	}

	/*
	 * Uncovers the specified area for the player
	 * 
	 */
	public void uncover(int x, int y) {
		for (int i = -1; i <= 1; i++) {
			for (int j = -1; j <= 1; j++) {
				int nx = x + i;
				int ny = y + j;
				if (inRange(nx, ny)) {
					tiles[nx][ny].uncover(player.getId());
				}
			}
		}
	}

	private void refreshMerchants() {
		for (int i = 0; i < player.getMerchants().size(); i++) {
			player.getMerchants().get(i).newTurn();
		}
	}

}
