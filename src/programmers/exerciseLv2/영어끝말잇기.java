package programmers.exerciseLv2;

import java.util.HashMap;

/*
영어 끝말잇기 - Summer/Winter Coding(~2018) - lv.2

 */
public class 영어끝말잇기 {

    public int[] solution(int n, String[] words) {
        int[] answer = new int[2];
        HashMap<String, Integer> map = new HashMap<>();
        int sub = 0;

        map.put(words[0], 1);
        for (int i = 1; i < words.length; i++) {
            if (map.containsKey(words[i])) {
                sub = i;
                break;
            }
            map.put(words[i], 1);

            if (words[i-1].charAt(words[i-1].length() - 1) != (words[i].charAt(0))) {
                sub = i;
                break;
            }
        }

        if (sub != 0) {
            answer[0] = sub % n + 1;
            answer[1] = sub / n + 1;
        }

        return answer;
    }

    public static void main(String[] args) {
        영어끝말잇기 T = new 영어끝말잇기();

        System.out.println(T.solution(3, new String[]{"tank", "kick", "know", "wheel", "land", "dream", "mother", "robot", "tank"}));
        System.out.println(T.solution(5, new String[]{"hello", "observe", "effect", "take", "either", "recognize", "encourage", "ensure", "establish", "hang", "gather", "refer", "reference", "estimate", "executive"}));
        System.out.println(T.solution(2, new String[]{"hello", "one", "even", "never", "now", "world", "draw"}));

    }
}
