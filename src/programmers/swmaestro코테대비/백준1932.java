package programmers.swmaestro코테대비;

import java.util.Scanner;

/*
백준 1932 - 정수 삼각형

 */
public class 백준1932 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[][] triangle = new int[n + 1][n + 1];
        int[][] dist = new int[n + 1][n + 1];
        int answer = 0;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                triangle[i][j] = sc.nextInt();
            }
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                dist[i][j] = Math.max(dist[i - 1][j - 1], dist[i - 1][j]) + triangle[i][j];
            }
        }

        for (int i = 1; i <= n; i++) {
            answer = Math.max(dist[n][i], answer);
        }

        System.out.println(answer);

    }
}
