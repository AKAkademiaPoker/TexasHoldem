package com.ak.texasholdem.winconditions;

import java.util.ArrayList;
import java.util.List;

import com.ak.texasholdem.cards.Card;
import com.ak.texasholdem.cards.Rank;

public class QuadsSearcher extends HandTypeSearcher {



	public QuadsSearcher(List<Card> cardsOnBoard, List<Card> cardsInHand) {
		super(cardsOnBoard, cardsInHand);
	}

	@Override
	public HandTypes search() {
		Rank rank = getMostFrequentRank();
		if (countRanks(rank) == 4) {
			setBestCards(rank);
			return HandTypes.FOUR_OF_A_KIND;
		}
		return null;
	}

	private void setBestCards(Rank rank) {
		bestCards = new ArrayList<>();
		for (Card card : cards) {
			if (rank.equals(card.getRank())) {
				bestCards.add(card);
			}
		}
	}

}
