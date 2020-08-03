package com.ak.texasholdem.winconditions;

import java.util.ArrayList;
import java.util.List;

import com.ak.texasholdem.cards.Card;

public class FullHouseSearcher extends HandTypeSearcher {

	

	public FullHouseSearcher(List<Card> cardsOnBoard, List<Card> cardsInHand) {
		super(cardsOnBoard, cardsInHand);
	}

	@Override
	public HandTypes search() {

		HandTypeSearcher hts = new TripleSearcher(cardsOnBoard, cardsInHand);
		if (HandTypes.TRIPLE.equals(hts.search())) {
			List<Card> newCards = new ArrayList<>();
			newCards.addAll(hts.getBestCards());
			List<Card> remainCards = new ArrayList<>(cards);
			remainCards.removeAll(newCards);
			hts = new PairSearcher(remainCards, new ArrayList<Card>());
			if (HandTypes.PAIR.equals(hts.search())) {
				newCards.addAll(hts.getBestCards());
				setBestCards(newCards);
				return HandTypes.FULL_HOUSE;
			}
		}
		return null;
	}

	protected void setBestCards(List<Card> newCards) {
		bestCards = new ArrayList<>();
		bestCards.addAll(newCards);
	}

}