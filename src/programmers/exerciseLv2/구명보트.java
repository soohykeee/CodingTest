package programmers.exerciseLv2;

import java.util.Arrays;

/*
구명보트 - 탐욕법(Greedy) lv.2

 */
public class 구명보트 {

    public int solution(int[] people, int limit) {
        int answer = 0;

        Arrays.sort(people);
        // 50 50 70 80

        int left = 0;
        for (int right = people.length - 1; left <= right; right--) {
            if (people[left] + people[right] > limit) {
                answer++;
            } else {
                answer++;
                left++;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        구명보트 T = new 구명보트();

        System.out.println(T.solution(new int[]{70, 50, 80, 50}, 100));
        System.out.println(T.solution(new int[]{70, 80, 50}, 100));
    }
}
