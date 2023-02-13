package programmers.swmaestro코테대비;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BFSSample {

    public static boolean[] visited;
    public static int[][] graph;
    public static Queue<Integer> queue = new LinkedList<>();

    public static void BFS(int start) {
        queue.add(start);
        visited[start] = true;

        while (!queue.isEmpty()) {
            int temp = queue.poll();
            System.out.print(temp + " ");

            for (int i = 0; i < graph.length; i++) {
                if (graph[temp][i] == 1 && !visited[i]) {
                    queue.add(i);
                    visited[i] = true;
                }
            }
        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();           // 정점의 개수
        int m = sc.nextInt();           // 간선의 개수

        visited = new boolean[n];
        graph = new int[n][n];

        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            graph[a][b] = 1;
        }

        System.out.println();
        System.out.println("탐색 시작할 번호 입력 :");
        int start = sc.nextInt();

        BFS(start);
    }
}
