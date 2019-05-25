package screens;

import java.awt.Color;

import buttons.TextButton;
import processing.core.PApplet;

public class InstructionsScreen extends Screen {
	private TextButton back;
	private ScreenHandler handler;

	/**
	 * 
	 * @param board PApplet that draws the window
	 */
	public InstructionsScreen(ScreenHandler board) {
		super(board);
		handler = board;
		back = new TextButton(Screen.DRAWING_WIDTH - 175, 125, 150, 75, Color.WHITE, Color.BLACK, "BACK", 18);
	}

	public void setup(PApplet p) {

	}

	public void draw(PApplet p) {
		p.background(255);
		p.textSize(18);
		p.fill(0);
		p.textAlign(PApplet.LEFT);

		p.text("Merchants: How to Play\r\n" + "\r\n" + "Goal:\r\n"
				+ "Defeat all other players by acquiring their Home Tile.\r\n" + "\r\n" + "Start:\r\n"
				+ "Each player starts with a Home Tile, a Merchant, and $100.\r\n" + "\r\n" + "Basic Mechanics:\r\n"
				+ "Merchants can move around the map and acquire Tiles which provide income. Income increases the player's balance,\nwhich is used to buy Merchants and Checkpoints, upgrade Merchants, and enter Tile auctions.\r\n"
				+ "\r\n" + "Acquiring Tiles:\r\n"
				+ "Tiles are acquired by entering auctions. To enter an auction, select a Merchant and right-click on an adjacent\n(diagonals included) Tile to that Merchant. That will enter the player in an auction for that Tile. At the end of each turn\nround, all auctions are taken care of in Auction Rooms. In an Auction Room, all the players participating in an auction for\na speific Tile may enter bids or withdraw. Based on the bids, the winner is automatically decided and the Tile in question\nbecomes a part of the winner's territory.\r\n"
				+ "\r\n" + "Merchants:\r\n"
				+ "Merchants are the key to winning the game, as they are used to expand the player's territory and potentially block\nopponents' movement. Here are the different types of Specialized Merchants:\r\n"
				+ " - AuctionMerchant: gives its player a bonus in an auction this Merchant is participating in.\r\n"
				+ " - MoneyMerchant: Increases income for Tiles acquired.\r\n"
				+ " - SpeedMerchant: Can move more Tiles per turn than other Merchants.\r\n"
				+ " - RadarMerchant: Can uncover a higher radius of Tiles when moving.\r\n"
				+ " - InvisibleMerchant: Is unseen to other players, until deep enough in enemy territory.\r\n"
				+ "Merchants can be further upgraded to increase the effects of theie specialized ability.\r\n" + "\r\n"
				+ "Checkpoints:\r\n"
				+ "Each player has the ability to convert each of their Tiles into Checkpoints for a price. Checkpoints serve as teleportation\npoints for Merchants, meaning Merchants can move to Checkpoints from anywhere on the map! Keep in mind that after\nmoving to a Checkpoint, Merchants cannot move anymore for the rest of that turn. When a Checkpoint becomes owned\nby another player, it then become a Checkpoint for that player.",
				25, 25);

		back.draw(p);
	}

	public void mousePressed(PApplet p) {
		if (back.isPointInButton(p.mouseX, p.mouseY)) {
			handler.proceed(new IntroScreen(handler));
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

}
