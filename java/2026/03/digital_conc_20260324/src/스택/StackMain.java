package 스택;

// Stack LIFO(Last In First Out) 구조 : 나중에 저장된 자료가 먼저 제거되는 구조

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class StackMain {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(10); // 스택에 요소 추가
        stack.push(20);
        stack.push(30);

        //일반적인 리스트
        List<Integer> list = new ArrayList<>();
        list.add(10);
        list.add(20);
        list.add(30);

        System.out.println(list.get(0));
        System.out.println(stack.get(0));
        System.out.println(stack.peek());
        System.out.println(stack.pop());
        System.out.println(stack.empty());
        System.out.println(stack.size());
        System.out.println(stack.contains(20));

        for(Integer e: stack){
            System.out.println(e);
        }
    }
}
