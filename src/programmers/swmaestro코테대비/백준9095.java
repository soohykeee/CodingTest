package programmers.swmaestro코테대비;

import java.util.Scanner;

/*
백준 9095 - 1,2,3 더하기
Dynamic Programming
 */
public class 백준9095 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] sum = new int[11];
        sum[1] = 1;
        sum[2] = 2;
        sum[3] = 4;
        for (int i = 4; i <= 10; i++) {
            sum[i] = sum[i - 3] + sum[i - 2] + sum[i - 1];
        }

        for (int i = 0; i < n; i++) {
            int temp = sc.nextInt();
            System.out.println(sum[temp]);
        }

    }
}
