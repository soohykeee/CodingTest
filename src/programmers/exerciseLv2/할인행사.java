package programmers.exerciseLv2;

import java.util.HashMap;

/*
할인행사 - 연숩문제 lv.2

 */
public class 할인행사 {

    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        int count = 0;

        HashMap<String, Integer> map = new HashMap<>();
        HashMap<String, Integer> copy = new HashMap<>();

        for (int i = 0; i < want.length; i++) {
            map.put(want[i], number[i]);
            copy.put(want[i], number[i]);
        }

        for (int i = 0; i < discount.length - 9; i++) {
            count = 0;
            map.putAll(copy);
            System.out.println("map " + map);
            System.out.println("copy " + copy);

            for (int j = i; j < discount.length; j++) {
                if (count == 10) {
                    answer++;
                    break;
                }

                if (!map.containsKey(discount[j])) {
                    break;
                } else {
                    count++;
                    if (map.get(discount[j]) != 1) {
                        map.replace(discount[j], map.get(discount[j]) - 1);
                    } else {
                        map.remove(map.get(discount[j]));
                    }
                }
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
