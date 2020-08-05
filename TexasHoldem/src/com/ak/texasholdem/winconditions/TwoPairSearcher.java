package com.ak.texasholdem.winconditions;

import java.util.ArrayList;
import java.util.List;

import com.ak.texasholdem.cards.Card;


public class TwoPairSearcher extends PairSearcher{


	public TwoPairSearcher(List<Card> cardsOnBoard, List<Card> cardsInHand) {
		super(cardsOnBoard, cardsInHand);
	}

	@Override
	public HandTypes search() {
		bestCards = new ArrayList<>();
		List<Card> temp = new ArrayList<>(cards);
		int i = 0;
		while (i < 2) {

			HandTypeSearcher hts = new PairSearcher(temp, new ArrayList<>());
			
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
