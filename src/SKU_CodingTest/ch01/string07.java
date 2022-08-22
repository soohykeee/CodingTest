package SKU_CodingTest.ch01;

import java.util.ArrayList;
import java.util.HashMap;

/*
같은 빈도수 만들기
        소문자 a, b, c로 이루어진 문자열이 주어지면 해당 문자열에서 a, b, c의 최소의 개수를 추가
        하여 a, b, c의 빈도수가 동일하게 되도록 해야 합니다. 동일빈도수가 되는 최소 추가 개수를
        알파벳 a, b, c순으로 배열에 저장하여 반환하는 프로그램을 작성하세요.
        만약 주어진 문자열이 "aaabc" 라면 빈도수는 a:3 , b:1, c:1 이고 최소 개수를 추가하여 동일
        빈도수가 되게 하려면 b를 2개 추가, c를 2개 추가하면 모두 빈도수가 3개로 동일해집니다.
*/

public class string07 {

    public ArrayList<Integer> solution(String s){

        ArrayList<Integer> answer = new ArrayList<>();
        HashMap<Character, Integer> map = new HashMap<>();
        for (char key : s.toCharArray()) {
            map.put(key, map.getOrDefault(key, 0) + 1);
        }

        int max=0;
        String temp = "abc";
        for (char key : map.keySet()) {
            if (map.get(key) > max) {
                max = map.get(key);
            }
        }

        for (char key : temp.toCharArray()) {
            answer.add(max - map.getOrDefault(key, 0));
        }

        return answer;

    }

    public static void main(String[] args) {
        string07 T = new string07();

        System.out.println(T.solution("aaabc"));
        System.out.println(T.solution("aabb"));
        System.out.println(T.solution("abc"));

    }
}
