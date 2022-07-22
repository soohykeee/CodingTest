package ch06;

/*
순열 구하기
        10이하의 N개의 자연수가 주어지면 이 중 M개를 뽑아 일렬로 나열하는 방법을 모두 출력합
        니다.
*/

import java.util.Scanner;
import java.util.Stack;

public class recursion04 {

    Stack<Integer> stack = new Stack<>();
    static int n, m;
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
        recursion04 T = new recursion04();

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
