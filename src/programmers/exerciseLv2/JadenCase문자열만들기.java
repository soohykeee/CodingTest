package programmers.exerciseLv2;

/*
JadenCase 문자열 만들기 - 연습문제 lv.2

 */
public class JadenCase문자열만들기 {

    public String solution(String s) {
        String answer = "";

        String[] arr = s.split(" ");

        for(int i=0; i<arr.length; i++) {
            String now = arr[i];

            if (arr[i].length() != 0) {
                answer += now.substring(0, 1).toUpperCase();
                answer += now.substring(1).toLowerCase();
            }
            answer += " ";


        }

        if(s.endsWith(" ")){
            return answer;
        }

        return answer.substring(0, answer.length() - 1);
    }

    public static void main(String[] args) {

        JadenCase문자열만들기 T = new JadenCase문자열만들기();

        System.out.println(T.solution("3people unFollowed me"));
        System.out.println(T.solution("for the last week"));
    }
}
