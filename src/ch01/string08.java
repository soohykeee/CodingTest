package ch01;

import java.util.HashMap;

/*
팰린드롬 길이
        문자열이 주어지면 해당 문자열의 문자들을 가지고 만들 수 있는 최대길이 팰린드롬을 만들고
        그 길이를 구하세요. 문자열은 소문자로만 이루어져 있습니다.
        만약 “abcbbbccaa" 가 주어진다면 만들 수 있는 가장 긴 팰린드롬은 ”bbcaaacbb"이고 답은
        9입니다.
*/
public class string08 {

    public int solution(String s) {

        int answer=1;

        HashMap<Character, Integer> map = new HashMap<>();
        for (char key : s.toCharArray()) {
            map.put(key, map.getOrDefault(key, 0) + 1);
        }

        for (char key : map.keySet()) {
            if (map.get(key) % 2 == 0) {
                answer += map.get(key);
            } else {
                answer += (map.get(key) - 1);
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        string08 T = new string08();

        System.out.println(T.solution("abcbbbccaa"));
        System.out.println(T.solution("abcde"));
        System.out.println(T.solution("ccc"));

    }

}
