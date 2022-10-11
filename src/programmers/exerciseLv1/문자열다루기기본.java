package programmers.exerciseLv1;

/*
문자열 다루기 기본 - 연습문제 lv.1

문자열 s의 길이가 4 혹은 6이고, 숫자로만 구성돼있는지 확인해주는 함수, solution을 완성하세요.
예를 들어 s가 "a234"이면 False를 리턴하고 "1234"라면 True를 리턴하면 됩니다.
 */
public class 문자열다루기기본 {

    public boolean solution(String s) {
        boolean answer = true;

        if (s.length() == 4 || s.length() == 6) {
            for (int i = 0; i < s.length(); i++) {
                if (Character.isAlphabetic(s.charAt(i))) {
                    return false;
                }
            }
        } else {
            return false;
        }

        return answer;
    }

    public static void main(String[] args) {
        문자열다루기기본 T = new 문자열다루기기본();

        System.out.println(T.solution("a234"));
        System.out.println(T.solution("1234"));
    }
}
