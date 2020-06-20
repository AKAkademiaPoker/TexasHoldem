package Models;

import java.util.ArrayList;
import java.util.List;

import com.ak.texasholdem.cards.Card;

public class Hand {

	private List<Card> cardsInHand;
	private List<Card> cardsInHandAfterEvaluation;

	public Hand() {
		super();
		cardsInHand = new ArrayList<Card>();
		cardsInHandAfterEvaluation = new ArrayList<Card>();
		;
	}

}
