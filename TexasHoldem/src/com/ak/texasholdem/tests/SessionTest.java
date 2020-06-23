package com.ak.texasholdem.tests;

import com.ak.texasholdem.board.Board;
import com.ak.texasholdem.cards.Deck;
import com.ak.texasholdem.game.Session;
import com.ak.texasholdem.player.Player;
import com.ak.texasholdem.player.Players;

public class SessionTest {

	public static void main(String[] args) {

		Board board = new Board();
		Players players = new Players();
		players.addPlayer(new Player("AAA", "", ""));
		players.addPlayer(new Player("BBB", "", ""));
		players.addPlayer(new Player("CCC", "", ""));
		players.addPlayer(new Player("DDD", "", ""));

		Deck deck = new Deck();
		Session session = new Session(board, players, deck);
		session.run();
		// TODO Auto-generated method stub

	}

}
