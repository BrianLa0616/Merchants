package board;

import java.awt.Color;

import buttons.TextButton;
import merchants.Merchant1;
import other.Player1;
import processing.core.PApplet;
import screens.AuctionScreen;
import screens.Screen;
import screens.ScreenHandler;
import screens.TransScreen;

public class Board1 extends Screen {
	private Player1 player;
	private ScreenHandler handler;
	private Tile1[][] tiles;

	private Tile1 selected;

	private TextButton endTurn;

	public Board1(ScreenHandler board) {
		super(board);
		this.handler = board;
		player = null;
		selected = null;

		tiles = new Tile1[15][15];
		for (int i = 0; i < 15; i++) {
			for (int j = 0; j < 15; j++) {
				tiles[i][j] = new Tile1(i, j, 20);
			}
		}

		endTurn = new TextButton(Screen.DRAWING_WIDTH - 175, 25, 150, 75, Color.WHITE, Color.BLACK, "END\nTURN", 18);
	}

	public void setPlayer(Player1 player) {
		this.player = player;

		if (player.getTerritory().size() == 0) {
			player.addTile(tiles[player.initX()][player.initY()]);
		}
	}

	public void setup(PApplet p) {
		// nothing
	}

	public void draw(PApplet p) {
		for (Tile1[] ts : tiles) {
			for (Tile1 t : ts) {
				if (!t.isUncovered(player.getId())) {
					t.setColor(new Color(75, 75, 75));
				} else {
					if (t.getOwner() == null) {
						t.setColor(null);
					} else {
						t.setColor(ScreenHandler.TILE_COLORS[t.getOwner().getId()]);
					}
				}

				t.draw(p);
			}
		}

		for (Tile1 t : player.getTerritory()) {
			for (int i = t.getX() - 1; i <= t.getX() + 1; i++) {
				for (int j = t.getY() - 1; j <= t.getY() + 1; j++) {
					if (inRange(i, j)) {
						tiles[i][j].uncover(player.getId());
					}
				}
			}
		}

		for (Merchant1 m : player.getMerchants()) {
			for (int i = m.getX() - 1; i <= m.getX() + 1; i++) {
				for (int j = m.getY() - 1; j <= m.getY() + 1; j++) {
					if (inRange(i, j)) {
						tiles[i][j].uncover(player.getId());
					}
				}
			}

			m.draw(p);
		}

		if (selected != null) {
			p.fill(0);
			p.textSize(14);
			p.textAlign(PApplet.LEFT);
			String display = selected.getCharacteristics();
			if (merchantAt(selected) != null) {
				for (Player1 p1 : handler.getPlayers()) {
					if (p1.getMerchants().contains(merchantAt(selected))) {
						display += "\nMerchant: Player " + (p1.getId() + 1);
					}
				}
			}
			p.text(display, Screen.DRAWING_WIDTH - 150, 200);
		}

		endTurn.draw(p);
	}

	private boolean inRange(int x, int y) {
		return x >= 0 && x < tiles.length && y >= 0 && y < tiles[0].length;
	}

	public Tile1[][] tiles() {
		return tiles;
	}

	public void mousePressed(PApplet p) {
		if (endTurn.isPointInButton(p.mouseX, p.mouseY)) {
			if (player.getId() + 1 == handler.getPlayers().size()) {
				if (handler.getAuction().size() == 0) {
					handler.proceed(new TransScreen(handler, handler.getPlayers().get(0)));
				} else {
					handler.proceed(new AuctionScreen(handler, handler.getAuction().get(0)));
				}
			} else {
				handler.proceed(new TransScreen(handler, handler.getPlayers().get(player.getId() + 1)));
			}
		} else {
			int mx = p.mouseX / Tile1.TILE_SIZE, my = p.mouseY / Tile1.TILE_SIZE;
			if (inRange(mx, my) && tiles[mx][my].isUncovered(player.getId())) {
				selected = tiles[mx][my];

				if (merchantAt(selected) != null && player.getMerchants().contains(merchantAt(selected))) {
					// highlight, move, auction, etc.
					// if buys tile, make new auction
				}
			}
		}
	}

	public Merchant1 merchantAt(Tile1 t) {
		for (Player1 p : handler.getPlayers()) {
			for (Merchant1 m : p.getMerchants()) {
				if (t.getX() == m.getX() && t.getY() == m.getY()) {
					return m;
				}
			}
		}

		return null;
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
