package ch03;

/*
충돌하는 수열
        N길이의 음수와 양수로 이루어진 수열이 주어집니다. 음수의 값은 왼쪽으로 이동하고, 양수의
        값은 오른쪽으로 이동합니다. 이동을 하다 양수와 음수가 부딪치면 다음과 같은 결과가 나옵
        니다.
        1. 부딪치는 양수와 음수가 서로 절대값의 크기가 다르면 절대값이 큰 값이 살아남고 작은 값
        은 수열에서 사라집니다.
        2. 만약 부딪치는 양수와 음수가 절대값이 같다면 두 수 모두 사라집니다.
*/
// 문제를 이해 못하겠음

import java.util.ArrayList;

public class stack03 {

    public ArrayList<Integer> solution(int[] nums) {

        ArrayList<Integer> answer = new ArrayList<>();

        return answer;

    }

    public static void main(String[] args) {
        stack03 T = new stack03();

        int[] nums1 = {3, 5, -2, -5};
        System.out.println(T.solution(nums1));

        int[] nums2 = {-2, -1, -3, 1, 3};
        System.out.println(T.solution(nums2));

        int[] nums3 = {-2, -1, 2, 1, -3, 2};
        System.out.println(T.solution(nums3));

    }
}
