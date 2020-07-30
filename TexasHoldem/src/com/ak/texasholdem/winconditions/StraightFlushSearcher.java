package com.ak.texasholdem.winconditions;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.ak.texasholdem.cards.Card;
import com.ak.texasholdem.cards.Suit;

public class StraightFlushSearcher extends FlushSearch {

	public StraightFlushSearcher(List<Card> cards) {
		super(cards);
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
		if (sfs.size() >= 5) {
			HandTypeSearcher searcher = new StraightSearcher(sfs);
			if (HandTypes.STRAIGHT.equals(searcher.search())) {
				setBestCards(sfs);
				return HandTypes.STRAIGHT_FLUSH;
			}
		}
		return null;

	}

	private void setBestCards(List<Card> sfs) {
		bestCards = new ArrayList<>();
		bestCards = sfs.stream().limit(5).collect(Collectors.toList());
	}

}
