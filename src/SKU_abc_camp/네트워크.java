package SKU_abc_camp;

import java.util.ArrayDeque;
import java.util.Deque;

public class 네트워크 {

    public int solution(int n, int[][] computers) {
        int answer = 0;

        for (int i = 0; i < n; i++) {
            computers[i][i] = 0;
        }

        boolean[] visited = new boolean[n];
        Deque<Integer> deque = new ArrayDeque<>();


        for (int j = 0; j < n; j++) {
            deque.addLast(j);
            visited[j] = true;

            while (!deque.isEmpty()) {
                int current = deque.removeLast();

                for (int i = 0; i < n; i++) {
                    if (!visited[i] && computers[current][i] == 1) {
                        answer++;
                        deque.addLast(i);
                        computers[current][i] = 0;
                        computers[i][current] = 0;
                        visited[i] = true;
                    }
                }
            }

        }

        answer = n - answer;

        return answer;
    }

    public static void main(String[] args) {
        네트워크 T = new 네트워크();

        System.out.println(T.solution(3, new int[][]{{1, 1, 0}, {1, 1, 0}, {0, 0, 1}}));
        System.out.println(T.solution(3, new int[][]{{1, 1, 0}, {1, 1, 1}, {0, 1, 1}}));
    }
}
