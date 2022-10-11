package programmers.exerciseLv1;

import java.util.ArrayList;

/*
제일 작은 수 제거하기 - 연습문제 lv.1

정수를 저장한 배열, arr 에서 가장 작은 수를 제거한 배열을 리턴하는 함수, solution을 완성해주세요.
단, 리턴하려는 배열이 빈 배열인 경우엔 배열에 -1을 채워 리턴하세요.
예를들어 arr이 [4,3,2,1]인 경우는 [4,3,2]를 리턴 하고, [10]면 [-1]을 리턴 합니다.
 */
public class 제일작은수제거하기 {
    public int[] solution(int[] arr) {
        int[] answer = {};
        int min = Integer.MAX_VALUE;
        int minDigit = 0;
        ArrayList<Integer> list = new ArrayList<>();

        if (arr.length == 1) {
            answer = new int[1];
            answer[0] = -1;
            return answer;
        } else {
            for (int i = 0; i < arr.length; i++) {
                if (min > arr[i]) {
                    min = arr[i];
                    minDigit = i;
                }
            }
            for (int i = 0; i < arr.length; i++) {
                if (i != minDigit) {
                    list.add(arr[i]);
                }
            }
        }

        answer = new int[list.size()];

        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }

        return answer;
    }

    public static void main(String[] args) {
        제일작은수제거하기 T = new 제일작은수제거하기();

        System.out.println(T.solution(new int[]{4, 3, 2, 1}));
        System.out.println(T.solution(new int[]{10}));
    }
}
