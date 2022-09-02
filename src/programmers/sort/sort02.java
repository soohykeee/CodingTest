package programmers.sort;

import java.util.Arrays;
import java.util.Comparator;

/*
가장 큰 수

0 또는 양의 정수가 주어졌을 때, 정수를 이어 붙여 만들 수 있는 가장 큰 수를 알아내 주세요.

예를 들어, 주어진 정수가 [6, 10, 2]라면
[6102, 6210, 1062, 1026, 2610, 2106]를 만들 수 있고, 이중 가장 큰 수는 6210입니다.

0 또는 양의 정수가 담긴 배열 numbers가 매개변수로 주어질 때,
순서를 재배치하여 만들 수 있는 가장 큰 수를 문자열로 바꾸어 return 하도록 solution 함수를 작성해주세요.
 */
public class sort02 {

    public String solution(int[] numbers) {
        String answer = "";

        String[] temp = new String[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            temp[i] = String.valueOf(numbers[i]);
        }

        Arrays.sort(temp, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return (o2 + o1).compareTo(o1 + o2);
            }
        });

        if (temp[0].equals("0")) {
            return "0";
        }
        for (String s : temp) {
            answer += s;
        }
        // testCase의 0,0,0,0 의 경우 0000 으로 출력이 되는데, 중복일 경우 0으로만 나오도록 if문


        return answer;
    }

    public static void main(String[] args) {
        sort02 T = new sort02();

        System.out.println(T.solution(new int[]{6, 10, 2}));
        System.out.println(T.solution(new int[]{3, 30, 34, 5, 9}));
    }

}
