package other;

public class Bid {
	private Player player;
	private int bid;

	public Bid(Player p, int bid) {
		player = p;
		this.bid = bid;
	}

	public Player getPlayer() {
		return player;
	}

	public int getAmount() {
		return bid;
	}
	
	public void setAmount(int val) {
		bid = val;
	}
	
}
