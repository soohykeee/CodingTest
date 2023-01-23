package programmers.exerciseLv1;

import java.util.*;
import java.util.stream.Collectors;

/*
숫자 짝꿍 - 연습문제 lv.1

두 정수 X, Y의 임의의 자리에서 공통으로 나타나는 정수 k(0 ≤ k ≤ 9)들을 이용하여 만들 수 있는
가장 큰 정수를 두 수의 짝꿍이라 합니다(단, 공통으로 나타나는 정수 중 서로 짝지을 수 있는 숫자만 사용합니다).
X, Y의 짝꿍이 존재하지 않으면, 짝꿍은 -1입니다.
X, Y의 짝꿍이 0으로만 구성되어 있다면, 짝꿍은 0입니다.

예를 들어, X = 3403이고 Y = 13203이라면,
X와 Y의 짝꿍은 X와 Y에서 공통으로 나타나는 3, 0, 3으로 만들 수 있는 가장 큰 정수인 330입니다.
다른 예시로 X = 5525이고 Y = 1255이면 X와 Y의 짝꿍은 X와 Y에서 공통으로 나타나는
2, 5, 5로 만들 수 있는 가장 큰 정수인 552입니다
(X에는 5가 3개, Y에는 5가 2개 나타나므로 남는 5 한 개는 짝 지을 수 없습니다.)

두 정수 X, Y가 주어졌을 때, X, Y의 짝꿍을 return하는 solution 함수를 완성해주세요.

 */
public class 숫자짝꿍 {

    public String solution(String X, String Y) {
        Map<String, Integer> xMap = new HashMap<>();
        Map<String, Integer> yMap = new HashMap<>();

        List<String> list = new ArrayList<>();

        for(String key: X.split("")) {
            xMap.put(key, xMap.getOrDefault(key, 0)+1);
        }

        for(String key: Y.split("")) {
            yMap.put(key, yMap.getOrDefault(key, 0)+1);
        }

        for(String key: xMap.keySet()) {
            if(!yMap.containsKey(key)) continue;

            int length = Math.min(xMap.get(key), yMap.get(key));
            for(int i = 0; i < length; i++) {
                list.add(key);
            }
        }

        String result = list.stream()
                .sorted(Collections.reverseOrder())
                .collect(Collectors.joining());

        if(result.isEmpty()) return "-1";
        if(result.replaceAll("0", "").isEmpty()) return "0";
        return result;
    }

    public static void main(String[] args) {
        숫자짝꿍 T = new 숫자짝꿍();

        System.out.println(T.solution("100", "2345"));
        System.out.println(T.solution("100", "203045"));
        System.out.println(T.solution("100", "123450"));
        System.out.println(T.solution("12321", "42531"));
        System.out.println(T.solution("5525", "1255"));

    }
}
