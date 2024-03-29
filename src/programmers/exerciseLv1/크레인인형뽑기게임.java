package programmers.exerciseLv1;

import java.util.Stack;

/*


 */
public class 크레인인형뽑기게임 {

    public int solution(int[][] board, int[] moves) {
        int answer = 0;

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < moves.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (board[j][moves[i] - 1] != 0) {

                    if (!stack.isEmpty() && stack.peek() == board[j][moves[i] - 1]) {
                        answer ++;
                        stack.pop();
                    } else {
                        stack.push(board[j][moves[i] - 1]);
                    }

                    board[j][moves[i] - 1] = 0;
                    break;
                }
            }
        }

        return answer*2;
    }

    public static void main(String[] args) {
        크레인인형뽑기게임 T = new 크레인인형뽑기게임();

        System.out.println(T.solution(new int[][]{{0, 0, 0, 0, 0}, {0, 0, 1, 0, 3}, {0, 2, 5, 0, 1}, {4, 2, 4, 4, 2}, {3, 5, 1, 3, 1}}, new int[]{1, 5, 3, 5, 1, 2, 1, 4}));

    }
}
