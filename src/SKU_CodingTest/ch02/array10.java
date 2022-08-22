package SKU_CodingTest.ch02;


/*
회장선거
        현수네 반은 오늘 회장선거를 합니다. 현수네 반 N명의 학생은 각자 자기가 좋아하는 학생을
        회장후보로 추천합니다. 한 학생이 여러명을 추천할 수 있습니다.
        추천횟수가 k번 이상인 학생들만 회장선거에 출마할 수 있습니다. 회장선거에 출마한 학생들
        은 자기를 추천해준 학생들에게 감사의 이메일을 보내기로 했습니다.
        0번 학생부터 N-1번 학생까지 각 학생이 감사이메일을 받는 횟수를 알아내는 프로그램을 작
        성하세요.
        만약 0번 학생이 3번학생을 추천 했다면 [0, 3]의 순써쌍 입력정보가 들어옵니다.
        만약 반 학생이 4명이고, 각 학생의 추천정보가 [0, 1], [0, 3], [1, 2], [2, 0], [2, 3], [3,
        0]이고, k=2이면 회장후보는 0번과 3번이다. 그리고 각 학생이 받는 감사이메일 횟수는 0번은
        1통, 1번은 0통, 2번은 2통, 3번은 1통입니다.
*/

import java.util.ArrayList;

public class array10 {

    public ArrayList<Integer> solution(int n, int[][] votes, int k) {

        ArrayList<Integer> answer = new ArrayList<>();

        int[][] board = new int[n][n];
        int[] candidate = new int[n];

        for (int[] x : votes) {
            board[x[0]][x[1]] = 1;
        }

        for (int i = 0; i < n; i++) {
            int count=0;
            for (int j = 0; j < n; j++) {
                if(board[j][i]==1) count++;
            }
            if (count >= k) {
                candidate[i]=1;
            }
        }

        for (int i = 0; i < n; i++) {
            int count=0;
            for (int j = 0; j < n; j++) {
                if(board[i][j]==1 && candidate[j]==1) count++;
            }
            answer.add(i, count);
        }

        return answer;
    }

    public static void main(String[] args) {
        array10 T = new array10();

        int[][] arr = {{0, 1}, {0, 3}, {1, 2}, {2, 0}, {2, 3}, {3, 0}};
        System.out.println(T.solution(4, arr, 2));
    }
}
