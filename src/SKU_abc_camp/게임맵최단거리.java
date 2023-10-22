package SKU_abc_camp;

import java.util.ArrayDeque;
import java.util.Deque;

public class 게임맵최단거리 {

    class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public int solution(int[][] maps) {
        int answer = 0;
        int n = maps.length;
        int m = maps[0].length;

        // 상 하 좌 우
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        int[][] visited = new int[n][m];

        Deque<Node> deque = new ArrayDeque<>();
        deque.addLast(new Node(0, 0));
        maps[0][0] = 0;
        visited[0][0] = 1;

        while (!deque.isEmpty()) {
            Node current = deque.removeFirst();

            for (int i = 0; i < 4; i++) {
                int nx = current.x + dx[i];
                int ny = current.y + dy[i];

                if (nx >= 0 && ny >= 0 && nx < n && ny < m && visited[nx][ny]==0 && maps[nx][ny] == 1) {
                    visited[nx][ny] = visited[current.x][current.y] + 1;
                    maps[nx][ny] = 0;
                    deque.addLast(new Node(nx, ny));
                }
            }
        }

        answer = visited[n - 1][m - 1];

        if (answer == 0) {
            return -1;
        }

        return answer;
    }

    public static void main(String[] args) {
        게임맵최단거리 T = new 게임맵최단거리();

        System.out.println(T.solution(new int[][]{{1, 0, 1, 1, 1}, {1, 0, 1, 0, 1}, {1, 0, 1, 1, 1}, {1, 1, 1, 0, 1}, {0, 0, 0, 0, 1}}));
        System.out.println(T.solution(new int[][]{{1, 0, 1, 1, 1}, {1, 0, 1, 0, 1}, {1, 0, 1, 1, 1}, {1, 1, 1, 0, 0}, {0, 0, 0, 0, 1}}));
    }
}
