package ch06;

/*
조합 구하기
        1부터 N까지 번호가 적힌 구슬이 있습니다. 이 중 M개를 뽑는 방법의 수를 출력하는 프로그
        램을 작성하세요.
*/

import java.util.Scanner;
import java.util.Stack;

public class recursion06 {

    static int n, m;
    Stack<Integer> stack = new Stack<>();

    public void solution(int L, int s) {
        if (L == m) {
            for (int x : stack) {
                System.out.print(x + " ");
            }
            System.out.println("");
        } else {
            for (int i = s; i <= n; i++) {
                stack.push(i);
                solution(L + 1, i + 1);
                stack.pop();
            }

        }

    }

    public static void main(String[] args) {
        recursion06 T = new recursion06();
        Scanner scanner = new Scanner(System.in);

        n = scanner.nextInt();
        m = scanner.nextInt();

        T.solution(0, 1);

    }

}
