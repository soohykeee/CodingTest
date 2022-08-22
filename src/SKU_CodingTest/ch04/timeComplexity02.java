package SKU_CodingTest.ch04;

/*
카드 가져가기
        N개의 카드가 일렬로 놓여져 있습니다. 각 카드에는 숫자가 적혀있습니다.
        현수는 카드가 일렬로 놓여진 줄의 양 끝에서 카드를 가져갈 수 있습니다. 현수는 양 끝에서
        가져가는 방식으로 K개의 카드를 가져갈 수 있습니다. 그리고 가져간 카드에 적혀진 숫자의
        총합이 현수가 얻는 점수입니다.
        일려로 놓여진 카드의 숫자가 nums배열에 주어지고, 현수가 가져갈 수 있는 카드의 개수 K가
        주어지면 현수가 얻을 수 있는 최대점수를 반환하는 프로그램을 작성하세요.
*/

// -> k개 만큼 가져가서 최댓값을 가져오려고 코드를 짜지 말고,
// 전체-k 개 만큼 가졌을때, 최솟값을 구해서 전체에서 빼주는 방식으로 접근해야한다.
public class timeComplexity02 {

    public int solution(int[] nums, int k) {

        int answer=0;
        for (int x : nums) {
            answer+=x;
        }

        int m=nums.length-k;
        int sum=0;
        for (int i = 0; i < m; i++) {
            sum += nums[i];
        }

        int mins=sum;
        for (int i = m; i < nums.length; i++) {
            sum += (nums[i] - nums[i - m]);
            mins = Math.min(mins, sum);
        }

        return answer-mins;
    }

    public static void main(String[] args) {
        timeComplexity02 T = new timeComplexity02();

        int[] nums1 = {2, 3, 7, 1, 2, 1, 5};
        System.out.println(T.solution(nums1, 4));

        int[] nums2 = {1, 2, 3, 5, 6, 7, 1, 3, 9};
        System.out.println(T.solution(nums2, 5));


    }
}
