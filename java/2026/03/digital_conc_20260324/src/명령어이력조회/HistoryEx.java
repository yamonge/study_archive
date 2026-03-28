package 명령어이력조회;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class HistoryEx {
    final static Stack<String> stack = new Stack<>();
    final static int MAX_SIZE = 10;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(true){
            System.out.print("입력: ");
            String cmd = sc.nextLine().trim();
            if(cmd.equalsIgnoreCase("q")){
                System.exit(0);
            }else if(cmd.equalsIgnoreCase("help")){
                System.out.println("help - 도움말 보여 줍니다.");
                System.out.println("q 또는 Q - 프로그램 종료");
                System.out.println("history - 최근 명령어" + MAX_SIZE + "개 보여 줍니다.");
            }else if(cmd.equalsIgnoreCase("history")){
                int cnt = 0;
                for(String e: stack){
                    cnt++;
                    System.out.println(cnt + ". " + e);
                }
            }else{
                save(cmd);
                System.out.println(cmd);
            }
        }
    }

    static void save(String cmd){
        stack.push(cmd);
        if(stack.size() > MAX_SIZE){
            int cnt = 0;
            for(String e: stack){
                cnt++;
                System.out.println(cnt + ". " + e);
            }
            stack.pop();
        }
    }
}
