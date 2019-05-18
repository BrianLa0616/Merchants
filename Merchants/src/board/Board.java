package board;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import buttons.TextButton;
import merchants.Merchant;
import other.Player;
import processing.core.PApplet;

/**
 * 
 * @author Brian
 *
 *         Represents the game board on which everything happens
 *
 */
public class Board extends PApplet {

	private static final int menuPage = 1, rulePage = 2, rulePage2 = 3, boardPage = 4, transPage = 5, aucPage = 6,
			endPage = 7;
	private final Color[] playerColors = { new Color(200, 0, 0), new Color(0, 0, 200), new Color(200, 200, 50),
			new Color(50, 255, 50) };
	private final Color[] tileColors = { new Color(255, 50, 50), new Color(50, 50, 255), new Color(255, 255, 0),
			new Color(50, 255, 50) };

	private int stage;
	private int currCost;
	private int waitFrame;

	private TextButton back, next, rule;
	private Merchant selected;

	private ArrayList<Tile> auctionTiles;
	private TextButton[] changeAuctionPrice;

	// Game fields
	private ArrayList<Player> players = new ArrayList<Player>();
	private int numPlayers, numTurns, curPlayer;
	private Tile[][] tiles = new Tile[15][15];

	private boolean auctionTurn;
	private int playerBid;

	/**
	 * Initiates buttons
	 */
	public Board() {
		stage = menuPage;

		back = new TextButton(25, 400, 50, 50, Color.BLACK, Color.WHITE, "BACK", 18);
		next = new TextButton(150, 150, 200, 75, Color.WHITE, new Color(0, 180, 255), "NEXT", 18);
		rule = new TextButton(150, 250, 200, 75, Color.WHITE, new Color(0, 180, 255), "RULE", 18);

		selected = null;
		curPlayer = 0;

		for (int i = 0; i < tiles.length; i++) {
			for (int j = 0; j < tiles[0].length; j++) {
				tiles[i][j] = new Tile(i, j, 0);
			}
		}
		auctionTiles = new ArrayList<Tile>();
		changeAuctionPrice = new TextButton[4];

		currCost = 0;
		waitFrame = 0;
		playerBid = 0;

		auctionTurn = true;
	}

	/**
	 * Draws the board
	 */
	public void draw() {
		background(255);
		if (stage == menuPage) {
			next.draw(this);
			rule.draw(this);
		} else if (stage == rulePage) {
			back.draw(this);
		} else if (stage == rulePage2) {
			back.draw(this);
		} else if (stage == boardPage) {
			next.draw(this);
			rule.draw(this);
			noFill();

			for (int i = 0; i < tiles.length; i++) {
				for (int j = 0; j < tiles[0].length; j++) {
					tiles[i][j].draw(this);
				}
			}

			for (Player p : players) {
				for (Tile t : p.getTerritory()) {
					t.setFill(tileColors[players.indexOf(p)]);
				}
				for (Merchant m : p.getMerchants()) {
					m.draw(this);
				}
			}

			for (Tile[] ts : tiles) {
				for (Tile t : ts) {
//					if ()
				}
			}

			if (selected != null) {
				int[] dx = { 1, -1, 0, 0 };
				int[] dy = { 0, 0, -1, 1 };
				for (int i = 0; i < 4; i++) {
					int nx = selected.getX() + dx[i];
					int ny = selected.getY() + dy[i];
					if (inRange(nx, ny)) {
						tiles[nx][ny].setSelected(true);
					}
				}

//				if (players.get(curPlayer).getMerchants().contains(selected)) // TODO
//				highlight(selected);
				selected.draw(this);
			}

		} else if (stage == transPage) {
			next.draw(this);
			textSize(50);
			fill(0);

			text("Player " + (curPlayer + 1) + " turn: " + players.get(curPlayer).getName(), 50, 50);
		} else if (stage == aucPage) {
			waitFrame++;
			textSize(50);
			fill(0);

			text("AUCTION", 50, 50);
			Tile t = auctionTiles.get(0);
			text("Starting price: " + t.getCost(), 50, 750);
			text("Current price: " + currCost, 50, 850);
			for (int i = 0; i < players.size(); i++) {
				text(players.get(i).getName() + "'s bid: " + playerBid, 50, 200 + 100 * i);
			}
			String input;
			// let first draw, than bid
			if (auctionTurn && waitFrame == 2) {
				for (int i = 0; i < t.getAuctioners().size(); i++) {
					changeAuctionPrice[i] = new TextButton(125, 100 * i, 50, 50, Color.BLACK, Color.WHITE, "BID", 18);
					changeAuctionPrice[i] = new TextButton(125, 800, 50, 50, Color.BLACK, Color.WHITE, "Withdraw From Auction", 18);
					do {
						input = JOptionPane.showInputDialog("Player " + players.get(i).getName() + "add money to the bid: ");
						if (input == null || input.equals("")) {
							continue;
						}
						System.out.println(input + " " + validIntegerInput(input));
					} while (!validIntegerInput(input));
					playerBid = Integer.parseInt(input);
					currCost = Integer.parseInt(input) + t.getCost();

					auctionTurn = false;

				}
			}

			waitFrame = 0;
			next.draw(this);

		} else if (stage == endPage) {

		}
	}

