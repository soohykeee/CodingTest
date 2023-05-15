package programmers.exerciseLv2;

import java.util.HashMap;

/*
전화번호 목록 - 해시 연습문제 lv.2

 */
public class 전화번호목록 {

    public boolean solution(String[] phone_book) {
        boolean answer = true;

        HashMap<String, Integer> map = new HashMap<>();

        for (String str : phone_book) {
            map.put(str, map.getOrDefault(str, 1));
        }

        System.out.println(map.keySet());

        for (String key : map.keySet()) {
            for (int i = 1; i < key.length(); i++) {
                String temp = key.substring(0, i);
                System.out.println(temp);
                if (map.containsKey(temp)) {
                    return false;
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        전화번호목록 T = new 전화번호목록();

        System.out.println(T.solution(new String[]{"119", "97674223", "1195524421"}));
        System.out.println(T.solution(new String[]{"123", "456", "789"}));
        System.out.println(T.solution(new String[]{"12", "123", "1235", "567", "88"}));

    }
}
