package ch06;

/*
재귀함수
        자연수 N이 입력되면 재귀함수를 이용하여 1부터 N까지를 출력하는 프로그램을 작성하세요.
*/

public class recursion01 {

    public void solution(int n) {
        if (n == 0) {
            return;
        } else {
            solution(n - 1);
            System.out.print(n + " ");
        }


    }

    public static void main(String[] args) {
        recursion01 T = new recursion01();

        T.solution(3);

    }
}
