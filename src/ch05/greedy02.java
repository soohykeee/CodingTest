package ch05;

/*
가격책정
        미술 작품에 가격을 매기는 일은 쉽지 않습니다. 작품의 가치를 매길 수 있는 정확한 지표가
        없기 때문입니다. 그렇기 때문에 사람의 주관이 많이 들어가게 됩니다.
        이런 문제를 해결하기 위해 여러 전문가들에게 감정을 맡겨보기로 했습니다. 하지만 전문가도
        항상 정당한 값을 매기기는 어렵습니다. 또 의도적으로 높게 혹은 낮게 가격을 매길 수 있습
        니다. 그래서 다음과 같은 4가지 방법으로 판매가를 결정하려고 합니다. 1번 방법부터 적용시
        킬수 있으며 적용시켜서 판매가를 결정하고, 적용시킬 수 없다면 다음 방법으로 차례차례 넘
        어갑니다.
        
        미완
*/

import java.util.Arrays;

public class greedy02 {

    public int getAverage(int[] prices, int from, int to) {

        int sum = 0;
        for (int i = from; i <= to; i++) {
            sum+=prices[i];
        }

        return sum / (to - from + 1);

    }

    public int solution(int[] prices, int d, int k) {

        int n = prices.length;
        Arrays.sort(prices);

        if (prices[n - 1] - prices[0] <= d) {
            return getAverage(prices, 0, n - 1);
        } else if (prices[n - 2] - prices[1] <= d) {
            return getAverage(prices, 1, n - 2);
        }
        for (int i = 0; i <= (n - k); i++) {
            if (prices[i + k -1] - prices[i] <= d) {
                return getAverage(prices, i, i + k - 1);
            }
        }

        return prices[(n-1)/2];
    }

    public static void main(String[] args) {
        greedy02 T = new greedy02();

        int[] prices1 = {4, 5, 6, 7, 8};
        System.out.println(T.solution(prices1, 4, 3));

        int[] prices2 = {4, 5, 6, 7, 8};
        System.out.println(T.solution(prices2, 2, 1));

        int[] prices3 = {4, 5, 6, 7, 8};
        System.out.println(T.solution(prices3, 1, 2));

        int[] prices4 = {8, 4, 5, 7, 6};
        System.out.println(T.solution(prices4, 1, 3));

        int[] prices5 = {1, 8, 1, 8, 1, 8};
        System.out.println(T.solution(prices5, 6, 4));
        // 1, 1, 1, 8, 8, 8

    }

}
