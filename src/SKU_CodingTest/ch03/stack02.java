package SKU_CodingTest.ch03;

/*
괄호문자제거
        입력된 문자열에서 소괄호 ( ) 사이에 존재하는 모든 문자를 제거하고 남은 문자만 출력하는
        프로그램을 작성하세요.
*/

import java.util.Stack;

public class stack02 {

    /*public String solution(String s) {

        String answer="";

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != ')') {
                stack.push(s.charAt(i));
            } else {
                while (!stack.peek().equals('(')) {
                    stack.pop();
                }
                stack.pop();
            }
        }
        answer = String.valueOf(stack);

        return answer;
    }*/

    public String solution(String s) {

        String answer="";
        Stack<Character> stack = new Stack<>();

        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                stack.push(ch);
            } else if (ch == ')') {
                if (stack.empty()) {
                    break;
                } else {
                    stack.pop();
                }
            } else {
                if (stack.empty()) {
                    answer += ch;
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        stack02 T = new stack02();

        System.out.println(T.solution("(A(BC)D)EF(G(H)(IJ)K)LM(N)"));
    }
}
