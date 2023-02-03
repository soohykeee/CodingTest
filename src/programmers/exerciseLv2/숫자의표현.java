package programmers.exerciseLv2;

/*
숫자의 표현 - 연습문제 lv.2

 */
public class 숫자의표현 {

    public boolean doSum(int n, int answer) {
        int sum = 0;
        int count = 0;

        for (int i = n; i > 0; i--) {
            sum+=i;
            count++;
            if (sum == answer && count > 1) {
                return true;
            } else if (sum > answer) {
                return false;
            } else {
                continue;
            }
        }

        return false;
    }

    public int solution(int n) {
        int answer = 1;
        int limit = n / 2 + 1;

        if (n == 1) {
            return 1;
        }

        for (int i = limit; i > 0; i--) {
            if(doSum(i, n))
                answer++;
        }
        return answer;
    }

    public static void main(String[] args) {
        숫자의표현 T = new 숫자의표현();

        System.out.println(T.solution(15));

    }

}
