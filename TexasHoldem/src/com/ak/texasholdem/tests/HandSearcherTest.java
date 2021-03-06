package com.ak.texasholdem.tests;

import java.util.ArrayList;
import java.util.List;

import com.ak.texasholdem.cards.Card;
import com.ak.texasholdem.cards.Rank;
import com.ak.texasholdem.cards.Suit;
import com.ak.texasholdem.winconditions.HandTypeSearcher;
import com.ak.texasholdem.winconditions.QuadsSearcher;

public class HandSearcherTest {

	public static void main(String[] args) {
		List<Card> testCards = new ArrayList<>();
		testCards.add(new Card(Suit.DIAMONDS, Rank.NINE));
		testCards.add(new Card(Suit.SPADES, Rank.NINE));
		testCards.add(new Card(Suit.CLUBS, Rank.ACE));
		testCards.add(new Card(Suit.DIAMONDS, Rank.QUEEN));
		testCards.add(new Card(Suit.DIAMONDS, Rank.KING));
		testCards.add(new Card(Suit.HEARTS, Rank.EIGHT));
		testCards.add(new Card(Suit.DIAMONDS, Rank.JACK));
		testCards.add(new Card(Suit.HEARTS, Rank.JACK));
		testCards.add(new Card(Suit.DIAMONDS, Rank.TEN));
		testCards.add(new Card(Suit.DIAMONDS, Rank.SEVEN));
		testCards.add(new Card(Suit.CLUBS, Rank.NINE));
		testCards.add(new Card(Suit.HEARTS, Rank.NINE));
		testCards.add(new Card(Suit.DIAMONDS, Rank.TWO));

		System.out.println("    eredeti: " + testCards);
		HandTypeSearcher searcher = new QuadsSearcher(testCards, new ArrayList<Card>());
		System.out.println("sorbarakott: " + testCards);
		System.out.println(searcher.search());

//		System.out.println(searcher.search());
		System.out.println("legjobb kártyák: " + searcher.getBestCards());

	}

}
