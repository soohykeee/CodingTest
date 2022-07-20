package ch05;

/*
팀구성
        당신은 새로 만들어진 두 개의 팀 중 한 팀을 이끄는 리더입니다. 당신은 상대팀 리더와 경쟁
        을 통해 사람들을 팀으로 데려옵니다. 매 라운드마다 각 리더는 사람을 한 명씩 선택할 수 있
        으며, 항상 상대 팀 리더가 먼저 선택합니다. 대신, 당신에게는 원할 때 쓸 수 있는 우선권 k
        개가 주어집니다. 우선권을 사용한 라운드는 당신이 상대 리더보다 먼저 선택할 수 있습니다.
        당신을 포함하여 리더는 항상 남은 사람들 중 가장 능력치가 높은 사람을 먼저 데려갑니다.
        당신은 이 우선권을 이용해 팀원의 능력치 합이 최대한 높은 팀을 만들려고 합니다.
        예를 들어 사람들의 능력치를 담은 배열이 [2, 8, 3, 6, 1, 9, 1, 9]이고 당신에게 우선권이 2
        개 있는 경우, 다음과 같이 행동할 수 있습니다.
*/


import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;

public class greedy03 {

    public int solution(int[] abilities, int k) {

        // 기본 Arrays.sort는 오른차순인데, 내림차순을 사용하기 위해서는
        // Integer[] 로 배열을 설정해야한다. 따라서 Integer[] temp 생성 후 값 옮겨주기
        // abilities의 길이가 홀수라면 짝수를 맞춰주기 위해 하나 더 추가해준다
        int n = abilities.length;
        Integer[] temp;

        if (n % 2 == 1) {
            n++;
            temp = new Integer[n];
            for (int i = 0; i < abilities.length; i++) {
                temp[i] = abilities[i];
            }
            temp[n - 1] = 0;
        } else {
            temp = new Integer[n];
            for (int i = 0; i < abilities.length; i++) {
                temp[i] = abilities[i];
            }
        }

        // 내림차순 정렬
        Arrays.sort(temp, Collections.reverseOrder());

        //짝수번째와, 홀수번째의 차를 저장하는 diff 배열 생성
        int sum = 0;
        for (int i = 0; i < n / 2; i++) {
            sum += temp[i * 2 + 1];
        }

        Integer[] diff = new Integer[n / 2];
        for (int i = 0; i < diff.length; i++) {
            diff[i] = temp[i * 2] - temp[i * 2 + 1];
        }

        Arrays.sort(diff, Collections.reverseOrder());

        for (int i = 0; i < k; i++) {
            sum += diff[i];
        }

        return sum;
    }

    public static void main(String[] args) {
        greedy03 T = new greedy03();

        int[] arr1= {2, 8, 3, 6, 1, 9, 1, 9};
        System.out.println(T.solution(arr1, 2));
        //1, 1, 2, 3, 6, 8, 9, 9


        int[] arr2 = {7, 6, 8, 9, 10};
        System.out.println(T.solution(arr2, 1));

    }
}
