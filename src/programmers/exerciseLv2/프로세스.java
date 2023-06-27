package programmers.exerciseLv2;

/*
프로세스 - 스택/큐 lv.2

 */

import java.util.Collections;
import java.util.PriorityQueue;

public class 프로세스 {

    public int solution(int[] priorities, int location) {
        int answer = 0;

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Collections.reverseOrder());

        for (int x : priorities) {
            priorityQueue.add(x);
        }

        while (!priorityQueue.isEmpty()) {
            for (int i = 0; i < priorities.length; i++) {
                if (priorities[i] == priorityQueue.peek()) {
                    if (i == location) {
                        answer++;
                        return answer;
                    }

                    priorityQueue.poll();
                    answer++;
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        프로세스 T = new 프로세스();

        System.out.println(T.solution(new int[]{2, 1, 3, 2}, 2));
        System.out.println(T.solution(new int[]{1, 1, 9, 1, 1, 1}, 0));
    }

}
