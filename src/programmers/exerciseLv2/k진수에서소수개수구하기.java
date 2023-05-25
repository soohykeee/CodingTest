package programmers.exerciseLv2;


/*
k진수에서 소수 개수 구하기 - 2022 KAKAO BLIND RECRUITMENT

 */
public class k진수에서소수개수구하기 {

    // 소수인지 확인하는 함수
    // long 으로 수정 필요
    public boolean isPrime(int number) {
        if (number == 1) {
            return false;
        }

        for (int i = 2; i * i <= number; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }


    public int solution(int n, int k) {
        int answer = 0;
        String temp = "";

        // n을 k진수로 변환
        String convert = Integer.toString(n, k);

        for (int i = 0; i < convert.length(); i++) {
            if (convert.charAt(i) != '0') {
                temp += convert.charAt(i);
            } else {
                if (temp.length() > 0 && isPrime(Integer.parseInt(temp))) {
                    answer++;
                }
                temp="";
            }
        }

        if (temp.length() > 0 && isPrime(Integer.parseInt(temp))) {
            answer++;
        }

        return answer;
    }

    public static void main(String[] args) {
        k진수에서소수개수구하기 T = new k진수에서소수개수구하기();

        System.out.println(T.solution(437674, 3));
        System.out.println(T.solution(110011, 10));
    }
}
