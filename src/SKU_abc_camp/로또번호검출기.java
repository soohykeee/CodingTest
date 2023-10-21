package SKU_abc_camp;

import java.util.HashMap;

public class 로또번호검출기 {

    public boolean solution(int[] lotto) {
        boolean answer = true;

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int num : lotto) {
            if (map.containsKey(num)) {
                answer = false;
                break;
            }

            if (num > 45 || num < 1) {
                answer = false;
                break;
            }

            map.put(num, 1);

        }

        if (map.size() != 6) {
            answer = false;
        }

        return answer;
    }

    public static void main(String[] args) {
        로또번호검출기 T = new 로또번호검출기();

        System.out.println(T.solution(new int[]{4, 7, 32, 43, 22, 19}));
        System.out.println(T.solution(new int[]{3, 19, 34, 39, 39, 20}));
    }
}
