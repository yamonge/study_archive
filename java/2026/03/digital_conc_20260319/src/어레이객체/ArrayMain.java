package 어레이객체;

import java.util.ArrayList;
import java.util.List;

public class ArrayMain {
    public static void main(String[] args) {
        List<Menu> book = new ArrayList<>();
        book.add(new Menu("김치찌개", 8000, "한식", "정말 맛있는 가정식 찌개"));
        book.add(new Menu("제육볶음", 9000, "한식", "리얼 밥도둗 제육볶음"));
        book.add(new Menu("오므라이스", 10000, "일식", "특별한 요리를 맛보세용"));
        for(Menu menu : book){
            System.out.println(menu);
        }
    }
}

class Menu{
    String name;
    int price;
    String category;
    String description;

    public Menu(String name, int price, String category, String description) {
        this.name = name;
        this.price = price;
        this.category = category;
        this.description = description;
    }

    @Override
    public String toString(){
        return "이름: " + name + "\n" + "가격: " + price + "\n" + "분류: " + category + "\n" + "설명: " + description + "\n";
    }
}
