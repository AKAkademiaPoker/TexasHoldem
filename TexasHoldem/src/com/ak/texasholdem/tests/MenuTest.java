package com.ak.texasholdem.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.jupiter.api.Test;

import com.ak.texasholdem.menu.Menu;
import com.ak.texasholdem.menu.MenuPoint;

public class MenuTest {
	private Menu menu = new Menu("bejelentkezés");

	@Test
	void givenMenu_WhenGivenNegativeNumber_ThenReturnWithErrorMenuPoint() {
		// given

		// when
		int input = -1;
		MenuPoint actual = menu.getMenuPoint(input);
		// then
		assertEquals(MenuPoint.ERROR, actual);
	}

	@Test
	void givenMenu_WhenGivenNumberBiggerThenMenuPoint_ThenReturnWithErrorMenuPoint() {
		// given

		// when
		int input = 100;
		MenuPoint actual = menu.getMenuPoint(input);
		// then
		assertEquals(MenuPoint.ERROR, actual);

	}

	@Test
	void givenMenu_WhenGivenNumberOfCorrectMenuPoint_ThenReturnWithNotErrorMenuPoint() {
		// given

		// when
		int input = 1;
		MenuPoint actual = menu.getMenuPoint(input);
		// then
		assertNotEquals(MenuPoint.ERROR, actual);
	}

}
