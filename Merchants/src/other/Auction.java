package other;

import java.util.ArrayList;
import board.Tile;

public class Auction {
	private Tile tile;
	private ArrayList<Bid> bids;
	private int startingPrice;

	public Auction(Tile t, int startingPrice) {
		tile = t;
		this.startingPrice = startingPrice;
		bids = new ArrayList<Bid>();
	}

	public void addBid(Bid bid) {
		bids.add(bid);
	}

	public Bid decideWinner() {
		int max = 0;
		ArrayList<Bid> winners = new ArrayList<Bid>();

		for (int i = 0; i < bids.size(); i++) {
			if (bids.get(i).getAmount() == max) {
				winners.add(bids.get(i));
			} else if (bids.get(i).getAmount() > max) {
				max = bids.get(i).getAmount();
				winners.clear();
				winners.add(bids.get(i));
			}
		}

		if (winners.size() == 1) {
			return winners.get(0);
		} else {
			return winners.get((int) (Math.random() * winners.size()));
		}
	}
}
