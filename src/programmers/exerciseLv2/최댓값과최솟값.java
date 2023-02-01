package programmers.exerciseLv2;

/*
최댓값과 최솟값 - 연습문제 lv.2

 */
public class 최댓값과최솟값 {

    public String solution(String s) {
        String answer = "";

        String[] temp = s.split(" ");

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < temp.length; i++) {
            int x = Integer.parseInt(temp[i]);
            if (x > max) {
                max = x;
            }
            if (x < min) {
                min = x;
            }
        }

        answer = min + " " + max;

        return answer;
    }

    public static void main(String[] args) {
        최댓값과최솟값 T = new 최댓값과최솟값();

        System.out.println(T.solution("1 2 3 4"));
        System.out.println(T.solution("-1 -2 -3 -4"));
        System.out.println(T.solution("-1 -1"));

    }
}
