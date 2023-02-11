package programmers.exerciseLv2;

/*
예상 대진표 - 2017 팁스타운

 */
public class 예상대진표 {

    public int solution(int n, int a, int b) {
        int answer = 1;

        while ((a / 2 == b / 2) || Math.abs(a - b) != 1) {
            if (a % 2 == 0) {
                a = a / 2;
            } else {
                a = a / 2 + 1;
            }

            if (b % 2 == 0) {
                b = b / 2;
            } else {
                b = b / 2 + 1;
            }

            answer++;
        }

        return answer;
    }

    public static void main(String[] args) {
        예상대진표 T = new 예상대진표();

        System.out.println(T.solution(8, 4, 7));
    }
}
