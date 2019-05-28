package other;

import merchants.AuctionMerchant;
import merchants.Merchant;

/**
 * Represents a bid in an auction, a neat way to store data
 * 
 * @author Eylam
 *
 */
public class Bid {
	private Player player;
	private int bid;

	/**
	 * New bid made by player
	 * 
	 * @param p   Player making bid
	 * @param bid amount put into bid
	 */
	public Bid(Player p, int bid) {
		player = p;
		this.bid = bid;
	}

	/**
	 * 
	 * @return player making bid
	 */
	public Player getPlayer() {
		return player;
	}

	/**
	 * 
	 * @return bid amount
	 */
	public int getAmount() {
		return bid;
	}

	/**
	 * 
	 * @return reduction amount player's bid goes down by if they own an auction
	 *         merchant
	 */
	public int getReduction() {
		for (Merchant m : player.getMerchants()) {
			if (m instanceof AuctionMerchant) {
				return ((AuctionMerchant) m).reduce(m.getLevel());
			}
		}
		return 0;
	}

	/**
	 * Set bid amount
	 * 
	 * @param val amount set into bid
	 */
	public void setAmount(int val) {
		bid = val;
	}

}
