package com.ak.texasholdem.winconditions;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.ak.texasholdem.player.Player;

public class WinnerSearcher {

	private List<Player> players;

	public WinnerSearcher(List<Player> players) {
		super();
		this.players = players;
	}

	public Set<Player> getWinner() {
		List<Player> winners = new ArrayList<>();
		for (Player player : players) {
			if (player.isInGame()) {
				winners.add(player);
				break;
			}
		}
		for (int i = 0; i < players.size(); i++) {
			if (players.get(i).isInGame()) {
				int comparator = winnerComparator(winners.get(0), players.get(i));
				if (comparator == 0) {
					winners.add(players.get(i));
				}
				if (comparator < 0) {
					winners.removeAll(winners);
					winners.add(players.get(i));
				}
			}
		}
		return new HashSet<>(winners);
	}

	private int winnerComparator(Player player1, Player player2) {
		for (int i = 0; i < player1.getBestCards().size(); i++) {
			if (player1.getBestCards().get(i).getRank().getRankValue() > player2.getBestCards().get(i).getRank()
					.getRankValue()) {
				return 1;
			} else if (player1.getBestCards().get(i).getRank().getRankValue() < player2.getBestCards().get(i).getRank()
					.getRankValue()) {
				return -1;
			}
		}
		return 0;
	}

}
