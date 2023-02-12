package programmers.swmaestro코테대비;

import java.util.Scanner;

/*
백준 1149 - RGB거리

 */
public class 백준1149 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[][] home = new int[n + 1][3];


        for (int i = 1; i <= n; i++) {
            int R = sc.nextInt();
            int G = sc.nextInt();
            int B = sc.nextInt();

            home[i][0] = Math.min(home[i - 1][1], home[i - 1][2]) + R;
            home[i][1] = Math.min(home[i - 1][0], home[i - 1][2]) + G;
            home[i][2] = Math.min(home[i - 1][1], home[i - 1][0]) + B;
        }

        System.out.println(Math.min(Math.min(home[n][0], home[n][1]), home[n][2]));
    }
}
