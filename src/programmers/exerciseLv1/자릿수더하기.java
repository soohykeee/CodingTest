package programmers.exerciseLv1;

/*
자릿수 더하기 - 연습문제 lv.1

자연수 N이 주어지면, N의 각 자릿수의 합을 구해서 return 하는 solution 함수를 만들어 주세요.
예를들어 N = 123이면 1 + 2 + 3 = 6을 return 하면 됩니다.
 */
public class 자릿수더하기 {

    public int solution(int n) {
        int answer = 0;

        while (n / 10 != 0) {
            answer += n % 10;
            n = n / 10;
        }
        answer += n;

        return answer;
    }

    public static void main(String[] args) {
        자릿수더하기 T = new 자릿수더하기();

        System.out.println(T.solution(123));
        System.out.println(T.solution(987));
    }
}
