package SKU_CodingTest.ch06;

/*
재귀함수를 이용한 이진수 출력
        10진수 N이 입력되면 2진수로 변환하여 출력하는 프로그램을 작성하세요. 단 재귀함수를 이용
        해서 출력해야 합니다.
*/

public class dfs02 {

    String answer="";

    public void DFS(int n){
        if (n == 0) {
            return;
        } else {
            DFS(n / 2);
            answer += (n % 2);
        }
    }

    public String solution(int n) {
        DFS(n);
        return answer;
    }

    public static void main(String[] args) {
        dfs02 T = new dfs02();

        System.out.println(T.solution(11));
    }
}
