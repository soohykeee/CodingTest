package programmers.exerciseLv1;

import java.util.ArrayList;

/*
3진법 뒤집기 - 월간 코드 챌린지 시즌1

자연수 n이 매개변수로 주어집니다.
n을 3진법 상에서 앞뒤로 뒤집은 후, 이를 다시 10진법으로 표현한 수를 return 하도록 solution 함수를 완성해주세요.
 */
public class 뒤집기3진법 {

    public int solution(int n) {
        int temp = n;
        int count = 1;
        while(temp >= 3) {
            temp = temp / 3;
            count++;
        }
        int[] arr = new int[count];

        int i = count;
        while (i > 0) {

            arr[i - 1] = n % 3;
            n = n / 3;
            i--;
        }
        int answer = 0;
        for(int j = 0; j<count; j++) {
            answer += Math.pow(3, j) * arr[j];
        }
        return answer;
    }

    public static void main(String[] args) {
        뒤집기3진법 T = new 뒤집기3진법();

        System.out.println(T.solution(45));
        System.out.println(T.solution(125));
    }
}
