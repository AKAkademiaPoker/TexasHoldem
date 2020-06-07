package Menu;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MenuTypes {
	private Map<String, List<MenuPoint>> menus;
	private final List<String> menuTypes = new ArrayList<String>(List.of("bejelentkezés", "játék indítása", "statisztika", "limitek", "játék"));

	{
		this.menus = new HashMap<>();
		menus.put(menuTypes.get(0), List.of(MenuPoint.RULES, MenuPoint.LOGIN, MenuPoint.SIGN_UP));
		menus.put(menuTypes.get(1), List.of(MenuPoint.DEPOSIT, MenuPoint.PAYMENT, MenuPoint.GAME_START, MenuPoint.HALL_OF_FRAME));
		menus.put(menuTypes.get(2), List.of(MenuPoint.TOP_10, MenuPoint.TOP_10_MONTH, MenuPoint.POKER_HANDS, MenuPoint.TO_PREVIOUS));
		menus.put(menuTypes.get(3), List.of(MenuPoint.FIX_LIMIT, MenuPoint.NO_LIMIT, MenuPoint.POT_LIMIT));
		menus.put(menuTypes.get(4), List.of(MenuPoint.CALL, MenuPoint.FOLD, MenuPoint.RAISE, MenuPoint.CHECK));
	}

	public List<MenuPoint> getMenuList(String key) {
		return menus.get(key);
	}

	public List<String> getMenuTypes() {
		return menuTypes;
	}

	public Map<String, List<MenuPoint>> getMenus() {
		return menus;
	}

}
