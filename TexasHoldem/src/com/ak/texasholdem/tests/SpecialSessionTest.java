package com.ak.texasholdem.tests;

import com.ak.texasholdem.board.Board;
import com.ak.texasholdem.cards.Card;
import com.ak.texasholdem.cards.Deck;
import com.ak.texasholdem.cards.Rank;
import com.ak.texasholdem.cards.Suit;
import com.ak.texasholdem.player.Player;
import com.ak.texasholdem.player.Players;
import com.ak.texasholdem.winconditions.ResultSearcher;
import com.ak.texasholdem.winconditions.WinnerSearcher;

public class SpecialSessionTest {
	public static void main(String[] args) {
		Board board = new Board();
		Players players = new Players();
		Deck deck = new Deck();
		players.addPlayerToTheBoard(new Player("Player 1", "", "", 5000));
		players.addPlayerToTheBoard(new Player("Player 2", "", "", 5000));
		players.addPlayerToTheBoard(new Player("Player 3", "", "", 5000));
		players.addPlayerToTheBoard(new Player("Player 4", "", "", 5000));

		for (Player player : players.getPlayers()) {
			player.setCard1(deck.getCard());
			player.setCard2(deck.getCard());
			player.setInGame(true);
			player.setChecked(true);
			System.out.println(player);
		}

		board.addVisibleCards(new Card(Suit.SPADES, Rank.FOUR));
		board.addVisibleCards(new Card(Suit.DIAMONDS, Rank.FOUR));
		board.addVisibleCards(new Card(Suit.SPADES, Rank.FOUR));
		board.addVisibleCards(new Card(Suit.SPADES, Rank.FOUR));
		board.addVisibleCards(new Card(Suit.SPADES, Rank.TWO));

		ResultSearcher rs = new ResultSearcher(board.getVisibleCards(), players.getPlayers());
		rs.doSearch();
		for (Player player : players.getPlayers()) {
			System.out.println("best cards: " + player.getBestCards());
		}
		WinnerSearcher ws = new WinnerSearcher(players.getPlayers());
		System.out.println(ws.getWinner());

	}

}
