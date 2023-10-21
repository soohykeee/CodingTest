package SKU_abc_camp;

import java.util.ArrayList;
import java.util.HashMap;

public class 보석쇼핑 {

    public int[] solution(String[] gems) {
        int[] answer = new int[2];

        HashMap<String, Integer> gemMap = new HashMap<>();
        HashMap<String, Integer> answerMap = new HashMap<>();

        // gem들을 알기위해 Map에 저장
        for (String gem : gems) {
            if (gemMap.getOrDefault(gem, 0) == 0) {
                gemMap.put(gem, 1);
            }
        }

        // gem의 갯수
        int temp = gemMap.size();

        int left = 0;
        int right = 0;
        int size = Integer.MAX_VALUE;
        while (left != gems.length) {

            if (answerMap.size() != temp) {
                if (right < gems.length) {
                    answerMap.put(gems[right], answerMap.getOrDefault(gems[right], 0) + 1);
                    right++;
                } else {
                    break;
                }
            } else {
                if ((right - left) < size) {
                    size = right-left;
                    answer[0] = left+1;
                    answer[1] = right;
                }

                answerMap.put(gems[left], answerMap.get(gems[left]) - 1);

                if (answerMap.get(gems[left]) == 0) {
                    answerMap.remove(gems[left]);
                }

                left++;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        보석쇼핑 T = new 보석쇼핑();

        System.out.println(T.solution(new String[]{"DIA", "RUBY", "RUBY", "DIA", "DIA", "EMERALD", "SAPPHIRE", "DIA"}));
        System.out.println(T.solution(new String[]{"AA", "AB", "AC", "AA", "AC"}));
        System.out.println(T.solution(new String[]{"XYZ", "XYZ", "XYZ"}));
        System.out.println(T.solution(new String[]{"ZZZ", "YYY", "NNNN", "YYY", "BBB"}));

    }
}
