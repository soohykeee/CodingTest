package programmers.exercise;

/*
x만큼 간격이 있는 n개의 숫자 - 연습문제 lv.1

함수 solution은 정수 x와 자연수 n을 입력 받아, x부터 시작해 x씩 증가하는 숫자를
n개 지니는 리스트를 리턴해야 합니다.
다음 제한 조건을 보고, 조건을 만족하는 함수, solution을 완성해주세요.
 */
public class arrayXAddN {

    public long[] solution(int x, int n) {
        long[] answer = new long[n];

        for (int i = 0; i < n; i++) {
            answer[i] = (long)x + ((long)x * i);
        }

        return answer;
    }

    public static void main(String[] args) {
        arrayXAddN T = new arrayXAddN();

        System.out.println(T.solution(2, 5));
        System.out.println(T.solution(4, 3));
        System.out.println(T.solution(-4, 2));

    }
}
