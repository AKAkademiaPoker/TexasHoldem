package com.ak.texasholdem.player;

import java.util.Scanner;

import com.ak.texasholdem.cards.Card;
import com.ak.texasholdem.io.UserInputHandler;
import com.ak.texasholdem.menu.Menu;
import com.ak.texasholdem.menu.MenuPoint;

public class Player {

	// TODO remove to another subclass
	private String nickname;
	private String userName;
	private String password;
	private int id;

	private int cash;
	private int sessionPot;
	private Card card1;
	private Card card2;
	private boolean isInGame;
	private boolean isChecked = false;

	public Player(String nickname, String userName, String password, int cash) {
		super();
		this.nickname = nickname;
		this.userName = userName;
		this.password = password;
		this.cash = cash;
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

	public int getCash() {
		return cash;
	}

	public void setCash(int cash) {
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

	public boolean isInGame() {
		return isInGame;
	}

	public void setInGame(boolean isInGame) {
		this.isInGame = isInGame;
	}

	public boolean isChecked() {
		return isChecked;
	}

	public void setChecked(boolean isChecked) {
		this.isChecked = isChecked;
	}

	public int getSessionPot() {
		return sessionPot;
	}

	public void setSessionPot(int sessionPot) {
		this.sessionPot = sessionPot;
	}

	public MenuPoint playerStep(Scanner scanner, Menu menu) {
		menu.print();
		int input = new UserInputHandler(scanner).getIntAmongTwoNumbs(1, menu.numberOfOptions());
		return menu.getMenuPoint(input);
	}
	@Override
	public String toString() {
		return nickname + " " + cash;
	}

}
