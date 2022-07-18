package ch04;

/*
영화 관람
        수요일은 오후에 영화를 보는 날입니다. 현수네 반 N명의 학생들은 영화를 보기 위해 학교 강
        당에 모였습니다.
        강당의 좌석은 영화관처럼 계단형이 아니라 평평한 바닥에 의자가 일렬로 놓여진 상태입니다.
        앉는 순서는 제일 앞자리부터 반 번호순(1번 부터)으로 앉습니다.
        그런데 영화시청에 문제가 생겼습니다. 만약 앞자리에 앉은 키가 큰 학생이 앉으면 그 학생보
        다 앉은키가 작은 뒷자리 학생은 스크린이 보이지 않습니다.
        N명의 학생들의 앉은 키 정보가 주어지면 각 학생들의 최초 시야를 가려 영화관람을 불가능하
        게 하는 학생들을 찾고 싶습니다.
        예를 들어 N=5이고 다음과 같이 1번 학생부터 앞자리에 차례대로 앉았다면
        50 57 52 53 51
        1번 학생(50)은 제일 앞자리이므로 최초 시청방해 학생이 없습니다.
        2번 학생(57)은 시청 방해학생이 없습니다.
        3번 학생(52)의 최초 시청 방해학생은 2번(57) 학생입니다.
        4번 학생(53)의 최초 시청 방해학생은 2번(57) 학생입니다.
        5번 학생(51)의 최초 시청 방해학생은 4번(53) 학생입니다.
        N명의 앉은 키 정보가 주어지면 각 학생들의 최초 시청을 방해하는 학생들의 번호를 출력하는
        프로그램을 장성하세요.
*/

import java.util.Stack;

public class timeComplexity09 {

    public int[] solution(int[] nums) {
        int m = nums.length;
        int[] answer = new int[m];

        Stack<Integer> stack = new Stack<>();

        for (int i = m - 1; i >= 0; i--) {
            while (!stack.empty() && nums[i] > nums[stack.peek()]) {
                answer[stack.peek()] = i + 1;
                stack.pop();
            }
            stack.push(i);
        }

        return answer;
    }

    public static void main(String[] args) {
        timeComplexity09 T = new timeComplexity09();

        int[] nums1 = {50, 57, 52, 53, 51};
        for (int x : T.solution(nums1)) {
            System.out.print(x + " ");
        }

        System.out.println("");

        int[] nums2 = {50, 46, 55, 76, 65, 50, 55, 53, 55, 50};
        for (int x : T.solution(nums2)) {
            System.out.print(x + " ");
        }

    }

}
