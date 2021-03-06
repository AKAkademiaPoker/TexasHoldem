package com.ak.texasholdem.board;

import java.util.ArrayList;
import java.util.List;

import com.ak.texasholdem.cards.Card;

public class Board {
	private List<Card> burnedCards = new ArrayList<>();
	private List<Card> visibleCards = new ArrayList<>();
	
	public Board() {
		
	}
	
	public void addBurnedCard(Card card) {
		burnedCards.add(card);
	}
	
	public void addVisibleCards(Card card) {
		visibleCards.add(card);
	}

	public List<Card> getVisibleCards() {
		return visibleCards;
	}
	
	public void newRound() {
		burnedCards.removeAll(burnedCards);
		visibleCards.removeAll(visibleCards);
	}
	
	@Override
	public String toString() {
		return visibleCards.toString();
	}
	
}
