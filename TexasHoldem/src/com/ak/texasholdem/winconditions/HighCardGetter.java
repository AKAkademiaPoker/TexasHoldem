package com.ak.texasholdem.winconditions;

import java.util.ArrayList;
import java.util.List;

import com.ak.texasholdem.cards.Card;
import com.ak.texasholdem.player.Player;

public interface HighCardGetter {
	
	default public List<Card> getHighCard(Player player) {
		List<Card> highCardInHand = new ArrayList<>();
		highCardInHand.add(player.getCard1());
		highCardInHand.add(player.getCard2());
		highCardInHand.removeAll(player.getBestCards());
		return highCardInHand;
	}

}
