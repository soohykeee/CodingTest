package programmers.exerciseLv2;

import java.util.PriorityQueue;

public class 더맵게 {
    public int solution(int[] scoville, int K) {
        int answer = 0;

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        for (int x : scoville) {
            priorityQueue.add(x);
        }

        while (priorityQueue.peek() < K) {
            if (priorityQueue.size() == 1) {
                return -1;
            }
            priorityQueue.add(priorityQueue.poll() + (priorityQueue.poll() * 2));
            answer ++;
        }

        return answer;
    }

}
