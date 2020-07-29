package com.ak.texasholdem.winconditions;

import java.util.ArrayList;
import java.util.List;

import com.ak.texasholdem.cards.Card;
import com.sun.tools.classfile.Annotation.element_value;

public class TwoPairSearcher extends PairSearcher {

	public TwoPairSearcher(List<Card> cards) {
		super(cards);
	}

	@Override
	public HandTypes search() {
		bestCards = new ArrayList<>();
		List<Card> temp = new ArrayList<>(cards);
		int i = 0;
		while (i < 2) {

			HandTypeSearcher hts = new PairSearcher(temp);

			if (HandTypes.PAIR.equals(hts.search())) {
				bestCards.addAll(hts.getBestCards());
				temp.removeAll(bestCards);
				i++;
			} else {
				bestCards.removeAll(bestCards);
				return null;
			}

		}
		return HandTypes.TWO_PAIRS;
	}

}
