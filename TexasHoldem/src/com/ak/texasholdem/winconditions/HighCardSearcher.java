package com.ak.texasholdem.winconditions;

import java.util.ArrayList;
import java.util.List;

import com.ak.texasholdem.cards.Card;

public class HighCardSearcher extends HandTypeSearcher {



	public HighCardSearcher(List<Card> cardsOnBoard, List<Card> cardsInHand) {
		super(cardsOnBoard, cardsInHand);
	}

	@Override
	public HandTypes search() {
		bestCards = new ArrayList<>();
		for (int i = 0; i < 5; i++) {
			bestCards.add(cards.get(i));
		}
		return HandTypes.HIGH_CARD;
	}

}
