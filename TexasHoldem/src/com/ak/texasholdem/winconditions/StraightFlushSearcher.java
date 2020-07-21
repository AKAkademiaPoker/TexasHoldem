package com.ak.texasholdem.winconditions;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.ak.texasholdem.cards.Card;
import com.ak.texasholdem.cards.Suit;

public class StraightFlushSearcher extends HandTypeSearcher {

	public StraightFlushSearcher(List<Card> cards) {
		super(cards);
		// TODO Auto-generated constructor stub
	}

	@Override
	public HandTypes search() {
		List<Card> sfs = new ArrayList<>();
		HandTypeSearcher fsc = new FlushSearch(cards);
		for (int i = 0; i < cards.size() - 1; i++) {
			if (HandTypes.FLUSH.equals(fsc.search())) {
				Suit suit = getMostFrequentSuit();
				sfs = cards.stream().filter(card -> card.getSuit().equals(suit)).collect(Collectors.toList());
			}
		}
		System.out.println(sfs);
		if (sfs.size() >= 5) {
			HandTypeSearcher searcher = new StraightSearcher(sfs);
			if (HandTypes.STRAIGHT.equals(searcher.search())) {
				return HandTypes.STRAIGHT_FLUSH;
			}
		}
		return null;

	}

	private Suit getMostFrequentSuit() {
		int counter = 0;
		Suit suit = null;
		for (int i = 0; i < Suit.values().length; i++) {
			if (counter < countSuits(Suit.values()[i])) {
				suit = Suit.values()[i];
			}
		}
		return suit;
	}
}
