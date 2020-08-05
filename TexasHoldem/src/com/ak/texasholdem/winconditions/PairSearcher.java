package com.ak.texasholdem.winconditions;

import java.util.ArrayList;
import java.util.List;

import com.ak.texasholdem.cards.Card;

public class PairSearcher extends HandTypeSearcher {

	public PairSearcher(List<Card> cardsOnBoard, List<Card> cardsInHand) {
		super(cardsOnBoard, cardsInHand);
	}

	@Override
	public HandTypes search() {

		for (int i = 0; i < cards.size() - 1; i++) {
			if (cards.get(i).getRank().equals(cards.get(i + 1).getRank())) {
				setBestCards(i);
				return HandTypes.PAIR;
			}
		}
		return null;
	}

	protected void setBestCards(int i) {

		bestCards = new ArrayList<>();
		bestCards.add(cards.get(i));
		bestCards.add(cards.get(i + 1));
//		cardsInHand.removeAll(bestCards);
//		bestCards.addAll(cardsInHand);

	}

}
