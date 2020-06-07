package Models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {

	private List<Card> deck;
	private List<String> suits;
	private List<String> numbers;

	public Deck() {
		super();
		suits = new ArrayList<String>();
		suits.add("\u2663");
		suits.add("\u2664");
		suits.add("\u2665");
		suits.add("\u2666");
		numbers = new ArrayList<String>();
		numbers.add("2");
		numbers.add("3");
		numbers.add("4");
		numbers.add("5");
		numbers.add("6");
		numbers.add("7");
		numbers.add("8");
		numbers.add("9");
		numbers.add("10");
		numbers.add("J");
		numbers.add("Q");
		numbers.add("K");
		numbers.add("A");
		int value;
		String name;
		deck = new ArrayList<Card>();
		for (int i = 0; i < 52; i++) {
			value = i % 13 + 1;
			name = suits.get(i / 13);
			name += numbers.get(i % 13);
			Card card = new Card(i, value, name);
			deck.add(card);
		}
		Collections.shuffle(deck);
	}

	public List<Card> getDeck() {
		return deck;
	}

}
