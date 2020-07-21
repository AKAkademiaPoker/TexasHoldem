package com.ak.texasholdem.winconditions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.ak.texasholdem.cards.Card;
import com.ak.texasholdem.cards.Rank;
import com.ak.texasholdem.cards.Suit;

public abstract class HandTypeSearcher {
	protected List<Card> cards;
	protected List<Card> bestCards;

	public HandTypeSearcher(List<Card> cards) {
		this.cards = cards;
		sortCardsByRank(this.cards);
	}

	public void sortCardsByRank(List<Card> cards) {
		Comparator c = new Comparator<Card>() {

			@Override
			public int compare(Card card1, Card card2) {
				if (card1.getRank()
						.getRankValue() < card2.getRank()
								.getRankValue()) {
					return 1;
				}
				if (card1.getRank()
						.getRankValue() > card2.getRank()
								.getRankValue()) {

					return -1;
				}
				return 0;
			}
		};
		Collections.sort(cards, c);
	}

	public List<Card> getBestCards() {
		return bestCards;
	}

	protected boolean hasSpecificRank(Rank rank) {
		for (Card card : cards) {
			if (card.getRank()
					.equals(rank)) {
				return true;
			}
		}
		return false;
	}

	protected int countSuits(Suit suit) {
		int counter = 0;
		for (Card card : cards) {
			if (card.getSuit()
					.equals(suit)) {
				counter++;
			}
		}
		return counter;
	}

	public abstract HandTypes search();

}