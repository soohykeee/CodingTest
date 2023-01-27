package programmers.exerciseLv1;

/*
옹알이 (2) - 연습문제 lv.1

머쓱이는 태어난 지 11개월 된 조카를 돌보고 있습니다.
조카는 아직 "aya", "ye", "woo", "ma" 네 가지 발음과 네 가지 발음을 조합해서
만들 수 있는 발음밖에 하지 못하고 연속해서 같은 발음을 하는 것을 어려워합니다.
문자열 배열 babbling이 매개변수로 주어질 때,
머쓱이의 조카가 발음할 수 있는 단어의 개수를 return하도록 solution 함수를 완성해주세요.
 */
public class 옹알이2 {

    public int solution(String[] babbling) {
        int answer = 0;

        for (int i = 0; i < babbling.length; i++) {
            if (babbling[i].contains("ayaaya") || babbling[i].contains("yeye") || babbling[i].contains("woowoo") || babbling[i].contains("mama")) {
                continue;
            }

            babbling[i] = babbling[i].replace("aya", " ");
            babbling[i] = babbling[i].replace("ye", " ");
            babbling[i] = babbling[i].replace("woo", " ");
            babbling[i] = babbling[i].replace("ma", " ");
            babbling[i] = babbling[i].replace(" ", "");


            if (babbling[i].length() == 0) {
                answer++;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        옹알이2 T = new 옹알이2();

        System.out.println(T.solution(new String[]{"aya", "yee", "u", "maa"}));
        System.out.println(T.solution(new String[]{"ayaye", "uuu", "yeye", "yemawoo", "ayaayaa"}));
    }

}
