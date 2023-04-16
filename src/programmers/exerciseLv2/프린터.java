package programmers.exerciseLv2;

import java.util.Collections;
import java.util.PriorityQueue;

/*
프린터 - 연습문제 lv.2

 */
public class 프린터 {

    public int solution(int[] priorities, int location) {
        int answer = 0;

        //Collections.reverseOrder() 를 해줘야 최대부터 꺼낸다.
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());

        for (int x : priorities) {
            queue.add(x);
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

    public static void main(String[] args) {
        프린터 T = new 프린터();

        System.out.println(T.solution(new int[]{2, 1, 3, 2}, 2));
        System.out.println(T.solution(new int[]{1, 1, 9, 1, 1, 1}, 0));

    }
}
