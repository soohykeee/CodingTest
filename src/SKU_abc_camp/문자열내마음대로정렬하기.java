package SKU_abc_camp;

import java.util.ArrayList;
import java.util.Collections;

public class 문자열내마음대로정렬하기 {

    public String[] solution(String[] strings, int n) {

        String[] answer = new String[strings.length];

        ArrayList<String> list = new ArrayList<>();

        // 비교할 문자 + 원래 문자로 정렬
        for (int i = 0; i < strings.length; i++) {
            list.add(strings[i].charAt(n) + strings[i]);
        }

        Collections.sort(list);

        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i).substring(1);
        }

        return answer;
    }

    public static void main(String[] args) {
        문자열내마음대로정렬하기 T = new 문자열내마음대로정렬하기();

        System.out.println(T.solution(new String[]{"sun", "bed", "car"}, 1));
        System.out.println(T.solution(new String[]{"abce", "abcd", "cdx"}, 2));
    }
}
