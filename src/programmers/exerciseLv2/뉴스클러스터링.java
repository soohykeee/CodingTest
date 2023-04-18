package programmers.exerciseLv2;

import java.util.ArrayList;
import java.util.Collections;

/*
뉴스 클러스터링 - 2018 KAKAO BLIND RECRUITMENT

 */
public class 뉴스클러스터링 {
    public static boolean isAlpha(String s) {
        if (s == null) {
            return false;
        }

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!(c >= 'A' && c <= 'Z') && !(c >= 'a' && c <= 'z')) {
                return false;
            }
        }
        return true;
    }

    public int solution(String str1, String str2) {

        ArrayList<String> strList1 = new ArrayList<>();
        ArrayList<String> strList2 = new ArrayList<>();
        ArrayList<String> gyo = new ArrayList<>();
        ArrayList<String> hap = new ArrayList<>();

        str1 = str1.toUpperCase();
        str2 = str2.toUpperCase();

        // 2글자씩 나눠 ArrayList에 저장
        for (int i = 0; i < str1.length() - 1; i++) {
            String temp = str1.substring(i, i + 2);
            if (isAlpha(temp)) {
                strList1.add(temp);
            }
        }
        for (int i = 0; i < str2.length() - 1; i++) {
            String temp = str2.substring(i, i + 2);
            if (isAlpha(temp)) {
                strList2.add(temp);
            }
        }

        // 교집합 구하기
        for (String s : strList1) {
            if (strList2.remove(s)) {
                gyo.add(s);
            }
            hap.add(s);
        }
        // 합집합 구하기
        for (String s : strList2) {
            hap.add(s);
        }

        // 합집합이 0 이라면 return 65536
        if (hap.size() == 0) {
            return 65536;
        }

        double answer = (double) gyo.size() / (double) hap.size();
        return (int) (answer * 65536);

    }

    public static void main(String[] args) {
        뉴스클러스터링 T = new 뉴스클러스터링();

        System.out.println(T.solution("FRANCE", "french"));
        System.out.println(T.solution("handshake", "shake hands"));
        System.out.println(T.solution("aa1+aa2", "AAAA12"));
        System.out.println(T.solution("E=M*C^2", "e=m*c^2"));
        System.out.println(T.solution("abab", "baba"));

    }
}
