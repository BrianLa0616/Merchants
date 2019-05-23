package board;

import java.awt.Color;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import buttons.TextButton;
import merchants.Merchant;
import other.Auction;
import other.Bid;
import other.Player;
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
public class Board extends Screen {
	private Player player;
	private ScreenHandler handler;
	private ArrayList<Auction> auctions;
	private Tile[][] tiles;
	private Tile selectedT;
	private Merchant selectedM;

	private TextButton upgradeM;
	private TextButton buyM;
	private TextButton endTurn;
	private TextButton createCheckpoint;

	/**
	 * Creates a new board
	 * 
	 * @param board
	 */
	public Board(ScreenHandler board) {
		super(board);
		this.handler = board;
		player = null;
		selectedT = null;
		selectedM = null;

		auctions = new ArrayList<Auction>();
		tiles = new Tile[15][15];
		for (int i = 0; i < 15; i++) {
			for (int j = 0; j < 15; j++) {
				tiles[i][j] = new Tile(i, j, 15 + (int) (Math.random() * 10));
			}
		}

		upgradeM = new TextButton(Screen.DRAWING_WIDTH - 175, 20, 150, 75, Color.WHITE, Color.BLACK,
				"UPGRADE \nMERCHANT", 18);
		createCheckpoint = new TextButton(Screen.DRAWING_WIDTH - 175, 20, 150, 75, Color.WHITE, Color.BLACK,
				"CREATE \nCHECKPOINT", 18);
		buyM = new TextButton(Screen.DRAWING_WIDTH - 175, 20, 150, 75, Color.WHITE, Color.BLACK, "BUY \nMERCHANT", 18);
		endTurn = new TextButton(Screen.DRAWING_WIDTH - 175, Screen.DRAWING_HEIGHT - 125, 150, 75, Color.WHITE,
				Color.BLACK, "END\nTURN", 18);
	}

	/**
	 * Sets the player within the board
	 * 
	 * @param player desired to set
	 */
	public void setPlayer(Player player) {
		this.player = player;
		refresh();
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
		p.fill(0);
		p.textSize(14);
		p.textAlign(PApplet.LEFT);

		for (Tile[] ts : tiles) {
			for (Tile t : ts) {
				t.draw(p, player.getId());
			}
		}

		p.fill(0);

		if (selectedM != null) {
			String display = "Merchant: ";
			display += "\nMoves left: " + selectedM.getMovesLeft();
			display += "\nLevel " + selectedM.getLevel();

			upgradeM.draw(p);

			p.text(display, Screen.DRAWING_WIDTH - 150, 400);

		} else if (selectedT != null) {

			if (selectedT instanceof Checkpoint == false && selectedT.getOwner() == player) {
				createCheckpoint.draw(p);
			} else if (selectedT.getX() == player.initX() && selectedT.getY() == player.initY()) {
				buyM.draw(p);
			}
			String display = selectedT.getCharacteristics();

			p.text(display, Screen.DRAWING_WIDTH - 150, 400);
		}

		p.textSize(36);
		p.text("Player " + (player.getId() + 1) + " (Balance: " + player.getBalance() + ")", 25,
				Screen.DRAWING_HEIGHT - 75);
		endTurn.draw(p);
	}

	/**
	 * Determines actions taken after the mouse has been pressed
	 * 
	 * @param p PApplet used to draw
	 */
	public void mousePressed(PApplet p) {

		if (endTurn.isPointInButton(p.mouseX, p.mouseY)) { // end turn
			if (player.getId() + 1 == handler.getPlayers().size()) { // auction
				if (auctions.size() == 0) {
					handler.proceed(new TransScreen(handler, handler.getPlayers().get(0)));
				} else {
					handler.proceed(new AuctionScreen(handler, auctions.get(0)));
				}
			} else {
				handler.proceed(new TransScreen(handler, handler.getPlayers().get(player.getId() + 1)));
			}
		} else {
			int mx = p.mouseY / Tile.TILE_SIZE, my = p.mouseX / Tile.TILE_SIZE;

			if (inRange(mx, my) && tiles[mx][my].isUncovered(player.getId())) {
				if (selectedT == null) { // if nothing is selected
					selectedT = tiles[mx][my];

					if (selectedT.getMerchant() != null) { // if merchant is selected
						selectedM = selectedT.getMerchant();
						drawUM(p);
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
							auction(mx, my);
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
							auction(mx, my);
						} else {
							switchHighlight(selectedT.getX(), selectedT.getY(), false);
							selectedT = null;
							selectedM = null;
						}
					}

				} else if (selectedT != null) { // if tile is only selected

					if (selectedT.getX() == player.initX() && selectedT.getY() == player.initY()) {
						if (buyM.isPointInButton(p.mouseX, p.mouseY)) {
							buyMerchant();
							tiles[mx][my].setSelected(false);
						}
					}
					if (selectedT == tiles[mx][my]) { // same tile is pressed
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
	public Tile[][] getTiles() {
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

	private void buyMerchant() {
		int count = 0;
		for (int i = 0; i < player.getMerchants().size(); i++) {
			if (player.getMerchants().get(i).getX() == player.initX()
					&& player.getMerchants().get(i).getY() == player.initY()) {
				count++;
				break;
			}
		}
		if (count == 0) {
			if (player.getBalance() >= 20) {
				player.setBalance(player.getBalance() - 20);
				player.addMerchant();
			}
		}

	}

	private boolean inRange(int x, int y) {
		return x >= 0 && x < tiles.length && y >= 0 && y < tiles[0].length;
	}

	private void drawUM(PApplet p) {
		if (selectedM != null) {
			upgradeM.draw(p);
		}
	}

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

	/**
	 * Uncovers the specified area for the player
	 * 
	 * @param x coordinate of desired location
	 * @param y coordinate of desired location
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

	private void refresh() {
		for (Tile[] ts : tiles) {
			for (Tile t : ts) {
				t.setPicked(false);
				t.setSelected(false);
			}
		}

		for (int i = 0; i < player.getMerchants().size(); i++) {
			player.getMerchants().get(i).newTurn();
		}

		double sum = 0;
		for (Tile t : player.getTerritory()) {
			sum += (double) t.getCost() * 0.4;
		}

		player.setBalance(player.getBalance() + (int) sum);
	}
	
	private void auction(int mx, int my) {
		if (!tiles[mx][my].isPicked()) {
			if (player.getBalance() < tiles[mx][my].getCost()) {
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
			tiles[mx][my].setPicked(true);
			selectedT = null;
			selectedM = null;
		} else {
			JOptionPane.showMessageDialog(null, "Already entered auction", "AUCTION",
					JOptionPane.INFORMATION_MESSAGE);
			selectedT = null;
			selectedM = null;
		}
	}

}
