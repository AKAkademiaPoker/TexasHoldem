package com.ak.texasholdem.cards;

public enum Suit {

	DIAMONDS("KÁRÓ", '\u2666'),
	CLUBS("TREFF", '\u2663'),
	HEARTS("KÖR", '\u2665'),
	SPADES("PIKK", '\u2660');

	private String hunName;
	private char symbol;

	private Suit(String hunName, char symbol) {
		this.hunName = hunName;
		this.symbol = symbol;

	}

	public String getHunName() {
		return hunName;
	}

	public char getSymbol() {
		return symbol;
	}
}
