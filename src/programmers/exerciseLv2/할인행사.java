package programmers.exerciseLv2;

import java.util.HashMap;

/*
할인행사 - 연숩문제 lv.2

 */
public class 할인행사 {

    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        HashMap<String, Integer> map = new HashMap<>();

        // 초기값 세팅
        for (int i = 0; i < want.length; i++) {
            map.put(want[i], number[i]);
        }

        // discount의 i ~ i+10 까지 값들을 저장
        for (int i = 0; i <= discount.length - 10; i++) {
            HashMap<String, Integer> temp = new HashMap<>();
            for (int j = i; j < i + 10; j++) {
                temp.put(discount[j], temp.getOrDefault(discount[j], 0) + 1);
            }

            // key 값으로 값 비교
            // getOrDefault 하지 않으면 temp에 없는 값이 들어가면 NullPointException 발생
            boolean check = true;
            for (String key : map.keySet()) {
                if (map.get(key) > temp.getOrDefault(key, 0)) {
                    check = false;
                    break;
                }
            }

            if (check) {
                answer++;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        할인행사 T = new 할인행사();

        System.out.println(T.solution(new String[]{"banana", "apple", "rice", "pork", "pot"}, new int[]{3, 2, 2, 2, 1}, new String[]{"chicken", "apple", "apple", "banana", "rice", "apple", "pork", "banana", "pork", "rice", "pot", "banana", "apple", "banana"}));
        System.out.println(T.solution(new String[]{"apple"}, new int[]{10}, new String[]{"banana", "banana", "banana", "banana", "banana", "banana", "banana", "banana", "banana", "banana"}));

    }
}
