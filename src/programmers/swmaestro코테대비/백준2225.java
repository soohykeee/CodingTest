package programmers.swmaestro코테대비;

import java.util.Scanner;

/*
백준 2225 - 합분해

 */
public class 백준2225 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int K = sc.nextInt();

        int[][] dp = new int[K + 1][N + 1];

        for (int i = 0; i <= N; i++) {
            dp[1][i] = 1;
        }

        for (int i = 1; i <= K; i++) {
            dp[i][0] = 1;
        }

        for (int i = 2; i <= K; i++) {
            for (int j = 1; j <= N; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }

        System.out.println(dp[K][N] % 1000000000);

    }
}
