package Models;

public class Player {
	String name;
	String password;
	int money;
	Hand hand;

	public Player(String name, String password, int money) {
		super();
		this.name = name;
		this.password = password;
		this.money = money;
		this.hand = new Hand();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}

	public Hand getHand() {
		return hand;
	}

	public void setHand(Hand hand) {
		this.hand = hand;
	}

}
