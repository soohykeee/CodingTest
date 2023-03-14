package programmers.exerciseLv2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/*
귤 고르기 - 연습문제 lv.2

 */
public class 귤고르기 {

    public int solution(int k, int[] tangerine) {
        int answer = 0;

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int key : tangerine) {
            map.put(key, map.getOrDefault(key, 0) + 1);
        }

        List<Integer> keyList = new ArrayList<>(map.keySet());
        keyList.sort((o1, o2) -> map.get(o2) - map.get(o1));

        int i = 0;
        while (k > 0) {
            k -= map.get(keyList.get(i));
            answer++;
            i++;
        }

        return answer;
    }

    public static void main(String[] args) {
        귤고르기 T = new 귤고르기();

        System.out.println(T.solution(6, new int[]{1, 3, 2, 5, 4, 5, 2, 3}));
        System.out.println(T.solution(4, new int[]{1, 3, 2, 5, 4, 5, 2, 3}));
        System.out.println(T.solution(2, new int[]{1, 1, 1, 1, 2, 2, 2, 3}));
    }

}
