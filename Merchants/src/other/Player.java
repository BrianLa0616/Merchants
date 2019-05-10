package other;

import java.awt.geom.Point2D;
import java.util.ArrayList;

import merchants.LandMerchant;
import merchants.Merchant;

public class Player {

	private int initX, initY;
	private int id, balance;
	private String name;
	private int income;
	private Merchant[] merchants;
	private ArrayList<Point2D> territory;

	public Player(int id, int balance, String name, int initX, int initY) {
		this.setInitX(initX);
		this.setInitY(initY);

		this.setId(id);
		this.setBalance(balance);
		this.name = name;

		merchants = new Merchant[5];
		for (int i = 0; i < merchants.length; i++) {
			merchants[i] = new Merchant(initX, initY);
		}

		territory = new ArrayList<Point2D>();
	}

	public void increaseIncome(int x) {
		setIncome(getIncome() + x);
	}

	public String getName() {
		return name;
	}

	public void upgradeMerchant(int i, int type) {
		//
	}

	public int getInitX() {
		return initX;
	}

	public void setInitX(int initX) {
		this.initX = initX;
	}

	public int getInitY() {
		return initY;
	}

	public void setInitY(int initY) {
		this.initY = initY;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	public ArrayList<Point2D> getTerritory() {
		return territory;
	}

	public int getIncome() {
		return income;
	}

	public void setIncome(int income) {
		this.income = income;
	}
}
