package merchants;

public class InvisibleMerchant extends Merchant {
	private int price;
	private boolean visible;

	public InvisibleMerchant(int x, int y) {
		super(x, y);
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public void setVisibility(boolean isVisible) {
		visible = isVisible;
	}
}
