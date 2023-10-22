package SKU_abc_camp;

import java.util.ArrayDeque;
import java.util.Deque;

public class JadenCase문자열만들기 {

    public String solution(String s) {
        String answer = "";

        Deque<Character> deque = new ArrayDeque<>();

        if (!Character.isDigit(s.charAt(0))) {
            deque.add(Character.toUpperCase(s.charAt(0)));
        } else {
            deque.add(s.charAt(0));
        }

        for (int i = 1; i < s.length(); i++) {
            if (deque.getLast() == ' ') {
                deque.addLast(Character.toUpperCase(s.charAt(i)));
            } else {
                deque.addLast(Character.toLowerCase(s.charAt(i)));
            }
        }

        StringBuffer sb = new StringBuffer();
        int length = deque.size();
        for (int i = 0; i < length; i++) {
            sb.append(deque.removeFirst());
        }

        answer = sb.toString();

        return answer;
    }

    public static void main(String[] args) {
        JadenCase문자열만들기 T = new JadenCase문자열만들기();

        System.out.println(T.solution("3people unFollowed me"));
        System.out.println(T.solution("for the last week"));

    }
}
