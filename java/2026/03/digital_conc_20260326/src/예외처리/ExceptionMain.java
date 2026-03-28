package 예외처리;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ExceptionMain {
    public static void main(String[] args) {
        int[] arr = new int[5];

        try{
            for(int i = 0; i < arr.length; i++){
                arr[i] = i;
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("배열의 범위를 벗어났습니다." + e);
        }

        System.out.println();
        Scanner sc = new Scanner(System.in);
        try{
            System.out.println("나눗셈 계산기 입니다.");
            System.out.print("첫번째 숫자 입력: ");
            int num1 = sc.nextInt();
            System.out.print("두번째 숫자 입력: ");
            int num2 = sc.nextInt();
            System.out.println(num1 + " / " + num2 + " = " + (num1 / num2));
        }catch(InputMismatchException e){
            System.out.println("잘못된 입력입니다." + e);
        }catch(ArithmeticException e){
            System.out.println("0으로 나눌 수 없습니다." + e);
            sc.nextLine();
        }

        BufferedReader br = null;
        try{
            br = new BufferedReader(new FileReader("test.txt"));
            br.readLine();
        }catch(IOException e){
            System.out.println("파일이 없거나 읽을수 없습니다." + e);
        }finally{
            try{
                if(br != null){
                    br.close();
                }
            }catch(IOException ignored){

            }
        }

    }
}
