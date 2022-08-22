package SKU_CodingTest.ch01;/*
음성인식
        음성 인식 기술을 사용하면 사람이 말하는 음성 데이터를 문자 데이터로 변환할 수 있습니다. 당신은
        오늘의 집에 전화로 들어온 주문을 자동으로 처리하기 위해, 음성 데이터를 문자 데이터로 변환하려 합
        니다. 당신은 이 문자 데이터를 쓰기 전에 먼저 반복적으로 사용된 말버릇 패턴을 삭제해야 합니다. 말
        버릇 패턴이란 문자 데이터에서 가장 많이 등장하는 길이 1 이상의 패턴이며, 문자 데이터에 등장하는
        해당 패턴을 모두 삭제하면 됩니다. 단, 이러한 패턴은 대소문자를 구분하지 않으며, 가장 맣이 등장한
        패턴이 여러 개일 경우 그러한 패턴을 모두 삭제합니다.
*/

import java.util.HashMap;
import java.util.Locale;

public class string09 {

    public String solution(String s) {

        String answer = "";
        HashMap<Character, Integer> map = new HashMap<>();
        String temp = s.toUpperCase(Locale.ROOT);

        for (char key : temp.toCharArray()) {
            map.put(key, map.getOrDefault(key, 0) + 1);
        }

        int max=0;
        for (char key : map.keySet()) {
            if (map.get(key) > max) {
                max = map.get(key);
            }
        }

        for (int i = 0; i < s.length(); i++) {
            if (map.get(temp.charAt(i)) < max) {
                answer += s.charAt(i);
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        string09 T = new string09();

        System.out.println(T.solution("abcabcdefabc"));
        System.out.println(T.solution("abxdeydeabz"));
        System.out.println(T.solution("abcabca"));
        System.out.println(T.solution("ABCabcA"));
    }
}
