package com.ak.texasholdem.winconditions;

import java.util.ArrayList;
import java.util.List;

import com.ak.texasholdem.cards.Card;
import com.ak.texasholdem.cards.Rank;

public class RoyalFlushSearcher extends HandTypeSearcher {

	public RoyalFlushSearcher(List<Card> cards) {
		super(cards);
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
		HandTypeSearcher fsc = new FlushSearch(temp);
		if (temp.size() >= 5) {
			if (HandTypes.FLUSH.equals(fsc.search())) {
				return HandTypes.ROYAL_FLUSH;
			}
		}
		return null;
	}

}
