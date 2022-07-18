package ch03;

import java.util.Stack;

/*
올바른 괄호
        괄호가 입력되면 올바른 괄호이면 “YES", 올바르지 않으면 ”NO"를 출력합니다.
        (())() 이것은 괄호의 쌍이 올바르게 위치하는 거지만, (()()))은 올바른 괄호가 아니다
*/

public class stack01 {

    public String solution(String s){

        Stack<Character> stack = new Stack<>();

        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                stack.push(ch);
            } else {
                if (stack.empty()) {
                    return "NO";
                } else {
                    stack.pop();
                }
            }
        }

        if (stack.empty()) {
            return "YES";
        } else {
            return "NO";
        }

    }

    public static void main(String[] args){
        stack01 T = new stack01();

        System.out.println(T.solution("(()(()))(()"));
        System.out.println(T.solution("(()))("));
        System.out.println(T.solution("(())()((()))"));
    }

}
