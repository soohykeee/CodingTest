package programmers.exerciseLv2;

import java.util.ArrayList;
import java.util.HashMap;

/*
[3차] 압축 - 2018 KAKAO BLIND RECRUITMENT

 */
public class 압축 {

    public int[] solution(String msg) {
        int[] answer = {};
        int count = 0;
        HashMap<String, Integer> hashMap = new HashMap<>();

        for (int i = 1; i < 27; i++) {
            char alpha = (char) (64+i);
            hashMap.put(String.valueOf(alpha), i);
        }

        for (int i = 0; i < msg.length(); i++) {
//            addLZW(hashMap, msg.);
        }



        return answer;
    }

    public int addLZW(HashMap<String, Integer> hashMap, String str, int count) {

        if (!hashMap.containsKey(str)) {
            hashMap.put(str, count);
            return count;
        }

        return hashMap.get(str);

    }


    public static void main(String[] args) {
        압축 T = new 압축();

        System.out.println(T.solution("KAKAO"));
        System.out.println(T.solution("TOBEORNOTTOBEORTOBEORNOT"));
        System.out.println(T.solution("ABABABABABABABAB"));
    }
}
