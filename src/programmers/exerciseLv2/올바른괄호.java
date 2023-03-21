package programmers.exerciseLv2;

import java.util.Stack;

/*
올바른 괄호 - 스택/큐 lv.2

 */
public class 올바른괄호 {

    public boolean solution(String s) {
        boolean answer = true;

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push('(');
            } else {
                if (stack.empty()) {
                    return false;
                } else {
                    stack.pop();
                }
            }
        }

        if (!stack.empty()) answer = false;

        return answer;
    }

    public static void main(String[] args) {
        올바른괄호 T = new 올바른괄호();

        System.out.println(T.solution("()()"));
        System.out.println(T.solution("(())()"));
        System.out.println(T.solution(")()("));
        System.out.println(T.solution("(()("));

    }

}
