package SKU_abc_camp;

public class 주식가격 {

    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];

        for (int i = 0; i < prices.length; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                answer[i]++;
                if (prices[i] > prices[j]) {
                    break;
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        주식가격 T = new 주식가격();

        System.out.println(T.solution(new int[]{1, 2, 3, 2, 3}));
    }
}
