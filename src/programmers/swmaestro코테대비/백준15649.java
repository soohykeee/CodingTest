package programmers.swmaestro코테대비;

import java.util.Scanner;

/*
백준 15649 - N과M (1)

 */
public class 백준15649 {

    static boolean[] visited;
    static int[] arr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();

        visited = new boolean[N];
        arr = new int[M];

        DFS(N, M, 0);
    }

    static void DFS(int N, int M, int depth) {
        if (depth == M) {
            for (int i = 0; i < M; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
            return;
        }

        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                arr[depth] = i + 1;
                DFS(N, M, depth + 1);
                visited[i] = false;
            }
        }
    }
}
