package SKU_CodingTest.ch01;

import java.util.Locale;

/*회문 문자열
        앞에서 읽을 때나 뒤에서 읽을 때나 같은 문자열을 회문 문자열이라고 합니다.
        문자열이 입력되면 해당 문자열이 회문 문자열이면 "YES", 회문 문자열이 아니면 “NO"를 출력
        하는 프로그램을 작성하세요.
        단 회문을 검사할 때 대소문자를 구분하지 않습니다.*/

public class string02 {

    public String solution(String s){

        String answer="YES";
        s=s.toUpperCase(Locale.ROOT);
        int left=0;
        int right=s.length()-1;

        while (left < right) {
            if (s.charAt(left) == s.charAt(right)) {
                left++;
                right--;
            } else {
                return "NO";
            }
        }

        return answer;

    }

    public static void main(String[] args) {
        string02 T = new string02();

        System.out.println(T.solution("gooG"));
        System.out.println(T.solution("Moon"));

    }
}
