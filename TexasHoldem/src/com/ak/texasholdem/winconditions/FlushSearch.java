package com.ak.texasholdem.winconditions;

import java.util.ArrayList;
import java.util.List;

import com.ak.texasholdem.cards.Card;
import com.ak.texasholdem.cards.Suit;

public class FlushSearch extends HandTypeSearcher {

	public FlushSearch(List<Card> cards) {
		super(cards);
	}

	protected Suit getMostFrequentSuit() {
		int counter = 0;
		Suit suit = null;
		for (int i = 0; i < Suit.values().length; i++) {
			if (counter < countSuits(Suit.values()[i])) {
				suit = Suit.values()[i];
			}
		}
		return suit;
	}

	@Override
	public HandTypes search() {
		for (int i = 0; i < Suit.values().length; i++) {
			if (countSuits(Suit.values()[i]) >= 5) {
				setBestCards();
				return HandTypes.FLUSH;
			}
		}
		return null;
	}

	private void setBestCards() {
		Suit suit = getMostFrequentSuit();
		bestCards = new ArrayList<>();
		for (Card card : cards) {
			if (suit.equals(card.getSuit()) && bestCards.size() < 5) {
				bestCards.add(card);
			}
		}
	}

}