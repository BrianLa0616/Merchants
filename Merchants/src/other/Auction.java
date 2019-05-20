package other;

import java.util.ArrayList;

import board.Tile1;

public class Auction {
	private Tile1 tile;
	private ArrayList<Bid> bids;

	public Auction(Tile1 t) {
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

	public Tile1 getTile() {
		return tile;
	}

	public ArrayList<Bid> getBids() {
		return bids;
	}
}
