package programmers.swmaestro코테대비;

import java.util.Scanner;

/*
백준 15650 - N과M (2)

 */
public class 백준15650 {

    static int N, M;
    static int[] arr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();

        arr = new int[M];

        DFS(0, 0);
    }

    static void DFS(int start, int depth) {
        if (depth == M) {
            for (int i = 0; i < arr.length; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
            return;
        }

        for (int i = start; i < N; i++) {
            arr[depth] = i + 1;
            DFS(i + 1, depth + 1);
        }
    }
}
