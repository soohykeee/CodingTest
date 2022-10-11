package programmers.exerciseLv1;

/*
약수의 개수의 덧셈 - 월간 코드 챌린지 시즌2

두 정수 left와 right가 매개변수로 주어집니다.
left부터 right까지의 모든 수들 중에서, 약수의 개수가 짝수인 수는 더하고,
약수의 개수가 홀수인 수는 뺀 수를 return 하도록 solution 함수를 완성해주세요.
 */
public class 약수의개수와덧셈 {

    public boolean isDivisor(int n) {
        int count = 0;

        for (int i = 1; i * i <= n; i++) {
            if(i*i == n) count++;
            else if(n%i ==0) count += 2;
        }

        if (count % 2 == 0) {
            return true;
        } else {
            return false;
        }
    }

    public int solution(int left, int right) {
        int answer = 0;

        for (int i = left; i <= right; i++) {
            if (isDivisor(i)) {
                answer += i;
            } else {
                answer -= i;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        약수의개수와덧셈 T = new 약수의개수와덧셈();

        System.out.println(T.solution(13, 17));
        System.out.println(T.solution(24, 27));
    }
}
