package SKU_CodingTest.ch08;

import java.util.ArrayList;
import java.util.Collections;

/*
원더랜드(최소스패닝트리 : 크루스칼, Union&Find 활용)
원더랜드에 문제가 생겼다. 원더랜드의 각 도로를 유지보수하는 재정이 바닥난 것이다.
원더랜드는 모든 도시를 서로 연결하면서 최소의 유지비용이 들도록 도로를 선택하고 나머지
도로는 폐쇄하려고 한다.
아래의 그림은 그 한 예를 설명하는 그림이다.

위의 지도는 각 도시가 1부터 9로 표현되었고, 지도의 오른쪽은 최소비용 196으로 모든 도시
를 연결하는 방법을 찾아낸 것이다.

크루스칼 알고리즘이란?
그래프 내의 모든 정점들을 가장 적은 비용으로 연결하기 위해 사용
-> 그래프 내의 모든 정점을 포함하고 사이클이 없는 연결 선을 그렸을 때, 가중치의 합이
최소가 되는 상황을 구하고 싶을 때 사용한다. (최소 신장 트리를 구현하기 위한 알고리즘) + 사이클 x
 */
class Edge1 implements Comparable<Edge1> {
    public int v1;
    public int v2;
    public int cost;

    Edge1(int v1, int v2, int cost) {
        this.v1 = v1;
        this.v2 = v2;
        this.cost = cost;
    }

    @Override
    public int compareTo(Edge1 o) {
        return this.cost - o.cost;
    }
}

public class kruskal01 {
    int[] unf;

    public int Find(int v) {
        if(v==unf[v]) return v;
        else return unf[v]=Find(unf[v]);
    }

    public void Union(int a, int b) {
        int fa = Find(a);
        int fb = Find(b);

        if(fa != fb) unf[fa] = fb;
    }

    public int solution(int n, int[][] edges) {
        unf = new int[n + 1];
        ArrayList<Edge1> list = new ArrayList<>();
        for (int i = 1; i <= n; i++) unf[i] = i;

        for (int[] x : edges) {
            list.add(new Edge1(x[0], x[1], x[2]));
        }

        int answer = 0;
        Collections.sort(list);
        for (Edge1 ob : list) {
            int fv1 = Find(ob.v1);
            int fv2 = Find(ob.v2);
            if (fv1 != fv2) {
                answer += ob.cost;
                Union(ob.v1, ob.v2);
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        kruskal01 T = new kruskal01();

        System.out.println(T.solution(9, new int[][]{{1, 2, 12}, {1, 9, 25}, {2, 3, 10}, {2, 8, 17}, {2, 9, 8},
                {3, 4, 18}, {3, 7, 55}, {4, 5, 44}, {5, 6, 60}, {5, 7, 38}, {7, 8, 35}, {8, 9, 15}}));
    }

}
