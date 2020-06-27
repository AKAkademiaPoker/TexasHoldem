package com.ak.texasholdem.menu;

public enum MenuPoint {
	RULES("J�t�kszab�lyok"),
	LOGIN("Bejelentkez�s"),
	SIGN_UP("Regisztr�ci�"),
	DEPOSIT("Befizet�s"),
	PAYMENT("Kifizet�s"),
	GAME_START("J�t�k ind�t�sa"),
	HALL_OF_FRAME("Statisztika"),
	TOP_10("Top 10"),
	TOP_10_MONTH("Top 10 ebben a honapban"),
	POKER_HANDS("P�ker kezek"),
	FIX_LIMIT("Fix limit"),
	NO_LIMIT("No limit"),
	POT_LIMIT("Pot limit"),
	CALL("Tart�s"),
	FOLD("Eldob�s"),
	RAISE("Emel�s"),
	CHECK("Passzol�s"),
	TO_PREVIOUS("Az el�z� men�h�z"),
	ERROR("Hib�s");

	private String onHUN;

	MenuPoint(String onHUN) {
		this.onHUN = onHUN;
	}

	public String getOnHUN() {
		return onHUN;
	}

}
