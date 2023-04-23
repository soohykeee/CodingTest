package programmers.exerciseLv2;

import java.util.HashMap;

public class 의상 {
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
}
