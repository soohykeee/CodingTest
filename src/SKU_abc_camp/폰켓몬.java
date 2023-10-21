package SKU_abc_camp;

import java.util.HashMap;

public class 폰켓몬 {

    public int solution(int[] nums) {
        int answer = 0;

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            map.put(num, 1);
        }

        if (map.size() > nums.length / 2) {
            answer = nums.length / 2;
        } else {
            answer = map.size();
        }

        return answer;
    }

    public static void main(String[] args) {
        폰켓몬 T = new 폰켓몬();

        System.out.println(T.solution(new int[]{3, 1, 2, 3}));
        System.out.println(T.solution(new int[]{3, 3, 3, 2, 2, 4}));
        System.out.println(T.solution(new int[]{3, 3, 3, 2, 2, 2}));
    }
}
