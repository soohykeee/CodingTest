package programmers.hash;

/*
전화번호 목록

전화번호부에 적힌 전화번호 중, 한 번호가 다른 번호의 접두어인 경우가 있는지 확인하려 합니다.
전화번호가 다음과 같을 경우, 구조대 전화번호는 영석이의 전화번호의 접두사입니다.

구조대 : 119
박준영 : 97 674 223
지영석 : 11 9552 4421
전화번호부에 적힌 전화번호를 담은 배열 phone_book 이 solution 함수의 매개변수로 주어질 때,
어떤 번호가 다른 번호의 접두어인 경우가 있으면 false를 그렇지 않으면 true를 return 하도록 solution 함수를 작성해주세요.
 */

import java.util.HashMap;

public class hash03 {

    public boolean solution(String[] phone_book) {
        boolean answer = true;

        HashMap<String , Integer> map = new HashMap<>();
        for (String phone : phone_book) {
            map.put(phone, map.getOrDefault(phone, 1));
        }
        for (String key : map.keySet()) {
            for (int i = 1; i < key.length(); i++) {
                String temp = key.substring(0, i);
                if(map.containsKey(temp)) return false;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        hash03 T = new hash03();

        System.out.println(T.solution(new String[]{"119", "97674223", "1195524421"}));
        System.out.println(T.solution(new String[]{"123","456","789"}));
        System.out.println(T.solution(new String[]{"12","123","1235","567","88"}));
    }
}
