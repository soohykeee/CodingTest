package ch05;

/*
선긋기
        현수는 수직선 위에 선을 그을려고 합니다. 선을 그을 때에는 수직선상의 한 점에서 다른 한 점
        까지 긋게 된다. 선을 그을 때에는 이미 선이 있는 위치에 겹쳐서 그릴 수도 있는데, 여러 번 그
        은 곳과 한 번 그은 곳의 차이를 구별할 수 없다고 하자.
        이와 같은 식으로 선을 그었을 때, 현수가 그린 선(들)의 총 길이를 구하는 프로그램을 작성하
        시오.
*/

import java.util.Arrays;
import java.util.Comparator;

public class greedy04 {

    public int solution(int[][] nums) {
        int answer = 0;

        Arrays.sort(nums, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0]) {
                    return o1[1] - o2[1];
                } else {
                    return o1[0] - o2[0];
                }
            }
        });

        for (int i = 0; i < nums.length-1; i++) {
            if (nums[i][1] > nums[i + 1][0]) {
                answer -= (nums[i][1] - nums[i + 1][0]);
            }
            answer += (nums[i][1] - nums[i][0]);
        }
        answer += (nums[nums.length-1][1] - nums[nums.length-1][0]);

        return answer;
    }

    public static void main(String[] args) {
        greedy04 T = new greedy04();

        int[][] nums1 = {{1, 3}, {2, 5}, {7, 10}};
        System.out.println(T.solution(nums1));

        int[][] nums2 = {{5, 6}, {1, 3}, {7, 8}, {9, 10}};
        // 1-3, 5-6, 7-8, 9-10
        System.out.println(T.solution(nums2));

    }
}
