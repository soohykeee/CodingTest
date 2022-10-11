package programmers.exerciseLv1;

/*
수박수박수박수박수박수? - 연습문제 lv.1

길이가 n이고, "수박수박수박수...."와 같은 패턴을 유지하는 문자열을 리턴하는 함수, solution을 완성하세요.
예를들어 n이 4이면 "수박수박"을 리턴하고 3이라면 "수박수"를 리턴하면 됩니다.
 */
public class 수박수박수 {

    public String solution(int n) {
        String answer = "";

        for (int i = 0; i < n; i++) {
            if (i % 2 != 0) {
                answer += "박";
            } else {
                answer += "수";
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        수박수박수 T = new 수박수박수();

        System.out.println(T.solution(3));
        System.out.println(T.solution(4));
    }
}
