package 상속TV;

public class CreateMenu {
    public void creatMenu(String title, String exit, String ...menus){
        System.out.println("=======================");
        System.out.printf("      %s         \n", title);
        System.out.println("=======================");
        for(int i = 0; i < menus.length; i++){
            System.out.printf("%d. %s \n", (i + 1), menus[i]);
        }
        System.out.printf("0. %s\n", exit);
        System.out.print("번호 입력: ");
    }
}
