package com.ak.texasholdem.menu;

public enum MenuPoint {
	RULES("Játékszabály"),
	LOGIN("Bejelentkezés"),
	SIGN_UP("Regisztráció"),
	DEPOSIT("Befizetés"),
	PAYMENT("Kifizetés"),
	GAME_START("Játék indítása"),
	HALL_OF_FRAME("Statisztika"),
	TOP_10("Top 10"),
	TOP_10_MONTH("Top 10 ebben a honapban"),
	POKER_HANDS("Póker kezek"),
	FIX_LIMIT("Fix limit"),
	NO_LIMIT("No limit"),
	POT_LIMIT("Pot limit"),
	CALL("Tartás"),
	FOLD("Eldobás"),
	RAISE("Emelés"),
	CHECK("Passzolás"),
	TO_PREVIOUS("Az előző menűhöz"),
	ERROR("Hibás");

	private String onHUN;

	MenuPoint(String onHUN) {
		this.onHUN = onHUN;
	}

	public String getOnHUN() {
		return onHUN;
	}

}
