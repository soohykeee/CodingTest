package programmers.swmaestro코테대비;

import java.util.Scanner;

public class 백준9461 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Long[] triangle = new Long[101];
        triangle[1] = triangle[2] = triangle[3] = 1L;
        triangle[4] = triangle[5] = 2L;

        for (int i = 6; i < 101; i++) {
            triangle[i] = triangle[i - 5] + triangle[i - 1];
        }

        int N = sc.nextInt();
        for (int i = 0; i < N; i++) {
            int temp = sc.nextInt();
            System.out.println(triangle[temp]);
        }

    }
}
