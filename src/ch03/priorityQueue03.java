package ch03;

import java.util.Collections;
import java.util.PriorityQueue;

/*
마지막 남은 수
        N길이의 수열이 주어집니다. 현수는 이 수열에서 가장 큰 두 개의 수를 뽑아 다음과 같은 행
        동을 합니다.
        만약 가장 큰 두 수가 a, b라면
        1. a==b(같다)이면 수열에서 두 수는 사라집니다.
        2. a!=b(다르다)이면 두 수 a와 b는 사라지고, |a-b|가 수열에 추가됩니다.
        이 과정을 반복하면 최종적으로 수열에서 1개의 수가 남거나 모두 사라지게 됩니다.
        예들 들어 N=5인 수열 [5, 2, 4, 3, 1]이 주어지면
        5, 4가 뽑히고 (5-4)의 값인 1이 추가되어 [1, 2, 3, 1]이 됩니다.
        3, 2가 뽑히고 (3-2)이 값인 1이 추가되어 [1, 1, 1]이 됩니다.
        1, 1이 뽑히고 두 수는 사라지므로 수열은 [1]이 됩니다.
        최종결과 마지막 남은 수는 1입니다.
*/

public class priorityQueue03 {

    public int solution(int[] nums) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Collections.reverseOrder());

        for (int x : nums) {
            priorityQueue.offer(x);
        }

        while (priorityQueue.size() > 1) {
            int temp=priorityQueue.poll();
            if (temp == priorityQueue.peek()) {
                priorityQueue.poll();
            } else {
                priorityQueue.offer(temp - priorityQueue.poll());
            }
        }

        if (priorityQueue.isEmpty()) {
            return 0;
        } else {
            return priorityQueue.poll();
        }
    }

    public static void main(String[] args) {
        priorityQueue03 T = new priorityQueue03();

        int[] nums1 = {5, 2, 4, 3, 1};
        System.out.println(T.solution(nums1));

        int[] nums2 = {7, 6, 3, 2, 4, 5, 1};
        System.out.println(T.solution(nums2));

    }
}
