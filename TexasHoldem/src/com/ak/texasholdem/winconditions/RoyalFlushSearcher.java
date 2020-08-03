package com.ak.texasholdem.winconditions;

import java.util.ArrayList;
import java.util.List;

import com.ak.texasholdem.cards.Card;
import com.ak.texasholdem.cards.Rank;
import com.ak.texasholdem.cards.Suit;

public class RoyalFlushSearcher extends StraightFlushSearcher {



	public RoyalFlushSearcher(List<Card> cardsOnBoard, List<Card> cardsInHand) {
		super(cardsOnBoard, cardsInHand);
	}

	@Override
	public HandTypes search() {
		List<Card> temp = new ArrayList<>();
		for (Card card2 : cards) {
			if (card2.getRank()
					.equals(Rank.ACE)
					|| card2.getRank()
							.equals(Rank.KING)
					|| card2.getRank()
							.equals(Rank.QUEEN)
					|| card2.getRank()
							.equals(Rank.JACK)
					|| card2.getRank()
							.equals(Rank.TEN)) {
				temp.add(card2);
			}
		}
		HandTypeSearcher fsc = new FlushSearch(temp, new ArrayList<Card>());
		if (temp.size() >= 5) {
			if (HandTypes.FLUSH.equals(fsc.search())) {
				setBestCards();
				return HandTypes.ROYAL_FLUSH;
			}
		}
		return null;
	}
	
	private void setBestCards() {
		bestCards = new ArrayList<>();
		Suit suit = getMostFrequentSuit();
		bestCards.add(new Card(suit, Rank.ACE));
		bestCards.add(new Card(suit, Rank.KING));
		bestCards.add(new Card(suit, Rank.QUEEN));
		bestCards.add(new Card(suit, Rank.JACK));
		bestCards.add(new Card(suit, Rank.TEN));
	}

}