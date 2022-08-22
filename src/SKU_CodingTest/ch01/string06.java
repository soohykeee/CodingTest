package SKU_CodingTest.ch01;

import java.util.HashMap;

/*
한번 사용한 최초 문자
        문자열에서 한번만 사용한 문자를 찾으려고 합니다.
        한번만 사용한 문자 중 문자열에서 먼저 나타난 문자의 인덱스 번호를 반환하는 프로그램을
        작성하세요. 인덱스는 1부터 시작합니다. 한번만 사용한 문자가 없을 경우 -1를 반환하세요.
*/

public class string06 {

    public int solution(String s){

        HashMap<Character, Integer> map = new HashMap<>();

        for (char key : s.toCharArray()) {
            map.put(key, map.getOrDefault(key, 0) + 1);
        }

        for(int i=0; i<s.length(); i++){
            if (map.get(s.charAt(i)) == 1) {
                return i+1;
            }
        }

        return -1;

    }

    public static void main(String[] args) {
        string06 T = new string06();

        System.out.println(T.solution("statitsics"));
        System.out.println(T.solution("aabb"));
        System.out.println(T.solution("stringshowtime"));

    }

}
