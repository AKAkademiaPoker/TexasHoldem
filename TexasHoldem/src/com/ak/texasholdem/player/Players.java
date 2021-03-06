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

	public void addPlayerToTheBoard(User player) {
		if (!isPlayersFull()) {
			players.add((Player) player);
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

	public boolean isMinTwoPlayerInGame() {
		int playersInGame = 0;
		for (Player player : players) {
			if (player.isInGame()) {
				playersInGame++;
			}
		}
		if (playersInGame >= 2) {
			return true;
		}
		return false;
	}

	public void setChecks() {
		for (Player player : players) {
			player.setChecked(false);
		}
	}

	public void readyToPlay() {
		for (Player player : players) {
			player.setInGame(true);

		}
	}

	public Player getLastInGame() {

		for (int i = 0; i < players.size(); i++) {
			if (players.get(i).isInGame()) {
				return players.get(i);
			}
		}
		return null;

	}

	public boolean isEveryoneChecked() {
		for (Player player : players) {
			if (!player.getIsChecked()) {
				return false;
			}
		}
		return true;
	}

	public boolean onlyOneNotChecked() {
		int counter = 0;
		for (Player player : players) {
			if (!player.getIsChecked()) {
				counter++;
			}
		}
		return counter <= 1;
	}

	public void removeBankruptPlayers() {
		for (Player player : players) {
			if (player.getCash() <= 0) {
				players.remove(player);
			}
		}
	}
}
