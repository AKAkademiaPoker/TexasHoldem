package com.ak.texasholdem.winconditions;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import com.ak.texasholdem.cards.Card;
import com.ak.texasholdem.cards.Rank;

public class StraightSearcher extends HandTypeSearcher {

	private List<Card> cardsList;

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

		Set<Card> cardSet = new TreeSet<>(Card.getComparatorByRankValue());
		cardSet.addAll(cards);
		cardsList = new ArrayList<>(cardSet);

		boolean flag = false;
		for (int i = 0; i < cardsList.size() - 4; i++) {
			for (int j = 0; j < 4; j++) {
				if (cardsList.get(j + i)
						.getRank()
						.getRankValue() != cardsList.get(j + i + 1)
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

		for (int i = index; i < cardsList.size(); i++) {
			if (bestCards.size() < 5) {
				bestCards.add(cardsList.get(i));
			}
		}
	}

}
