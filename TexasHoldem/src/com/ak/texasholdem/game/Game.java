package com.ak.texasholdem.game;

import com.ak.texasholdem.board.Board;
import com.ak.texasholdem.cards.Deck;
import com.ak.texasholdem.constants.PokerConstants;
import com.ak.texasholdem.player.Players;

public class Game {

	protected Board board;
	protected Deck deck;
	protected Players players;

	protected int smallBlindIndex = 0;

	protected int bigBlindIndex = smallBlindIndex + 1;

	protected int minPot;
	private int playerCounter;

	public Game(Players players, int minPot) {
		super();
		this.players = players;
		this.minPot = minPot;
		this.playerCounter = players.getPlayers().size();
	}

	public void runGame() {
		int minPotTracker = minPot;
		int counter = 0;
		do {
			Session session = new Session(this.players, this.minPot);
			session.setSmallBlindIndex(this.smallBlindIndex);
			session.setBigBlindIndex(this.bigBlindIndex);
			session.run();
			rotateBlinds();
			if (setMinPot(counter, minPotTracker)) {
				counter = 0;
			} else {
				counter++;
			}
			players.removeBankruptPlayers();
		} while (!isGameEnded());
	}

	private void rotateBlinds() {
		smallBlindIndex++;
		smallBlindIndex = (smallBlindIndex + players.getPlayers().size()) % players.getPlayers().size();
		if (smallBlindIndex == players.getPlayers().size() - 1) {
			bigBlindIndex = 0;
		} else {
			bigBlindIndex = smallBlindIndex + 1;
		}
	}

	private boolean isGameEnded() {
		if (players.getPlayers().size() <= 1) {
			return true;
		}
		return false;
	}

	private boolean setMinPot(int counter, int minPotTracker) {
		if (counter >= PokerConstants.ROUNDS_UNTIL_POT_INCREASE || players.getPlayers().size() < playerCounter) {
			minPot += minPotTracker;
			playerCounter = players.getPlayers().size();
			return true;
		}
		return false;
	}

	public int getSmallBlindIndex() {
		return smallBlindIndex;
	}

	public void setSmallBlindIndex(int smallBlindIndex) {
		this.smallBlindIndex = smallBlindIndex;
	}

	public int getBigBlindIndex() {
		return bigBlindIndex;
	}

	public void setBigBlindIndex(int bigBlindIndex) {
		this.bigBlindIndex = bigBlindIndex;
	}
}
