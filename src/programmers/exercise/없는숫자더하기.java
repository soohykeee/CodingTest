package programmers.exercise;

/*
없는 숫자 더하기 - 월간 코드 챌린지 시즌2

0부터 9까지의 숫자 중 일부가 들어있는 정수 배열 numbers가 매개변수로 주어집니다.
numbers에서 찾을 수 없는 0부터 9까지의 숫자를 모두 찾아 더한 수를 return 하도록 solution 함수를 완성해주세요.
 */
public class 없는숫자더하기 {

    public int solution(int[] numbers) {
        int answer = 0;

        for (int i = 0; i < numbers.length; i++) {
            answer += numbers[i];
        }

        return 45-answer;
    }

    public static void main(String[] args) {
        없는숫자더하기 T = new 없는숫자더하기();

        System.out.println(T.solution(new int[]{1, 2, 3, 4, 6, 7, 8, 0}));
        System.out.println(T.solution(new int[]{5, 8, 4, 0, 6, 7, 9}));
    }
}
