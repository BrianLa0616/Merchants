package other;

import java.awt.Color;
import java.awt.geom.Point2D;
import java.util.ArrayList;

import board.Checkpoint;
import board.Tile;
import merchants.Merchant;
import merchants.MoneyMerchant;

/**
 * 
 * @author Eylam Tagor
 * 
 *         Represents one of the game's Players, and manages merchants,
 *         territory and income.
 *
 */
public class Player {

	private int initX, initY;
	private int id, balance;
	private String name;
	private Color color;
	private int income, auctionPrice;
	private ArrayList<Merchant> merchants;
	private ArrayList<Tile> territory;

	/**
	 * Creates a new Player object with 1 regular merchant and 1 territory.
	 * 
	 * @param id      the player's number in relation to other players
	 * @param balance the player's starting balance, used to expand territory and
	 *                upgrade merchants
	 * @param name    the username of the player
	 * @param color   the player's color
	 * @param initX   the player's initial starting location's x-coordinate
	 * @param initY   the player's initial starting location's y-coordinate
	 */
	public Player(int id, int balance, String name, Color color, Merchant merchant, Merchant special) {
		this.initX = merchant.getX();
		this.initY = merchant.getY();

		this.id = id;
		this.balance = balance;
		this.name = name;
		this.color = color;

		merchants = new ArrayList<Merchant>();
		merchant.setColor(color);
		merchants.add(merchant);
		special.setColor(color);
		merchants.add(special);

		territory = new ArrayList<Tile>();
	}

	/**
	 * Increases the income of the player
	 * 
	 * @param x amount desired to add to the player's current income
	 */
	public void increaseIncome(int x) {
		setIncome(getIncome() + x);
	}

	public void upgradeMerchant(int i, char type) {
//		switch (type) {
//		case 'a':
//			AuctionMerchant am = new AuctionMerchant(merchants[i].getX(), merchants[i].getY());
//			merchants[i] = am;
//			break;
//		case 's':
//			SpeedMerchant sm = new SpeedMerchant(merchants[i].getX(), merchants[i].getY());
//			merchants[i] = sm;
//			break;
//		case 'l':
//			LandMerchant lm = new LandMerchant(merchants[i].getX(), merchants[i].getY());
//			merchants[i] = lm;
//			break;
//		case 'i':
//			InvisibleMerchant im = new InvisibleMerchant(merchants[i].getX(), merchants[i].getY());
//			merchants[i] = im;
//			break;
//		case 'm':
//			MoneyMerchant mm = new MoneyMerchant(merchants[i].getX(), merchants[i].getY());
//			merchants[i] = mm;
//			break;
//		default:
//			break;
//		}
	}

	/**
	 * 
	 * @return the name of the player
	 */
	public String getName() {
		return name;
	}

	/**
	 * 
	 * @return the color of the player
	 */
	public Color getColor() {
		return color;
	}

	/**
	 * 
	 * @return the x-coordinate of the player's original spawn point
	 */
	public int getInitX() {
		return initX;
	}

	/**
	 * 
	 * @return the y-coordinate of the player's original spawn point
	 */
	public int getInitY() {
		return initY;
	}

	/**
	 * 
	 * @return player id
	 */
	public int getId() {
		return id;
	}

	/**
	 * Sets the id of the player
	 * 
	 * @param id desired of player
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * 
	 * @return player balance
	 */
	public int getBalance() {
		return balance;
	}

	/**
	 * Sets the balance of the player
	 * 
	 * @param balance desired for the player
	 */
	public void setBalance(int balance) {
		this.balance = balance;
	}

	/**
	 * 
	 * @return territory that the player currently owns
	 */
	public ArrayList<Tile> getTerritory() {
		return territory;
	}

	/**
	 * 
	 * @return current income of the player
	 */
	public int getIncome() {
		return income;
	}

	/**
	 * Sets the income of the player
	 * 
	 * @param income desired of the player
	 */
	public void setIncome(int income) {
		this.income = income;
	}

	/**
	 * 
	 * @return all merchants the player owns
	 */
	public ArrayList<Merchant> getMerchants() {
		return merchants;
	}

	/**
	 * Adds land to the player's territory
	 * 
	 * @param t Tile being added to the player's territory
	 */
	public void addTerritory(Tile t) {
		territory.add(t);
	}

	public int getAuctionPrice() {
		return auctionPrice;
	}

	public void setAuctionPrice(int x) {
		auctionPrice = x;
	}

	/**
	 * 
	 * @return r value of RGB value
	 */
	public int getR() {
		return color.getRed();
	}

	/**
	 * 
	 * @return g value of RGB value
	 */
	public int getG() {
		return color.getGreen();
	}

	/**
	 * 
	 * @return b value of RGB value
	 */
	public int getB() {
		return color.getBlue();
	}

	// TODO check validity of purchase (if player owns that tile) in Board.java
	/**
	 * Buys and sets a checkpoint at the desired location
	 * 
	 * @param x coordinate of checkpoint
	 * @param y coordinate of checkpoint
	 */
	public void purchaseCheckpoint(int x, int y) {
		for (int i = 0; i < territory.size(); i++) {
			if (territory.get(i).getX() == x && territory.get(i).getY() == y) {
				int amplifier = 0;
				for (Tile t : territory)
					if (t instanceof Checkpoint)
						amplifier++;
				territory.set(i, new Checkpoint(x, y, 0, i, amplifier));
			}
		}
	}
}
