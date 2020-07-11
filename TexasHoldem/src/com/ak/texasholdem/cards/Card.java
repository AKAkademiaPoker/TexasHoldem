package com.ak.texasholdem.cards;

public class Card {
	private Suit suit;
	private Rank rank;

	public Card(Suit suit, Rank rank) {
		super();
		this.suit = suit;
		this.rank = rank;
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
