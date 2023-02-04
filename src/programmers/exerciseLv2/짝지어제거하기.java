package programmers.exerciseLv2;

import java.util.Stack;

/*
짝지어 제거하기 - 2017 팁스타운 lv.2

 */
public class 짝지어제거하기 {

    public int solution(String s) {
        int answer = 0;
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            if (stack.isEmpty()) {
                stack.push(s.charAt(i));
            } else {
                if (stack.peek().equals(s.charAt(i))) {
                    stack.pop();
                } else {
                    stack.push(s.charAt(i));
                }
            }
        }

        if (stack.isEmpty()) {
            answer = 1;
        }

        return answer;
    }

    public static void main(String[] args) {
        짝지어제거하기 T = new 짝지어제거하기();

        System.out.println(T.solution("baabaa"));
        System.out.println(T.solution("cdcd"));

    }

}
