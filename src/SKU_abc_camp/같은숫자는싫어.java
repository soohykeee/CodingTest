package SKU_abc_camp;

import java.util.*;

public class 같은숫자는싫어 {

    public int[] solution(int []arr) {
        int[] answer = {};

        Deque<Integer> deque = new ArrayDeque<>();
        deque.addLast(arr[0]);

        for (int i = 1; i < arr.length; i++) {
            if (deque.getLast() != arr[i]) {
                deque.addLast(arr[i]);
            }
        }

        answer = new int[deque.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = deque.removeFirst();
        }

        return answer;
    }

    public static void main(String[] args) {
        같은숫자는싫어 T = new 같은숫자는싫어();

        System.out.println(T.solution(new int[]{1, 1, 3, 3, 0, 1, 1}));
        System.out.println(T.solution(new int[]{4, 4, 4, 3, 3}));
    }
}
