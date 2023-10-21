package SKU_abc_camp;

public class 문자열내p와y의개수 {
    boolean solution(String s) {
        boolean answer = false;
        s = s.toLowerCase();

        int pCount = 0;
        int yCount = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'p') {
                pCount++;
            }
            if (s.charAt(i) == 'y') {
                yCount++;
            }
        }

        if (pCount == yCount) {
            return true;
        }
        return answer;
    }

    public static void main(String[] args) {
        문자열내p와y의개수 T = new 문자열내p와y의개수();

        System.out.println(T.solution("pPoooyY"));
        System.out.println(T.solution("Pyy"));

    }
}
