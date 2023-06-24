package programmers.exerciseLv2;

/*
n^2 배열 자르기 - 월간 코드 챌린지 시즌3

 */
public class n2배열자르기 {

    /*
        0	1	2	3	4
        1	1	2	3	4
        2	2	2	3	4
        3	3	3	3	4
        4	4	4	4	4

    행과 열의 Max 값이 그자리의 값
*/
    public int[] solution(int n, long left, long right) {
        int len = (int) right - (int) left;
        int[] answer = new int[len + 1];

        int idx = 0;
        for (long i = left; i <= right; i++) {
            long row = i / n;
            long col = i % n;
            answer[idx++] = Math.max((int)row, (int)col) + 1;
        }

        return answer;
    }

    public static void main(String[] args) {
        n2배열자르기 T = new n2배열자르기();

        System.out.println(T.solution(3, 2, 5));
        System.out.println(T.solution(4, 7, 14));

    }
}
