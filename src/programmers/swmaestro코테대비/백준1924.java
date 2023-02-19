package programmers.swmaestro코테대비;

import java.util.Scanner;

/*
백준 1924 - 2007년

 */
public class 백준1924 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] month = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        String[] day = {"SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT"};

        int x = sc.nextInt();
        int y = sc.nextInt();
        int temp = 0;

        for (int i = 0; i < x; i++) {
            temp += month[i];
        }
        temp += y;

        System.out.println(day[temp % 7]);

    }
}
