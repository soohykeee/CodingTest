package programmers.exerciseLv1;

import java.util.ArrayList;
import java.util.Collections;

/*
나누어 떨어지는 숫자 배열 - 연습문제 lv.1

array의 각 element 중 divisor로 나누어 떨어지는 값을 오름차순으로 정렬한 배열을 반환하는 함수, solution을 작성해주세요.
divisor로 나누어 떨어지는 element가 하나도 없다면 배열에 -1을 담아 반환하세요.
 */
public class 나누어떨어지는숫자배열 {

    public int[] solution(int[] arr, int divisor) {
        int[] answer = {};
        ArrayList<Integer> list = new ArrayList<>();
        int count = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % divisor == 0) {
                list.add(arr[i]);
                count++;
            }
        }

        Collections.sort(list);
        if (count == 0) {
            answer = new int[1];
            answer[0] = -1;
            return answer;
        } else {
            answer = new int[count];
        }

        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }

        return answer;

    }

    public static void main(String[] args) {
        나누어떨어지는숫자배열 T = new 나누어떨어지는숫자배열();

        System.out.println(T.solution(new int[]{5, 9, 7, 10}, 5));
        System.out.println(T.solution(new int[]{2, 36, 1, 3}, 1));
        System.out.println(T.solution(new int[]{3, 2, 6}, 10));
    }
}
