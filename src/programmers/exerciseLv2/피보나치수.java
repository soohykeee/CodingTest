package programmers.exerciseLv2;

/*
피보나치 수 - 연습문제 lv.2

 */
public class 피보나치수 {

    public int solution(int n) {
        int answer[] = new int[n + 1];

        answer[0] = 0;
        answer[1] = 1;

        for (int i = 2; i <= n; i++) {
            answer[i] = (answer[i - 2] + answer[i - 1]) % 1234567;
        }

        return answer[n];
    }

    public static void main(String[] args) {
        피보나치수 T = new 피보나치수();

        System.out.println(T.solution(3));
        System.out.println(T.solution(5));

    }
}
