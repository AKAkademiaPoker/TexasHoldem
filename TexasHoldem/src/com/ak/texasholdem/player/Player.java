package com.ak.texasholdem.player;

import java.util.List;
import java.util.Scanner;

import com.ak.texasholdem.cards.Card;
import com.ak.texasholdem.io.UserInputHandler;
import com.ak.texasholdem.menu.Menu;
import com.ak.texasholdem.menu.MenuPoint;
import com.ak.texasholdem.winconditions.HandTypes;

public class Player extends User {

	// TODO remove to another subclass
	private int sessionPot;
	private Card card1;
	private Card card2;
	private boolean isInGame;
	private boolean isChecked = false;
	
	private HandTypes bestHandType;
	private List<Card> bestCards;

	public HandTypes getBestHandType() {
		return bestHandType;
	}

	public void setBestHandType(HandTypes bestHandType) {
		this.bestHandType = bestHandType;
	}

	public List<Card> getBestCards() {
		return bestCards;
	}

	public void setBestCards(List<Card> bestCards) {
		this.bestCards = bestCards;
	}

	public Player() {
		super();
	}

	public Player(String nickname, String userName, String password, int cash) {
		super(nickname, userName, password, cash);
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

	public boolean isInGame() {
		return isInGame;
	}

	public void setInGame(boolean isInGame) {
		this.isInGame = isInGame;
	}

	public boolean getIsChecked() {
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

	public void showCards(Scanner scanner) {
		Menu menu = new Menu("mutat");
		MenuPoint menuPoint = playerStep(scanner, menu);
		if (menuPoint.equals(MenuPoint.SHOW_CARDS)) {
			System.out.println(card1 + " " + card2);
		}
	}

	@Override
	public String toString() {
		return super.getNickname() + " " + super.getCash() + " " + card1.toString() + " " + card2.toString();
	}

}
