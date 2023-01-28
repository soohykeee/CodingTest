package programmers.exerciseLv1;

/*
신규 아이디 추천 - 2021 KAKAO BLIND RECRUITMENT

 */
public class 신규아이디추천 {

    public String first_opt(String str) {
        return str.toLowerCase();
    }

    public String second_opt(String str) {
        String temp = "";
        for (int i = 0; i < str.length(); i++) {
            if ((str.charAt(i) >= 'a' && str.charAt(i) <= 'z') || (str.charAt(i) >= '0' && str.charAt(i) <= '9') || str.charAt(i) == '-' || str.charAt(i) == '_' || str.charAt(i) == '.') {
                temp += str.charAt(i);
            }
        }
        return temp;
    }

    public String third_opt(String str) {
        str = str.replace("..", ".");
        while (str.contains("..")) {
            str = str.replace("..", ".");
        }
        return str;
    }

    public String forth_opt(String str) {

        if (str.length() > 0 && str.charAt(0) == '.') {
            str = str.substring(1);
        }
        if (str.length() > 0 && str.charAt(str.length() - 1) == '.') {
            str = str.substring(0, str.length() - 1);
        }

        return str;
    }

    public String fifth_opt(String str) {
        if (str.length() == 0) {
            str = "a";
        }
        return str;
    }

    public String sixth_opt(String str) {
        if (str.length() >= 16) {
            str = str.substring(0, 15);

            if (str.charAt(str.length() - 1) == '.') {
                str = str.substring(0, str.length() - 1);
            }
        }
        return str;
    }

    public String seventh_opt(String str) {
        while (str.length() < 3) {
            str += str.charAt(str.length() - 1);
        }

        return str;
    }

    public String solution(String new_id) {
        String answer = "";

        answer = seventh_opt(sixth_opt(fifth_opt(forth_opt(third_opt(second_opt(first_opt(new_id)))))));

        return answer;
    }

    public static void main(String[] args) {
        신규아이디추천 T = new 신규아이디추천();

        System.out.println(T.solution("...!@BaT#*..y.abcdefghijklm"));
        System.out.println(T.solution("z-+.^."));
        System.out.println(T.solution("=.="));
        System.out.println(T.solution("123_.def"));
        System.out.println(T.solution("abcdefghijklmn.p"));

    }
}
