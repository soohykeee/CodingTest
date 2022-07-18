package ch03;

/*
쇠막대기
        여러 개의 쇠막대기를 레이저로 절단하려고 한다. 효율적인 작업을 위해서 쇠막대기를 아래에
        서 위로 겹쳐 놓고, 레이저를 위에서 수직으로 발사하여 쇠막대기들을 자른다. 쇠막대기와 레
        이저의 배치는 다음 조건을 만족한다.
*/

import java.util.Stack;

public class stack04 {

    public int solution(String s) {

        int answer = 0;
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(s.charAt(i));
            } else {
                stack.pop();
                if (s.charAt(i - 1) == '(') {
                    answer += stack.size();
                } else {
                    answer++;
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        stack04 T = new stack04();

        System.out.println(T.solution("()(((()())(())()))(())"));
        System.out.println(T.solution("(((()(()()))(())()))(()())"));
    }
}
