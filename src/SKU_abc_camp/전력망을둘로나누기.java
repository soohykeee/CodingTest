package SKU_abc_camp;

import java.util.ArrayDeque;
import java.util.Deque;

public class 전력망을둘로나누기 {

    public int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;

        int[][] list = new int[n + 1][n + 1];
        int count, min;

        for (int i = 0; i < wires.length; i++) {
            list[wires[i][0]][wires[i][1]] = 1;
            list[wires[i][1]][wires[i][0]] = 1;
        }

        for (int i = 0; i < wires.length; i++) {
            boolean[] visited = new boolean[n + 1];
            Deque<Integer> deque = new ArrayDeque<>();
            deque.clear();
            count = 1;
            min = 0;

            list[wires[i][0]][wires[i][1]] = 0;
            list[wires[i][1]][wires[i][0]] = 0;

            deque.addLast(wires[i][0]);
            visited[wires[i][0]] = true;

            while (!deque.isEmpty()) {
                int current = deque.removeFirst();

                for (int j = 1; j < n + 1; j++) {
                    if (list[current][j] == 1 && !visited[j]) {
                        visited[j] = true;
                        count++;
                        deque.addLast(j);
                    }
                }
            }

            list[wires[i][0]][wires[i][1]] = 1;
            list[wires[i][1]][wires[i][0]] = 1;

            min = Math.abs(count - (n - count));
            answer = Math.min(answer, min);
        }

        return answer;
    }

    public static void main(String[] args) {
        전력망을둘로나누기 T = new 전력망을둘로나누기();

        System.out.println(T.solution(9, new int[][]{{1, 3}, {2, 3}, {3, 4}, {4, 5}, {4, 6}, {4, 7}, {7, 8}, {7, 9}}));
        System.out.println(T.solution(4, new int[][]{{1, 2}, {2, 3}, {3, 4}}));
        System.out.println(T.solution(7, new int[][]{{1, 2}, {2, 7}, {3, 7}, {3, 4}, {4, 5}, {6, 7}}));
    }
}
