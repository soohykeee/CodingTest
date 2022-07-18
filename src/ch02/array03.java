package ch02;

/*
바이토닉 수열
        바이토닉 수열이란 수열이 증가했다가 감소하는 수열을 의미합니다.
        길이가 n인 수열이 매개변수 nums에 주어지면 이 수열이 바이토닉 수열인지 판별하는 프로그
        램을 작성하세요.
        만약 [1, 2, 3, 4, 2, 1]이면 바이토닉 수열입니다. 하지만 [1, 2, 2, 3, 2, 1]과 같이 같은 값
        이 연속으로 있으면 바아토닉 수열이라 하지 않습니다.
*/

public class array03 {

    public String solution(int[] nums) {

        String answer="YES";
        
        int peak = 0;
        for (int i = 1; i < nums.length-1; i++) {
            if (nums[i - 1] < nums[i] && nums[i] > nums[i + 1]) {
                peak = nums[i];
            } else if (nums[i - 1] == nums[i] || nums[i] == nums[i + 1]) {
                return "NO";
            }
        }

        if (peak == 0) {
            return "NO";
        }

        return answer;
    }

    public static void main(String[] args) {
        array03 T = new array03();

        int[] arr1 = new int[]{1, 2, 3, 4, 5, 3, 1};
        System.out.println(T.solution(arr1));

        int[] arr2 = new int[]{1, 3, 4, 5, 5, 6, 4, 3};
        System.out.println(T.solution(arr2));

        int[] arr3 = new int[]{1, 2, 3, 4, 5};
        System.out.println(T.solution(arr3));
    }
}
