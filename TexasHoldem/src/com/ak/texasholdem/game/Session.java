package com.ak.texasholdem.game;

import java.util.List;
import java.util.Scanner;

import com.ak.texasholdem.board.Board;
import com.ak.texasholdem.cards.Deck;
import com.ak.texasholdem.io.UserInputHandler;
import com.ak.texasholdem.menu.Menu;
import com.ak.texasholdem.menu.MenuPoint;
import com.ak.texasholdem.menu.MenuTypes;
import com.ak.texasholdem.player.Player;
import com.ak.texasholdem.player.Players;

public class Session {
	private Board board;
	private Players players;
	private Deck deck;
	private int smallBlind = 0;
	private int bigBlind;
	private Scanner scanner = new Scanner(System.in);
	private int minPot = 250;
	private int bank = 0;
	private boolean isRaised;
	private int actualRaise = 0;
	private Menu menu = new Menu("játék call nélkül");

	public Session(Board board, Players players, Deck deck) {
		this.board = board;
		this.players = players;
		this.deck = deck;
		bigBlind = players.getPlayers().size() - 1;

	}

	public void run() {
		readyToPlay();
		blinds();
		dealing();
		doRound();
		addCards(3);
		doRound();
		addCards(1);
		doRound();
		addCards(1);
		doRound();
		// TODO: kiértékelés + kifizetés
		// TODO: vakok forgatása
	}

	private void addCards(int num) {
		board.addBurnedCard(deck.getCard());
		for (int i = 0; i < num; i++) {
			board.addVisibleCards(deck.getCard());

		}
	}

	private void doRound() {
		for (int i = players.getPlayers().size();; i++) {
			int index = i % players.getPlayers().size();
			Player current = players.getPlayers().get(index);
			System.out.println(current.toString());
			MenuPoint menuPoint = current.playerStep(scanner, menu);

			if (menuPoint.equals(MenuPoint.RULES)) {
				// TODO
				System.out.println("Szabályok....");
			}
			if (menuPoint.equals(MenuPoint.RAISE)) {
				doRaise(current);
			}
			if (menuPoint.equals(MenuPoint.FOLD)) {
				current.setInGame(false);

			}
			if (!isRaised) {
				if (menuPoint.equals(MenuPoint.CHECK)) {
					System.out.println("Passzol");
					current.setChecked(true);
					System.out.println(current.toString());
					if (isEveryoneChecked()) {
						break;
					}
				}
			} else {
				if (menuPoint.equals(MenuPoint.CALL)) {
					System.out.println(current.getSessionPot());
					if (actualRaise > current.getSessionPot()) {
						doCall(current);
					}
					current.setChecked(true);
					if (isEveryoneChecked()) {
						break;
					}
				}
			}
		}
	}

	private void doCall(Player current) {
		int difference = actualRaise - current.getSessionPot();
		current.setCash(current.getCash() - difference);
		bank += difference;
		current.setSessionPot(current.getSessionPot() + difference);
		System.out.println(current.getSessionPot() + " session pot");
		System.out.println(current.toString());
	}

	private void doRaise(Player current) {
		System.out.println("Kérem, válasszon emelési összeget: ");
		System.out.println(minPot + " " + current.getCash());
		int raisePot = new UserInputHandler(scanner).getIntAmongTwoNumbs(minPot, current.getCash());
		System.out.println("Emelt: " + raisePot);
		current.setCash(current.getCash() - raisePot);
		current.setSessionPot(current.getSessionPot() + raisePot);
		bank += raisePot;
		actualRaise = current.getSessionPot();
		players.setAllNotChecked();
		current.setChecked(true);
		isRaised = true;
		menu = new Menu("játék check nélkül");
	}

	private boolean isEveryoneChecked() {
		for (Player player : players.getPlayers()) {
			if (player.isInGame() && !player.isChecked()) {
				return false;
			}
		}
		return true;
	}

	private void blinds() {
		players.getPlayers().get(smallBlind).setSessionPot(minPot / 2);
		players.getPlayers().get(bigBlind).setSessionPot(minPot);

	}

	private void readyToPlay() {
		for (Player player : players.getPlayers()) {
			player.setInGame(true);

		}
	}

	private void dealing() {
		for (Player player : players.getPlayers()) {
			player.setCard1(deck.getCard());
			player.setCard2(deck.getCard());

		}
	}
}
