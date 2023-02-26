package programmers.exerciseLv2;

/*
멀리 뛰기 - 연습문제 lv.2

 */
public class 멀리뛰기 {


    public long solution(int n) {
        long answer = 0;
        long[] dp = new long[2001];

        dp[1] = 1;
        dp[2] = 2;

        for (int i = 3; i <= n; i++) {
            dp[i] = (dp[i - 2] + dp[i - 1]) % 1234567;
        }

        return dp[n];
    }

    public static void main(String[] args) {
        멀리뛰기 T = new 멀리뛰기();

        System.out.println(4);
        System.out.println(3);
    }
}
