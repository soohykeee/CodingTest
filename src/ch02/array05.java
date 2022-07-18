package ch02;

/*
수열의 경우수
        바이토닉 수열이란 수열이 증가했다가 감소하는 수열을 의미합니다.
        길이가 n인 수열이 주어지면 이 수열의 연속부분수열 중 바이토익 수열이 몇 개 있는지 알아
        내는 프로그램을 작성하세요. 만약 [1, 3, 2, 5, 7, 4, 2, 5, 1]수열이 주어지면 이 수열의 연
        속부분 수열 중 바이토닉 수열은 [1, 3, 2], [2, 5, 7, 4], [2, 5, 7, 4, 2], [5, 7, 4], [5, 7,
        4, 2], [2, 5, 1]로 6개가 있습니다.
*/

import java.util.ArrayList;

public class array05 {

    public int solution(int[] nums) {

        int answer=0;

        ArrayList<Integer> peak = new ArrayList<>();

        for (int i = 1; i < nums.length - 1; i++) {
            if (nums[i - 1] < nums[i] && nums[i + 1] < nums[i]) {
                peak.add(i);
            }
        }

        for (int i = 0; i < peak.size(); i++) {
            int leftCnt = 0;
            int rightCnt = 0;

            int left = peak.get(i);
            int right = peak.get(i);

            while (left - 1 >= 0 && nums[left - 1] < nums[left]) {
                leftCnt++;
                left--;
            }
            while (right + 1 < nums.length && nums[right + 1] < nums[right]) {
                rightCnt++;
                right++;
            }
            answer += leftCnt * rightCnt;
            leftCnt = 0;
            rightCnt = 0;
        }

        return answer;

    }

    public static void main(String[] args) {
        array05 T = new array05();

        int[] arr1 = new int[]{1, 3, 2, 5, 7, 4, 2, 5, 1};
        System.out.println(T.solution(arr1));
    }

}
