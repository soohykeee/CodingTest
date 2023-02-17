package programmers.swmaestro코테대비;

import java.util.Scanner;

/*
백준 11057 - 오르막길

 */
public class 백준11057 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        int[][] step = new int[N + 1][10];

        for (int i = 0; i < 10; i++) {
            step[0][i] = 1;
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 0; j < 10; j++) {
                for (int k = j; k < 10; k++) {
                    step[i][j] += step[i - 1][k];
                    step[i][j] %= 10007;
                }
            }
        }

        System.out.println(step[N][0]);
    }
}
