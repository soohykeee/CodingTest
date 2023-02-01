package programmers.exerciseLv2;

import java.util.Arrays;

/*
최솟값 만들기 - 연습문제 lv.2

 */
public class 최솟값만들기 {

    public int solution(int[] A, int[] B) {
        int answer = 0;

        Arrays.sort(A);
        Arrays.sort(B);

        for (int i = 0; i < A.length; i++) {
            answer += (A[i] * B[A.length - i - 1]);
        }

        return answer;
    }

    public static void main(String[] args) {
        최솟값만들기 T = new 최솟값만들기();

        System.out.println(T.solution(new int[]{1, 4, 2}, new int[]{5, 4, 4}));
        System.out.println(T.solution(new int[]{1, 2}, new int[]{3, 4}));
    }

}
