package programmers.swmaestro코테대비;

import java.util.Scanner;

/*
백준 2579 - 계단 오르기

 */
public class 백준2579 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();               // 계단 수
        int[] stairs = new int[n + 1];      // 각 계단의 점수
        int[] steps = new int[n + 1];       // 각 계단에 도달했을 때의 최댓값

        for (int i = 1; i <= n; i++) {
            stairs[i] = sc.nextInt();
        }

        steps[1] = stairs[1];
        if (n >= 2) {
            steps[2] = stairs[1] + stairs[2];
        }

        for (int i = 3; i <= n; i++) {
            steps[i] = Math.max(steps[i - 3] + stairs[i - 1], steps[i - 2]) + stairs[i];
        }

        System.out.println(steps[n]);
    }

}
