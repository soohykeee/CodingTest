package SKU_abc_camp;

import java.util.ArrayDeque;
import java.util.Deque;

public class DFS샘플 {

    public int[] solution(int n, int[][] arr) {
        int[] answer = {};

        int[][] adj = new int[n + 1][n + 1];
        boolean[] visited = new boolean[n + 1];

        // 인접행렬 양방향으로 연결
        for (int i = 0; i < arr.length; i++) {
            adj[arr[i][0]][arr[i][1]] = 1;
            adj[arr[i][1]][arr[i][0]] = 1;
        }

        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < n + 1; j++) {
                System.out.print(adj[i][j] + " ");
            }
            System.out.println("");
        }

        // DFS로 1부터 순차적으로 찾을 때 흐름에 대해 출력 해보기
        Deque<Integer> deque = new ArrayDeque<>();
        deque.addLast(1);

        while (!deque.isEmpty()) {

            int current = deque.removeFirst();

            // stack 에서 빼낸 것이 방문하지 않았으면 출력
            if (!visited[current]) {
                visited[current] = true;
                System.out.print(current + " ");
            }

            // stack 에서 빼낸 것과 연결된 것 중 방문 하지 않은 것들은 stack에 삽입
            for (int i = 1; i < n + 1; i++) {
                if (!visited[i] && adj[current][i] == 1) {
                    deque.addLast(i);
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        DFS샘플 T = new DFS샘플();

        System.out.println(T.solution(7, new int[][]{{1, 2}, {1, 3}, {2, 4}, {2, 5}, {4, 6}, {5, 6}, {6, 7}, {3, 7}}));

    }
}
