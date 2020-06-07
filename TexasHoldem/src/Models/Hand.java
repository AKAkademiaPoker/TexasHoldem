package Models;

import java.util.ArrayList;
import java.util.List;

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
