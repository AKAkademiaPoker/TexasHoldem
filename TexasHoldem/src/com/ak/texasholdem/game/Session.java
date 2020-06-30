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
	private Scanner scanner = new Scanner(System.in);
	private Board board;
	private Players players;
	private Deck deck;
	
	private int bigBlindIndex = 0;
	private int smallBlindIndex = 1;
	
	private int minPot = 250;
	private int bank = 0;
	private int actualRaise = 0;
	
	private boolean hasWinner;

	private Menu menu = new Menu("játék call nélkül");

	public Session(Board board, Players players, Deck deck) {
		this.board = board;
		this.players = players;
		this.deck = deck;
	}

	public void run() {
		readyToPlay();
		blinds();
		dealing();
		CLOSE: for (int i = 0; i < 4; i++) {
			System.out.println("Round :" + (i + 1) + "----------");
			players.setChecks();
			doRound();
			if (hasWinner) {
				break CLOSE;
			}
			switch (i) {
			case 0:
				addCards(3);
				break;
			case 3:
				break CLOSE;
			default:
				addCards(1);
				break;
			}
		}
		// TODO: kis- és nagyvak + bank cash
		// TODO: vakok forgatása
		// TODO: szabályok
		// TODO: kiértékelés (nyerő kombinációk enum/list) + kifizetés
		// TODO: emelési limitek beállítása
	}

	private void addCards(int num) {
		board.addBurnedCard(deck.getCard());
		for (int i = 0; i < num; i++) {
			board.addVisibleCards(deck.getCard());

		}
	}

	private void doRound() {
		END: for (int i = players.getPlayers().size(); ; i++) {
			int index = i % players.getPlayers().size();
			Player current = players.getPlayers().get(index);
			System.out.println(current.toString());
			System.out.println("Bankban lévő összeg: " + bank);
			System.out.println(board);
			MenuPoint menuPoint = current.playerStep(scanner, menu);
			System.out.println(menuPoint);

			if (menuPoint.equals(MenuPoint.RULES)) {
				// TODO: szabályok file-ból
				System.out.println("Szabályok....");
				i--;
			}

			if (menuPoint.equals(MenuPoint.RAISE)) {
				doRaise(current);
			}

			if (menuPoint.equals(MenuPoint.FOLD)) {
				current.setInGame(false);
				// TODO: elegánsabb megoldás!
				current.setChecked(true);
				if (!players.isMinTwoPlayerInGame()) {
					endSession();
					break END;
				}
			}

			if (menuPoint.equals(MenuPoint.CHECK)) {
				System.out.println("Passzol");
				current.setChecked(true);
				System.out.println(current.toString());
				if (isEveryoneChecked()) {
					break END;
				}
			}
			if (menuPoint.equals(MenuPoint.CALL)) {
				System.out.println(current.getSessionPot());
				if (actualRaise > current.getSessionPot()) {
					doCall(current);
				}
				current.setChecked(true);
				if (isEveryoneChecked()) {
					break END;
				}
			}
		}
	}

	private void endSession() {
		Player winner = getLastInGame();
		winner.setCash(winner.getCash() + bank);
		System.out.println(winner);
		// meg akarja-e mutatni a kártyát
		showCards(winner);
		hasWinner = true;
	}

	private void showCards(Player winner) {
		Menu menu = new Menu("mutat");
		MenuPoint menuPoint = winner.playerStep(scanner, menu);
		if (menuPoint.equals(MenuPoint.SHOW_CARDS)) {
			System.out.println(winner.getCard1() + " " + winner.getCard2());
		}
	}

	// TODO: objektumot készíteni a wincon-okból., kiértékelés
	private Player getWinner() {
		// meghatározni, hogy kinek voltak a legmagasabb lapjai
		if (true) {
			return null;
		}
		return null;
	}

	private Player getLastInGame() {

		for (int i = 0; i < players.getPlayers().size(); i++) {
			if (players.getPlayers().get(i).isInGame()) {
				return players.getPlayers().get(i);
			}
		}
		return null;

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
		menu = new Menu("játék check nélkül");
	}

	private boolean isEveryoneChecked() {
		for (Player player : players.getPlayers()) {
			if (!player.isChecked()) {
				return false;
			}
		}
		return true;
	}

	private void blinds() {
		players.getPlayers().get(smallBlindIndex).setSessionPot(minPot / 2);
		players.getPlayers().get(bigBlindIndex).setSessionPot(minPot);

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
