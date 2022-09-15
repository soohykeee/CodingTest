package programmers.bruteForce;

import java.util.HashSet;
import java.util.Iterator;

/*
소수 찾기

한자리 숫자가 적힌 종이 조각이 흩어져있습니다.
흩어진 종이 조각을 붙여 소수를 몇 개 만들 수 있는지 알아내려 합니다.

각 종이 조각에 적힌 숫자가 적힌 문자열 numbers가 주어졌을 때,
종이 조각으로 만들 수 있는 소수가 몇 개인지 return 하도록 solution 함수를 완성해주세요.
 */
public class bruteForce03 {

    HashSet<Integer> numberSet = new HashSet<>();

    // 에라스토테네스의 체를 활용한 소수 찾기 알고리즘
    public static boolean isPrime(int num) {
        if (num == 1 || num == 0) return false;

        int limit = (int) Math.sqrt(num);
        for (int i = 2; i <= limit; i++) {
            if(num % i == 0) return  false;
        }

        return true;
    }

    // 입력 받은 숫자를 나올 수 있는 최대의 조합을 구해서 HashSet으로 만들어 반환
    // Set을 사용하면 중복을 거를 수 있다
    public void recursive(String comb, String others) {
        // 1. 현재 조합을 set에 추가
        if (!comb.equals("")) {
            numberSet.add(Integer.parseInt(comb));
        }

        // 2. 남은 숫자 중 한개를 더해서 새로운 조합을 만든 후, 재귀함수 루프
        for (int i = 0; i < others.length(); i++) {
            if (!comb.equals("")) {
                numberSet.add(Integer.valueOf(comb));
            }
            recursive(comb + others.charAt(i), others.substring(0, i) + others.substring(i + 1));
        }
    }

    public int solution(String numbers) {
        int answer = 0;

        recursive("", numbers);
        Iterator<Integer> iterator = numberSet.iterator();

        while (iterator.hasNext()) {
            int number = iterator.next();
            if (isPrime(number)) {
                answer++;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        bruteForce03 T = new bruteForce03();

        System.out.println(T.solution("17"));
        System.out.println(T.solution("011"));

    }
}
