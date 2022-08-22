package SKU_CodingTest.ch07;

/*
경로 탐색(인접행렬)
방향그래프가 주어지면 1번 정점에서 N번 정점으로 가는 모든 경로의 가지 수를 출력하는 프
로그램을 작성하세요. 아래 그래프에서 1번 정점에서 5번 정점으로 가는 가지 수는
1 2 3 4 5
1 2 5
1 3 4 2 5
1 3 4 5
1 4 2 5
1 4 5
총 6 가지입니다.
 */

public class graphDfs01 {

    int target, answer = 0;
    int[][] graph;
    int[] ch;

    public void DFS(int v) {
        if (v == target) {
            answer++;
        } else {
            for (int i = 1; i <= target; i++) {
                if (graph[v][i] == 1 && ch[i] == 0) {
                    ch[i] = 1;
                    DFS(i);
                    ch[i] = 0;
                }
            }
        }
    }

    public int solution(int n, int[][] edge) {
        graph = new int[n + 1][n + 1];
        ch = new int[n + 1];
        target = n;
        // graph라는 2차원 배열에 연결된 그래프에 1을 표시 (초기화)
        // 방향 그래프이다.
        for (int[] x : edge) {
            graph[x[0]][x[1]] = 1;
        }
        // check 배열을 통해 무한루프 해결, 1부터 시작하므로 ch[1]에 1을 미리 넣어줌
        // 1 사옹, 0 미사용
        ch[1] = 1;
        DFS(1);
        return answer;
    }

    public static void main(String[] args) {
        graphDfs01 T = new graphDfs01();
        System.out.println(T.solution(5, new int[][]{{1, 2}, {1, 3}, {1, 4},
                {2, 1}, {2, 3}, {2, 5}, {3, 4}, {4, 2}, {4, 5}}));
    }

}
