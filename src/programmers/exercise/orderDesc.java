package programmers.exercise;

import java.util.Collections;
import java.util.PriorityQueue;

/*
정수 내림차순으로 배치하기 - 연습문제 lv.1

함수 solution은 정수 n을 매개변수로 입력받습니다.
n의 각 자릿수를 큰것부터 작은 순으로 정렬한 새로운 정수를 리턴해주세요.
예를들어 n이 118372면 873211을 리턴하면 됩니다.
 */
public class orderDesc {

    public long solution(long n) {
        long answer = 0;

        String str = String.valueOf(n);
        char[] arr = str.toCharArray();

        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < arr.length; i++) {
            queue.add(arr[i] - '0');
        }
        str = "";
        for (int i = 0; i < arr.length; i++) {
            str += queue.poll();
        }

        answer = Long.parseLong(str);

        return answer;
    }

    public static void main(String[] args) {
        orderDesc T = new orderDesc();

        System.out.println(T.solution(118372));

    }
}
