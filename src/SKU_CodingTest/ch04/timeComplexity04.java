package SKU_CodingTest.ch04;

/*
연속 부분수열 2
        N개의 수로 이루어진 수열이 주어집니다.
        이 수열에서 연속부분수열의 합이 특정숫자 M이하가 되는 경우가 몇 번 있는지 구하는 프로그
        램을 작성하세요.
        만약 N=5, M=5이고 수열이 다음과 같다면
        1 3 1 2 3
        합이 5이하가 되는 연속부분수열은 {1}, {3}, {1}, {2}, {3}, {1, 3}, {3, 1}, {1, 2}, {2, 3},
        {1, 3, 1}로 총 10가지입니다.
*/

public class timeComplexity04 {

    public int solution(int[] nums, int k) {

        int answer=0;

        int sum=0;
        int left=0;
        for (int right = 0; right < nums.length; right++) {
            sum += nums[right];

            while (sum > k) {
                sum -= nums[left++];
            }

            if (sum <= k) {
                answer += (right - left + 1);
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        timeComplexity04 T = new timeComplexity04();

        int[] nums1 = {1, 3, 1, 2, 3};
        System.out.println(T.solution(nums1, 5));

        int[] nums2 = {1, 1, 1, 1, 1, 1};
        System.out.println(T.solution(nums2, 3));

        int[] nums3 = {1, 1, 2, 2, 1, 2, 1, 3, 2};
        System.out.println(T.solution(nums3, 5));

    }
}
