package com.ak.texasholdem.cards;

public enum Suit {

	SPADES("PIKK", 'P'), HEARTS("KÖR", 'K'), CLUBS("TREFF", 'T'), DIAMOND("KÁRÓ", 'C');

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
