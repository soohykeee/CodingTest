package SKU_CodingTest.ch03;

import java.util.Stack;

/*
가장 큰 수
        선생님은 현수에게 숫자 하나를 주고, 해당 숫자의 자릿수들 중 m개의 숫자를 제거하
        여 가장 큰 수를 만들라고 했습니다. 여러분이 현수를 도와주세요.(단 숫자의 순서는
        유지해야 합니다)
        만약 5276823 이 주어지고 3개의 자릿수를 제거한다면
        7823이 가장 큰 숫자가 됩니다.
*/

public class stack05 {

    public String solution(String num, int m) {

        char[] answer = new char[num.length()-m];
        int count = m;

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < num.length(); i++) {
            // 불필요한 반목문을 끝내기 위해 count 걸어줌
            while (!stack.isEmpty() && stack.peek() < num.charAt(i) && count > 0) {
                stack.pop();
                count--;
            }
            stack.push(num.charAt(i));
        }

        // 지정된 자릿수만큼 표시해주기 위해서 작성
        for (int i = 0; i < answer.length; i++) {
            answer[i] = stack.get(i);
        }

        return new String(answer);
    }

    public static void main(String[] args) {
        stack05 T = new stack05();

        System.out.println(T.solution("5276823", 3));
        System.out.println(T.solution("9977252641",5));
    }
}
