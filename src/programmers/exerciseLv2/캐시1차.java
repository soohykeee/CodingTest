package programmers.exerciseLv2;

import java.util.LinkedList;
import java.util.Locale;

/*
[1차] 캐시 - 2018 KAKAO BLIND RECRUITMENT lv.2

 */
public class 캐시1차 {

    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        LinkedList<String> list = new LinkedList<>();

        if (cacheSize < 1) {
            return cities.length * 5;
        }

        for (int i = 0; i < cities.length; i++) {
            String temp = cities[i].toUpperCase(Locale.ROOT);

            if (list.contains(temp)) {
                answer += 1;
                list.remove(temp);
                list.add(temp);
            } else {
                if (list.size() >= cacheSize) {
                    list.remove(0);
                }
                list.add(temp);
                answer += 5;
            }

        }

        return answer;
    }

    public static void main(String[] args) {
        캐시1차 T = new 캐시1차();

        System.out.println(T.solution(3, new String[]{"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "Jeju", "Pangyo", "Seoul", "NewYork", "LA"}));
        System.out.println(T.solution(3, new String[]{"Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul"}));
        System.out.println(T.solution(2, new String[]{"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "SanFrancisco", "Seoul", "Rome", "Paris", "Jeju", "NewYork", "Rome"}));
        System.out.println(T.solution(5, new String[]{"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "SanFrancisco", "Seoul", "Rome", "Paris", "Jeju", "NewYork", "Rome"}));
        System.out.println(T.solution(2, new String[]{"Jeju", "Pangyo", "NewYork", "newyork"}));
        System.out.println(T.solution(0, new String[]{"Jeju", "Pangyo", "Seoul", "NewYork", "LA"}));

    }
}
