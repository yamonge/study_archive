package 커피메뉴만들기;

import java.util.ArrayList;
import java.util.List;

public class MenuService {
    private final List<CoffeeMenu> menuList;

    public MenuService(){
        menuList = new ArrayList<>();
    }

    public void initMenu(){
        menuList.add(new CoffeeMenu("아메리카노", 3000, "커피", "기본 커피 메뉴", true));
        menuList.add(new CoffeeMenu("카페라떼", 3500, "커피", "우유가 들어간 커피 메뉴", true));
        menuList.add(new CoffeeMenu("카푸치노", 4000, "커피", "우유 거품이 있는 커피 메뉴", true));
        menuList.add(new CoffeeMenu("에스프레소", 2500, "커피", "진한 커피 메뉴", true));
        menuList.add(new CoffeeMenu("녹차 라떼", 3500, "차", "녹차가 들어간 라떼 메뉴", true));
        menuList.add(new CoffeeMenu("홍차 라떼", 3500, "차", "홍차가 들어간 라떼 메뉴", true));
    }

    public void addmenu(CoffeeMenu menu){
        menuList.add(menu);
    }

    public CoffeeMenu searchMenu(String name){
        for(CoffeeMenu menu : menuList){
            if(menu.getName().equals(name)){
                return menu;
            }
        }
        return null;
    }

    public List<CoffeeMenu> getMenuList() {
        return menuList;
    }

    public boolean updateMenu(int index, CoffeeMenu menu){
        if(index >= 0 && index < menuList.size()){
            menuList.set(index, menu);
            return true;
        }else{
            return false;
        }
    }

    public boolean deleteMenu(int index, CoffeeMenu menu){
        if(index >= 0 && index < menuList.size()){
            menuList.remove(index);
            return true;
        }else{
            return false;
        }
    }
}
