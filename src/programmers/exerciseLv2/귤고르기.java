package programmers.exerciseLv2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class 귤고르기 {

    private Map<Integer, Integer> map;
    public int solution(int k, int[] tangerine) {
        int answer = 0;

        // 크기별로 몇 개 있는지 map에 저장함
        map = new HashMap<>();
        for (int tan : tangerine) {
            map.put(tan, map.getOrDefault(tan, 0)+1);
        }

        // 개수(value)가 많은 순으로 정렬
        List<Map.Entry<Integer, Integer>> entryList = new ArrayList<>(map.entrySet());
        entryList.sort((o1, o2) -> o2.getValue().compareTo(o1.getValue()));

        // 개수가 많은 순부터 사용
        for (Map.Entry<Integer, Integer> entry : entryList) {
            if(k<=0) break;
            answer++;
            k -= entry.getValue();
        }

        return answer;
    }

}
