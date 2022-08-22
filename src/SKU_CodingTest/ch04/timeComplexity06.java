package SKU_CodingTest.ch04;

/*
k개 홀수가 있는 연속부분수열
        N개의 수로 이루어진 수열이 주어집니다.
        이 수열에서 홀수의 개수가 k개인 연속부분수열의 개수를 구하려고 합니다.
        만약 N=5인 수열이 아래와 같고
        [1, 2, 1, 1, 2]
        k=2라면 홀수의 개수가 2개인 연속부분수열은
        {1, 2, 1}, {2, 1, 1}, {2, 1, 1, 2}, {1, 1}, {1, 1, 2} 로 5가지입니다.
*/

public class timeComplexity06 {

    public int counting(int[] nums, int k) {

        int answer=0;
        int count=0;
        int left=0;
        for (int right = 0; right < nums.length; right++) {
            if (nums[right] % 2 == 1) {
                count++;
            }

            while (count > k) {
                if (nums[left++] % 2 == 1) {
                    count--;
                }
            }
            answer += (right - left + 1);
        }

        return answer;
    }

    public int solution(int[] nums, int k) {

        int answer = counting(nums, k) - counting(nums, k - 1);

        return answer;
    }

    public static void main(String[] args) {
        timeComplexity06 T = new timeComplexity06();

        int[] nums1 = {1, 2, 1, 1, 2};
        System.out.println(T.solution(nums1, 2));

        int[] nums2 = {2, 2, 2, 1, 2, 2, 1, 2, 2, 2};
        System.out.println(T.solution(nums2, 2));

        int[] nums3 = {2, 4, 6};
        System.out.println(T.solution(nums3, 1));

    }

}
