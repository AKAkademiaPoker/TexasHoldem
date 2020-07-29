package com.ak.texasholdem.cards;

import java.util.Comparator;

public class Card {
	private Suit suit;
	private Rank rank;

	public Card(Suit suit, Rank rank) {
		super();
		this.suit = suit;
		this.rank = rank;
	}

	public static Comparator<Card> getComparatorByRankValue() {
		Comparator<Card> comparator = new Comparator<Card>() {

			@Override
			public int compare(Card c1, Card c2) {
				if (c1.getRank()
						.getRankValue() > c2.getRank()
								.getRankValue()) {
					return -1;
				} else if (c1.getRank()
						.getRankValue() < c2.getRank()
								.getRankValue()) {
					return 1;
				} else {
					return 0;
				}
			}
		};
		return comparator;
	}

	@Override
	public String toString() {
		return rank.getRank() + " " + suit.getSymbol();
	}

	public Suit getSuit() {
		return suit;
	}

	public Rank getRank() {
		return rank;
	}

}
