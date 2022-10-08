package programmers.exercise;

/*
하샤드 수 - 연습문제 lv.1

양의 정수 x가 하샤드 수이려면 x의 자릿수의 합으로 x가 나누어져야 합니다.
예를 들어 18의 자릿수 합은 1+8=9이고, 18은 9로 나누어 떨어지므로 18은 하샤드 수입니다.
자연수 x를 입력받아 x가 하샤드 수인지 아닌지 검사하는 함수, solution을 완성해주세요.
 */

public class 하샤드수 {

    public int recursion(int x) {
        if (x < 10) {
            return x;
        } else {
            return x % 10 + recursion(x / 10);
        }
    }

    public boolean solution(int x) {
        boolean answer = true;

        if (x % recursion(x) != 0) {
            return false;
        }

        return answer;
    }

    public static void main(String[] args) {
        하샤드수 T = new 하샤드수();

        System.out.println(T.solution(10));
        System.out.println(T.solution(12));
        System.out.println(T.solution(11));
        System.out.println(T.solution(13));

    }
}
