package merchants;

public class AuctionMerchant extends Merchant {
	private int x, y, price;

	public AuctionMerchant(int x, int y) {
		super(x, y);
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int auction(int amount) {
		return amount + 20;
	}
}