package com.ak.texasholdem.tests;

import com.ak.texasholdem.board.Board;
import com.ak.texasholdem.cards.Card;
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
		players.addPlayer(new Player("BBB", "", "", 5000));
		players.addPlayer(new Player("AAA", "", "", 5000));
		
		for (Player player : players.getPlayers()) {
			player.setCard1(new Card(Suit.CLUBS, Rank.ACE));
			player.setCard2(new Card(Suit.CLUBS, Rank.KING));
			player.setInGame(true);
			player.setChecked(true);
		}
		board.addVisibleCards(new Card(Suit.DIAMONDS, Rank.NINE));
		board.addVisibleCards(new Card(Suit.SPADES, Rank.EIGHT));
		board.addVisibleCards(new Card(Suit.DIAMONDS, Rank.FIVE));
		board.addVisibleCards(new Card(Suit.SPADES, Rank.THREE));
		board.addVisibleCards(new Card(Suit.DIAMONDS, Rank.TWO));
		
		
		
		ResultSearcher rs = new ResultSearcher(board.getVisibleCards(), players.getPlayers());
		rs.doSearch();
		WinnerSearcher ws = new WinnerSearcher(players.getPlayers());
		System.out.println(ws.getWinner());
		
		
	}

}
