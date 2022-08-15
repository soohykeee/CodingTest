package ch07;

/*
줄다리기
현수네 반 총 인원수는 7명입니다. 오늘은 운동회 날로 반대항 줄다리기 시합이 있습니다.
현수네 반 총 인원인 7명이 모두 줄다리기에 출전합니다.
선생님은 줄다리기를 하기 위해 7명을 일렬로 세우는데 서로 싫어하는 학생끼리 붙어서 일렬
로 세우면 싸움이 납니다.
현수네 반 학생의 서로 싫어하는 정보가 주어지면 싸우지 않고 줄다리기를 하기 위해 일렬로
세울 수 있는 모든 방법의 수를 구하세요.
 */

import java.util.Stack;

public class graphDfs05 {

    int[] ch;
    int[][] relation;
    int answer = 0;
    Stack<Integer> stack = new Stack<>();

    public void DFS(int n) {
        if (n == 7) {
            answer++;
        } else {
            for (int i = 1; i < 8; i++) {
                // stack에 값이 존재하고 (줄을 누군가 서있다는 뜻), 미리 fight 정보를 연결해 놓은
                // relation 배열에서 fight 정보가 있는 사람이 연속해서 오게 된다면 continue를 통해
                // 다른 i로 넘어가게 if문 조건
                if (!stack.isEmpty() && relation[stack.peek()][i] == 1)
                    continue;
                // check 배열을 통해 이미 stack에 넣은 값인지 확인,
                // stack에 넣은 값이 아니라면 1로 바꿔주고 stack에 넣어준다음 dfs 재귀함수 돌도록
                if (ch[i] == 0) {
                    ch[i] = 1;
                    stack.push(i);
                    DFS(n + 1);
                    ch[i] = 0;
                    stack.pop();
                }
            }
        }
    }

    public int solution(int[][] fight) {
        // relation 이차원 배열에 fight 배열 정보를 양쪽으로(무방향) 연결
        relation = new int[8][8];
        ch = new int[8];

        // 무방향 그래프이므로 양쪽으로 연결
        for (int[] x : fight) {
            relation[x[0]][x[1]] = 1;
            relation[x[1]][x[0]] = 1;
        }

        DFS(0);

        return answer;
    }

    public static void main(String[] args) {
        graphDfs05 T = new graphDfs05();
        System.out.println(T.solution(new int[][] { { 1, 3 }, { 5, 7 }, { 4, 2 } }));
    }

}
