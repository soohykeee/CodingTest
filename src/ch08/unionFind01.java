package ch08;

/*
친구인가? (Disjoint-Set : Union&Find)
오늘은 새 학기 새로운 반에서 처음 시작하는 날이다. 현수네 반 학생은 N명이다.
현수는 각 학생들의 친구관계를 알고 싶다.
모든 학생은 1부터 N까지 번호가 부여되어 있고, 현수에게는 각각 두 명의 학생은 친구 관계가
번호로 표현된 숫자쌍이 주어진다. 만약 (1, 2), (2, 3), (3, 4)의 숫자쌍이 주어지면 1번 학
생과 2번 학생이 친구이고, 2번 학생과 3번 학생이 친구, 3번 학생과 4번 학생이 친구이다.
그리고 1번 학생과 4번 학생은 2번과 3번을 통해서 친구관계가 된다.
학생의 친구관계를 나타내는 숫자쌍이 주어지면 특정 두 명이 친구인지를 판별하는 프로그램을 작성하세요.
두 학생이 친구이면 “YES"이고, 아니면 ”NO"를 출력한다.
 */

public class unionFind01 {

    int[] unf;

    public int Find(int v) {
        if (v == unf[v]) return v;
        else return unf[v] = Find(unf[v]);
    }

    public void Union(int a, int b) {
        int fa = Find(a);
        int fb = Find(b);

        if (fa != fb) unf[fa] = fb;
    }

    public String solution(int n, int[][] friend, int s1, int s2) {

        // 선언 + 초기화
        unf = new int[n + 1];
        for (int i = 1; i <= n; i++) unf[i] = i;

        // friend[][] 정보 연결
        for (int[] x : friend) {
            Union(x[0], x[1]);
            /*for (int i = 1; i <= n; i++)
                System.out.print(unf[i]+" ");
            System.out.println("");*/
        }

        int fa = Find(s1);
        int fb = Find(s2);

        if (fa == fb) return "YES";
        else return "NO";

    }

    public static void main(String[] args) {
        unionFind01 T = new unionFind01();
        System.out.println(T.solution(9, new int[][] {
                { 1, 2 }, { 2, 3 }, { 3, 4 }, { 1, 5 }, { 6, 7 }, { 7, 8 }, { 8, 9 } },
                2, 5));
    }
}
