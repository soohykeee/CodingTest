package programmers.bruteForce;

import java.util.ArrayList;
import java.util.List;

/*
모의고사

수포자는 수학을 포기한 사람의 준말입니다. 수포자 삼인방은 모의고사에 수학 문제를 전부 찍으려 합니다.
수포자는 1번 문제부터 마지막 문제까지 다음과 같이 찍습니다.

1번 수포자가 찍는 방식: 1, 2, 3, 4, 5, 1, 2, 3, 4, 5, ...
2번 수포자가 찍는 방식: 2, 1, 2, 3, 2, 4, 2, 5, 2, 1, 2, 3, 2, 4, 2, 5, ...
3번 수포자가 찍는 방식: 3, 3, 1, 1, 2, 2, 4, 4, 5, 5, 3, 3, 1, 1, 2, 2, 4, 4, 5, 5, ...

1번 문제부터 마지막 문제까지의 정답이 순서대로 들은 배열 answers가 주어졌을 때,
가장 많은 문제를 맞힌 사람이 누구인지 배열에 담아 return 하도록 solution 함수를 작성해주세요.
 */
public class bruteForce02 {

    public int[] solution(int[] answers) {

        int[] count = new int[3];
        int[] person1 = {1, 2, 3, 4, 5};
        int[] person2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] person3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

        for (int i = 0; i < answers.length; i++) {
            if(answers[i] == person1[i%5]) count[0]++;
            if(answers[i] == person2[i%8]) count[1]++;
            if(answers[i] == person3[i%10]) count[2]++;
        }

        int max = Math.max(count[0], Math.max(count[1], count[2]));
        List<Integer> list = new ArrayList<>();
        if (max == count[0]) {
            list.add(1);
        }
        if (max == count[1]) {
            list.add(2);
        }
        if (max == count[2]) {
            list.add(3);
        }

        int[] answer = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }

        return answer;
    }

    public static void main(String[] args) {
        bruteForce02 T = new bruteForce02();

        System.out.println(T.solution(new int[]{1, 2, 3, 4, 5}));
        System.out.println(T.solution(new int[]{1, 3, 2, 4, 2}));

    }
}
