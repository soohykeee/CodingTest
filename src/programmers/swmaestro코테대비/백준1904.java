package programmers.swmaestro코테대비;

import java.util.Scanner;

/*
백준 1904 - 01 타일
 */
public class 백준1904 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] arr = new int[N + 1];

        arr[1] = 1;
        if (N >= 2) {
            arr[2] = 2;
        }

        for (int i = 3; i <= N; i++) {
            arr[i] = (arr[i - 2] + arr[i - 1]) % 15746;
        }

        System.out.println(arr[N]);
    }
}
