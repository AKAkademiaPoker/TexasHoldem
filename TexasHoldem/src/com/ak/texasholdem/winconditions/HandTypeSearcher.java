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
	protected List<Card> cardsOnBoard;
	protected List<Card> cardsInHand;
	

	public HandTypeSearcher(List<Card> cardsOnBoard, List<Card> cardsInHand) {
		this.cardsOnBoard = cardsOnBoard;
		this.cardsInHand = cardsInHand;
		cards = new ArrayList<>(cardsInHand);
		cards.addAll(cardsOnBoard);
		sortCardsByRank(this.cards);
	}

	public static void sortCardsByRank(List<Card> cards) {
		Comparator<Card> c = new Comparator<Card>() {

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

	protected boolean hasSpecificRank(Rank rank) {
		for (Card card : cards) {
			if (card.getRank()
					.equals(rank)) {
				return true;
			}
		}
		return false;
	}

	protected Card getFirstCardByRank(Rank rank) {
		for (Card card : cards) {
			if (card.getRank()
					.equals(rank)) {
				return card;
			}
		}
		return null;
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

	protected int countRanks(Rank rank) {
		int counter = 0;
		for (Card card : cards) {
			if (card.getRank()
					.equals(rank)) {
				counter++;
			}
		}
		return counter;
	}

	protected Rank getMostFrequentRank() {
		int counter = 0;
		Rank rank = null;
		for (int i = 0; i < Rank.values().length; i++) {
			if (counter < countRanks(Rank.values()[i])) {
				rank = Rank.values()[i];
				counter = countRanks(Rank.values()[i]);
			}
		}
		return rank;
	}

	public abstract HandTypes search();

	public List<Card> getBestCards() {
		return bestCards;
	}

}