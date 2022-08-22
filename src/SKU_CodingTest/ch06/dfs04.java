package SKU_CodingTest.ch06;

/*
순열 구하기
        10이하의 N개의 자연수가 주어지면 이 중 M개를 뽑아 일렬로 나열하는 방법을 모두 출력합
        니다.
*/

import java.util.Scanner;
import java.util.Stack;

public class dfs04 {

    Stack<Integer> stack = new Stack<>();
    static int n, m;
    // ch는 체크를 위한 배열   1이면 사용, 0이면 미사용
    static int[] num, ch;

    public void solution(int L) {

        if (L == m) {
            for (int x : stack) {
                System.out.print(x + " ");
            }
            System.out.println("");
        } else {
            for (int i = 0; i < n; i++) {
                if (ch[i] == 0) {
                    ch[i] = 1;
                    stack.push(num[i]);
                    solution(L + 1);
                    ch[i] = 0;
                    stack.pop();
                }
            }
        }

    }

    public static void main(String[] args) {
        dfs04 T = new dfs04();

        Scanner kb = new Scanner(System.in);
        n = kb.nextInt();
        m = kb.nextInt();

        ch = new int[n];
        num = new int[n];
        for (int i = 0; i < num.length; i++) {
            num[i] = kb.nextInt();
        }

        T.solution(0);

    }
}
