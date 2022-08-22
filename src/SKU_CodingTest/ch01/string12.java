package SKU_CodingTest.ch01;/*
공부시간
*/
import java.util.ArrayList;

public class string12 {

    public int timeToMinute(String time) {
        String[] arr = time.split(":");

        int hour = Integer.parseInt(arr[0]);
        int minute = Integer.parseInt(arr[1]);

        return hour * 60 + minute;
    }

    public String solution(String[] time) {

        String answer="";

        ArrayList<Integer> timeList = new ArrayList<>();
        for (String s : time) {
            timeList.add(timeToMinute(s));
        }

        int totalTime=0;
        for (int i = 0; i < timeList.size() - 1; i+=2) {
            if (timeList.get(i + 1) - timeList.get(i) < 5) {
                totalTime += 0;
            } else if (timeList.get(i + 1) - timeList.get(i) >= 105) {
                totalTime += 105;
            } else {
                totalTime += (timeList.get(i + 1) - timeList.get(i));
            }
        }

        int H=totalTime/60;
        int M=totalTime%60;
        answer=(H<10?"0"+H : H)+":"+(M<10?"0"+M:M);

        return answer;
    }

    public static void main(String[] args) {
        string12 T = new string12();

        String[] tmp = new String[]{"08:30", "09:00", "14:00", "16:00", "16:01", "16:06", "16:07", "16:11"};
        System.out.println(T.solution(tmp));
        String[] tmp1 = new String[]{"01:00", "08:00", "15:00", "15:04", "23:00", "23:59"};
        System.out.println(T.solution(tmp1));
    }
}
