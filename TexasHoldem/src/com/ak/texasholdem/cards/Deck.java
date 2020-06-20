package com.ak.texasholdem.cards;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {

	private List<Card> deck = new ArrayList<>();

	public Deck() {
		Suit[] suits = Suit.values();
		Rank[] ranks = Rank.values();

		for (int i = 0; i < suits.length; i++) {
			for (int j = 0; j < ranks.length; j++) {
				Card card = new Card(suits[i], ranks[j]);
				deck.add(card);

			}
		}
		Collections.shuffle(deck);
	}

	public List<Card> getDeck() {
		return deck;
	}

	public Card getCard() {
		return deck.remove(0);
	}

}
