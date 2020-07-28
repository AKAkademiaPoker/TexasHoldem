package com.ak.texasholdem.winconditions;

import java.util.ArrayList;
import java.util.List;

import com.ak.texasholdem.cards.Card;

public class TripleSearcher extends HandTypeSearcher {

	public TripleSearcher(List<Card> cards) {
		super(cards);
	}

	@Override
	public HandTypes search() {
		for (int i = 0; i < cards.size() - 2; i++) {
			if (cards.get(i).getRank().equals(cards.get(i + 1).getRank())
					&& cards.get(i).getRank().equals(cards.get(i + 2).getRank())) {
				setBestCards(i);
				return HandTypes.TRIPLE;
			}
		}

		return null;
	}

	private void setBestCards(int i) {
		bestCards = new ArrayList<>();
		bestCards.add(cards.get(i));
		bestCards.add(cards.get(i + 1));
		bestCards.add(cards.get(i + 2));
	}

}
