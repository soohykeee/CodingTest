package programmers.exerciseLv1;

/*
숫자 문자열과 영단어 - 2021 카카오 채용연계형 인턴십

네오와 프로도가 숫자놀이를 하고 있습니다. 네오가 프로도에게 숫자를 건넬 때
일부 자릿수를 영단어로 바꾼 카드를 건네주면 프로도는 원래 숫자를 찾는 게임입니다.

다음은 숫자의 일부 자릿수를 영단어로 바꾸는 예시입니다.

1478 → "one4seveneight"
234567 → "23four5six7"
10203 → "1zerotwozero3"
이렇게 숫자의 일부 자릿수가 영단어로 바뀌어졌거나, 혹은 바뀌지 않고 그대로인 문자열 s가 매개변수로 주어집니다.
s가 의미하는 원래 숫자를 return 하도록 solution 함수를 완성해주세요.


 */
public class 숫자문자열과영단어 {

    public int solution(String s) {
        int answer = 0;

        String[] nums = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};

        for (int i = 0; i < 10; i++) {
            s = s.replace(nums[i], Integer.toString(i));
        }

        answer = Integer.parseInt(s);

        return answer;
    }

    public static void main(String[] args) {
        숫자문자열과영단어 T = new 숫자문자열과영단어();

        System.out.println(T.solution("one4seveneight"));
        System.out.println(T.solution("23four5six7"));
        System.out.println(T.solution("2three45sixseven"));
        System.out.println(T.solution("123"));

    }
}
