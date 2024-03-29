package programmers.exerciseLv1;

/*
정수 제곱근 판별 - 연습문제 lv.1

임의의 양의 정수 n에 대해, n이 어떤 양의 정수 x의 제곱인지 아닌지 판단하려 합니다.
n이 양의 정수 x의 제곱이라면 x+1의 제곱을 리턴하고,
n이 양의 정수 x의 제곱이 아니라면 -1을 리턴하는 함수를 완성하세요.
 */
public class 정수제곱근판별 {

    public long solution(long n) {
        long answer = 0;

        double x = Math.sqrt(n);
        if (Math.ceil(x) == Math.floor(x)) {
            x = x + 1;
        } else {
            return -1;
        }

        answer = (long) (x*x);

        return answer;
    }

}
