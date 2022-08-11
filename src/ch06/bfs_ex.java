package ch06;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/*
이진트리 레벨탐색(넓이우선탐색 : BFS)
아래 그림과 같은 이진트리를 큐(Queue) 자료구조를 이용해 레벨탐색을 해보세요.
 */

public class bfs_ex {

    ArrayList<Integer> answer = new ArrayList<>();

    public ArrayList<Integer> solution(int n) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1);
        int L = 0;

        while (!queue.isEmpty()) {
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                int v = queue.poll();
                answer.add(v);
                for (int nv : new int[]{v * 2, v * 2 + 1}) {
                    if (nv > n) {
                        continue;
                    }
                    queue.offer(nv);
                }
            }
            L++;
        }
        return answer;
    }

    public static void main(String[] args) {
        bfs_ex T = new bfs_ex();
        System.out.println(T.solution(7));
    }
}
