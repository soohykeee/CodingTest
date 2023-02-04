package programmers.exerciseLv2;

public class 다음큰숫자 {

    public int solution(int n) {
        int answer = 0;

        String temp = Integer.toBinaryString(n);

        int limit = 0;
        int count = 0;

        for (int i = 0; i < temp.length(); i++) {
            if (temp.charAt(i) == '1') {
                limit++;
            }
        }

        while (true) {
            count = 0;
            n++;
            temp = Integer.toBinaryString(n);

            for (int i = 0; i < temp.length(); i++) {
                if (temp.charAt(i) == '1') {
                    count++;
                }
            }

            if (limit == count) {
                answer = n;
                break;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        다음큰숫자 T = new 다음큰숫자();

        System.out.println(T.solution(78));
        System.out.println(T.solution(15));

    }
}
