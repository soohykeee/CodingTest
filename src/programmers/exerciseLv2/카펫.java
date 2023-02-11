package programmers.exerciseLv2;

/*
카펫 - 완전탐색 lv.2

 */
public class 카펫 {

    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int total = brown + yellow;

        for (int i = 3; i < total; i++) {
            int j = total / i;
            if (total % i == 0 && j >= 3) {
                int width = Math.max(i, j);
                int height = Math.min(i, j);

                if ((width - 2) * (height - 2) == yellow) {
                    answer[0] = width;
                    answer[1] = height;
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        카펫 T = new 카펫();

        System.out.println(T.solution(10, 2));
        System.out.println(T.solution(8, 1));
        System.out.println(T.solution(24, 24));
    }
}
