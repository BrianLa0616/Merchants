package merchants;
import javax.swing.JOptionPane;

import other.Player;

public class Merchant {

	private Merchant merchant;
	private int merchantPrice = 20;
	private Player player;
	private AuctionMerchant auctionMerchant;
	private MoneyMerchant moneyMerchant;
	private LandMerchant landMerchant;

	public Merchant() {
		merchant = new Merchant();

	}

	public int buyMerchant() {
		if (player.getMoney() >= merchantPrice) {
			String input;
			input = JOptionPane.showInputDialog(
					"What type of merchant would you like to upgrade to: AuctionMerchant, LandMerchant, or MoneyMerchant?");
			if (input.equals("AuctionMerchant")) {
				spawnAuctionMerchant();
			} else if (input.equals("MoneyMerchant")) {
				spawnMoneyMerchant();
			} else if (input.equals("LandMerchant")) {
				spawnLandMerchant();
			}
			int leftoverMoney =  player.getMoney() - merchantPrice;
			return leftoverMoney;
		} else {
			String output;
			output = JOptionPane.showInputDialog("Not enough money!");
		}
		return merchantPrice;
	}

	public void spawnAuctionMerchant() {
		auctionMerchant = new AuctionMerchant();
		// draw merchant near player? original spawn point?

	}

	public void spawnMoneyMerchant() {
		moneyMerchant = new MoneyMerchant();
	}

	public void spawnLandMerchant() {
		landMerchant = new LandMerchant();
	}
	
	public void move() {
		//if merchant clicked, move, cannot move more than certain amount of tiles
	}

}
