package com.ak.texasholdem.winconditions;

import java.util.List;

import com.ak.texasholdem.cards.Card;
import com.ak.texasholdem.cards.Suit;

public class FlushSearch extends HandTypeSearcher {

	public FlushSearch(List<Card> cards) {
		super(cards);
	}

	@Override
	public HandTypes search() {
		for (int i = 0; i < Suit.values().length; i++) {
			if(countSuits(Suit.values()[i]) >= 5) {
				
				return HandTypes.FLUSH;
			}
		}
		return null;
	}
	
}