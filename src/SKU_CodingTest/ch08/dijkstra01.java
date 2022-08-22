package SKU_CodingTest.ch08;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

/*
다익스트라 알고리즘
아래의 가중치 방향그래프에서 1번 정점(출발정점)에서 특정 정점(도착정점)까지의 최소 거리
비용을 출력하는 프로그램을 작성하세요. (경로가 없으면 -1를 출력한다)

하나의 정점에서 출발했을 때 다른 모든 정점으로의 최단 경로를 구하는 알고리즘
가장 적은 비용을 하나씩 선택하며 알고리즘을 수행
 */
class Edge implements Comparable<Edge> {
    // 정점
    public int vex;
    // 비용
    public int cost;

    public Edge(int vex, int cost) {
        this.vex = vex;
        this.cost = cost;
    }

    @Override
    public int compareTo(Edge o) {
        return this.cost - o.cost;
    }
}

public class dijkstra01 {

    public int solution(int n, int[][] edges, int end) {
        // 2차원 ArrayList 선언 + 초기화
        ArrayList<ArrayList<Edge>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<Edge>());
        }

        //거리를 저장하는 배열, 거리 cost의 최솟값을 찾아야하므로, 최대값으로 미리 세팅
        int[] dis = new int[n + 1];
        Arrays.fill(dis, Integer.MAX_VALUE);

        //2차원 ArrayList graph 에 edges 에 적힌 가중치 그래프로 초기화
        for (int[] x : edges) {
            graph.get(x[0]).add(new Edge(x[1], x[2]));
        }

        PriorityQueue<Edge> priorityQueue = new PriorityQueue<>();
        // 우선순위 큐를 사용하여, 1번 정점에서 0의 비용으로 시작하도록 초기화
        priorityQueue.offer(new Edge(1, 0));
        // 거리 정보를 저장하는 dis 배열에는 1번 정점에서 시작하므로 dis[1] = 0 으로 저장
        dis[1] = 0;

        while (!priorityQueue.isEmpty()) {
            Edge temp = priorityQueue.poll();
            // 현재 정점(위치)
            int now = temp.vex;
            // 현재 비용(지나온 가중치)
            int nowCost = temp.cost;

            // 지나온 가중치가, 1번에서 now까지 가는 거리보다 길면 continue
            if (nowCost > dis[now]) {
                continue;
            }

            //graphDfs03 에서의 for 문 참고
            // temp 로 우선순위 큐에서 끌어온 vex(정점) 과 연결된 Edge를 반복문을 돌린다.
            // dis 배열보다 비용이 적으면 갱신해준다
            for (Edge ob : graph.get(now)) {
                if (dis[ob.vex] > nowCost + ob.cost) {
                    dis[ob.vex] = nowCost + ob.cost;
                    priorityQueue.offer(new Edge(ob.vex, dis[ob.vex]));
                }
            }
        }
        // 도착 정점까지의 비용이 맨처음 초기화했던 MAX_VALUE와 동일하다면 -1 return
        // 그렇지 않으면 도착정점까지의 비용을 return
        if (dis[end] == Integer.MAX_VALUE) {
            return -1;
        } else {
            return dis[end];
        }
    }

    public static void main(String[] args) {
        dijkstra01 T = new dijkstra01();
        System.out.println(T.solution(6, new int[][] { { 1, 2, 12 }, { 1, 3, 4 }, { 2, 1, 2 }, { 2, 3, 5 }, { 2, 5, 5 },
                { 3, 4, 5 }, { 4, 2, 2 }, { 4, 5, 5 }, { 6, 4, 5 } }, 5));
    }
}
