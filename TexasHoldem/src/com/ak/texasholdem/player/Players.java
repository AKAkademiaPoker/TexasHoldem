package com.ak.texasholdem.player;

import java.util.ArrayList;
import java.util.List;

import com.ak.texasholdem.constants.PokerConstants;

public class Players {

	private List<Player> players = new ArrayList<>();

	public Players() {
		super();
	}

	public List<Player> getPlayers() {
		return players;
	}

	public void addPlayer(Player player) {
		if (!isPlayersFull()) {
			players.add(player);
		} else {
			// TODO: Exception: board is full...
			System.out.println("The board is full. Try another one.");
		}
	}

	private boolean isPlayersFull() {
		return players.size() >= PokerConstants.MAX_PLAYER;
	}
	
	public void setAllNotChecked() {
		for (Player player : players) {
			player.setChecked(false);
		}
	}

}
