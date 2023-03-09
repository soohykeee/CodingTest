package programmers.exerciseLv2;

import java.util.HashMap;

public class 위장 {

    public int solution(String[][] clothes) {
        int answer = 1;

        HashMap<String, Integer> map = new HashMap<>();
        for (String[] clothe : clothes) {
            String type = clothe[1];
            map.put(type, map.getOrDefault(type, 0) + 1);
        }

        for (String key : map.keySet()) {
            answer *= (map.get(key) + 1);
        }

        return answer - 1;
    }

}
