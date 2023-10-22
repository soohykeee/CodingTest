package SKU_abc_camp;

import java.util.ArrayList;

public class 제일작은수제거하기 {

    public int[] solution(int[] arr) {

        if (arr.length == 1) {
            return new int[]{-1};
        }

        int[] answer = new int[arr.length - 1];
        ArrayList<Integer> list = new ArrayList<>();

        int min = Integer.MAX_VALUE;
        int count = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
                count = i;
            }
        }

        for (int i = 0; i < arr.length; i++) {
            if (i == count) {
                continue;
            }
            list.add(arr[i]);
        }

        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }

        return answer;
    }

    public static void main(String[] args) {
        제일작은수제거하기 T = new 제일작은수제거하기();

        System.out.println(T.solution(new int[]{4, 3, 2, 1}));
        System.out.println(T.solution(new int[]{10}));

    }
}
