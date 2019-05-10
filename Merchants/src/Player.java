import java.awt.geom.Point2D;
import java.util.ArrayList;

public class Player {

	private int id, money;
	private String name;
	private int income;
	private Merchant[] merchants;
	private ArrayList<Point2D> territory;

	Player(int id, int money, String name) {
		this.id = id;
		this.money = money;
		this.name = name;

		merchants = new Merchant[5];
		territory = new ArrayList<Point2D>();
	}

	public void addMoney() {
		money += income;
	}

	public void increaseIncome(int x) {
		income += x;
	}

	public String getName() {
		return name;
	}

	public void upgradeMerchant(int i, int type) {
		switch(type) {
		case 0:
			merchants[i] = new LandMerchant(...);
		}
	}
}
