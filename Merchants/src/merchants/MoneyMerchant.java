package merchants;

import other.Player;

public class MoneyMerchant {

	private int x, y;
	private Player player;
	private MoneyMerchant moneyMerchant;
	private int money;

	public MoneyMerchant() {
		// draw new merchant
		money = player.getBalance();
	}

	public MoneyMerchant(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public void power(int n) {
		for (int i = 0; i < n; i++) {
			money += 10;
		}
	}

}
