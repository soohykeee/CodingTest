package programmers.exerciseLv1;

import java.util.Stack;

/*
햄버거 만들기 - 연습문제 lv.1

 */
public class 햄버거만들기 {

    // 1 = 빵, 2 = 야채, 3 = 고기
    // 빵 - 야채 - 고기 - 빵
    // 1 2 3 1
    public int solution(int[] ingredient) {
        int answer = 0;

        Stack<Integer> stack = new Stack<>();

        for (int x : ingredient) {
            stack.push(x);

            if (stack.size() >= 4) {
                if (stack.get(stack.size() - 4) == 1
                        && stack.get(stack.size() - 3) == 2
                        && stack.get(stack.size() - 2) == 3
                        && stack.get(stack.size() - 1) == 1) {

                    answer ++;

                    stack.pop();
                    stack.pop();
                    stack.pop();
                    stack.pop();

                }
            }
        }


        return answer;
    }

    public static void main(String[] args) {
        햄버거만들기 T = new 햄버거만들기();

        System.out.println(T.solution(new int[]{2, 1, 1, 2, 3, 1, 2, 3, 1}));
        System.out.println(T.solution(new int[]{1, 3, 2, 1, 2, 1, 3, 1, 2}));
    }
}
