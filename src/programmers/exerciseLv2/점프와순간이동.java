package programmers.exerciseLv2;

/*
점프와 순간 이동 - Summer/Winter Coding(~2018)

 */
public class 점프와순간이동 {

    public int solution(int n) {
        int answer = 0;

        while (n != 0) {
            if (n % 2 == 0) {
                n /= 2;
            } else {
                n -= 1;
                answer++;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        점프와순간이동 T = new 점프와순간이동();

        System.out.println(T.solution(5));
        System.out.println(T.solution(6));
        System.out.println(T.solution(5000));

    }
}
