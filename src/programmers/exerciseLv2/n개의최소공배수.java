package programmers.exerciseLv2;

/*
N개의 최소공배수 - 연습문제 lv.2

 */
public class n개의최소공배수 {
    public int solution(int[] arr) {
        int answer = 0;

        if (arr.length == 1) {
            return arr[0];
        }

        int g = gcd(arr[0], arr[1]);
        answer = (arr[0] * arr[1]) / g;
        if (arr.length > 2) {
            for (int i = 2; i < arr.length; i++) {
                g = gcd(answer, arr[i]);
                answer = (answer * arr[i]) / g;
            }
        }

        return answer;
    }

    //최대 공약수 구하기
    private static int gcd(int a, int b) {
        int r = a % b;
        if (r == 0) {
            return b;
        } else {
            return gcd(b, r);
        }

    }



    public static void main(String[] args) {
        n개의최소공배수 T = new n개의최소공배수();

        System.out.println(T.solution(new int[]{2, 6, 8, 14}));
        System.out.println(T.solution(new int[]{1, 2, 3}));
    }
}
