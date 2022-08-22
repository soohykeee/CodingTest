package SKU_CodingTest.ch02;

/*
최대길이 바이토닉
        바이토닉 수열이란 수열이 증가했다가 감소하는 수열을 의미합니다.
        길이가 n인 수열이 주어지면 이 수열의 연속부분수열 중 가장 긴 바이토닉 수열을 찾아 그 길
        이를 반환하는 프로그램을 작성하세요.
        만약 [1, 3, 2, 5, 7, 4, 2, 5, 1]수열이 주어지면 이 수열의 연속부분수열 중 가장 긴 바이토
        닉 수열은 [2, 5, 7, 4, 2]이고, 답은 5입니다.
*/

import java.util.ArrayList;

public class array04 {

    public int solution(int[] nums) {
        int answer=0;

        ArrayList<Integer> peak = new ArrayList<>();

        for (int i = 1; i < nums.length - 1; i++) {
            if (nums[i - 1] < nums[i] && nums[i + 1] < nums[i]) {
                peak.add(i);
            }
        }

        for (int i = 0; i < peak.size(); i++) {
            int count=1;
            int left = peak.get(i);
            int right = peak.get(i);

            while (left - 1 >= 0 && nums[left - 1] < nums[left]) {
                count++;
                left--;
            }
            while (right + 1 < nums.length && nums[right + 1] < nums[right]) {
                count++;
                right++;
            }

            if (answer < count) {
                answer = count;
            }

            count = 1;
        }

        return answer;

    }

    public static void main(String[] args) {
        array04 T = new array04();

        int[] arr1 = new int[]{1, 3, 2, 5, 7, 4, 2, 5, 1};
        System.out.println(T.solution(arr1));
    }
}