	/**
	 * Checks for clicks and checks if it corresponds to a specific location
	 */
	public void mousePressed() {
		if (stage == menuPage) {
			if (next.isPointInButton(mouseX, mouseY)) {
				String input;
				do {
					input = JOptionPane.showInputDialog("Enter number of players. 1-4 players");
					if (input == null || input.equals("")) {
						return;
					}
				} while (!validIntegerInput(input)
						|| !(input.compareTo("0") > 0 && input.compareTo("5") < 0 && input.length() == 1));
				numPlayers = Integer.parseInt(input);

				for (int i = 0; i < numPlayers; i++) {
					input = JOptionPane.showInputDialog("Enter the name for player " + (i + 1));
					if (input == null || input.equals("")) {
						return;
					}

					int x, y;

					do {
						x = (int) (Math.random() * tiles.length);
						y = (int) (Math.random() * tiles[0].length);
					} while (tiles[x][y].getMerchant() != null);

					players.add(new Player(i, 00, input, playerColors[i], new Merchant(x, y)));

					tiles[x][y].setMerchant(players.get(i).getMerchants().get(0));
					tiles[x][y].setOwner(i);
					players.get(i).addTerritory(tiles[x][y]);
				}

				do {
					input = JOptionPane.showInputDialog("How many turns should the game last?");
					if (input == null || input.equals("")) {
						return;
					}
				} while (!validIntegerInput(input));
				numTurns = Integer.parseInt(input);

				next = new TextButton(1000, 100, 50, 50, Color.WHITE, new Color(0, 180, 255), "NEXT", 18);
				rule = new TextButton(1000, 200, 50, 50, Color.WHITE, new Color(0, 180, 255), "RULE", 18);

				auctionTiles.add(tiles[0][0]);
				tiles[0][0].addAuctioner(players.get(0));

				stage = transPage;
			} else if (rule.isPointInButton(mouseX, mouseY)) {
				stage = rulePage;
			}
		} else if (stage == rulePage) {
			if (back.isPointInButton(mouseX, mouseY)) {
				stage = menuPage;
			}
		} else if (stage == rulePage2) {
			if (back.isPointInButton(mouseX, mouseY)) {
				stage = boardPage;
			}
		} else if (stage == boardPage) {
			if (next.isPointInButton(mouseX, mouseY)) {
				curPlayer++;
				curPlayer %= numPlayers;
				if (curPlayer == 0 && auctionTiles.size() != 0) {
					stage = aucPage;
				} else {
					stage = transPage;
				}
			} else if (rule.isPointInButton(mouseX, mouseY)) {
				stage = rulePage2;
			} else {
				int mx = mouseX / Tile.TILE_SIZE;
				int my = mouseY / Tile.TILE_SIZE;
				if (inRange(mx, my)) {

					if (selected == null) {
						selected = tiles[mx][my].getMerchant();
					} else {
						if (Math.abs(mx - selected.getX()) + Math.abs(my - selected.getY()) <= 1
								&& tiles[mx][my].getMerchant() == null) {

							// Check if moving or buying

							/*
							 * String[] options = { "moving", "buying" };
							 * 
							 * int x = JOptionPane.showOptionDialog(null, "What do you want to do",
							 * "Choose a move", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE,
							 * null, options, 0);
							 */
							if (mouseButton == LEFT) {

								tiles[mx][my].setMerchant(selected);
								tiles[selected.getX()][selected.getY()].setMerchant(null);
								deselect();

								tiles[mx][my].getMerchant().setX(mx);
								tiles[mx][my].getMerchant().setY(my);

								for (int i = -1; i <= 1; i++) {
									for (int j = -1; j <= 1; j++) {
										int nx = mx + i;
										int ny = my + j;
										if (inRange(nx, ny) && Math.abs(i) + Math.abs(j) < 2) {
											tiles[nx][ny].setFill(null);
										}
									}
								}

							} else if (mouseButton == RIGHT) {
								deselect();
								auctionTiles.add(tiles[mx][my]);
								tiles[mx][my].addAuctioner(players.get(curPlayer));

								stage = aucPage;

							}
						} else {
							deselect();
						}

					}

				}
			}
		} else if (stage == transPage) {
			if (next.isPointInButton(mouseX, mouseY)) {
				repaint();
				stage = boardPage;
			}

		} else if (stage == aucPage) {
			if (next.isPointInButton(mouseX, mouseY)) {

				int winner = 0;
				ArrayList<Player> auctioners = auctionTiles.get(0).getAuctioners();

				/*
				 * int max = -1; for (int i = 0; i < auctioners.size(); i++) { if
				 * (auctioners.get(i).getAuctionPrice() > max) { winner =
				 * auctioners.get(i).getId(); max = auctioners.get(i).getAuctionPrice(); } }
				 */
				winner = (int) (Math.random() * auctioners.size());

				players.get(auctioners.get(winner).getId()).addTerritory(auctionTiles.get(0));
				auctionTiles.get(0).setOwner(auctioners.get(winner).getId());
				auctionTiles.remove(0);

				System.out.println(players.get(0).getTerritory().size());

				if (auctionTiles.size() == 0) {
					stage = transPage;
				}
			}
		} else if (stage == endPage) {

		}
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

	/**
	 * Checks if (x, y) is within the board
	 * 
	 * @param x coordinate of location
	 * @param y coordinate of location
	 * @return true if the specified location is within the board, false otherwise
	 */
	private boolean inRange(int x, int y) {
		return x >= 0 && x < tiles.length && y >= 0 && y < tiles[0].length;
	}

	/**
	 * Deselects the merchant
	 */
	private void deselect() {
		for (int i = -1; i <= 1; i++) {
			for (int j = -1; j <= 1; j++) {
				int nx = selected.getX() + i;
				int ny = selected.getY() + j;
				if (inRange(nx, ny) && Math.abs(i) + Math.abs(j) < 2) {
					tiles[nx][ny].setSelected(false);
				}
			}
		}

//		unhighlight(selected);

		selected = null;
	}

	/**
	 * Covers the area that the player is unable to see with Dark Gray
	 */
	private void repaint() {

		for (int i = 0; i < tiles.length; i++) {
			for (int j = 0; j < tiles[0].length; j++) {
				tiles[i][j].setFill(Color.DARK_GRAY);
			}
		}

		ArrayList<Tile> tiles = players.get(curPlayer).getTerritory();

		for (int i = 0; i < tiles.size(); i++) {
			for (int j = -1; j <= 1; j++) {
				for (int k = -1; k <= 1; k++) {
					int nx = tiles.get(i).getX() + j;
					int ny = tiles.get(i).getY() + k;
					if (inRange(nx, ny)) {
						this.tiles[nx][ny].setFill(null);
					}
				}
			}
		}

		ArrayList<Merchant> merchants = players.get(curPlayer).getMerchants();
		for (int i = 0; i < merchants.size(); i++) {
			for (int j = -1; j <= 1; j++) {
				for (int k = -1; k <= 1; k++) {
					int nx = merchants.get(i).getX() + j;
					int ny = merchants.get(i).getY() + k;
					if (inRange(nx, ny)) {
						this.tiles[nx][ny].setFill(null);
					}
				}
			}
		}

	}

//	private void highlight(Merchant m) {
//		highlight(m.getX(), m.getY(), m.getSpeed());
//	}
//
//	public void unhighlight(Merchant m) {
//		unhighlight(m.getX(), m.getY(), m.getSpeed());
//	}

//	// yay recursion
//	private void highlight(int x, int y, int steps) {
//		if (steps > 0) {
//			highlight(x, y, steps - 1);
//			if (inRange(x - 1, y))
//				highlight(x - 1, y, steps - 1);
//			if (inRange(x + 1, y))
//				highlight(x + 1, y, steps - 1);
//			if (inRange(x, y - 1))
//				highlight(x, y - 1, steps - 1);
//			if (inRange(x, y + 1))
//				highlight(x, y + 1, steps - 1);
//		} else
//			tiles[x][y].setFill(Color.YELLOW);
//	}
//
//	// yay more recursion
//	private void unhighlight(int x, int y, int steps) {
//		if (steps > 0) {
//			unhighlight(x, y, steps - 1);
//			if (inRange(x - 1, y))
//				unhighlight(x - 1, y, steps - 1);
//			if (inRange(x + 1, y))
//				unhighlight(x + 1, y, steps - 1);
//			if (inRange(x, y - 1))
//				unhighlight(x, y - 1, steps - 1);
//			if (inRange(x, y + 1))
//				unhighlight(x, y + 1, steps - 1);
//		} else
//			tiles[x][y].setFill(null);
//	}

}
