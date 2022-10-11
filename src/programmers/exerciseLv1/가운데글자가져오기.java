package programmers.exerciseLv1;

/*
가운데 글자 가져오기 - 연습문제 lv.1

단어 s의 가운데 글자를 반환하는 함수, solution을 만들어 보세요.
단어의 길이가 짝수라면 가운데 두글자를 반환하면 됩니다.
 */
public class 가운데글자가져오기 {

    public String solution(String s) {
        String answer = "";

        if (s.length() % 2 != 0) {
            answer += s.charAt(s.length() / 2);
        } else {
            answer += s.charAt(s.length() / 2 - 1);
            answer += s.charAt(s.length() / 2 );
        }

        return answer;
    }

    public static void main(String[] args) {
        가운데글자가져오기 T = new 가운데글자가져오기();

        System.out.println(T.solution("abcde"));
        System.out.println(T.solution("qwer"));

    }

}
