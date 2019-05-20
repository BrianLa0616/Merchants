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

	private Tile1 selectedT;
	private Merchant1 selectedM;

	private TextButton endTurn;

	public Board1(ScreenHandler board) {
		super(board);
		this.handler = board;
		player = null;
		selectedT = null;
		selectedM = null;

		tiles = handler.getTiles();

		endTurn = new TextButton(Screen.DRAWING_WIDTH - 175, 25, 150, 75, Color.WHITE, Color.BLACK, "END\nTURN", 18);
	}

	public void setPlayer(Player1 player) {
		this.player = player;

	}

	public void setup(PApplet p) {
		// nothing
	}

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

				if (selectedT == null) {
					// if nothing is selected
					selectedT = tiles[mx][my];
					if (selectedT.getMerchant() != null) {
						selectedM = selectedT.getMerchant();
						switchHighlight(mx, my);
					}
				} else if (selectedM != null) {
					// if merchant and tile are selected
					if (selectedT == tiles[mx][my]) {
						selectedM = null;
						switchHighlight(mx, my);
					} else {
						if (Math.abs(mx - selectedT.getX()) + Math.abs(my - selectedT.getY()) == 1
								&& p.mouseButton == p.LEFT) {
							switchHighlight(mx, my);
							selectedT.setMerchant(null);
							tiles[mx][my].setMerchant(selectedM);
							selectedM.setX(mx);
							selectedM.setY(my);
							selectedM = null;
							selectedT = null;
						}
					}

				} else if (selectedT != null) {
					// if tile is only selected
					if (selectedT == tiles[mx][my]) {
						selectedT = null;
					} else {
						selectedT = tiles[mx][my];
						if (selectedT.getMerchant() != null) {
							selectedM = selectedT.getMerchant();
							switchHighlight(mx, my);
						}
					}

				}

			} else {
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

	private boolean inRange(int x, int y) {
		return x >= 0 && x < tiles.length && y >= 0 && y < tiles[0].length;
	}

	private void switchHighlight(int x, int y) {
		int[] dx = { 0, 0, -1, 1 };
		int[] dy = { 1, -1, 0, 0 };

		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if (inRange(nx, ny)) {
				tiles[nx][ny].setSelected(!tiles[nx][ny].getSelected());
			}
		}
	}
}
