package Tests;

import Menu.Menu;
import Menu.MenuPoint;
import Menu.MenuTypes;

public class MenuTest {

	/**
	 * it is only tests
	 */
	public static void main(String[] args) {
		Menu menu = new Menu();

		menu.print();
		System.out.println();
		menu.setMenu("játék indítása");
		menu.print();
		System.out.println();
		menu.setMenu("statisztika");
		menu.print();
		System.out.println();
		menu.setMenu("limitek");
		menu.print();
		System.out.println();
		menu.setMenu("játék");
		menu.print();
		System.out.println("-------------");
		
		MenuTypes menuTypes=new MenuTypes();
		
		menu.setMenu(menuTypes.getMenuTypes().get(0));
		menu.print();
		System.out.println();
		MenuPoint menuPoint=null;
		menu.setNextMenu(menuPoint);
		menu.print();
		System.out.println();
		menuPoint=MenuPoint.HALL_OF_FRAME;
		menu.setNextMenu(menuPoint);
		menu.print();
		System.out.println();
		menu.setPreviousMenu();
		menu.print();
		System.out.println();
		menuPoint=MenuPoint.GAME_START;
		menu.setNextMenu(menuPoint);
		menu.print();
		System.out.println();
		menu.setNextMenu(menuPoint);
		menu.print();
		System.out.println();
		menu.setNextMenu(menuPoint);
		menu.print();
		System.out.println();
	}

}
