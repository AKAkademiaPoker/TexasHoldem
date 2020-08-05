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
		players.addPlayerToTheBoard(new Player("AAA", "", "", 5000));
		players.addPlayerToTheBoard(new Player("BBB", "", "", 5000));
		players.addPlayerToTheBoard(new Player("CCC", "", "", 5000));
		players.addPlayerToTheBoard(new Player("DDD", "", "", 5000));
		

		Deck deck = new Deck();
		System.out.println("game over");
	}
}
