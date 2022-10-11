package programmers.exerciseLv1;

/*
평균 구하기 - 연습문제 lv.1

정수를 담고 있는 배열 arr의 평균값을 return 하는 함수, solution을 완성해보세요.
 */
public class 평균구하기 {

    public double solution(int[] arr) {
        double answer = 0;
        int sum = 0;

        for (int x : arr) {
            sum += x;
        }

        answer = (double) sum / arr.length;

        return answer;
    }

    public static void main(String[] args) {

    }

}
