package programmers.swmaestro코테대비;

import java.util.Scanner;

/*
백준 1463 - 1로 만들기

 */
public class 백준1463 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] number = new int[n + 1];
        number[1] = 0;

        for (int i = 2; i <= n; i++) {
            number[i] = number[i - 1] + 1;
            if (i % 2 == 0) {
                number[i] = Math.min(number[i], number[i / 2] + 1);
            }else if (i % 3 == 0) {
                number[i] = Math.min(number[i], number[i / 3] + 1);
            }
        }

        System.out.println(number[n]);
    }

}
