package other;

import java.util.ArrayList;

import board.Tile;

public class Auction {
	private Tile tile;
	private ArrayList<Bid> bids;

	public Auction(Tile t) {
		tile = t;
		bids = new ArrayList<Bid>();
	}

	public void addBid(Bid bid) {
		for (int i = 0; i < bids.size(); i++) {
			if (bids.get(i).getPlayer() == bid.getPlayer()) {
				bids.set(i, bid);
				return;
			}
		}
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

	public Tile getTile() {
		return tile;
	}

	public ArrayList<Bid> getBids() {
		return bids;
	}

	public void setBids(ArrayList<Bid> bids) {
		this.bids = bids;
	}
}
