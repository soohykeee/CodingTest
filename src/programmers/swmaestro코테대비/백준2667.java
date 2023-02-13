package programmers.swmaestro코테대비;

import java.util.*;

/*
백준 2667 - 단지번호 붙이기
 */
public class 백준2667 {

    // 상 하 좌 우
    public static int[] dx = {0, 0, -1, 1};
    public static int[] dy = {-1, 1, 0, 0};

    public static int N;
    public static int[][] apart;
    public static boolean[][] visited;
    public static Queue<Integer> queue = new LinkedList<>();
    public static ArrayList<Integer> apartmentComplex = new ArrayList<>();
    public static int complex;

    public static void BFS(int x, int y) {
        visited[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && ny >= 0 && nx < N && ny < N) {
                if (apart[nx][ny] == 1 && !visited[nx][ny]) {
                    BFS(nx, ny);
                    complex++;
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        apart = new int[N][N];
        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            String str = sc.next();
            for (int j = 0; j < N; j++) {
                apart[i][j] = str.charAt(j) - '0';
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (apart[i][j] == 1 && !visited[i][j]) {
                    complex = 1;
                    BFS(i, j);
                    apartmentComplex.add(complex);
                }

            }
        }

        Collections.sort(apartmentComplex);
        System.out.println(apartmentComplex.size());
        for (int x : apartmentComplex) {
            System.out.println(x);
        }

    }
}
