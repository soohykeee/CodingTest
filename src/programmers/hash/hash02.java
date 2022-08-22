package programmers.hash;

/*
완주하지 못한 선수

수많은 마라톤 선수들이 마라톤에 참여하였습니다.
단 한 명의 선수를 제외하고는 모든 선수가 마라톤을 완주하였습니다.

마라톤에 참여한 선수들의 이름이 담긴 배열 participant와 완주한 선수들의 이름이 담긴 배열 completion이 주어질 때,
완주하지 못한 선수의 이름을 return 하도록 solution 함수를 작성해주세요.
 */

import java.util.HashMap;

public class hash02 {

    public String solution(String[] participant, String[] completion) {
        String answer = "";

        HashMap<String, Integer> map = new HashMap<>();
        for (String part : participant) {
            map.put(part, map.getOrDefault(part, 0) + 1);
        }
        for (String comp : completion) {
            map.put(comp, map.get(comp) - 1);
        }

        for (String key : map.keySet()) {
            if (map.get(key).equals(1)) {
                answer = key;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        hash02 T = new hash02();

        System.out.println(T.solution(new String[]{"leo", "kiki", "eden"}, new String[]{"eden", "kiki"}));
        System.out.println(T.solution(new String[]{"marina", "josipa", "nikola", "vinko", "filipa"}, new String[]{"josipa", "filipa", "marina", "nikola"}));
        System.out.println(T.solution(new String[]{"mislav", "stanko", "mislav", "ana"}, new String[]{"stanko", "ana", "mislav"}));
    }
}
