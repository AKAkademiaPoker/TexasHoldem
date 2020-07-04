package com.ak.texasholdem.tests;

import com.ak.texasholdem.board.Board;
import com.ak.texasholdem.cards.Deck;
import com.ak.texasholdem.game.Session;
import com.ak.texasholdem.player.Player;
import com.ak.texasholdem.player.Players;
import com.ak.texasholdem.player.User;

public class SessionTest {

	public static void main(String[] args) {
		System.out.println("game setup");
		Board board = new Board();
		Players players = new Players();
		players.addPlayer(new Player("AAA", "", "", 5000));
		players.addPlayer(new Player("BBB", "", "", 5000));
		players.addPlayer(new Player("CCC", "", "", 5000));
		players.addPlayer(new Player("DDD", "", "", 5000));

		Deck deck = new Deck();
		Session session = new Session(board, players, deck);
		session.run();
		System.out.println("game over");
	}
}
