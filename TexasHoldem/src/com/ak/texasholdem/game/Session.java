package com.ak.texasholdem.game;

import java.util.Scanner;
import java.util.Set;

import com.ak.texasholdem.board.Board;
import com.ak.texasholdem.cards.Deck;
import com.ak.texasholdem.io.FileReader;
import com.ak.texasholdem.io.UserInputHandler;
import com.ak.texasholdem.menu.Menu;
import com.ak.texasholdem.menu.MenuPoint;
import com.ak.texasholdem.player.Player;
import com.ak.texasholdem.player.Players;
import com.ak.texasholdem.winconditions.ResultSearcher;
import com.ak.texasholdem.winconditions.WinnerSearcher;

public class Session extends Game {
	private Scanner scanner = new Scanner(System.in);

	private int bank = 0;
	private int actualRaise = minPot;

	private boolean hasWinner;

	private Menu menu = new Menu("játék check nélkül");

	public Session(Players players, int minPot) {
		super(players, minPot);
		super.board = new Board();
		super.deck = new Deck();
	}

	public void run() {
		players.readyToPlay();
		blinds();
		dealing();
		CLOSE: for (int i = 0; i < 4; i++) {
			System.out.println("Round :" + (i + 1) + "----------");
			for (Player player : players.getPlayers()) {
				if (player.isInGame()) {
					player.setChecked(false);
				}
			}
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
		if (!hasWinner) {
			ResultSearcher rs = new ResultSearcher(board.getVisibleCards(), players.getPlayers());
			rs.doSearch();
			getWinner();
		}

		for (Player player : players.getPlayers()) {
			System.out.println(player.getNickname() + player.getBestCards() + player.getBestHandType());

		}
	}
	// TODO: Game-ben: licitek, játékosok összeállítása
	// TODO: Board is full, 2-10 Players

	private void addCards(int num) {
		board.addBurnedCard(deck.getCard());
		for (int i = 0; i < num; i++) {
			board.addVisibleCards(deck.getCard());

		}
	}

	private void doRound() {
		END: for (int i = players.getPlayers().size() + smallBlindIndex;; i++) {
			int index = i % players.getPlayers().size();
			Player current = players.getPlayers().get(index);

			if (!current.isInGame()) {
				continue;
			}
			System.out.println("---------------------------------");

			System.out.println(current.toString());
			System.out.println("Bankban lévő összeg: " + bank);
			System.out.println(board);

			if (players.onlyOneNotChecked() && actualRaise == current.getSessionPot()) {
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

			}

			if (menuPoint.equals(MenuPoint.CALL)) {
				doCall(current);
				current.setChecked(true);
			}
			if (players.isEveryoneChecked()) {
				break END;
			}
		}
	}

	private void endSession() {
		Player winner = players.getLastInGame();
		winner.setCash(winner.getCash() + bank);
		winner.showCards(scanner);
		hasWinner = true;
	}

	private Set<Player> getWinner() {
		WinnerSearcher ws = new WinnerSearcher(players.getPlayers());
		Set<Player> winner = ws.getWinner();
		int profitPerPlayer = bank / winner.size();
		for (Player player : winner) {
			player.setCash(player.getCash() + profitPerPlayer);
			System.out.println(player + " " + player.getBestCards());
		}

		return winner;
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

	private void blinds() {

		players.getPlayers().get(smallBlindIndex).setSessionPot(minPot / 2);
		players.getPlayers().get(smallBlindIndex)
		.setCash(players.getPlayers().get(smallBlindIndex).getCash() - (minPot / 2));
		bank += (minPot / 2);
		players.getPlayers().get(bigBlindIndex).setSessionPot(minPot);
		players.getPlayers().get(bigBlindIndex).setCash(players.getPlayers().get(bigBlindIndex).getCash() - minPot);
		bank += minPot;

	}

	private void dealing() {
		for (Player player : players.getPlayers()) {
			player.setCard1(deck.getCard());
			player.setCard2(deck.getCard());

		}
	}
}
