package com.ak.texasholdem.tests;

import java.util.ArrayList;
import java.util.List;

import com.ak.texasholdem.cards.Card;
import com.ak.texasholdem.cards.Rank;
import com.ak.texasholdem.cards.Suit;
import com.ak.texasholdem.winconditions.HandTypeSearcher;
import com.ak.texasholdem.winconditions.RoyalFlushSearcher;

public class HandSearcherTest {

	public static void main(String[] args) {
		List<Card> testCards = new ArrayList<>();
		testCards.add(new Card(Suit.DIAMONDS, Rank.THREE));
		testCards.add(new Card(Suit.DIAMONDS, Rank.TEN));
		testCards.add(new Card(Suit.DIAMONDS, Rank.ACE));
		testCards.add(new Card(Suit.DIAMONDS, Rank.QUEEN));
		testCards.add(new Card(Suit.DIAMONDS, Rank.KING));
		testCards.add(new Card(Suit.DIAMONDS, Rank.SEVEN));
		testCards.add(new Card(Suit.DIAMONDS, Rank.JACK));

		HandTypeSearcher searcher = new RoyalFlushSearcher(testCards);
		System.out.println(searcher.search());
		System.out.println(searcher.getBestCards());

	}

}
