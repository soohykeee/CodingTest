package programmers.exerciseLv1;

/*
이상한 문자 만들기 - 연습문제 lv.1

문자열 s는 한 개 이상의 단어로 구성되어 있습니다.
각 단어는 하나 이상의 공백문자로 구분되어 있습니다. 각 단어의 짝수번째 알파벳은 대문자로,
홀수번째 알파벳은 소문자로 바꾼 문자열을 리턴하는 함수, solution을 완성하세요.
 */
public class 이상한문자만들기 {

    public String solution(String s) {
        String answer = "";
        int count = 0;

        for (int i = 0; i < s.length(); i++) {
            if (!Character.isAlphabetic(s.charAt(i))) {
                count = -1;
            }
            if (count % 2 == 0) {
                answer += Character.toUpperCase(s.charAt(i));
            } else {
                answer += Character.toLowerCase(s.charAt(i));
            }
            count++;
        }

        return answer;
    }

    public static void main(String[] args) {
        이상한문자만들기 T = new 이상한문자만들기();

        System.out.println(T.solution("try Hello"));
        System.out.println(T.solution("world"));

    }
}
