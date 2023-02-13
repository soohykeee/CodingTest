package programmers.swmaestro코테대비;

import java.util.Scanner;

public class DFSSample {

    public static int[][] graph;
    public static boolean[] visited;

    public static void DFS(int start) {
        visited[start] = true;
        System.out.print(start + " ");

        for (int i = 0; i < graph.length; i++) {
            if (graph[start][i] == 1 && !visited[i]) {
                DFS(i);
            }
        }
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();                   // 정점 개수
        int m = sc.nextInt();                   // 간선 개수
        graph = new int[n][n];
        visited = new boolean[n];

        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            //graph[a][b] = graph[b][a] = 1;    //양방향
            graph[a][b] = 1;                    //단방향
        }

        System.out.println("");
        System.out.println("탐색 시작할 번호 입력 :");
        int start = sc.nextInt();

        DFS(start);
    }
}
