package SKU_CodingTest.ch02;

/*
거리 두기
        현수는 영화관에 도착했습니다. 영화상영 시간보다 약간 늦은 현수는 남은 좌석을 빨리 선택
        하고 영화를 보려고 합니다.
        일렬로된 n개의 좌석정보가 매개변수 nums에 주어지면, 이미 앉아 있는 사람들 중 가장 가까
        운 사람과 최대한 멀리 떨어져 앉을 자석을 선택해야 그 거리를 반환하는 프로그램을 작성하
        세요.
*/

public class array06 {

    public int solution(int[] nums) {
        int answer = 0;

        int[] arr = new int[nums.length - 1];
        int count=1;

        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == 1) {
                arr[i] = 0;
                count = 1;
            } else {
                arr[i] = count++;
            }
        }

        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] == 1) {
                count = 1;
            } else {
                count++;
                if (arr[i] > count) {
                    arr[i] = count;
                }
            }
        }

        for (int i = 0; i < arr.length; i++) {
            if (answer < arr[i]) {
                answer = arr[i];
            }
        }


        return answer;
    }

    public static void main(String[] args) {
        array06 T = new array06();

        int[] arr1 = new int[]{1, 0, 0, 0, 1, 0, 0, 1, 0, 1};
        System.out.println(T.solution(arr1));
    }
}
