package 연습문제3;

public class CreateMenu {
    public void create(String title, String ...menus){
        System.out.println("=========================");
        System.out.printf("            %s           \n", title);
        System.out.println("=========================");
        for(int i = 0; i < menus.length; i++){
            System.out.printf("%d. %s \n", (i + 1), menus[i]);
        }
        System.out.println("0. 나가기");
        System.out.print("숫자 입력: ");
    }
}
