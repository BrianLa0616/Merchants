
public class Player {
	
	private int id, money;
	private String name;
	private int income;
	
	Player(int id, int money, String name) {
		this.id = id;
		this.money = money;
		this.name = name;
	}
	
	public void addMoney() {
		money += income;
	}
	
	public void increaseIncome(int x) {
		income += x;
	}
	
}
