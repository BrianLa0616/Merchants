package merchants;

/**
 * 
 * @author eylam unseen by other players
 */
public class InvisibleMerchant extends Merchant {
	private int price;
	private boolean visible;

	/**
	 * 
	 * @param x x value
	 * @param y y value
	 */
	public InvisibleMerchant(int x, int y) {
		super(x, y);
	}

	/**
	 * 
	 * @return cost to upgrade
	 */
	public int getPrice() {
		return price;
	}

	/**
	 * 
	 * @param price cost to upgrade
	 */
	public void setPrice(int price) {
		this.price = price;
	}

	/**
	 * 
	 * @param isVisible to other players
	 */
	public void setVisibility(boolean isVisible) {
		visible = isVisible;
	}
}
