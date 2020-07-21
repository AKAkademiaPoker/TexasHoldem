package com.ak.texasholdem.winconditions;

import java.util.List;

import com.ak.texasholdem.cards.Card;

public class RoyalFlushSearcher extends HandTypeSearcher {

	public RoyalFlushSearcher(List<Card> cards) {
		super(cards);
	}

	@Override
	public HandTypes search() {
		List<Card> bestCards = straightSearcher(14, 10);
		
		for (int i = 1; i < bestCards.size(); i++) {
			if (!bestCards.get(0)
					.getSuit()
					.equals(bestCards.get(i)
							.getSuit())) {
				return null;
			}
		}
		super.bestCards = bestCards;
		return HandTypes.ROYAL_FLUSH;
	}

}
