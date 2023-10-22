package SKU_abc_camp;

public class 단어변환 {

    static int answer = 0;
    static boolean[] visited;

    int compare(String begin, String word) {
        int n = 0;
        for (int i = 0; i < begin.length(); i++) {
            if (begin.charAt(i) != word.charAt(i)) {
                n++;
            }
        }
        return n;
    }

    void dfs(String begin, String target, String[] words, int count) {
        if (begin.equals(target)) {
            answer = count;
            return;
        }

        for (int i = 0; i < words.length; i++) {
            if (visited[i]) {
                continue;
            }

            int n = compare(begin, words[i]);

            if (n == 1) {
                visited[i] = true;
                dfs(words[i], target, words, count + 1);
                visited[i] = false;
            }
        }
    }

    public int solution(String begin, String target, String[] words) {
        visited = new boolean[words.length];

        dfs(begin, target, words, 0);

        return answer;
    }

    public static void main(String[] args) {
        단어변환 T = new 단어변환();

        System.out.println(T.solution("hit", "cog", new String[]{"hot", "dot", "dog", "lot", "log", "cog"}));
//        System.out.println(T.solution("hit", "cog", new String[]{"hot", "dot", "dog", "lot", "log"}));

    }
}
