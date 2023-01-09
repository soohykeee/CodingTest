package programmers.exerciseLv1;

/*
소수만들기 - Summer/Winter Coding(~2018) lv.1

주어진 숫자 중 3개의 수를 더했을 때 소수가 되는 경우의 개수를 구하려고 합니다.
숫자들이 들어있는 배열 nums가 매개변수로 주어질 때, nums에 있는 숫자들 중 서로 다른 3개를 골라 더했을 때
소수가 되는 경우의 개수를 return 하도록 solution 함수를 완성해주세요.
 */
public class 소수만들기 {

    public boolean isPrime(int num) {
        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    public int solution(int[] nums) {
        int answer = 0;

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    if (isPrime(nums[i] + nums[j] + nums[k])) {
                        answer++;
                    }
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        소수만들기 T = new 소수만들기();

        System.out.println(T.solution(new int[]{1, 2, 3, 4}));
        System.out.println(T.solution(new int[]{1, 2, 7, 6, 4}));

    }
}
