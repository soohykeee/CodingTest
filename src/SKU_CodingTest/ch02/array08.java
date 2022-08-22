package SKU_CodingTest.ch02;

/*
봉우리
        지도 정보가 N*N 격자판에 주어집니다. 각 격자에는 그 지역의 높이가 쓰여있습니다. 각 격자
        판의 숫자 중 자신의 상하좌우 숫자보다 큰 숫자는 봉우리 지역입니다. 봉우리 지역이 몇 개
        있는 지 알아내는 프로그램을 작성하세요.
        격자의 가장자리는 0으로 초기화 되었다고 가정한다.
        만약 N=5 이고, 격자판의 숫자가 다음과 같다면 봉우리의 개수는 10개입니다.
*/

public class array08 {

    public int solution(int[][] board) {

        int answer=0;
        // 좌, 상, 우, 하
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                boolean flag = true;
                for (int k = 0; k < 4; k++) {
                    int nx = i + dx[k];
                    int ny = j + dy[k];
                    if (nx >= 0 && ny >= 0 && nx < board.length && ny < board.length
                            && board[nx][ny] >= board[i][j]) {
                        flag = false;
                        break;
                    }
                }
                if(flag) answer++;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        array08 T = new array08();

        int[][] arr={{5, 3, 7, 2, 3},
                {3, 7, 1, 6, 1},
                {7, 2, 5, 3, 4},
                {4, 3, 6, 4, 1},
                {8, 7, 3, 5, 2}};
        System.out.println(T.solution(arr));
    }

}
