package programmers.exerciseLv2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/*
주차요금계산 - 2019 KAKAO BLIND RECRUITMENT

 */
public class 주차요금계산 {
    public int[] solution(int[] fees, String[] records) {
        int[] answer = {};

        HashMap<String, String> map = new HashMap<>();
        HashMap<String, Integer> feeMap = new HashMap<>();

        // 요금을 내야 하는 차량번호 등록
        for (int i = 0; i < records.length; i++) {
            feeMap.put(records[i].split(" ")[1], 0);
        }


        for (int i = 0; i < records.length; i++) {
            String[] infos = records[i].split(" ");

            if (map.containsKey(infos[1])) {
                String[] inTime = map.remove(infos[1]).split(":");
                String[] outTime = infos[0].split(":");

                int hour = Integer.parseInt(outTime[0]) - Integer.parseInt(inTime[0]);
                int minute = Integer.parseInt(outTime[1]) - Integer.parseInt(inTime[1]);

                feeMap.replace(infos[1], feeMap.get(infos[1]) + 60 * hour + minute);

            } else {
                map.put(infos[1], infos[0]); // 차 번호, 시간
            }
        }

        // IN하고 OUT하지 않은 차는 23:59에 출차
        for (String key : map.keySet()) {
            String[] inTime = map.get(key).split(":");

            int hour = 23 - Integer.parseInt(inTime[0]);
            int minute = 59 - Integer.parseInt(inTime[1]);

            feeMap.replace(key, feeMap.get(key) + 60 * hour + minute);
        }

        // 차량번호가 낮은 순으로 출력해야하기에 정렬
        List<HashMap.Entry<String, Integer>> list = new ArrayList(feeMap.entrySet());
        Collections.sort(list, (o1, o2) -> {
            return Integer.parseInt(o1.getKey()) > Integer.parseInt(o2.getKey()) ? 1 :
                    Integer.parseInt(o1.getKey()) < Integer.parseInt(o2.getKey()) ? -1 : 0;
        });


        answer = new int[list.size()];
        for (int i = 0; i < answer.length; i++) {
            if (list.get(i).getValue() > fees[0]) {
                answer[i] = fees[1] + (int) Math.ceil((list.get(i).getValue() - fees[0]) / (double) fees[2]) * fees[3];
            } else {
                answer[i] = fees[1];
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        주차요금계산 T = new 주차요금계산();

        System.out.println(T.solution(new int[]{180, 5000, 10, 600}, new String[]{"05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT", "07:59 0148 IN", "18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT"}));
        System.out.println(T.solution(new int[]{120, 0, 60, 591}, new String[]{"16:00 3961 IN", "16:00 0202 IN", "18:00 3961 OUT", "18:00 0202 OUT", "23:58 3961 IN"}));
        System.out.println(T.solution(new int[]{1, 461, 1, 10}, new String[]{"00:00 1234 IN"}));

    }
}
