package programmers.swmaestro코테대비;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*
백준 1260 - DFS와 BFS

 */
public class 백준1260 {

    public static int N;
    public static int M;
    public static int V;
    public static boolean[] visit;
    public static int[][] arr;
    public static Queue<Integer> queue = new LinkedList<>();

    public static void DFS(int start) {
        visit[start] = true;
        System.out.print(start + " ");

        for (int i = 1; i <= N; i++) {
            if (arr[start][i] == 1 && !visit[i]) {
                DFS(i);
            }
        }

    }

    public static void BFS(int start) {
        queue.add(start);
        visit[start] = true;

        while (!queue.isEmpty()) {
            start = queue.poll();
            System.out.print(start + " ");

            for (int i = 1; i <= N; i++) {
                if (arr[start][i] == 1 && !visit[i]) {
                    queue.add(i);
                    visit[i] = true;
                }
            }
        }


    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();
        V = sc.nextInt();

        visit = new boolean[N + 1];
        arr = new int[N + 1][N + 1];

        for (int i = 0; i < M; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            arr[a][b] = arr[b][a] = 1;
        }

        DFS(V);
        System.out.println();
        visit = new boolean[N + 1];
        BFS(V);

    }
}
