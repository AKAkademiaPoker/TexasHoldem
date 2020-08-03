package com.ak.texasholdem.winconditions;

import java.util.ArrayList;
import java.util.List;

import com.ak.texasholdem.player.Player;

public class WinnerSearcher {

	private List<Player> players;

	public WinnerSearcher(List<Player> players) {
		super();
		this.players = players;
	}

	public List<Player> getWinner() {
		List<Player> winners = new ArrayList<>();
		for (Player player : players) {
			if (player.isInGame()) {
				winners.add(player);
				break;
			}
		}
		for (int i = 0; i < players.size(); i++) {
			if (players.get(i).isInGame()) {
				if(players.get(i).getBestHandType().getValue() == winners.get(0).getBestHandType().getValue()) {
					winners.add(players.get(i));
				}
				if (winners.get(0).getBestHandType().getValue() < players.get(i).getBestHandType().getValue()) {
					winners.removeAll(winners);
					winners.add(players.get(i));
				}
				
			}
		}
		return winners;
	}
	
	

}
