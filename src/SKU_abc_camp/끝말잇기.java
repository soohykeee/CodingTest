package SKU_abc_camp;

import java.util.ArrayDeque;
import java.util.Deque;

public class 끝말잇기 {

    public boolean solution(String[] words) {
        boolean answer = true;

        Deque<String> deque = new ArrayDeque<>();

        deque.addLast(words[0]);

        for (int i = 1; i < words.length; i++) {
            if (deque.contains(words[i])) {
                answer = false;
                break;
            }

            String lastWord = deque.getLast();

            if (lastWord.charAt(lastWord.length() - 1) == words[i].charAt(0)) {
                deque.addLast(words[i]);
            } else {
                answer = false;
                break;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        끝말잇기 T = new 끝말잇기();

        System.out.println(T.solution(new String[]{"tank", "kick", "know", "wheel", "land", "dream"}));
        System.out.println(T.solution(new String[]{"tank", "kick", "know", "wheel", "land", "dream", "mother", "robot", "tank"}));

    }
}
