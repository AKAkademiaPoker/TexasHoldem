package Functions;

import java.util.List;
import java.util.Scanner;

import com.ak.texasholdem.Card;
import com.ak.texasholdem.Player;

import Menu.Menu;
import Menu.MenuPoint;
import Menu.MenuTypes;
import Models.Board;
import Models.Deck;

public class Session {

	private List<Player> players = List.of(new Player("AAAA", "bbb", 15000), new Player("BBB", "aaa", 25000),
			new Player("CCC", "aaa", 27000));
	private Deck deck = new Deck();
	private long bank = 0;
	private Board board = new Board();
	private int limit = 100;
	private Scanner scanner = new Scanner(System.in);
	private int raise = 0;
	private int callCounter = 0;

	public void run() {
		int player = 0;
		dealoutCards();
		setBlinds();
		for (int i = 0; i < 5; i++) {
			// kivett játékosok hozzáadása
			while (true) {
				System.out.println("Kör:" + i);
				System.out.println("Játékos: "+ players.get(player).getName());
				System.out.printf("Asztal lapok: %s          Pot: %d          Limit: %d/%d%n", board.getCardsOnBoard(),
						bank, limit / 2, limit);
				System.out.printf("Saját lapok: %s %s          Pénz: %d", players.get(player).getCard1().toString(),
						players.get(player).getCard2().toString(), players.get(player).getCash());
				System.out.println("Te jössz: ");
				Menu menu = new Menu("játék");
				menu.print();
				System.out.print(">");
				int choice = scanner.nextInt();
				MenuPoint menuPoint = menu.getMenuPoint(choice);
				if (menuPoint.equals(MenuPoint.CALL)) {
					callCounter++;
					long newCash = players.get(player).getCash() - raise;
					if (newCash < 0) {
						players.get(player).setCash(0);
						bank += players.get(player).getCash();
					} else {
						players.get(player).setCash(newCash);
						bank += raise;
					}

				} else if (menuPoint.equals(MenuPoint.RAISE)) {
					callCounter = 0;
					System.out.println("Tét:");
					int bet = 0;
					do {
						System.out.println(">");
						bet = scanner.nextInt();
					} while (bet >= players.get(player).getCash());
					raise = bet;
					bank += bet;
				} else if (menuPoint.equals(MenuPoint.FOLD)) {
					// ToDO
					// Játékos lista új paraméter hozzáadása boolean Folded...
				}

				player++;
				if (player > players.size() - 1) {
					player = 0;
				}
				if (callCounter+1 == players.size()) {
					break;
				}
			}
			bank = 0;

		}
		// TO DO
		// Cseréljünk vakot!
	}

	private void setBlinds() {
		long newCach = players.get(0).getCash() - (limit / 2);
		long newCach2 = players.get(1).getCash() - limit;
		bank+=(limit + limit/2);
		players.get(0).setCash(newCach);
		players.get(1).setCash(newCach2);
	}

	private void dealoutCards() {
		for (Player player : players) {
			Card card1 = new Card();
			Card card2 = new Card();
			player.setCard1(card1);
			player.setCard2(card2);
		}

	}

}
