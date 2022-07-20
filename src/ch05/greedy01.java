package ch05;

/*
침몰하는 타이타닉
        유럽에서 가장 유명했던 유람선 타이타닉이 침몰하고 있습니다. 유람선에는 N명의 승객이 타고
        있습니다. 구명보트를 타고 탈출해야 하는데 타이타닉에 있는 구명보트는 2명 이하로만 탈 수 있
        으며, 보트 한 개에 탈 수 있는 총 무게도 M kg 이하로 제한되어 있습니다.
        N명의 승객 몸무게가 주어졌을 때 승객 모두가 탈출하기 위한 구명보트의 최소개수를 출력하는
        프로그램을 작성하세요
*/

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class greedy01 {

    public int solution(int[] nums, int m) {

       /* int answer=0;
        Deque<Integer> deque = new ArrayDeque<>();

        //deque 에 집어넣기 전에 sort 후 삽입
        Arrays.sort(nums);
        for (int x : nums) {
            deque.add(x);
        }

        //제일 작은값 + 제일 큰값 > 리미트  라면 큰값부터 삭제
        //제일 작은값 + 제일 큰값 < 리미트  라면 둘다 삭제
        while(!deque.isEmpty()) {
            if (deque.getFirst() + deque.getLast() > m) {
                deque.pollLast();
                answer++;
            } else {
                deque.poll();
                deque.pollLast();
                answer++;
            }
        }

        return answer;*/

        // 굳이 deque를 사용할 필요는 없음

        int answer = 0;
        Arrays.sort(nums);

        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            if (nums[left] + nums[right] > m) {
                right--;
                answer++;
            } else {
                right--;
                left++;
                answer++;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        greedy01 T = new greedy01();

        int[] nums = {90, 50, 70, 100, 60};
        // 50, 60, 70, 90, 100
        System.out.println(T.solution(nums, 140));

    }
}
