package SKU_CodingTest.ch01;/*
공통문자찾기
        N개의 문자열이 주어지면 모든 문자열에 공통으로 들어있는 문자를 찾아 출력하는 프로그램을
        작성하세요. 만약 어떤 문자가 모든 문자열에서 2번 나타난다면 답에서도 2번 나타나게 해야
        합니다.
        문자열 배열 words가 주어지면 모든 문자열에 공통으로 들어있는 공통문자를 문자배열형태로
        반환하는 프로그램을 작성하세요.
        문자의 순서는 상관없습니다. 반드시 공통문자는 존재합니다
*/

import java.util.ArrayList;
import java.util.HashMap;

public class string10 {

    public ArrayList<Character> solution(String[] words) {
        ArrayList<Character> answer = new ArrayList<>();
        HashMap<Character, Integer> map = new HashMap<>();

        for (char key : words[0].toCharArray()) {
            map.put(key, map.getOrDefault(key, 0) + 1);
        }

        for (int i = 1; i < words.length; i++) {
            HashMap<Character, Integer> temp = new HashMap<>();
            for (char key : words[i].toCharArray()) {
                if (map.getOrDefault(key, 0) > 0) {
                    map.put(key, map.get(key) - 1);
                    temp.put(key, temp.getOrDefault(key, 0) + 1);
                }
            }
            map = temp;
        }

        for (char key : map.keySet()) {
            for (int i = 0; i < map.get(key); i++) {
                answer.add(key);
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        string10 T = new string10();

        String[] tmp = new String[]{"steasue", "sasseysu", "kseseas"};
        System.out.println(T.solution(tmp));
        String[] tmp1 = new String[]{"longlong", "longtong", "longbig"};
        System.out.println(T.solution(tmp1));
    }
}
