package other;

public class Bid {
	private Player1 player;
	private int bid;

	public Bid(Player1 p, int bid) {
		player = p;
		this.bid = bid;
	}

	public Player1 getPlayer() {
		return player;
	}

	public int getAmount() {
		return bid;
	}
}
