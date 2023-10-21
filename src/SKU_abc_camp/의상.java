package SKU_abc_camp;

import java.util.HashMap;

public class 의상 {

    public int solution(String[][] clothes) {
        int answer = 1;

        HashMap<String, Integer> map = new HashMap<>();

        for (int i = 0; i < clothes.length; i++) {
            map.put(clothes[i][1], map.getOrDefault(clothes[i][1], 1) + 1);
        }

        for (String key : map.keySet()) {
            answer *= map.get(key);
        }

        return answer - 1;
    }

    public static void main(String[] args) {
        의상 T = new 의상();

        System.out.println(T.solution(new String[][]{{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}}));
        System.out.println(T.solution(new String[][]{{"crow_mask", "face"}, {"blue_sunglasses", "face"}, {"smoky_makeup", "face"}}));
    }
}
