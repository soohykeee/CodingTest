package ch03;

import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;

/*
최대힙
        최대힙은 완전이진트리로 구현된 자료구조입니다. 그 구성은 부모 노드값이 왼쪽자식과 오른
        쪽 자식노드의 값보다 크게 트리를 구성하는 것입니다. 그렇게 하면 트리의 루트(root)노드는
        입력된 값들 중 가장 큰 값이 저장되어 있습니다. 예를 들어 5 3 2 1 4 6 7순으로 입력되면
        최대힙 트리는 아래와 같이 구성됩니다.
*/


public class priorityQueue02 {
    public ArrayList<Integer> solution(int[] nums) {

        ArrayList<Integer> answer = new ArrayList<>();

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Collections.reverseOrder());

        for (int x : nums) {
            if (x != 0) {
                priorityQueue.offer(x);
            } else {
                if (priorityQueue.isEmpty()) {
                    answer.add(-1);
                } else {
                    answer.add(priorityQueue.poll());
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        priorityQueue02 T = new priorityQueue02();

        int[] nums = {5, 3, 6, 0, 5, 0, 2, 4, 0};
        System.out.println(T.solution(nums));

    }
}
