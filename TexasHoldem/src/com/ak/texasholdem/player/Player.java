package com.ak.texasholdem.player;

import com.ak.texasholdem.cards.Card;

public class Player {

	private String nickname;
	private String userName;
	private String password;
	private int id;

	private long cash;

	private Card card1;
	private Card card2;

	public Player(String nickname, String userName, String password) {
		super();
		this.nickname = nickname;
		this.userName = userName;
		this.password = password;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
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
		this.cash = cash;
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

	public int getId() {
		return id;
	}
	
}
