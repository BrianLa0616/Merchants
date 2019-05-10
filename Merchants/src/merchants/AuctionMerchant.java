package merchants;

/**
 * merchant with auction discounts
 * 
 * @author eylam
 *
 */
public class AuctionMerchant extends Merchant {
	private int x, y, price;

	/**
	 * 
	 * @param x  x vluw
	 * @param yy value
	 */
	public AuctionMerchant(int x, int y) {
		super(x, y);
	}

	/**
	 * 
	 * @return rpcie to upgrade
	 */
	public int getPrice() {
		return price;
	}

	/**
	 * 
	 * @param price to upgrade
	 */
	public void setPrice(int price) {
		this.price = price;
	}

	/**
	 * apply discount
	 * 
	 * @param amount sggestion
	 * @return auction value
	 */
	public int auction(int amount) {
		return amount + 20;
	}
}