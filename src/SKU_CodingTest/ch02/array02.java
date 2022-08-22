package SKU_CodingTest.ch02;

/*
가장 높은 증가수열
        길이가 n인 수열이 주어지면 이 수열에서 연속된 부분 증가수열을 찾습니다. 각 부분증가수열
        은 높이가 있습니다. 증가수열의 높이란 증가수열의 첫항과 마지막항의 차를 의미합니다.
        수열이 주어지면 여러 증가수열 중 가장 높은 부분증가수열을 찾는 프로그램을 작성하세요.
        만약 수열이 [5, 2, 4, 7, 7, 3, 9, 10, 11]이 주어지면 가장 높은 부분증가수열은 [3, 9, 10,
        11]이고, 높이는 8입니다.
        주의 : 이웃하는 두 수가 같을 경우 증가수열로 보지 않습니다.
*/

public class array02 {

    public int solution(int[] nums) {
        int result=0;

        int temp=0;
        for (int i = 0; i < nums.length-1; i++) {
            if (nums[i + 1] > nums[i]) {
                temp += (nums[i+1]-nums[i]);
            } else {
                result = Math.max(result, temp);
                temp = 0;
            }
        }
        result = Math.max(result, temp);
        return result;
    }

    public static void main(String[] args) {
        array02 T = new array02();

        int[] arr1 = new int[]{8, 12, 2, 3, 7, 6, 12, 20, 3};
        System.out.println(T.solution(arr1));

        int[] arr2 = new int[]{5, 2, 4, 7, 7, 3, 9, 10, 11};
        System.out.println(T.solution(arr2));

    }
}
