package ch04;

/*
연속 부분수열 1
        N개의 수로 이루어진 수열이 주어집니다.
        이 수열에서 연속부분수열의 합이 특정숫자 M이 되는 경우가 몇 번 있는지 구하는 프로그램을
        작성하세요.
        만약 N=8, M=6이고 수열이 다음과 같다면
        1 2 1 3 1 1 1 2
        합이 6이 되는 연속부분수열은 {2, 1, 3}, {1, 3, 1, 1}, {3, 1, 1, 1}로 총 3가지입니다.
*/

public class timeComplexity03 {

    public int solution(int[] nums, int k) {

        int answer=0;

        int sum=0;
        int left=0;
        for (int right = 0; right < nums.length; right++) {
            sum += nums[right];

            while (sum > k) {
                sum -= nums[left++];
            }

            if (sum == k) {
                answer++;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        timeComplexity03 T = new timeComplexity03();

        int[] nums1 = {1, 2, 1, 3, 1, 1, 1, 2};
        System.out.println(T.solution(nums1, 6));

        int[] nums2 = {1, 1, 1, 1, 1, 1};
        System.out.println(T.solution(nums2, 3));

        int[] nums3 = {1, 2, 1, 2, 1, 2, 1};
        System.out.println(T.solution(nums3, 3));

    }
}
