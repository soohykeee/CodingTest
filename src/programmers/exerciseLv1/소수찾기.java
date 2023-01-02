package programmers.exerciseLv1;

/*
소수찾기 - 연습문제 lv.1

1부터 입력받은 숫자 n 사이에 있는 소수의 개수를 반환하는 함수, solution을 만들어 보세요.

소수는 1과 자기 자신으로만 나누어지는 수를 의미합니다.
(1은 소수가 아닙니다.)
 */
public class 소수찾기 {

    public boolean isPrime(int num) {
        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    public int solution(int n) {
        int answer = 0;

        for (int i = 2; i<= n; i++) {
            if(isPrime(i)) answer++;
        }

        return answer;
    }

    public static void main(String[] args) {
        소수찾기 T = new 소수찾기();

        System.out.println(T.solution(10));
        System.out.println(T.solution(5));

    }
}
