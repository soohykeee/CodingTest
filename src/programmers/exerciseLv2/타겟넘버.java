package programmers.exerciseLv2;

/*
타겟넘버 - 깊이/너비 우선 탐색(DFS/BFS) lv.2

 */
public class 타겟넘버 {

    int answer = 0;

    public void dfs(int[] numbers, int target, int depth, int sum) {
        if (depth == numbers.length) {
            if (target == sum) {
                answer++;
            }
        } else {
            dfs(numbers, target, depth + 1, sum + numbers[depth]);
            dfs(numbers, target, depth + 1, sum - numbers[depth]);
        }
    }

    public int solution(int[] numbers, int target) {
        dfs(numbers, target, 0, 0);

        return answer;
    }

    public static void main(String[] args) {
        타겟넘버 T = new 타겟넘버();

        System.out.println(T.solution(new int[]{1, 1, 1, 1, 1}, 3));
        System.out.println(T.solution(new int[]{4, 1, 2, 1}, 4));
    }
}
