package programmers.stackAndQueue;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/*
기능개발

프로그래머스 팀에서는 기능 개선 작업을 수행 중입니다. 각 기능은 진도가 100%일 때 서비스에 반영할 수 있습니다.
또, 각 기능의 개발속도는 모두 다르기 때문에 뒤에 있는 기능이 앞에 있는 기능보다 먼저 개발될 수 있고,
이때 뒤에 있는 기능은 앞에 있는 기능이 배포될 때 함께 배포됩니다.
먼저 배포되어야 하는 순서대로 작업의 진도가 적힌 정수 배열 progresses와
각 작업의 개발 속도가 적힌 정수 배열 speeds가 주어질 때 각 배포마다 몇 개의 기능이 배포되는지를
return 하도록 solution 함수를 완성하세요.
 */
public class queue01 {

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

    public static void main(String[] args) {
        queue01 T = new queue01();

        System.out.println(T.solution(new int[]{93, 30, 55}, new int[]{1, 30, 5}));
        System.out.println(T.solution(new int[]{95, 90, 99, 99, 80, 99}, new int[]{1, 1, 1, 1, 1, 1}));

    }
}
