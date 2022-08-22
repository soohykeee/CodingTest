package SKU_CodingTest.ch07;

import java.util.ArrayList;

/*
동아리 개수
현수가 다니는 학교에는 동아리가 많이 있습니다. 현수가 다니는 학교의 동아리의 개수를 구하는
프로그램을 작성하세요.
현수가 다니는 학교의 학생은 1번부터 N번까지 번호가 부여된 N명의 학생들로 되어 입력됩니다.
만약 1번 학생과 2번 학생이 같은 동아리 이면 (1, 2) 순서쌍으로 입력되며, (2, 3)이 입력되면
1, 2, 3번 학생은 같은 동아리입니다.
모든 학생은 동아리를 가지고 있습니다.
 */

public class graphDfs03 {

    ArrayList<ArrayList<Integer>> graph;
    int[] ch;

    public void DFS(int v) {
        // DFS(v)에서 v에 들어온 값과 연결된 수들을 반복문을 돌려서
        // 이미 check 한지 확인하고, check 가 안되어 있으면 1로 바꿔주고
        // 해당 nv에 연결된 간선을 재귀함수로 확인한다.
        for (int nv : graph.get(v)) {
            //System.out.println("----"+nv);
            if (ch[nv] == 0) {
                ch[nv] = 1;
                DFS(nv);
            }
        }
    }

    public int solution(int n, int[][] edge) {
        int answer = 0;
        // check 배열 초기화
        ch = new int[n + 1];

        // 인접리스트 생성 + 초기화 + 공간미리생성
        graph = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<Integer>());
        }

        //방향그래프가 아니므로 양쪽을 다 연결해준다.
        for (int[] x : edge) {
            graph.get(x[0]).add(x[1]);
            graph.get(x[1]).add(x[0]);
        }

        // DFS에서 check 배열을 통해서 카운트를 하므로, DFS에 들어가기전에
        // 미리 answer++ 를 해준다.
        for (int i = 1; i <= n; i++) {
            if (ch[i] == 0) {
                ch[i] = 1;
                answer++;
                DFS(i);
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        graphDfs03 T = new graphDfs03();
        System.out.println(T.solution(7, new int[][]{{1, 2}, {2, 3}, {1, 4}, {1, 5}}));
    }
}
