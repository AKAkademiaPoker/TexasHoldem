package com.ak.texasholdem.winconditions;

import java.util.List;

import com.ak.texasholdem.cards.Card;

public class PairSearcher extends HandTypeSearcher {

	public PairSearcher(List<Card> cards) {
		super(cards);
		// TODO Auto-generated constructor stub
	}

	@Override
	public HandTypes search() {

		for (int i = 0; i < cards.size() - 1; i++) {
			if (cards.get(i).getRank().equals(cards.get(i + 1).getRank())) {
				return HandTypes.PAIR;
			}
		}
		return null;
	}

}
