package 시스템출력실습;

public class SystemOutEx {
    public static void main(String[] args) {
        String name  = "홀길동";
        int age = 25;
        String habit = "코딩, 독서, 운동";
        String words = "안녕하세요,  잘부탁드립니다!";

        System.out.println("================================");
        System.out.println("\t\t나를 소개합니다!\t");
        System.out.println("================================");
        System.out.println("이름 \t: " + name);
        System.out.println("나이 \t: " + age);
        System.out.println("취미 \t: " + habit);
        System.out.println("한마디 \t: \"" + words + "\"");
        System.out.println("================================");
        System.out.println();
        System.out.println();
        System.out.println();


        String drink1 = "아메리카노";
        String drink2 = "카페라떼";
        String drink3 = "치즈케이크";

        int count1 = 2;
        int count2 = 1;
        int count3 = 1;

        int price1 = 4500;
        int price2 = 5500;
        int price3 = 6800;

        int totalPrice = (count1 * price1) + (count2 * price2) + (count3 * price3);

        String total1 = String.format("%,d", (count1 * price1));
        String total2 = String.format("%,d", (count2 * price2));
        String total3 = String.format("%,d", (count3 * price3));
        String total4 = String.format("%,d", totalPrice);


        System.out.printf("==============================\n");
        System.out.printf("\t☕ JAVA CAFE 영수증\t\n");
        System.out.printf("==============================\n");
        System.out.printf("%-15s %d잔 %5s원\n", drink1, count1, total1);
        System.out.printf("%-15s %d잔 %5s원\n", drink2, count2, total2);
        System.out.printf("%-15s %d잔 %5s원\n", drink3, count3, total3);
        System.out.printf("------------------------------\n");
        System.out.printf("%-15s %10s원\n", "합 계", total4);
        System.out.printf("==============================\n");
        System.out.printf("감사합니다. 또 방문해주세요!\n");

        System.out.printf("─────────────────────\n");
        System.out.printf("\t%4s \t%-2s\n", "구구단", "3단");
        System.out.printf("─────────────────────\n");
        System.out.printf("%d x %d = %2d\n", 3, 1, 3);
        System.out.printf("%d x %d = %2d\n", 3, 2, 6);
        System.out.printf("%d x %d = %2d\n", 3, 3, 9);
        System.out.printf("%d x %d = %2d\n", 3, 4, 12);
        System.out.printf("%d x %d = %2d\n", 3, 5, 15);
        System.out.printf("%d x %d = %2d\n", 3, 6, 18);
        System.out.printf("%d x %d = %2d\n", 3, 7, 21);
        System.out.printf("%d x %d = %2d\n", 3, 8, 24);
        System.out.printf("%d x %d = %2d\n", 3, 9, 27);

        System.out.printf("─────────────────────\n");
        System.out.printf("\t%4s \t%-2s\n", "구구단", "3단");
        System.out.printf("─────────────────────\n");
        for(int i = 1; i <= 9; i++){
            System.out.printf("%d x %d = %2d\n", 3, i, (3 * i));
        }

    }
}
