package com.ak.texasholdem.winconditions;

import java.util.ArrayList;
import java.util.List;

import com.ak.texasholdem.cards.Card;
import com.ak.texasholdem.player.Player;

public class ResultSearcher {

	private List<Card> visibleCardsOnBoard;
	private List<Player> players;

	public ResultSearcher(List<Card> visibleCardsOnBoard, List<Player> players) {
		super();
		this.visibleCardsOnBoard = visibleCardsOnBoard;
		this.players = players;
	}

	public void doSearch() {
		for (Player player : players) {
			List<Card> currentPlayerCards = new ArrayList<Card>(visibleCardsOnBoard);
			currentPlayerCards.add(player.getCard1());
			currentPlayerCards.add(player.getCard2());
			HandTypeSearcher searcher = new RoyalFlushSearcher(currentPlayerCards);
			
			if(HandTypes.ROYAL_FLUSH.equals(searcher.search())) {
				setBestCardsAndHandType(player, searcher);
				continue;
			}
			searcher = new StraightFlushSearcher(currentPlayerCards);
			if(HandTypes.STRAIGHT_FLUSH.equals(searcher.search())) {
				setBestCardsAndHandType(player, searcher);
				continue;
			}
			searcher = new QuadsSearcher(currentPlayerCards);
			if(HandTypes.FOUR_OF_A_KIND.equals(searcher.search())) {
				setBestCardsAndHandType(player, searcher);
				continue;
			}
			searcher = new FullHouseSearcher(currentPlayerCards);
			if(HandTypes.FULL_HOUSE.equals(searcher.search())) {
				setBestCardsAndHandType(player, searcher);
				continue;
			}
			searcher = new FlushSearch(currentPlayerCards);
			if(HandTypes.FLUSH.equals(searcher.search())) {
				setBestCardsAndHandType(player, searcher);
				continue;
			}
			searcher = new StraightSearcher(currentPlayerCards);
			if(HandTypes.STRAIGHT.equals(searcher.search())) {
				setBestCardsAndHandType(player, searcher);
				continue;
			}
			searcher = new TripleSearcher(currentPlayerCards);
			if(HandTypes.TRIPLE.equals(searcher.search())) {
				setBestCardsAndHandType(player, searcher);
				continue;
			}
			searcher = new TwoPairSearcher(currentPlayerCards);
			if(HandTypes.TWO_PAIRS.equals(searcher.search())) {
				setBestCardsAndHandType(player, searcher);
				continue;
			}
			searcher = new PairSearcher(currentPlayerCards);
			if(HandTypes.PAIR.equals(searcher.search())) {
				setBestCardsAndHandType(player, searcher);
				continue;
			}
			searcher = new HighCardSearcher(currentPlayerCards);
			if(HandTypes.HIGH_CARD.equals(searcher.search())) {
				setBestCardsAndHandType(player, searcher);
				continue;
			}
			
		}
		
	}

	private void setBestCardsAndHandType(Player player, HandTypeSearcher searcher) {
		player.setBestHandType(searcher.search());
		player.setBestCards(searcher.getBestCards());
	}

}
