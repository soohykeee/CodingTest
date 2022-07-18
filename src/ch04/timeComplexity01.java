package ch04;

/*
최대 매출
        현수의 아빠는 제과점을 운영합니다. 현수아빠는 현수에게 N일 동안의 매출기록을 주고 연속
        된 K일 동안의 매출액의 합 중에서 최대값이 얼마인지 구하라고 했습니다.
        만약 N=10이고 10일 간의 매출기록이 아래와 같습니다. 이때 K=3이면
        12 15 11 20 25 10 20 19 13 15
        연속된 3일간의 최대 매출액은 11+20+25=56만원입니다.
        여러분이 현수를 도와주세요.
*/

public class timeComplexity01 {

    public int solution(int[] nums, int k) {

        int answer=0;
        for (int i = 0; i < k; i++) {
            answer += nums[i];
        }

        for (int i = k; i < (nums.length - k); i++) {
            answer = Math.max(answer, (answer - nums[i - k] + nums[i]));
        }

        return answer;
    }

    public static void main(String[] args) {
        timeComplexity01 T = new timeComplexity01();

        int[] nums1 = {12, 15, 11, 20, 25, 10, 20, 19, 13, 15};
        System.out.println(T.solution(nums1, 3));

        int[] nums2 = {1, 2, 3, 5, 6, 7, 1, 3, 9};
        System.out.println(T.solution(nums2, 5));

        int[] nums3 = {12, 34, 56, 72, 93, 121, 33, 11, 23, 52};
        System.out.println(T.solution(nums3, 4));

    }
}
