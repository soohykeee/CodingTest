package SKU_CodingTest.ch08;

/*
플로이드 와샬 알고리즘
N개의 도시가 주어지고, 각 도시들을 연결하는 도로와 해당 도로를 통행하는 비용이 주어질
때 모든 도시에서 모든 도시로 이동하는데 쓰이는 비용의 최소값을 구하는 프로그램을 작성하세요.

모든 정점에서 모든 정점으로의 최단 경로를 구하고 싶을 떄 사용하는 알고리즘
거쳐가는 정점을 기준으로 알고리즘을 수행
 */

public class floydWarshall01 {

    public int solution(int n, int[][] edges) {

        // 비용을 저장하는 dy 이차원 배열 초기화.
        int[][] dy = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i == j) {
                    dy[i][j] = 0;
                } else {
                    dy[i][j] = 100000;
                }
            }
        }

        // 연결된 간선의 비용을 갱신
        for (int[] x : edges) {
            dy[x[0]][x[1]] = x[2];
        }

        // 중간에 k를 거쳐 도달 정점으로 갈때 원래 비용보다 최소라면 새로 값을 갱신
        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    // i~j로 가는길에 k를 거쳐 가는 경로
                    if (dy[i][k] + dy[k][j] < dy[i][j]) {
                        dy[i][j] = dy[i][k] + dy[k][j];
                    }
                }
            }
        }

        // 답 출력
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (dy[i][j] == 100000) {
                    System.out.print("M ");
                } else {
                    System.out.print(dy[i][j] + " ");
                }
            }
            System.out.println();
        }

        return 0;
    }

    public static void main(String[] args) {
        floydWarshall01 T = new floydWarshall01();
        System.out.println(T.solution(5, new int[][]{{1, 2, 6}, {1, 3, 3}, {3, 2, 2},
                {2, 4, 1}, {2, 5, 13}, {3, 4, 5}, {4, 2, 3}, {4, 5, 7}}));
    }
}
