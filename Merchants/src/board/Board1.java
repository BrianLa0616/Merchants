package board;

import java.awt.Color;

import buttons.TextButton;
import merchants.Merchant1;
import other.Player1;
import processing.core.PApplet;
import screens.Screen;
import screens.ScreenHandler;

public class Board1 extends Screen {
	private Player1 player;
	private ScreenHandler board;
	private Tile1[][] tiles;

	private TextButton endTurn;

	public Board1(ScreenHandler board) {
		super(board);
		this.board = board;
		player = null;

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

		if (player.getTerritory().size() == 0)
			player.addTile(tiles[player.initX()][player.initY()]);
	}

	public void setup(PApplet p) {
		// nothing
	}

	public void draw(PApplet p) {
		for (Tile1[] ts : tiles) {
			for (Tile1 t : ts) {
				if (!t.isUncovered(player.getIndex())) {
					t.setColor(new Color(75, 75, 75));
				} else {
					if (t.getOwner() == null) {
						t.setColor(null);
					} else {
						t.setColor(ScreenHandler.TILE_COLORS[t.getOwner().getIndex()]);
					}
				}

				t.draw(p);
			}
		}

		for (Tile1 t : player.getTerritory()) {
			for (int i = t.getX() - 1; i <= t.getX() + 1; i++) {
				for (int j = t.getY() - 1; j <= t.getY() + 1; j++) {
					if (inRange(i, j)) {
						tiles[i][j].uncover(player.getIndex());
					}
				}
			}
		}

		for (Merchant1 m : player.getMerchants()) {
			for (int i = m.getX() - 1; i <= m.getX() + 1; i++) {
				for (int j = m.getY() - 1; j <= m.getY() + 1; j++) {
					if (inRange(i, j)) {
						tiles[i][j].uncover(player.getIndex());
					}
				}
			}

			m.draw(p);
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
