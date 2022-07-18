package ch01;/*
가장 가까운 시간
        0시부터 24시까지의 시간이 “HH:MM" 의 표현으로 각 시간대가 주어집니다. 이 중 임의의
        2개의 시간대의 차가 가장 작은 시간차이를 분단위로 구하여 반환하는 프로그램을 작성하세
        요.
*/

import java.util.ArrayList;
import java.util.Collections;

public class string11 {

    public int timeToMinute(String time) {
        String[] arr = time.split(":");

        int hour = Integer.parseInt(arr[0]);
        int minute = Integer.parseInt(arr[1]);

        return hour * 60 + minute;
    }

    public int solution(String[] time) {

        int answer=Integer.MAX_VALUE;

        ArrayList<Integer> timeList = new ArrayList<>();
        for (String s : time) {
            timeList.add(timeToMinute(s));
        }

        Collections.sort(timeList);

        for (int i = 1; i < timeList.size(); i++) {
            answer = Math.min(answer,Math.abs(timeList.get(i)-timeList.get(i-1)));
        }
        // 제일 앞과 제일 뒤를 비교하기위해 추가
        answer=Math.min(answer, 60*24+timeList.get(0)-timeList.get(timeList.size()-1));

        return answer;
    }

    public static void main(String[] args) {
        string11 T = new string11();

        String[] tmp = new String[]{"00:12","00:00", "01:05", "00:57"};
        System.out.println(T.solution(tmp));
        String[] tmp1 = new String[]{"00:00","23:59","00:00"};
        System.out.println(T.solution(tmp1));
        String[] tmp2 = new String[]{"23:59","00:00", "23:57"};
        System.out.println(T.solution(tmp2));

    }

}
