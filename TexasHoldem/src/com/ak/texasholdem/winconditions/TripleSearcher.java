package com.ak.texasholdem.winconditions;

import java.util.List;

import com.ak.texasholdem.cards.Card;

public class TripleSearcher extends HandTypeSearcher{

	public TripleSearcher(List<Card> cards) {
		super(cards);
		// TODO Auto-generated constructor stub
	}

	@Override
	public HandTypes search() {
		for (int i = 0; i < cards.size() - 2; i++) {
			if (cards.get(i).getRank().equals(cards.get(i + 1).getRank()) && cards.get(i).getRank().equals(cards.get(i + 2).getRank())) {
				return HandTypes.TRIPLE;
			}
		}
		
		return null;
	}

}
