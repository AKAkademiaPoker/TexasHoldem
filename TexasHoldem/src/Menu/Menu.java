package Menu;

import java.util.List;

public class Menu {
	private List<MenuPoint> menuList;
	private String menuType;

	public Menu() {
		MenuTypes menuTypes = new MenuTypes();
		this.menuType = menuTypes.getMenuTypes().get(0);
		menuList = menuTypes.getMenuList(menuType);
	}

	public Menu(String menuType) {
		this.menuType = menuType;
		menuList = new MenuTypes().getMenuList(menuType);
	}

	public void setMenu(String key) {
		this.menuType = key;
		this.menuList = new MenuTypes().getMenuList(key);
	}

	public void print() {
		System.out.println("Kérem, válasszon az alábbi menüpontok között:");
		for (int i = 0; i < menuList.size(); i++) {
			System.out.println((i + 1) + ". " + menuList.get(i).getOnHUN());
		}
	}

	public MenuPoint getMenuPoint(int input) {
		int index = input - 1;
		if (index >= 0 && input < menuList.size()) {
			return menuList.get(index);
		}
		return MenuPoint.ERROR;
	}

	public void setNextMenu(MenuPoint menuPoint) {
		MenuTypes menuTypes = new MenuTypes();
		if (menuType.equals(menuTypes.getMenuTypes().get(0)) && menuPoint.equals(MenuPoint.SIGN_UP)) {
			setMenu(menuTypes.getMenuTypes().get(1));
		} else if (menuType.equals(menuTypes.getMenuTypes().get(1)) && menuPoint.equals(MenuPoint.HALL_OF_FRAME)) {
			setMenu(menuTypes.getMenuTypes().get(2));
		} else if (menuType.equals(menuTypes.getMenuTypes().get(1)) && menuPoint.equals(MenuPoint.GAME_START)) {
			setMenu(menuTypes.getMenuTypes().get(3));
		} else if (menuType.equals(menuTypes.getMenuTypes().get(2)) && menuPoint.equals(MenuPoint.TO_PREVIOUS)) {
			setMenu(menuTypes.getMenuTypes().get(1));
		} else if (menuType.equals(menuTypes.getMenuTypes().get(3))
				&& (menuPoint == null || !menuPoint.equals(MenuPoint.ERROR))) {
			setMenu(menuTypes.getMenuTypes().get(4));
		} else if (menuType.equals(menuTypes.getMenuTypes().get(4))
				&& (menuPoint == null || !menuPoint.equals(MenuPoint.ERROR))) {
			setMenu(menuTypes.getMenuTypes().get(1));
		}

	}

}
