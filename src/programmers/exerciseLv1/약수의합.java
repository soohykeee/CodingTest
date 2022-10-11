package programmers.exerciseLv1;

/*
약수의 합 - 연습문제 lv.1

정수 n을 입력받아 n의 약수를 모두 더한 값을 리턴하는 함수, solution을 완성해주세요.
 */
public class 약수의합 {

    public int solution(int n) {
        int answer = 0;

        /*if (n == 0) {
            return 0;
        }

        for (int i = 1; i <= Math.sqrt(n); i++) {
            if (n == 1) {
                return 1;
            }
            if (n % i == 0) {
                answer = answer + i + (n / i);
            }
        }*/

        for (int i = 1; i <= n; i++) {
            if (n % i == 0) {
                answer += i;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        약수의합 T = new 약수의합();

        System.out.println(T.solution(12));
        System.out.println(T.solution(5));

    }
}
