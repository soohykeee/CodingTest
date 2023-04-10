package programmers.exerciseLv2;

import java.util.Collections;
import java.util.PriorityQueue;

public class 프린터 {

    public int solution(int[] priorities, int location) {
        int answer = 0;

        //Collections.reverseOrder() 를 해줘야 최대부터 꺼낸다.
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < priorities.length; i++) {
            queue.add(priorities[i]);
        }

        while (!queue.isEmpty()) {
            for (int i = 0; i < priorities.length; i++) {
                if (priorities[i] == queue.peek()) {
                    if (i == location) {
                        answer++;
                        return answer;
                    }
                    queue.poll();
                    answer++;
                }
            }
        }

        return answer;
    }
}
