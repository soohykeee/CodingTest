package programmers.exerciseLv2;

/*
피로도 - 완전탐색 연습문제 lv.2

 */
public class 피로도 {

    public int answer = 0;
    public boolean[] visit;

    public int solution(int k, int[][] dungeons) {
        visit = new boolean[dungeons.length];

        dfs(0, k, dungeons);

        return answer;
    }

    public void dfs(int L, int k, int[][] dungeons) {
        for (int i = 0; i < dungeons.length; i++) {
            if (!visit[i] && dungeons[i][0] <= k) {
                visit[i] = true;
                dfs(L + 1, k - dungeons[i][1], dungeons);
                visit[i] = false;
            }
        }
        answer = Math.max(answer, L);
    }

    public static void main(String[] args) {
        피로도 T = new 피로도();

        System.out.println(T.solution(80, new int[][]{{80, 20}, {50, 40}, {30, 10}}));
    }
}
