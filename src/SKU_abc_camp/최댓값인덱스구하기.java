package SKU_abc_camp;


import java.util.ArrayList;

public class 최댓값인덱스구하기 {

    public int[] solution(int[] arr) {

        ArrayList<Integer> list = new ArrayList<>();
        int max = 0;

        for (int i = 0; i < arr.length; i++) {
            max = Math.max(arr[i], max);
        }

        for (int i = 0; i < arr.length; i++) {
            if (max == arr[i]) {
                list.add(i);
            }
        }

        int[] answer = new int[list.size()];

        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }

        return answer;
    }

    public static void main(String[] args) {
        최댓값인덱스구하기 T = new 최댓값인덱스구하기();

        System.out.println(T.solution(new int[]{1, 3, 5, 4, 5, 2, 1}));
        System.out.println(T.solution(new int[]{3, 6, 10, 1, 7, 2, 4, 6, 10, 9}));
    }
}
