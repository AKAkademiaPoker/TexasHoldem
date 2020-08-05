package com.ak.texasholdem.tests;

import com.ak.texasholdem.board.Board;
import com.ak.texasholdem.cards.Deck;
import com.ak.texasholdem.game.Game;
import com.ak.texasholdem.player.Player;
import com.ak.texasholdem.player.Players;

public class GameTest {
	public static void main(String[] args) {
		Board board = new Board();
		Deck deck = new Deck();
		Players players = new Players();
		players.addPlayerToTheBoard(new Player("Player 1", "", "", 5000));
		players.addPlayerToTheBoard(new Player("Player 2", "", "", 5000));
		players.addPlayerToTheBoard(new Player("Player 3", "", "", 1000));
		players.addPlayerToTheBoard(new Player("Player 4", "", "", 1000));
//		players.addPlayerToTheBoard(new Player("Player 5", "", "", 1000));
//		players.addPlayerToTheBoard(new Player("Player 6", "", "", 1000));
//		players.addPlayerToTheBoard(new Player("Player 7", "", "", 1000));
//		players.addPlayerToTheBoard(new Player("Player 8", "", "", 1000));
//		players.addPlayerToTheBoard(new Player("Player 9", "", "", 1000));
//		players.addPlayerToTheBoard(new Player("Player 10", "", "", 1000));
//		players.addPlayerToTheBoard(new Player("Player 11", "", "", 1000));
//		players.addPlayerToTheBoard(new Player("Player 12", "", "", 1000));
//		players.addPlayerToTheBoard(new Player("Player 13", "", "", 1000));
//		players.addPlayerToTheBoard(new Player("Player 14", "", "", 1000));
		

		Game game = new Game(players, 250);
		game.runGame();
		
	}

}
