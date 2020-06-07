package Models;

import java.util.ArrayList;
import java.util.List;

public class Board {

	private List<Card> cardsOnBoard;

	public Board() {
		super();
		cardsOnBoard = new ArrayList<Card>();
	}

	public List<Card> getCardsOnBoard() {
		return cardsOnBoard;
	}

	public void setCardsOnBoard(List<Card> cardsOnBoard) {
		this.cardsOnBoard = cardsOnBoard;
	}

}
