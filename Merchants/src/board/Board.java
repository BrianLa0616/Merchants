package board;

import java.awt.Color;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import buttons.TextButton;
import merchants.AuctionMerchant;
import merchants.InvisibleMerchant;
import merchants.Merchant;
import merchants.MoneyMerchant;
import merchants.RadarMerchant;
import merchants.SpeedMerchant;
import other.Auction;
import other.Bid;
import other.Player;
import processing.core.PApplet;
import processing.core.PConstants;
import screens.AuctionScreen;
import screens.EndScreen;
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
	public static final int BOARD_SIZE = 5;

	private Player player;
	private ScreenHandler handler;
	private ArrayList<Auction> auctions;
	private Tile[][] tiles;
	private Tile selectedT;
	private Merchant selectedM;

	private TextButton upgradeM;
	private TextButton buyM;
	private TextButton auctionM;
	private TextButton invisM;
	private TextButton moneyM;
	private TextButton radarM;
	private TextButton speedM;
	private TextButton endTurn;
	private TextButton createCheckpoint;

	private int count;
	private int currTurn, totalTurns;
	
	private static final int auctionEdge = Color.CYAN.getRGB();
	private static final int invisEdge = Color.GRAY.getRGB();
	private static final int moneyEdge = Color.PINK.getRGB();
	private static final int radarEdge = Color.YELLOW.getRGB();
	private static final int speedEdge = Color.MAGENTA.getRGB();

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

		count = 0;

		currTurn = 1;
		auctions = new ArrayList<Auction>();
		tiles = new Tile[BOARD_SIZE][BOARD_SIZE];
		for (int i = 0; i < BOARD_SIZE; i++) {
			for (int j = 0; j < BOARD_SIZE; j++) {
				tiles[i][j] = new Tile(i, j, 15 + (int) (Math.random() * 20));
			}
		}

		auctionM = new TextButton(Screen.DRAWING_WIDTH - 175, 145, 150, 95, Color.WHITE, Color.BLACK,
				"AUCTION \nMERCHANT \n$20", 18);
		invisM = new TextButton(Screen.DRAWING_WIDTH - 175, 270, 150, 95, Color.WHITE, Color.BLACK,
				"INVISIBLE \nMERCHANT \n$20", 18);
		moneyM = new TextButton(Screen.DRAWING_WIDTH - 175, 395, 150, 95, Color.WHITE, Color.BLACK,
				"MONEY \nMERCHANT \n$20", 18);
		radarM = new TextButton(Screen.DRAWING_WIDTH - 175, 520, 150, 95, Color.WHITE, Color.BLACK,
				"RADAR \nMERCHANT \n$20", 18);
		speedM = new TextButton(Screen.DRAWING_WIDTH - 175, 645, 150, 95, Color.WHITE, Color.BLACK,
				"SPEED \nMERCHANT \n$20", 18);

		upgradeM = new TextButton(Screen.DRAWING_WIDTH - 175, 20, 150, 95, Color.WHITE, Color.BLACK,
				"UPGRADE \nMERCHANT", 18); // + price of merchant
		createCheckpoint = new TextButton(Screen.DRAWING_WIDTH - 175, 20, 150, 75, Color.WHITE, Color.BLACK,
				"CREATE \nCHECKPOINT", 18);
		buyM = new TextButton(Screen.DRAWING_WIDTH - 175, 20, 150, 75, Color.WHITE, Color.BLACK, "BUY\nMERCHANT ($50)",
				18);
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
			String display = "Merchant: Player " + (1 + selectedM.getOwner().getId());
			display += "\nMoves left: " + selectedM.getMovesLeft();
			display += "\nLevel " + selectedM.getLevel();

			upgradeM.draw(p);

			p.text(display, Screen.DRAWING_WIDTH - 150, 770);

		} else if (selectedT != null) {

			if (selectedT instanceof Checkpoint == false && selectedT.getOwner() == player) {
				createCheckpoint.draw(p);
			} else if (selectedT == player.getTerritory().get(0)) {
				buyM.draw(p);
			}

			String display = selectedT.getCharacteristics();

			p.text(display, Screen.DRAWING_WIDTH - 150, 770);
		}

		if (count == 1 && selectedM.getLevel() == 0) {
			auctionM.draw(p);
			invisM.draw(p);
			moneyM.draw(p);
			radarM.draw(p);
			speedM.draw(p);
		}

		p.textSize(36);
		p.text("Player " + (player.getId() + 1) + " (Balance: $" + player.getBalance() + ")", 25,
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
			unselectAll();
			if (player == handler.getPlayers().get(handler.getPlayers().size() - 1)) { // auction
				if (auctions.size() == 0) {
					if (currTurn == totalTurns) {
						handler.proceed(new EndScreen(handler, getWinner()));
					} else {
						currTurn++;
						handler.proceed(new TransScreen(handler, handler.getPlayers().get(0)));
					}
				} else {
					handler.proceed(new AuctionScreen(handler, auctions.get(0)));
				}
			} else {
				handler.proceed(
						new TransScreen(handler, handler.getPlayers().get(handler.getPlayers().indexOf(player) + 1)));
			}
		} else if (upgradeM.isPointInButton(p.mouseX, p.mouseY) && selectedM != null
				&& selectedM.getOwner() == player) {
			if (selectedM.getLevel() == 0) {
				upgradeMerchant();

				if (auctionM.isPointInButton(p.mouseX, p.mouseY)) {
					player.setBalance(player.getBalance() - selectedM.getPrice());

					player.getMerchants().set(player.getMerchants().indexOf(selectedM),
							new AuctionMerchant(selectedM.getX(), selectedM.getY(), player.getMerchantColor(),
									selectedM.setEdge(auctionEdge)));

				} else if (invisM.isPointInButton(p.mouseX, p.mouseY)) {
					player.setBalance(player.getBalance() - selectedM.getPrice());

					player.getMerchants().set(player.getMerchants().indexOf(selectedM),
							new InvisibleMerchant(selectedM.getX(), selectedM.getY(), player.getMerchantColor(),
									selectedM.setEdge(invisEdge)));

				} else if (moneyM.isPointInButton(p.mouseX, p.mouseY)) {
					player.setBalance(player.getBalance() - selectedM.getPrice());

					player.getMerchants().set(player.getMerchants().indexOf(selectedM),
							new MoneyMerchant(selectedM.getX(), selectedM.getY(), player.getMerchantColor(),
									selectedM.setEdge(moneyEdge)));

				} else if (radarM.isPointInButton(p.mouseX, p.mouseY)) {
					player.setBalance(player.getBalance() - selectedM.getPrice());

					player.getMerchants().set(player.getMerchants().indexOf(selectedM),
							new RadarMerchant(selectedM.getX(), selectedM.getY(), player.getMerchantColor(),
									selectedM.setEdge(radarEdge)));

				} else if (speedM.isPointInButton(p.mouseX, p.mouseY) && selectedM != null) {
					player.setBalance(player.getBalance() - selectedM.getPrice());

					player.getMerchants().set(player.getMerchants().indexOf(selectedM),
							new SpeedMerchant(selectedM.getX(), selectedM.getY(), player.getMerchantColor(),
									selectedM.setEdge(speedEdge)));

				}
			} else if (selectedM.getLevel() > 1 && selectedM.getLevel() < 5) {

				selectedM.setLevel(selectedM.getLevel() + 1);

			}

		} else if (buyM.isPointInButton(p.mouseX, p.mouseY) && selectedT != null
				&& player.getTerritory().get(0) == selectedT) {
			buyMerchant();
		} else if (createCheckpoint.isPointInButton(p.mouseX, p.mouseY) && selectedT != null
				&& selectedT.getOwner() == player) {
			createCheckpoint();
		} else {
			int mx = p.mouseY / Tile.TILE_SIZE, my = p.mouseX / Tile.TILE_SIZE;

			if (inRange(mx, my) && tiles[mx][my].isUncovered(player.getId())) {
				if (selectedT == null) { // if nothing is selected
					selectedT = tiles[mx][my];
					selectedT.setSelected(true);

					if (selectedT.getMerchant() != null) { // if merchant is selected
						selectedT.setSelected(false);
						selectedM = selectedT.getMerchant();
						selectedM.setColor(Color.YELLOW);
						if (selectedM.getOwner() == player && selectedM.movable()) {
							switchHighlight(mx, my, true);
						}

						if (selectedM.getEdge() == speedEdge) {
							selectedM.getSpeedM().speed(selectedM.getLevel(), selectedM.getTotalMoves());
						}

						if (selectedM.getEdge() == radarEdge) {
							selectedM.getRadarM().reveal(selectedM.getLevel());
						}
					} else {
						selectedT.setSelected(true);
					}
				} else if (selectedM != null) { // if merchant and tile are selected

					if (selectedT == tiles[mx][my]) { // if same tile pressed
						if (p.mouseButton == PConstants.LEFT) {
							selectedM.setColor(selectedM.getOwner().getMerchantColor());
							selectedM = null;
							tiles[mx][my].setSelected(true);
							switchHighlight(mx, my, false);
						} else {
							if (selectedM.getOwner() == player) {
								auction(mx, my);
							}
						}
					} else { // if different tile is pressed
						if ((Math.abs(mx - selectedT.getX()) + Math.abs(my - selectedT.getY()) == 1
								|| tiles[mx][my] instanceof Checkpoint && tiles[mx][my].getOwner() == player)
								&& p.mouseButton == PConstants.LEFT && tiles[mx][my].getMerchant() == null
								&& selectedM.movable() && selectedM.getOwner() == player) { // moving

							switchHighlight(selectedM.getX(), selectedM.getY(), false);
							selectedT.setMerchant(null);
							tiles[mx][my].setMerchant(selectedM);
							selectedM.setCoordinates(mx, my);
							if (tiles[mx][my] instanceof Checkpoint && selectedM.getMovesLeft() >= 0) {
								selectedM.setNumMoves(selectedM.getSpeed());
							}

							unselectAll();

							uncover(mx, my);
						} else if (Math.abs(mx - selectedT.getX()) <= 1 && Math.abs(my - selectedT.getY()) <= 1
								&& p.mouseButton == PConstants.RIGHT && selectedM.getOwner() == player) { // auctioning
							auction(mx, my);
						} else {
							unselectAll();
						}
					}

				} else if (selectedT != null) { // if tile is only selected

					if (selectedT == tiles[mx][my]) { // same tile is pressed
						unselectAll();
					} else {
						unselectAll();
						selectedT = tiles[mx][my];
						if (selectedT.getMerchant() != null) {
							selectedM = selectedT.getMerchant();
							if (selectedM.movable() && selectedM.getOwner() == player) {
								switchHighlight(mx, my, true);
							}
							selectedM.setColor(Color.YELLOW);
						} else {
							selectedT.setSelected(true);
						}
					}

				}
			} else {
				unselectAll();

			}
			count = 0;

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

	public void setTotalTurns(int x) {
		totalTurns = x;
	}

	public int getTotalTurns() {
		return totalTurns;
	}

	public void setCurrentTurn(int x) {
		currTurn = x;
	}

	public int getCurrentTurn() {
		return currTurn;
	}

	public Player getWinner() {
		ArrayList<Player> winners = new ArrayList<Player>();
		int max = 0;
		for (int i = 0; i < handler.getPlayers().size(); i++) {
			if (handler.getPlayers().get(i).getTerritory().size() > max) {
				winners.clear();
				max = handler.getPlayers().get(i).getTerritory().size();
				winners.add(handler.getPlayers().get(i));
			} else if (handler.getPlayers().get(i).getTerritory().size() == max) {
				winners.add(handler.getPlayers().get(i));
			}
		}

		if (winners.size() == 1) {
			return winners.get(0);
		}

		max = 0;
		Player winner = null;
		for (int i = 0; i < winners.size(); i++) {
			if (winners.get(i).getBalance() > max) {
				max = winners.get(i).getBalance();
				winner = winners.get(i);
			}
		}

		return winner;

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

	public boolean inRange(int x, int y) {
		return x >= 0 && x < tiles.length && y >= 0 && y < tiles[0].length;
	}

	private void upgradeMerchant() {
		count++;
	}

	// selectedT is an owned tile
	private void createCheckpoint() {
		int mx = selectedT.getX();
		int my = selectedT.getY();
		if (selectedT instanceof Checkpoint) {
			JOptionPane.showMessageDialog(null, "Checkpoint already created", "INVALID MOVE",
					JOptionPane.ERROR_MESSAGE);
		} else if (player.getBalance() < tiles[mx][my].getCost() * 2) {
			JOptionPane.showMessageDialog(null, "Not enough money", "INVALID MOVE", JOptionPane.ERROR_MESSAGE);
		} else {
			player.setBalance(player.getBalance() - tiles[mx][my].getCost() * 2);
			Checkpoint temp = new Checkpoint(mx, my, tiles[mx][my].getCost() * 2);
			// conserving characteristics of tile
			temp.setOwner(player);
			for (int i = 0; i < 4; i++) {
				if (tiles[mx][my].isUncovered(i)) {
					temp.uncover(i);
				}
			}
			temp.setMerchant(tiles[mx][my].getMerchant());
			player.getTerritory().set(player.getTerritory().indexOf(tiles[mx][my]), temp);
			tiles[mx][my] = temp;

			unselectAll();
		}
	}

	// selectedT is checkpoint
	private void buyMerchant() {

		if (selectedT.getMerchant() == null) {
			if (player.getBalance() >= 50) {
				player.setBalance(player.getBalance() - 50);
				player.addMerchant();
				selectedM = player.getTerritory().get(0).getMerchant();
				selectedT.setSelected(false);
				selectedM.setColor(Color.YELLOW);
			} else {
				JOptionPane.showMessageDialog(null, "Not enough money", "INVALID MOVE", JOptionPane.ERROR_MESSAGE);
			}
		} else {
			JOptionPane.showMessageDialog(null, "Merchant can not be created due to obstruction", "INVALID MOVE",
					JOptionPane.ERROR_MESSAGE);
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

		ArrayList<Tile> tiles = player.getTerritory();
		for (int i = 0; i < tiles.size(); i++) {
			if (tiles.get(i) instanceof Checkpoint && selectedT != tiles.get(i)) {
				tiles.get(i).setSelected(state);
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
			sum += (double) t.getCost() * 0.25;
		}
		/*
		 * //System.out.println(moneyEdge); System.out.println(selectedM.getEdge()); if
		 * (selectedM.getEdge() == moneyEdge) { player.setBalance(player.getBalance() +
		 * (int) sum + selectedM.getMoneyM().add(selectedM.getLevel())); return; }
		 */
		player.setBalance(player.getBalance() + (int) sum);
	}

	private void auction(int mx, int my) {
		if (!tiles[mx][my].isPicked()) {
			if (player.getBalance() < tiles[mx][my].getCost()) {
				JOptionPane.showMessageDialog(null, "Not enough money", "INVALID MOVE", JOptionPane.ERROR_MESSAGE);
				return;
			}

			Auction a = new Auction(tiles[mx][my]);
			a.addBid(new Bid(player, tiles[mx][my].getCost()));
			addAuction(a);

			JOptionPane.showMessageDialog(null, "Successfully entered auction", "AUCTION",
					JOptionPane.INFORMATION_MESSAGE);
			switchHighlight(selectedT.getX(), selectedT.getY(), false);
			tiles[mx][my].setPicked(true);
			unselectAll();
		} else {
			JOptionPane.showMessageDialog(null, "Already entered auction", "AUCTION", JOptionPane.INFORMATION_MESSAGE);
			unselectAll();
		}
	}

	private void unselectAll() {
		if (selectedT != null) {
			selectedT.setSelected(false);
			selectedT = null;
		}
		if (selectedM != null) {
			selectedM.setColor(selectedM.getOwner().getMerchantColor());
			switchHighlight(selectedM.getX(), selectedM.getY(), false);
			selectedM = null;
		}
	}

}