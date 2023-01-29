package programmers.exerciseLv1;

import java.util.HashMap;

/*
성격 유형 검사하기 - KAKAO TECH INTERNSHIP

 */
public class 성격유형검사하기 {

    public String solution(String[] survey, int[] choices) {
        String answer = "";

        HashMap<String, Integer> map = new HashMap<>();
        map.put("R", 0);
        map.put("T", 0);
        map.put("C", 0);
        map.put("F", 0);
        map.put("J", 0);
        map.put("M", 0);
        map.put("A", 0);
        map.put("N", 0);

        for (int i = 0; i < survey.length; i++) {
            String[] arr = survey[i].split("");

            if (choices[i] > 4) {
                map.put(arr[1], map.get(arr[1]) + choices[i] - 4);
            } else if (choices[i] < 4) {
                map.put(arr[0], map.get(arr[0]) + 4 - choices[i]);
            } else {
                continue;
            }
        }

        if (map.get("R") >= map.get("T")) {
            answer += "R";
        } else {
            answer += "T";
        }

        if (map.get("C") >= map.get("F")) {
            answer += "C";
        } else {
            answer += "F";
        }

        if (map.get("J") >= map.get("M")) {
            answer += "J";
        } else {
            answer += "M";
        }

        if (map.get("A") >= map.get("N")) {
            answer += "A";
        } else {
            answer += "N";
        }

        return answer;

    }

    public static void main(String[] args) {
        성격유형검사하기 T = new 성격유형검사하기();

        System.out.println(T.solution(new String[]{"AN", "CF", "MJ", "RT", "NA"}, new int[]{5, 3, 2, 7, 5}));
        System.out.println(T.solution(new String[]{"TR", "RT", "TR"}, new int[]{7, 1, 3}));

    }
}
