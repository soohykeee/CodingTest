package SKU_abc_camp;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

public class 기능개발 {

    public int[] solution(int[] progresses, int[] speeds) {
        int[] answer = {};
        ArrayList<Integer> list = new ArrayList<>();

        int n = progresses.length;
        Deque<Integer> deque = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            int cal = (100 - progresses[i]) / speeds[i];
            if ((100 - progresses[i]) % speeds[i] == 0) {
                deque.addLast(cal);
            } else {
                deque.addLast(cal + 1);
            }
        }

        int first = deque.removeFirst();
        int count = 1;
        while (deque.size() != 0) {
            if (first >= deque.getFirst()) {
                deque.removeFirst();
                count++;
            } else {
                first = deque.removeFirst();
                list.add(count);
                count = 1;
            }
        }
        list.add(count);

        answer = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }

        return answer;
    }

    public static void main(String[] args) {
        기능개발 T = new 기능개발();

        System.out.println(T.solution(new int[]{93, 30, 55}, new int[]{1, 30, 5}));
        System.out.println(T.solution(new int[]{95, 90, 99, 99, 80, 99}, new int[]{1, 1, 1, 1, 1, 1}));
    }
}
