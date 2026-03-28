package hashMap응용;

import java.util.Scanner;

public class HashMain {
    private static final MenuService menuService = new MenuService();
    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        while(true){
            System.out.println("1. 메뉴 추가");
            System.out.println("2. 메뉴 조회");
            System.out.println("3. 메뉴 수정");
            System.out.println("4. 메뉴 삭제");
            System.out.println("5. 전체 메뉴 출력");
            System.out.println("0. 종료");
            System.out.print("선택: ");
            int choice = sc.nextInt();
            sc.nextLine(); // 버퍼 비우기
            System.out.println();

            switch (choice) {
                case 1:
                    addMenu();
                    break;
                case 2:
                    getMenu();
                    break;
                case 3:
                    updateMenu();
                    break;
                case 4:
                    deleteMenu();
                    break;
                case 5:
                    menuService.printAllMenus();
                    break;
                case 0:
                    System.out.println("프로그램을 종료합니다.");
                    return;
                default:
                    System.out.println("잘못된 선택입니다. 다시 시도하세요.");
            }
        }
    }

    private static void addMenu() {
        System.out.print("메뉴 이름: ");
        String name = sc.nextLine();
        System.out.print("가격: ");
        int price = sc.nextInt();
        sc.nextLine(); // 버퍼 비우기
        System.out.print("카테고리: ");
        String category = sc.nextLine();
        System.out.print("설명: ");
        String desc = sc.nextLine();

        Menu menu = new Menu(name, price, category, desc);
        menuService.addMenu(menu);
    }

    private static void getMenu() {
        System.out.print("조회할 메뉴 이름: ");
        String name = sc.nextLine();
        Menu menu = menuService.getMenu(name);
        if (menu != null) {
            System.out.println(menu);
        } else {
            System.out.println("메뉴가 존재하지 않습니다.");
        }
    }

    private static void updateMenu() {
        System.out.print("수정할 메뉴 이름: ");
        String name = sc.nextLine();
        Menu existingMenu = menuService.getMenu(name);
        if (existingMenu != null) {
            System.out.print("새로운 가격: ");
            int price = sc.nextInt();
            sc.nextLine(); // 버퍼 비우기
            System.out.print("새로운 카테고리: ");
            String category = sc.nextLine();
            System.out.print("새로운 설명: ");
            String desc = sc.nextLine();

            Menu updatedMenu = new Menu(name, price, category, desc);
            menuService.updateMenu(name, updatedMenu);
        } else {
            System.out.println("메뉴가 존재하지 않습니다.");
        }
    }

    private static void deleteMenu() {
        System.out.print("삭제할 메뉴 이름: ");
        String name = sc.nextLine();
        menuService.deleteMenu(name);
    }
}
