package ch02;

/*
스카이라인
        N*N 격자판에 N*N개의 도시 빌딩의 높이정보가 주어집니다.
    도시를 앞에7서 봤을 때 스카이 라인은 왼쪽부터 해서 [7, 8, 9, 8]의 높이정보로 보이고, 옆에
        서 보면 위쪽에서부터 해서 [7, 9, 5, 8]입니다.
        도시의 각 빌딩들의 높이를 높이는데 도시의 스카이라인은 변함이 없이 각 빌딩의 높이를 최
        대한 높이고자 합니다. 각 빌딩의 높이를 증가시킬 수 있는 최대 높이의 합을 구하는 프로그
        램을 작성하세요.
*/

public class array09 {

    public int solution(int[][] board) {

        int answer=0;

        int[] frontMax = new int[board[0].length];
        int[] sideMax = new int[board.length];

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                frontMax[i] = Math.max(frontMax[i], board[j][i]);
                sideMax[i] = Math.max(sideMax[i], board[i][j]);
            }
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                answer += ((Math.min(frontMax[j], sideMax[i])) - board[i][j]);
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        array09 T = new array09();

        int[][] arr1={{2, 5, 7, 3},
                {6, 8, 9, 7},
                {3, 2, 4, 5},
                {7, 2, 5, 8}};
        System.out.println(T.solution(arr1));

        int[][] arr2={{3, 7, 6, 2},
                {5, 3, 8, 7},
                {3, 2, 5, 7},
                {7, 7, 5, 3}};
        System.out.println(T.solution(arr2));
    }
}
