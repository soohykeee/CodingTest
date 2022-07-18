package ch05;

/*
회의실 배정
        한 개의 회의실이 있는데 이를 사용하고자 하는 n개의 회의들에 대하여 회의실 사용표를 만들
        려고 한다. 각 회의에 대해 시작시간과 끝나는 시간이 주어져 있고, 각 회의가 겹치지 않게 하
        면서 회의실을 사용할 수 있는 최대수의 회의를 찾아라. 단, 회의는 한번 시작하면 중간에 중
        단될 수 없으며 한 회의가 끝나는 것과 동시에 다음 회의가 시작될 수 있다.
*/

import java.util.Arrays;
import java.util.Comparator;

public class greedy05 {

    public int solution(int[][] times) {

        int answer = 1;

        Arrays.sort(times, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });

        int endTime = times[0][1];
        for (int i = 1; i < times.length; i++) {
            if (endTime <= times[i][0]) {
                endTime = times[i][1];
                answer++;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        greedy05 T = new greedy05();

        int[][] times = {{1, 4}, {2, 3}, {3, 5}, {4, 6}, {5, 7}};

        // 2-3, 1-4, 3-5, 4-6, 5-7
        System.out.println(T.solution(times));

    }
}
