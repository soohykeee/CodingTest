package SKU_CodingTest.ch07;

/*
섬나라 아일랜드(DFS)
N*N의 섬나라 아일랜드의 지도가 격자판의 정보로 주어집니다. 각 섬은 1로 표시되어 상하좌
우와 대각선으로 연결되어 있으며, 0은 바다입니다.
1 1 0 0 0 1 0
0 1 1 0 1 1 0
0 1 0 0 0 0 0
0 0 0 1 0 1 1
1 1 0 1 1 0 0
1 0 0 0 1 0 0
1 0 1 0 1 0 0
만약 위와 같다면 섬나라 아일랜드에 몇 개의 섬이 있는지 구하는 프로그램을 작성하세요.
 */

public class graphDfs04 {

    int n, answer = 0;
    // 기존에는 상하좌우 4방향만 검사했지만, 해당 문제는 대각선도 검사해줘야한다
    int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
    int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};

    public void DFS(int x, int y, int[][] board) {
        for (int i = 0; i < 8; i++) {
            // 앞서 4방향 검사한것과 동일하게 8방향 검사
            int nx = x + dx[i];
            int ny = y + dy[i];

            // 0을 이용하여 맵의 바깥쪽인지 확인 + board[][] 가 1 (육지) 인지 확인
            if (nx >= 0 && nx < n && ny >= 0 && ny < n && board[nx][ny] == 1) {
                // 무한루프의 탈출을 위해 확인 한 곳은 0으로 바꿔준다.
                board[nx][ny] = 0;

                DFS(nx, ny, board);
            }
        }
    }

    public int solution(int[][] board) {
        n = board.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                // DFS 함수에 들어가면 시작한 값과 연결된 모두를 확인하고
                // 0으로 값을 바꿔주기 떄문에 DFS 에 들어가기전에 answer를 카운트해준다
                if (board[i][j] == 1) {
                    answer++;
                    board[i][j] = 0;
                    DFS(i, j, board);
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        graphDfs04 T = new graphDfs04();
        System.out.println(T.solution(new int[][]{
                {1, 1, 0, 0, 0, 1, 0}, {0, 1, 1, 0, 1, 1, 0},
                {0, 1, 0, 0, 0, 0, 0}, {0, 0, 0, 1, 0, 1, 1},
                {1, 1, 0, 1, 1, 0, 0}, {1, 0, 0, 0, 1, 0, 0},
                {1, 0, 1, 0, 1, 0, 0}
        }));
    }
}
