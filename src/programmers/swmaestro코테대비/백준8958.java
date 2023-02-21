package programmers.swmaestro코테대비;

import java.util.Scanner;

public class 백준8958 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        String[] str = new String[N];

        for (int i = 0; i < N; i++) {
            str[i] = sc.next();
        }

        for (int i = 0; i < N; i++) {
            int answer = 0;
            int temp = 0;
            for (int j = 0; j < str[i].length(); j++) {
                if (str[i].charAt(j) == 'O') {
                    temp++;
                } else {
                    temp = 0;
                }
                answer+=temp;
            }
            System.out.println(answer);
        }
    }
}
