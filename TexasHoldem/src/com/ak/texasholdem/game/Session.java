package com.ak.texasholdem.game;

import java.util.Scanner;

import com.ak.texasholdem.board.Board;
import com.ak.texasholdem.cards.Deck;
import com.ak.texasholdem.io.FileReader;
import com.ak.texasholdem.io.UserInputHandler;
import com.ak.texasholdem.menu.Menu;
import com.ak.texasholdem.menu.MenuPoint;
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
	private int actualRaise = minPot;

	private boolean hasWinner;

	private Menu menu = new Menu("játék check nélkül");

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
		
		
		// TODO: kiértékelés (nyerő kombinációk enum/list) + kifizetés
		// TODO: vakok forgatása
		// TODO: külön Game class amiben fut egy sessionökből álló ciklus, amég vannak játékosok. 
		// TODO: Game-ben: vakok, licitek, játékosok összeállítása
		// TODO: Board is full, 2-10 Players
		
	}

	private void addCards(int num) {
		board.addBurnedCard(deck.getCard());
		for (int i = 0; i < num; i++) {
			board.addVisibleCards(deck.getCard());

		}
	}

	private void doRound() {
		END: for (int i = players.getPlayers().size();; i++) {
			if (bank == minPot * 1.5) {
				i++;
			}
			System.out.println("---------------------------------");
			System.out.println();
			System.out.println();
			int index = i % players.getPlayers().size();
			Player current = players.getPlayers().get(index);
			System.out.println(current.toString());
			System.out.println("Bankban lévő összeg: " + bank);
			System.out.println(board);

			if (onlyOneNotChecked() && actualRaise == current.getSessionPot()) {
				menu = new Menu("játék call nélkül");
			}

			MenuPoint menuPoint = current.playerStep(scanner, menu);
			System.out.println(menuPoint);

			if (menuPoint.equals(MenuPoint.RULES)) {
				new FileReader("res/shortrules.txt").printRules();
				i--;
				continue;
			}

			if (menuPoint.equals(MenuPoint.RAISE)) {
				doRaise(current);
			}

			if (menuPoint.equals(MenuPoint.FOLD)) {
				current.setInGame(false);
				current.setChecked(true);
				if (!players.isMinTwoPlayerInGame()) {
					endSession();
					break END;
				}
			}

			if (menuPoint.equals(MenuPoint.CHECK)) {
				System.out.println("Passzol");
				current.setChecked(true);

				if (isEveryoneChecked()) {
					break END;
				}
			}

			if (menuPoint.equals(MenuPoint.CALL)) {
				doCall(current);
				current.setChecked(true);
			}
		}
	}

	private boolean onlyOneNotChecked() {
		int counter = 0;
		for (Player player : players.getPlayers()) {
			if (!player.isChecked()) {
				counter++;
			}
		}
		return counter <= 1;
	}

	private void endSession() {
		Player winner = getLastInGame();
		winner.setCash(winner.getCash() + bank);
		System.out.println(winner);
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
	// meghatározni, hogy kinek voltak a legmagasabb lapjai
	private Player getWinner() {
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
		players.getPlayers().get(bigBlindIndex).setSessionPot(minPot);
		players.getPlayers().get(bigBlindIndex).setCash(players.getPlayers().get(bigBlindIndex).getCash() - minPot);
		bank += minPot;
		players.getPlayers().get(smallBlindIndex).setSessionPot(minPot / 2);
		players.getPlayers().get(smallBlindIndex)
				.setCash(players.getPlayers().get(smallBlindIndex).getCash() - (minPot / 2));
		bank += (minPot / 2);

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
