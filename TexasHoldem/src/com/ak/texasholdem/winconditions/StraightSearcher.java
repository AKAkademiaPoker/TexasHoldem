package com.ak.texasholdem.winconditions;

import java.util.ArrayList;
import java.util.List;

import com.ak.texasholdem.cards.Card;
import com.ak.texasholdem.cards.Rank;

public class StraightSearcher extends HandTypeSearcher {

	public StraightSearcher(List<Card> cards) {
		super(cards);
	}

	@Override
	public HandTypes search() {
		if (hasSpecificRank(Rank.ACE) && hasSpecificRank(Rank.FIVE) && hasSpecificRank(Rank.FOUR)
				&& hasSpecificRank(Rank.THREE) && hasSpecificRank(Rank.TWO)) {
			setBestCards();
			return HandTypes.STRAIGHT;
		}

		boolean flag = false;
		for (int i = 0; i < cards.size() - 4; i++) {
			for (int j = 0; j < 4; j++) {
				if (cards.get(j)
						.getRank()
						.getRankValue() != cards.get(j + 1)
								.getRank()
								.getRankValue() + 1) {
					flag = false;
					break;
				}
				flag = true;
				if (j == 3 && flag) {
					setBestCards(j - 3 + i);
					return HandTypes.STRAIGHT;
				}
			}
		}

		return null;
	}
	
	private void setBestCards() {
		bestCards = new ArrayList<>();
		bestCards.add(getFirstCardByRank(Rank.FIVE));
		bestCards.add(getFirstCardByRank(Rank.FOUR));
		bestCards.add(getFirstCardByRank(Rank.THREE));
		bestCards.add(getFirstCardByRank(Rank.TWO));
		bestCards.add(getFirstCardByRank(Rank.ACE));
	}
	
	private void setBestCards(int index) {
		bestCards = new ArrayList<>();
		Card firstCard = cards.get(index);
		bestCards.add(firstCard);
		
	}

}
