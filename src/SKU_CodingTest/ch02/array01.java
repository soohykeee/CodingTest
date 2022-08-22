package SKU_CodingTest.ch02;

/*
제곱수 정렬
        오름차순 정렬되어 있는 길이가 n인 수열이 주어집니다. 수열의 원소를 제곱하여 오름차순 정
        열한 배열을 반환하는 프로그램을 작성하세요.
        주의 : sort 함수를 사용하면 안됩니다.
*/
public class array01 {

    public int[] solution(int[] nums) {

        int left = 0;
        int right = nums.length - 1;
        int[] answer = new int[nums.length];

        for (int i = nums.length - 1; i >= 0; i--) {
            if (Math.abs(nums[left]) > Math.abs(nums[right])) {
                answer[i] = nums[left] * nums[left];
                left++;
            } else {
                answer[i] = nums[right] * nums[right];
                right--;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        array01 T = new array01();

        int[] arr1 = new int[]{-4, -1, 0, 3, 10};
        for(int x : T.solution(arr1)){
            System.out.print(x+" ");
        }
        System.out.println("");

        int[] arr2 = new int[]{-7, -3, 2, 3, 11};
        for(int x : T.solution(arr2)){
            System.out.print(x+" ");
        }
    }
}
