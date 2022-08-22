package SKU_CodingTest.ch05;

/*
최대 수입 스케쥴
        현수는 유명한 강연자이다. N개이 기업에서 강연 요청을 해왔다. 각 기업은 D일 안에 와서 강
        연을 해 주면 M만큼의 강연료를 주기로 했다.
        각 기업이 요청한 D와 M의 정보를 바탕으로 가장 많을 돈을 벌 수 있도록 강연 스케쥴을 짜
        야 한다.
        단 강연의 특성상 현수는 하루에 하나의 기업에서만 강연을 할 수 있다.
*/

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

public class greedy08 {
    public int solution(int[][] times) {

        int answer = 0;
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Collections.reverseOrder());

        Arrays.sort(times, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[1] - o1[1];
            }
        });

        int maxd = times[0][1];
        int j = 0;
        for (int i = maxd; i >= 1; i--) {
            for (; j < times.length; j++) {
                if (times[j][1] < i) {
                    break;
                }
                priorityQueue.offer(times[j][0]);
            }
            if (!priorityQueue.isEmpty()) {
                answer += priorityQueue.poll();
            }
        }

        return answer;

    }

    public static void main(String[] args) {
        greedy08 T = new greedy08();

        int[][] times1 = {{50, 2}, {20, 1}, {40, 2}, {60, 3}, {30, 3}, {30, 1}};
        // 60-3, 50-2, 40-2, 30-3, 30-1, 20-1
        System.out.println(T.solution(times1));

        int[][] times2 = {{50, 2}, {40, 2}, {20, 1}, {10, 1}};
        // 50-2, 40-2, 20-1, 10-1
        System.out.println(T.solution(times2));

    }


}
