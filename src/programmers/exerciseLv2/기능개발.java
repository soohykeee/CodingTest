package programmers.exerciseLv2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class 기능개발 {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] answer = {};

        ArrayList<Integer> arrayList = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < progresses.length; i++) {
            queue.add((int) Math.ceil((double) (100 - progresses[i]) / speeds[i]));
        }

        int front = queue.poll();
        int count = 1;
        while (!queue.isEmpty()) {
            if (front < queue.peek()) {
                arrayList.add(count);
                front = queue.poll();
                count = 1;
            } else {
                count++;
                queue.poll();
            }
        }
        arrayList.add(count);

        answer = new int[arrayList.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = arrayList.get(i);
        }

        return answer;
    }
}
