package SKU_abc_camp;

import java.util.ArrayDeque;
import java.util.Deque;

public class 올바른괄호 {
    boolean solution(String s) {

        Deque<Character> deque = new ArrayDeque<>();

        if (s.charAt(0) == ')') {
            return false;
        }

        deque.addLast(s.charAt(0));
        for (int i = 1; i < s.length(); i++) {
            if (deque.size() == 0) {
                if (s.charAt(i) == ')') {
                    return false;
                }
            }

            if (s.charAt(i) == ')') {
                deque.removeLast();
            } else {
                deque.addLast(s.charAt(i));
            }
        }

        if (deque.size() == 0) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        올바른괄호 T = new 올바른괄호();

        System.out.println(T.solution("()()"));
        System.out.println(T.solution("(())()"));
        System.out.println(T.solution(")()("));
        System.out.println(T.solution("(()("));

    }
}
