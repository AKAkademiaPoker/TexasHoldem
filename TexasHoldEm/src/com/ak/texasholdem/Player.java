package com.ak.texasholdem;

public class Player {
	
	public String name;
	public long cash;
	
	private String loginName;
	private String password;
	
	private Card card1;
	private Card card2;

	public Player() {
		
	}
	
	public Player(String name, String password, long cash) {
		super();
		this.name = name;
		this.password = password;
		this.cash = cash;
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

	public long getCash() {
		return cash;
	}

	public void setCash(long cash) {
		this.cash += cash;
	}

	public Card getCard1() {
		return card1;
	}

	public void setCard1(Card card1) {
		this.card1 = card1;
	}

	public Card getCard2() {
		return card2;
	}

	public void setCard2(Card card2) {
		this.card2 = card2;
	}

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

}
