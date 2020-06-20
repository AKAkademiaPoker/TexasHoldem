package Functions;

import java.util.List;

import com.ak.texasholdem.cards.Deck;

import Models.Board;

public class Game {

	public static void main(String[] args) {
		Deck deck = new Deck();
		Board board = new Board();
		for (int i = 0; i < 52; i++) {
			System.out.println(deck.getDeck()
					.get(i));
		}

	}

}
