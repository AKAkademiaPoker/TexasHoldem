package com.ak.texasholdem.winconditions;

import java.util.ArrayList;
import java.util.List;

import com.ak.texasholdem.cards.Card;
import com.ak.texasholdem.player.Player;

public class TripleSearcher extends HandTypeSearcher implements HighCardGetter{

	
	public TripleSearcher(List<Card> cardsOnBoard, List<Card> cardsInHand) {
		super(cardsOnBoard, cardsInHand);
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
