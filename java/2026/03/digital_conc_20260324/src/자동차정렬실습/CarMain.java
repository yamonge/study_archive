package 자동차정렬실습;

import java.util.Comparator;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class CarMain {
    public static Scanner sc = new Scanner(System.in);
    public static Set<Car> cars = new TreeSet<>();
    public static void main(String[] args) {
        while(true){
            System.out.println("1. 자동차 입력");
            System.out.println("2. 자동차 목록 출력");
            System.out.println("3. 프로그램 종료");
            System.out.print("선택: ");
            int choice = sc.nextInt();
            sc.nextLine(); // 버퍼 비우기
            switch (choice){
                case 1:
                    addCar((TreeSet<Car>) cars);
                    break;
                case 2:
                    printCars();
                    break;
                case 3:
                    System.out.println("프로그램을 종료합니다.");
                    System.exit(0);
                default:
                    System.out.println("잘못된 선택입니다.");
            }
        }

    }

    public static void addCar(TreeSet<Car> cars){
        System.out.print("자동차 연식: ");
        int year = sc.nextInt();
        sc.nextLine(); // 버퍼 비우기
        System.out.print("자동차 이름: ");
        String name = sc.nextLine().trim();
        System.out.print("자동차 가격: ");
        int price = sc.nextInt();
        sc.nextLine(); // 버퍼 비우기
        cars.add(new Car(year, name, price));
    }

    public static void printCars(){
        System.out.println("1. 연식순 정렬(오름차순)");
        System.out.println("2. 이름순 정렬(오름차순)");
        System.out.println("3. 가격순 정렬(오름차순)");
        System.out.println("4. 가격순 정렬(내림차순)");
        System.out.println("5. 연식순 정렬(내림차순)");
        System.out.println("6. 이름순 정렬(내림차순)");
        System.out.println("0. 뒤로가기");
        System.out.print("선택: ");
        int choice = sc.nextInt();
        sc.nextLine(); // 버퍼 비우기
        switch (choice){
            case 1:
                function1(new YearComparator());
                break;
            case 2:
                function1(new NameComparator());
                break;
            case 3:
                function1(new PriceComparator());
                break;
            case 4:
                function1(new PriceComparatorDesc());
                break;
            case 5:
                function1(new YearComparatorDesc());
                break;
            case 6:
                function1(new NameComparatorDesc());
                break;
            case 0:
                return;
            default:
                System.out.println("잘못된 선택입니다.");
        }
    }

    public static void function1(Comparator<Car> comparator){
        Set<Car> compCars = new TreeSet<>(comparator);
        compCars.addAll(cars);
        for(Car car : compCars){
            System.out.println(car);
        }
    }
}
