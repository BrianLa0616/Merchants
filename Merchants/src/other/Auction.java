package other;

import java.util.ArrayList;

import board.Tile;
import merchants.AuctionMerchant;

public class Auction {
	private Tile tile;
	private ArrayList<Bid> bids;
	private AuctionMerchant auctionM;

	private int[] nx = { 0, 1, 1, 1, 0, -1, -1, -1 };
	private int[] ny = { -1, -1, 0, 1, 1, 1, 0, -1 };

	public Auction(Tile t) {
		tile = t;
		bids = new ArrayList<Bid>();

		auctionM = null;
	}

	public void addBid(Bid bid) {
		for (int i = 0; i < bids.size(); i++) {
			if (bids.get(i).getPlayer() == bid.getPlayer()) {
				for (int j = 0; j < nx.length; j++) {
					for (int k = 0; k < ny.length; k++) {
						if (tile.getMerchant().getX() == j && tile.getMerchant().getY() == k
								&& tile.getMerchant().getOwner() == bid.getPlayer()
								&& tile.getMerchant().equals(auctionM)) {
							//auctionM.auction()
						}
					}
				}
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
