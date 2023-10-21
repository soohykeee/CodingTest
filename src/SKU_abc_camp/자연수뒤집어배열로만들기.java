package SKU_abc_camp;

public class 자연수뒤집어배열로만들기 {

    public int[] solution(long n) {
        String temp = String.valueOf(n);

        int[] answer = new int[temp.length()];

        for (int i = 0; i < answer.length; i++) {
            answer[i] = temp.charAt(answer.length - 1 - i) - '0';
        }

        return answer;
    }

    public static void main(String[] args) {
        자연수뒤집어배열로만들기 T = new 자연수뒤집어배열로만들기();

        System.out.println(T.solution(12345));

    }
}
