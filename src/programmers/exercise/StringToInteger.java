package programmers.exercise;

/*
문자열을 정수로 바꾸기 - 연습문제 lv.1

문자열 s를 숫자로 변환한 결과를 반환하는 함수, solution을 완성하세요.
 */
public class StringToInteger {

    public int solution(String s) {
        /*if (s.charAt(0) == '+') {
            s = s.substring(1);
            return Integer.parseInt(s);
        } else if (s.charAt(0) == '-') {
            s = s.substring(1);
            return 0 - Integer.parseInt(s);
        } else {
            return Integer.parseInt(s);
        }*/

        return Integer.parseInt(s);
    }

    public static void main(String[] args) {
        StringToInteger T = new StringToInteger();

        System.out.println(T.solution("1234"));
        System.out.println(T.solution("-1234"));

    }
}
