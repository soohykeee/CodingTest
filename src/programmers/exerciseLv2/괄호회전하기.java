package programmers.exerciseLv2;

/*
괄호 회전하기 - 월간 코드 챌린지 시즌2 lv.2

 */

import java.util.Stack;

public class 괄호회전하기 {

    public int solution(String s) {
        int answer = 0;
        String str = s;

        for (int i = 0; i < s.length(); i++) {
            if (check(str)) answer++;
            str = str.substring(1) + str.charAt(0);
        }

        return answer;
    }

    public boolean check(String str) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < str.length(); i++) {

            if (str.charAt(i) == '[' || str.charAt(i) == '{' || str.charAt(i) == '(') {
                stack.push(str.charAt(i));
            }

            if (str.charAt(i) == ']') {
                if (!stack.isEmpty() && stack.peek() == '[') {
                    stack.pop();
                } else {
                    return false;
                }
            } else if (str.charAt(i) == ')') {
                if (!stack.isEmpty() && stack.peek() == '(') {
                    stack.pop();
                } else {
                    return false;
                }
            } else if (str.charAt(i) == '}') {
                if (!stack.isEmpty() && stack.peek() == '{') {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }

        if(stack.isEmpty()) return true;
        else return false;

    }

    public static void main(String[] args) {
        괄호회전하기 T = new 괄호회전하기();

        System.out.println(T.solution("[](){}"));
        System.out.println(T.solution("}]()[{"));
        System.out.println(T.solution("[)(]"));
        System.out.println(T.solution("}}}"));

    }
}
