package ch06;

/*
중복순열 구하기
        1부터 N까지 번호가 적힌 구슬이 있습니다. 이 중 중복을 허락하여 M번을 뽑아 일렬로 나열
        하는 방법을 모두 출력합니다.
*/

import java.util.Scanner;
import java.util.Stack;

public class dfs03 {

    Stack<Integer> stack = new Stack<>();
    static int n, m;

    public void solution(int L) {
        if (L == m) {
            for (int x : stack) {
                System.out.print(x + " ");
            }
            System.out.println("");
        } else {
            for (int i = 1; i <= n; i++) {
                stack.push(i);
                solution(L + 1);
                stack.pop();
            }
        }

    }

    public static void main(String[] args) {
        dfs03 T = new dfs03();

        Scanner kb = new Scanner(System.in);
        n = kb.nextInt();
        m = kb.nextInt();
        T.solution(0);

    }
}
