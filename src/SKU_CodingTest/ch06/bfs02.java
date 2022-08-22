package SKU_CodingTest.ch06;

/*
미로의 최단거리 통로(BFS)
7*7 격자판 미로를 탈출하는 최단경로의 길이를 출력하는 프로그램을 작성하세요. 경로의 길
이는 출발점에서 도착점까지 가는데 이동한 횟수를 의미한다. 출발점은 격자의 (1, 1) 좌표이
고, 탈출 도착점은 (7, 7)좌표이다. 격자판의 1은 벽이고, 0은 도로이다.
격자판의 움직임은 상하좌우로만 움직인다. 미로가 다음과 같다면
출발 0 0 0 0 0 0
    0 1 1 1 1 1 0
    0 0 0 1 0 0 0
    1 1 0 1 0 1 1
    1 1 0 1 0 0 0
    1 0 0 0 1 0 0
    1 0 1 0 0 0 도착
위와 같은 경로가 최단 경로의 길이는 12이다.
 */

import java.util.LinkedList;
import java.util.Queue;

class Point{
    public int x, y;
    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class bfs02 {

    public int solution(int[][] board) {
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};
        int[][] dis = new int[7][7];

        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(0, 0));
        board[0][0] = 1;

        while (!queue.isEmpty()) {
            Point temp = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nx = temp.x + dx[i];
                int ny = temp.y + dy[i];

                if (nx >= 0 && nx < 7 && ny >= 0 && ny < 7 && board[nx][ny] == 0) {
                    // 지나온 길을 1로 표시해서 무한루프 되지 않도록
                    board[nx][ny] = 1;
                    queue.offer(new Point(nx, ny));
                    dis[nx][ny] = dis[temp.x][temp.y] + 1;
                }
            }
        }

        if (dis[6][6] == 0) return -1;
        else return dis[6][6];
    }

    public static void main(String[] args) {
        bfs02 T = new bfs02();

        int[][] arr={{0, 0, 0, 0, 0, 0, 0},
                {0, 1, 1, 1, 1, 1, 0},
                {0, 0, 0, 1, 0, 0, 0},
                {1, 1, 0, 1, 0, 1, 1},
                {1, 1, 0, 1, 0, 0, 0},
                {1, 0, 0, 0, 1, 0, 0},
                {1, 0, 1, 0, 0, 0, 0}};

        System.out.println(T.solution(arr));
    }
}
