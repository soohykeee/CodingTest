package ch04;

/*
연속된 자연수의 합
        N입력으로 양의 정수 N이 입력되면 2개 이상의 연속된 자연수의 합으로 정수 N을 표현하는
        방법의 가짓수를 출력하는 프로그램을 작성하세요.
        만약 N=15이면
        7+8=15
        4+5+6=15
        1+2+3+4+5=15
        와 같이 총 3가지의 경우가 존재한다.
*/

public class timeComplexity07 {

    public int solution(int n) {

        int[] nums = new int[n / 2 + 1];
        for (int i = 0; i < nums.length; i++) {
            nums[i]=i+1;
        }

        int answer=0;
        int sum=0;
        int left=0;
        for (int right = 0; right < nums.length; right++) {
            sum += nums[right];

            while (sum > n) {
                sum -= nums[left++];
            }

            if (sum == n) {
                answer++;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        timeComplexity07 T = new timeComplexity07();

        System.out.println(T.solution(15));
        System.out.println(T.solution(45678));
        System.out.println(T.solution(98765));

    }
}
