package programmers.exercise;

/*
자연수 뒤집어 배열로 만들기 - 연습문제 lv.1

자연수 n을 뒤집어 각 자리 숫자를 원소로 가지는 배열 형태로 리턴해주세요.
예를들어 n이 12345이면 [5,4,3,2,1]을 리턴합니다.
 */
public class reverseToNum {

    public int[] solution(long n) {
        String s = String.valueOf(n);
        int[] answer = new int[s.length()];

        for (int i = s.length() - 1; i >= 0; i--) {
            answer[s.length() - 1 - i] = s.charAt(i)-'0';
        }

        return answer;
    }
}
