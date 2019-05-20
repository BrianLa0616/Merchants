package screens;

import java.awt.Color;
import java.util.ArrayList;

import board.Board1;
import board.Tile1;
import other.Auction;
import other.Player1;
import processing.core.PApplet;

public class ScreenHandler extends PApplet {
	public static final Color[] PLAYER_COLORS = { new Color(200, 0, 0), new Color(0, 0, 200), new Color(200, 200, 50),
			new Color(50, 255, 50) };
	public static final Color[] TILE_COLORS = { new Color(255, 50, 50), new Color(50, 50, 255), new Color(255, 255, 0),
			new Color(50, 255, 50) };

	private Screen currScreen;
	private ArrayList<Player1> players;
	private ArrayList<Auction> auctions;
	private Tile1[][] tiles;
	int currPlayer;
	private Board1 board;

	public ScreenHandler() {
		currScreen = new IntroScreen(this);
		players = new ArrayList<Player1>();
		auctions = new ArrayList<Auction>();
		tiles = new Tile1[15][15];
		for (int i = 0; i < 15; i++) {
			for (int j = 0; j < 15; j++) {
				tiles[i][j] = new Tile1(i, j, 15 + (int)(Math.random()*10));
			}
		}

		currPlayer = 0;
		board = new Board1(this);
	}

	public void draw() {
		background(255);
		currScreen.draw(this);
	}

	public void proceed(Screen s) {
		currScreen = s;
	}

	public ArrayList<Player1> getPlayers() {
		return players;
	}

	public Board1 getBoard() {
		return board;
	}
	
	public Tile1[][] getTiles() {
		return tiles;
	}
	
	public void addAuction(Auction a) {
		for (int i = 0; i < auctions.size(); i++) {
			if (a.getTile() == auctions.get(i).getTile()) {
				auctions.get(i).addBid(a.getBids().get(0));
				return;
			}
		}
		
		auctions.add(a);
	}
	
	public int getCurrentPlayer() {
		return currPlayer;
	}

	public ArrayList<Auction> getAuction() {
		return auctions;
	}
	public void mousePressed() {
		currScreen.mousePressed(this);
	}

	public void mouseMoved(PApplet p) {
		currScreen.mouseMoved(this);
	}

	public void mouseDragged(PApplet p) {
		currScreen.mouseDragged(this);
	}

	public void mouseClicked(PApplet p) {
		currScreen.mouseClicked(this);
	}

	public void mouseReleased(PApplet p) {
		currScreen.mouseReleased(this);
	}

	public void keyPressed(PApplet p) {
		currScreen.keyPressed(this);
	}

	public void keyReleased(PApplet p) {
		currScreen.keyReleased(this);
	}
}
