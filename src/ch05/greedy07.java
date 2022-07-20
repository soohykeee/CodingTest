package ch05;

/*
씨름 선수(그리디)
        현수는 씨름 감독입니다. 현수는 씨름 선수를 선발공고를 냈고, N명의 지원자가 지원을 했습
        니다. 현수는 각 지원자의 키와 몸무게 정보를 알고 있습니다.
        현수는 씨름 선수 선발 원칙을 다음과 같이 정했습니다.
        “다른 모든 지원자와 일대일 비교하여 키와 몸무게 중 적어도 하나는 크거나, 무거운 지원자
        만 뽑기로 했습니다.”
        만약 A라는 지원자보다 키도 크고 몸무게도 무거운 지원자가 존재한다면 A지원자는 탈락입니
        다.
        모르겠당
*/

import java.util.Arrays;
import java.util.Comparator;

public class greedy07 {

    public int solution(int n, int[][] nums) {
        int answer = 0;

        //키순으로 정렬 내림차순
        Arrays.sort(nums, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[0] - o1[0];
            }
        });

        int maxWeight = 0;
        for (int[] x : nums) {
            if (x[1] > maxWeight) {
                answer++;
                maxWeight = x[1];
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        greedy07 T = new greedy07();

        int[][] nums = {{172, 67}, {183, 65}, {180, 70}, {170, 72}, {181, 60}};
        // 183-65, 181-60, 180-70, 172-67, 170-72  키순
        // 170-72, 180-70, 172-67, 183-65, 181-60  무게순

        // 181-60, 180-70, 172-67  나머지 키순
        // 180-70, 172-67, 181-60  나머지 무게순
        System.out.println(T.solution(5, nums));

    }
}
