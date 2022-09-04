package programmers.heap;

/*
디스크 컨트롤러

하드디스크는 한 번에 하나의 작업만 수행할 수 있습니다. 디스크 컨트롤러를 구현하는 방법은 여러 가지가 있습니다.
가장 일반적인 방법은 요청이 들어온 순서대로 처리하는 것입니다.

예를들어
- 0ms 시점에 3ms가 소요되는 A작업 요청
- 1ms 시점에 9ms가 소요되는 B작업 요청
- 2ms 시점에 6ms가 소요되는 C작업 요청

한 번에 하나의 요청만을 수행할 수 있기 때문에 각각의 작업을 요청받은 순서대로 처리하면 다음과 같이 처리 됩니다.
- A: 3ms 시점에 작업 완료 (요청에서 종료까지 : 3ms)
- B: 1ms부터 대기하다가, 3ms 시점에 작업을 시작해서 12ms 시점에 작업 완료(요청에서 종료까지 : 11ms)
- C: 2ms부터 대기하다가, 12ms 시점에 작업을 시작해서 18ms 시점에 작업 완료(요청에서 종료까지 : 16ms)
이 때 각 작업의 요청부터 종료까지 걸린 시간의 평균은 10ms(= (3 + 11 + 16) / 3)가 됩니다.

하지만 A → C → B 순서대로 처리하면
- A: 3ms 시점에 작업 완료(요청에서 종료까지 : 3ms)
- C: 2ms부터 대기하다가, 3ms 시점에 작업을 시작해서 9ms 시점에 작업 완료(요청에서 종료까지 : 7ms)
- B: 1ms부터 대기하다가, 9ms 시점에 작업을 시작해서 18ms 시점에 작업 완료(요청에서 종료까지 : 17ms)
이렇게 A → C → B의 순서로 처리하면 각 작업의 요청부터 종료까지 걸린 시간의 평균은 9ms(= (3 + 7 + 17) / 3)가 됩니다.

각 작업에 대해 [작업이 요청되는 시점, 작업의 소요시간]을 담은 2차원 배열 jobs가 매개변수로 주어질 때,
작업의 요청부터 종료까지 걸린 시간의 평균을 가장 줄이는 방법으로 처리하면 평균이 얼마가 되는지 return 하도록 solution 함수를 작성해주세요.
(단, 소수점 이하의 수는 버립니다)
 */

import java.util.Arrays;
import java.util.PriorityQueue;

/*
해당 문제를 해결하기 위한 Tip
1. jobs 배열이 요청 시간 순서에 따라 들어오는 것이 아니라, 무작위로 들어오므로 오름차순 정렬을 해줘야한다.
2. 요청시간부터 종료시간까지 가장 짧게 배치하기 위해서는 수행시간이 짧은 것부터 해결하는 것이 더 빠르다.
3. (2)번에서 주의할 점이, 무작정 요청시간이 짧은 것을 먼저 수행하는 것이 아니라, 하나의 작업이 끝나는 시점까지
들어온 요청들에 한해서 가장 짧은 수행시간을 가진 작업을 우선 선택해야 효율적이다.
 */

public class heap02 {

    public int solution(int[][] jobs) {
        int answer = 0;
        int end = 0; // 수행완료된 직후의 시간
        int jobsIndex = 0; // jobs 배열의 인덱스
        int count = 0; // 수행이 완료된 갯수

        // 요청시간으로 오름차순 정렬
        Arrays.sort(jobs, ((o1, o2) -> o1[0] - o2[0]));

        // 처리시간으로 오름차순 정렬하는 priorityQueue (heap)
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);

        while (count < jobs.length) {

            //들어온 하나의 작업이 완료되기 전까지 요청된 모든 요청을 우선순위 큐에 넣는다.
            while (jobsIndex < jobs.length && jobs[jobsIndex][0] <= end) {
                priorityQueue.add(jobs[jobsIndex++]);
            }

            if (priorityQueue.isEmpty()) {
                end = jobs[jobsIndex][0];
            } else {
                int[] temp = priorityQueue.poll();
                answer += temp[1] + end - temp[0];
                end += temp[1];
                count++;
            }
        }

        return (int) Math.floor(answer / jobs.length);

    }

    public static void main(String[] args) {
        heap02 T = new heap02();

        System.out.println(T.solution(new int[][]{{0, 3}, {1, 9}, {2, 6}}));

    }
}
