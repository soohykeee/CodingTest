package programmers.exerciseLv1;

/*
시저 암호 - 연습문제 lv.1

떤 문장의 각 알파벳을 일정한 거리만큼 밀어서 다른 알파벳으로 바꾸는 암호화 방식을 시저 암호라고 합니다.
예를 들어 "AB"는 1만큼 밀면 "BC"가 되고, 3만큼 밀면 "DE"가 됩니다.
"z"는 1만큼 밀면 "a"가 됩니다. 문자열 s와 거리 n을 입력받아 s를 n만큼 민 암호문을 만드는 함수, solution을 완성해 보세요.
 */
public class 시저암호 {

    public String solution(String s, int n) {
        String answer = "";
        int temp = 0;


        for (int i = 0; i < s.length(); i++) {
            if (!Character.isAlphabetic(s.charAt(i))) {
                answer += " ";
            } else {
                temp = (int) s.charAt(i) + n;

                if (Character.isLowerCase(s.charAt(i))) {
                    if (temp > 122) {
                        temp -= 26;
                    }
                }
                if (Character.isUpperCase(s.charAt(i))) {
                    if (temp > 90) {
                        temp -= 26;
                    }
                }

                answer += (char) temp;
                temp = 0;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        시저암호 T = new 시저암호();

        System.out.println(T.solution("AB", 1));
        System.out.println(T.solution("z", 1));
        System.out.println(T.solution("a B z", 4));

    }
}
