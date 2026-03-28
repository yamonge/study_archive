package hashMap응용;

import java.util.HashMap;
import java.util.Map;

public class MenuService {
    private final Map<String, Menu> map = new HashMap<>();

    public MenuService() {
        addMenu(new Menu("아메리카노", 3000, "음료", "커피의 기본 메뉴입니다."));
        addMenu(new Menu("카페라떼", 3500, "음료", "우유가 들어간 부드러운 커피입니다."));
        addMenu(new Menu("카푸치노", 3500, "음료", "에스프레소와 스팀 밀크가 어우러진 커피입니다."));
        addMenu(new Menu("카라멜 마끼아또", 4000, "음료", "카라멜 시럽이 들어간 달콤한 커피입니다."));
        addMenu(new Menu("바닐라 라떼", 4000, "음료", "바닐라 시럽이 들어간 부드러운 커피입니다."));
    }

    public void addMenu(Menu menu) {
        map.put(menu.getName(), menu);
    }

    public Menu getMenu(String name) {
        return map.get(name);
    }

    public void updateMenu(String name, Menu menu) {
        if (map.containsKey(name)) {
            map.put(name, menu);
        } else {
            System.out.println("메뉴가 존재하지 않습니다.");
        }
    }

    public void deleteMenu(String name) {
        if (map.containsKey(name)) {
            map.remove(name);
        } else {
            System.out.println("메뉴가 존재하지 않습니다.");
        }
    }

    public void printAllMenus() {
        for (Menu menu : map.values()) {
            System.out.println(menu);
        }
    }
}
