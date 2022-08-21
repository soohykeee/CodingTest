package ch08;

/*
동전교환(냅색 알고리즘)
다음과 같이 여러 단위의 동전들이 주어져 있을때 거스름돈을 가장 적은 수의 동전으로 교환
해주려면 어떻게 주면 되는가? 각 단위의 동전은 무한정 쓸 수 있다.

1. 리스트 dy에는 거슬러주는데 사용된 동전의 최소개수를 저장한다.

2. 즉, dy[j]에 j원을 거슬러주는데 사용된 동전의 최소개수를 저장하는 것이다.

3. 변수 coins에는 동전의 종류를 저장한다.

4. dy에는 동전의 최소개수를 저장하기 때문에 초기값으로 충분히 큰 수인 1000을 미리 저장해둔다.
    (최소개수를 구하는 문제)

5. dy[0] = 0으로 초기값을 미리 설정한 이유는 0원을 거슬러주는데 사용되는 동전의 개수는 0개이기 때문이다.

6. for (int j = coins[i]; j <= m; j++) 에서 반복문이 1이 아닌 coin[i] 부터 시작하는 이유는
coin[i]의 동전을 추가할 때 해당 동전보다 작은 단위의 동전은 고려할 필요가 없기 때문이다.

7. dy[j] = min(dy[j], dy[j-coin[i]]+1)는 기존의 최소 동전 개수와 coin[i] 동전을 추가로 사용할 경우
새롭게 얻는 최소 동전의 개수를 비교하여 더 작은 값을 dy[j]에 저장해주는 코드이다.
 */

import java.util.Arrays;

public class knapsack01 {

    public int solution(int[] coins, int m) {

        int n = coins.length;

        // 최대크기로 초기화
        int[] dy = new int[m + 1];
        Arrays.fill(dy, Integer.MAX_VALUE);

        dy[0] = 0;
        for (int i = 0; i < n; i++) {
            for (int j = coins[i]; j <= m; j++) {
                dy[j] = Math.min(dy[j], dy[j - coins[i]] + 1);
            }
        }
        return dy[m];
    }

    public static void main(String[] args) {
        knapsack01 T = new knapsack01();
        System.out.println(T.solution(new int[]{1, 2, 5}, 15));
    }
}
