package com.ak.texasholdem.winconditions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import com.ak.texasholdem.cards.Card;

public abstract class HandTypeSearcher {
	protected List<Card> cards;
	protected List<Card> bestCards;

	public HandTypeSearcher(List<Card> cards) {
		this.cards = cards;
		
	}

	protected List<Card> straightSearcher(int fromInclusive, int toInclusive) {
		List<Card> bestCards = new ArrayList<>();
		for (int value = fromInclusive; value >= toInclusive; value--) {
			for (Card card : cards) {
				if (card.getRank()
						.getRankValue() == value) {
					bestCards.add(card);
					break;
				} else {
					return null;
				}
			}
		}
		return bestCards;
	}

	public List<Card> getBestCards() {
		return bestCards;
	}

	public abstract HandTypes search();
	
	

}
