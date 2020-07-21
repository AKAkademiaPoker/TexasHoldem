package com.ak.texasholdem.tests;

import java.util.ArrayList;
import java.util.List;

import com.ak.texasholdem.cards.Card;
import com.ak.texasholdem.cards.Rank;
import com.ak.texasholdem.cards.Suit;
import com.ak.texasholdem.winconditions.FlushSearch;
import com.ak.texasholdem.winconditions.HandTypeSearcher;
import com.ak.texasholdem.winconditions.HandTypes;
import com.ak.texasholdem.winconditions.PairSearcher;
import com.ak.texasholdem.winconditions.RoyalFlushSearcher;
import com.ak.texasholdem.winconditions.StraightFlushSearcher;
import com.ak.texasholdem.winconditions.StraightSearcher;
import com.ak.texasholdem.winconditions.TripleSearcher;

public class HandSearcherTest {

	public static void main(String[] args) {
		List<Card> testCards = new ArrayList<>();
		testCards.add(new Card(Suit.DIAMONDS, Rank.NINE));
		testCards.add(new Card(Suit.CLUBS, Rank.ACE));
		testCards.add(new Card(Suit.CLUBS, Rank.NINE));
		testCards.add(new Card(Suit.DIAMONDS, Rank.KING));
		testCards.add(new Card(Suit.DIAMONDS, Rank.QUEEN));
		testCards.add(new Card(Suit.DIAMONDS, Rank.JACK));
		testCards.add(new Card(Suit.DIAMONDS, Rank.TEN));
		

		System.out.println(testCards);
		HandTypeSearcher searcher = new StraightFlushSearcher(testCards);
		System.out.println(testCards);
		System.out.println(searcher.search());
//		System.out.println(searcher.search());
//		System.out.println(searcher.getBestCards());

	}

}
