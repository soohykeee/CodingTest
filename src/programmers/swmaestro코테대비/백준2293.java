package programmers.swmaestro코테대비;

import java.util.Scanner;

public class 백준2293 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();

        int[] coin = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            coin[i] = sc.nextInt();
        }

        int[] dp = new int[k + 1];
        dp[0] = 1;

        for (int i = 1; i <= n; i++) {
            for (int j = coin[i]; j <= k; j++) {
                dp[j] = dp[j] + dp[j - coin[i]];
            }
        }

        System.out.println(dp[k]);

    }
}
