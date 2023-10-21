package SKU_abc_camp;

public class 달팽이1 {

    /*
    풀이 방법 1 : 델타탐색
     */



    public int[] solution(int n, int find) {
        int[] answer = new int [2];
        int[][] snail = new int[n][n];

        // 하 우 상 좌
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};

        int x = 0, y = 0, d = 0;

        for (int i = n * n; i > 0; i--) {
            snail[x][y] = i;

            if (i == find) {
                answer[0] = x + 1;
                answer[1] = y + 1;
            }

            int nx = x + dx[d];
            int ny = y + dy[d];

            if (nx < 0 || nx >= n || ny < 0 || ny >= n || snail[nx][ny] != 0) {
                d = (d + 1) % 4;
                nx = x + dx[d];
                ny = y + dy[d];
            }
            x = nx;
            y = ny;

        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(snail[i][j] + " ");
            }
            System.out.println("");
        }

        System.out.println(answer[0] + " " + answer[1]);

        return answer;
    }

    public static void main(String[] args) {
        달팽이1 T = new 달팽이1();

        System.out.println(T.solution(7, 35));

    }
}
