package SKU_abc_camp;


import java.util.Arrays;

public class 순열검사 {

    public boolean solution(int[] arr) {
        boolean answer = true;

        Arrays.sort(arr);

        if (arr[0] == 1 && arr[arr.length - 1] == arr.length) {
            answer = true;
        } else {
            answer = false;
        }

        return answer;
    }

    public static void main(String[] args) {
        순열검사 T = new 순열검사();

        System.out.println(T.solution(new int[]{4, 1, 3, 2}));
        System.out.println(T.solution(new int[]{4, 1, 3}));
    }
}
