package programmers.exerciseLv1;

import java.util.ArrayList;
import java.util.Arrays;

/*
두개 뽑아서 더하기 - 월간 코드 챌린지 시즌 1

정수 배열 numbers가 주어집니다.
numbers에서 서로 다른 인덱스에 있는 두 개의 수를 뽑아 더해서 만들 수 있는 모든 수를 배열에 오름차순으로 담아
return 하도록 solution 함수를 완성해주세요.
 */
public class 두개뽑아서더하기 {

    public int[] solution(int[] numbers) {
        ArrayList<Integer> temp = new ArrayList<>();
        int left = 0;
        int right = 1;
        while (right < numbers.length) {
            if (!temp.contains(numbers[left] + numbers[right])) {
                temp.add(numbers[left] + numbers[right]);
            }
            right++;
            if (right == numbers.length) {
                left++;
                right = left + 1;
            }
        }

        int[] answer = new int[temp.size()];

        for (int i = 0; i < temp.size(); i++) {
            answer[i] = temp.get(i);
        }
        Arrays.sort(answer);

        return answer;
    }

    public static void main(String[] args) {
        두개뽑아서더하기 T = new 두개뽑아서더하기();

        System.out.println(T.solution(new int[]{2, 1, 3, 4, 1}));
        System.out.println(T.solution(new int[]{5, 0, 2, 7}));
    }

}
