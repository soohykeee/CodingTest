package programmers.swmaestro코테대비;

import java.util.Scanner;

/*
백준 11052 - 카드 구매하기

 */
public class 백준11052 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] card = new int[N + 1];
        int[] max = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            card[i] = sc.nextInt();
        }

        max[0] = 0;
        max[1] = card[1];

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= i; j++) {
                max[i] = Math.max(max[i], max[i - j] + card[j]);
            }
        }

        System.out.println(max[N]);
    }
}
