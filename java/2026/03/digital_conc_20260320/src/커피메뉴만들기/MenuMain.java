package 커피메뉴만들기;

import java.util.Scanner;

public class MenuMain {
    public static void main(String[] args) {
        MenuService service = new MenuService();
        Scanner scanner = new Scanner(System.in);
        service.initMenu();

        while(true){
            System.out.println("[1] 조회 [2] 등록 [3] 수정 [4] 삭제 [5] 검색 [6] 종료");
            System.out.print("메뉴를 선택하세요: ");
            int choice = scanner.nextInt();

            switch (choice){
                case 1 : printMenuList(service.getMenuList()); break;
                case 2 : addMenu(service, scanner); break;
                case 3 : updateMenu(service, scanner); break;
                case 4 : deleteMenu(service, scanner); break;
                case 5 : searchMenu(service, scanner); break;
                case 6 : System.out.println("프로그램을 종료합니다."); return;
                default: System.out.println("잘못된 입력입니다. 다시 시도하세요."); break;
            }
        }
    }

    // 커피 목록 출력
    private static void printMenuList(java.util.List<CoffeeMenu> menuList) {
        System.out.println("커피 메뉴 목록:");
        for (CoffeeMenu menu : menuList) {
            System.out.println(menu);
        }
    }

    // 신규 메뉴 압력
    private static void addMenu(MenuService service, Scanner scanner) {
        System.out.print("메뉴 이름: ");
        String name = scanner.next();
        scanner.nextLine(); // 버퍼 비우기
        System.out.print("가격: ");
        int price = scanner.nextInt();
        System.out.print("카테고리: ");
        String category = scanner.next();
        System.out.print("설명: ");
        String desc = scanner.next();
        System.out.print("세금 포함 여부 (1/0): ");
        boolean isTax = scanner.nextInt() == 1;

        CoffeeMenu newMenu = new CoffeeMenu(name, price, category, desc, isTax);
        service.addmenu(newMenu);
        System.out.println("메뉴가 추가되었습니다.");
    }

    // 수정 메뉴 입력
    private static void updateMenu(MenuService service, Scanner scanner) {
        System.out.print("수정할 메뉴의 인덱스: ");
        int index = scanner.nextInt();
        System.out.print("새로운 메뉴 이름: ");
        String name = scanner.next();
        System.out.print("새로운 가격: ");
        int price = scanner.nextInt();
        System.out.print("새로운 카테고리: ");
        String category = scanner.next();
        System.out.print("새로운 설명: ");
        String desc = scanner.next();
        System.out.print("세금 포함 여부 (1/0): ");
        boolean isTax = scanner.nextInt() == 1;

        CoffeeMenu updatedMenu = new CoffeeMenu(name, price, category, desc, isTax);
        if (service.updateMenu(index, updatedMenu)) {
            System.out.println("메뉴가 수정되었습니다.");
        } else {
            System.out.println("유효하지 않은 인덱스입니다.");
        }
    }

    // 삭제 메뉴 입력
    private static void deleteMenu(MenuService service, Scanner scanner) {
        System.out.print("삭제할 메뉴의 인덱스: ");
        int index = scanner.nextInt();

        if (service.deleteMenu(index, null)) {
            System.out.println("메뉴가 삭제되었습니다.");
        } else {
            System.out.println("유효하지 않은 인덱스입니다.");
        }
    }

    // 검색 메뉴 입력
    private static void searchMenu(MenuService service, Scanner scanner) {
        System.out.print("검색할 메뉴 이름: ");
        String name = scanner.next();
        CoffeeMenu menu = service.searchMenu(name);
        if (menu != null) {
            System.out.println("검색 결과:");
            System.out.println(menu);
        } else {
            System.out.println("해당 이름의 메뉴가 없습니다.");
        }
    }
}
