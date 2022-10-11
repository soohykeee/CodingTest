package programmers.exerciseLv1;

import java.util.Arrays;
import java.util.Collections;

/*
문자열 내림차순으로 배치하기 - 연습문제 lv.1

문자열 s에 나타나는 문자를 큰것부터 작은 순으로 정렬해 새로운 문자열을 리턴하는 함수, solution을 완성해주세요.
s는 영문 대소문자로만 구성되어 있으며, 대문자는 소문자보다 작은 것으로 간주합니다.
 */
public class 문자열내림차순배치 {

    public String solution(String s) {
        char arr[] = s.toCharArray();
        Arrays.sort(arr);
        StringBuilder sb = new StringBuilder(new String(arr, 0, arr.length));
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        문자열내림차순배치 T = new 문자열내림차순배치();

        System.out.println(T.solution("Zbcdefg"));
    }
}
