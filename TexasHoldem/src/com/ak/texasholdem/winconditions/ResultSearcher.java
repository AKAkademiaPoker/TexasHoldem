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
			List<Card> cardsOnBoard = new ArrayList<Card>(visibleCardsOnBoard);
			List<Card> cardsInHand = new ArrayList<>();
			cardsInHand.add(player.getCard1());
			cardsInHand.add(player.getCard2());
			HandTypeSearcher searcher = new RoyalFlushSearcher(cardsOnBoard, cardsInHand);
			
			if(HandTypes.ROYAL_FLUSH.equals(searcher.search())) {
				setBestCardsAndHandType(player, searcher);
				continue;
			}
			searcher = new StraightFlushSearcher(cardsOnBoard, cardsInHand);
			if(HandTypes.STRAIGHT_FLUSH.equals(searcher.search())) {
				setBestCardsAndHandType(player, searcher);
				continue;
			}
			searcher = new QuadsSearcher(cardsOnBoard, cardsInHand);
			if(HandTypes.FOUR_OF_A_KIND.equals(searcher.search())) {
				setBestCardsAndHandType(player, searcher);
				continue;
			}
			searcher = new FullHouseSearcher(cardsOnBoard, cardsInHand);
			if(HandTypes.FULL_HOUSE.equals(searcher.search())) {
				setBestCardsAndHandType(player, searcher);
				continue;
			}
			searcher = new FlushSearch(cardsOnBoard, cardsInHand);
			if(HandTypes.FLUSH.equals(searcher.search())) {
				setBestCardsAndHandType(player, searcher);
				continue;
			}
			searcher = new StraightSearcher(cardsOnBoard, cardsInHand);
			if(HandTypes.STRAIGHT.equals(searcher.search())) {
				setBestCardsAndHandType(player, searcher);
				continue;
			}
			searcher = new TripleSearcher(cardsOnBoard, cardsInHand);
			if(HandTypes.TRIPLE.equals(searcher.search())) {
				setBestCardsAndHandType(player, searcher);
				
				continue;
			}
			searcher = new TwoPairSearcher(cardsOnBoard, cardsInHand);
			if(HandTypes.TWO_PAIRS.equals(searcher.search())) {
				setBestCardsAndHandType(player, searcher);
				continue;
			}
			searcher = new PairSearcher(cardsOnBoard, cardsInHand);
			if(HandTypes.PAIR.equals(searcher.search())) {
				setBestCardsAndHandType(player, searcher);
				continue;
			}
			searcher = new HighCardSearcher(cardsOnBoard, cardsInHand);
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
