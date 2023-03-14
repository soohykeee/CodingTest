package programmers.exerciseLv2;

import java.util.HashMap;

/*
위장 - 해시 lv.2

 */
public class 위장 {

    public int solution(String[][] clothes) {
        int answer = 1;

        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < clothes.length; i++) {
            String key = clothes[i][1];
            map.put(key, map.getOrDefault(key, 1) + 1);
        }

        for (String key : map.keySet()) {
            answer *= map.get(key);
        }

        return answer - 1;
    }

    public static void main(String[] args) {
        위장 T = new 위장();

        System.out.println(T.solution(new String[][]{{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}}));
        System.out.println(T.solution(new String[][]{{"crow_mask", "face"}, {"blue_sunglasses", "face"}, {"smoky_makeup", "face"}}));
    }

}
