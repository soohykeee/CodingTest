package SKU_CodingTest.ch01;

import java.util.HashMap;

/*
학급 회장
        학급 회장을 뽑는데 후보로 기호 A, B, C, D, E 후보가 등록을 했습니다.
        투표용지에는 반 학생들이 자기가 선택한 후보의 기호(알파벳)가 쓰여져 있으며 선생님은 그
        기호를 발표하고 있습니다.
        매개변수 s에 투표용지에 쓰여져 있던 각 후보의 기호가 선생님이 발표한 순서대로 문자열로
        주어지면 어떤 기호의 후보가 학급 회장이 되었는지 반환하는 프로그램을 작성하세요.
        반드시 한 명의 학급회장이 선출되도록 투표결과가 나왔다고 가정합니다.
*/

public class string05 {

    public char solution(String s){
        char answer = 0;
        HashMap<Character, Integer> map = new HashMap<>();

        for (char key : s.toCharArray()) {
            map.put(key, map.getOrDefault(key, 0) + 1);
        }
        
        int max=0;
        for (char key : map.keySet()) {
            if (map.get(key) > max) {
                max = map.get(key);
                answer = key;
            }
        }

        return answer;

    }

    public static void main(String[] args) {
        string05 T = new string05();

        System.out.println(T.solution("BACBACCACCBDEDE"));
        System.out.println(T.solution("AAAAABBCCDDDD"));

    }
}
