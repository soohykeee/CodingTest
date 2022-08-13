package ch07;

/*
경로 탐색(인접리스트)
방향그래프가 주어지면 1번 정점에서 N번 정점으로 가는 모든 경로의 가지 수를 출력하는 프
로그램을 작성하세요. 아래 그래프에서 1번 정점에서 5번 정점으로 가는 가지 수는
1 2 3 4 5
1 2 5
1 3 4 2 5
1 3 4 5
1 4 2 5
1 4 5
총 6 가지입니다.

앞서와 다른 점은 공간복잡도가 더 효율적이다.
인접행렬이 아니라 인접리스트를 활용.
인접리스트가 더 효율적이다.
외우는 편이 좋음
 */

import java.util.ArrayList;

public class graphDfs02 {

    // target -> 입력하는 n 값을 넘겨주기 위한 전역번수 선언
    int target, answer = 0;
    // 2차원 ArrayList
    ArrayList<ArrayList<Integer>> graph;
    int[] ch;

    public void DFS(int v) {
        if (v == target) {
            answer++;
        } else {
            // 반복문으로 arrayList를 돌면서 만약 연결된 것에서 check 배열에서 0으로 미사용 했으면
            // 1로 바꿔주고, 재귀함수로 DFS에 다시 값을 넘겨주어 target과 같이 될때까지 돌려준다.
            for (int nv : graph.get(v)) {
                if (ch[nv] == 0) {
                    ch[nv] = 1;
                    DFS(nv);
                    ch[nv] = 0;
                }
            }
        }
    }

    public int solution(int n, int[][] edge) {
        // 인접리스트 생성 + 초기화 + 공간미리생성
        graph = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<Integer>());
        }
        // check 배열 초기화
        ch = new int[n + 1];
        // 전역변수인 target에 도달해야할 정점을 넘겨준다.
        target = n;

        // 방향그래프라서 한쪽으로만 연결
        for (int[] x : edge) {
            graph.get(x[0]).add(x[1]);
        }

        ch[1] = 1;
        DFS(1);

        return answer;
    }

    public static void main(String[] args) {
        graphDfs02 T = new graphDfs02();
        System.out.println(T.solution(5, new int[][]{{1, 2}, {1, 3}, {1, 4}, {2, 1}, {2, 3}, {2, 5},
                {3, 4}, {4, 2}, {4, 5}}));
    }
}
