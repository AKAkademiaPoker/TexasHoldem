package com.ak.texasholdem.winconditions;

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
			return HandTypes.STRAIGHT;
		}

		boolean flag = false;
		for (int i = 0; i < cards.size() - 5; i++) {
			for (int j = 0; j < 4; j++) {
				if (cards.get(j).getRank().getRankValue() != cards.get(j + 1).getRank().getRankValue() + 1) {
					flag = false;
					break;
				}
				flag = true;
				if (j == 3 && flag) {
					return HandTypes.STRAIGHT;
				}
			}
		}

		return null;
	}

}
