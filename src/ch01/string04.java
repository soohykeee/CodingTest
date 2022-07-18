package ch01;

import java.util.Locale;
/*
회문문자열2
        문자열 s가 주어지면 s가 최대 문자 1개까지 지워서 회문문자열이 되면 “YES"를 출력하고, 그
        렇지 않으면 ”NO"를 출력하는 프로그램을 작성하세요.
*/
public class string04 {

    // 회문인지 확인하는 메소드
    public boolean isPalindrome(String s) {

        s=s.toUpperCase(Locale.ROOT);

        int left=0;
        int right=s.length()-1;

        while (left < right) {
            if (s.charAt(left) == s.charAt(right)) {
                left++;
                right--;
            } else {
                return false;
            }
        }
        return true;
    }

    public String solution(String s){

        String answer="YES";

        if (isPalindrome(s)) {
            return "YES";
        } else {
            s = s.toUpperCase(Locale.ROOT);
            int left=0;
            int right=s.length()-1;

            while (left < right) {
                if (s.charAt(left) != s.charAt(right)) {
                    if (!isPalindrome(s.substring(left, right)) && !isPalindrome(s.substring(left + 1, right + 1))) {
                        return "NO";
                    } else {
                        break;
                    }
                }
                left++;
                right--;
            }

        }
        return answer;
    }

    public static void main(String[] args) {
        string04 T = new string04();

        System.out.println(T.solution("abcbdcba"));
        System.out.println(T.solution("abcabbakcba"));
        System.out.println(T.solution("abcacbakcba"));

    }
}
