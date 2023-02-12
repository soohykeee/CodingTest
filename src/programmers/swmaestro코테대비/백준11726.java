package programmers.swmaestro코테대비;

import java.util.Scanner;

/*
백준 11726 - 2*n 타일링

 */
public class 백준11726 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] arr = new int[n + 1];
        arr[1] = 1;

        // ArrayIndexOutOfBoundException 방지를 위해 추가.
        if (n >= 2) {
            arr[2] = 2;
        }
        for (int i = 3; i <= n; i++) {
            arr[i] = (arr[i - 2] + arr[i - 1]) % 10007;
        }

        System.out.println(arr[n]);

    }
}
