package programmers.swmaestro코테대비;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*
백준 1697 - 숨바꼭질
 */
public class 백준1697 {

    public static int subin;
    public static int sister;
    public static Queue<Integer> queue = new LinkedList<>();
    public static int[] check = new int[100001];

    public static void BFS(int start) {
        queue.add(start);
        check[start] = 1;

        while (!queue.isEmpty()) {
            int temp = queue.poll();

            for (int i = 0; i < 3; i++) {
                int next;

                if (i == 0) {
                    next = temp - 1;
                } else if (i == 1) {
                    next = temp + 1;
                } else {
                    next = temp * 2;
                }

                if (next == sister) {
                    System.out.println(check[temp]);
                    return;
                }

                if (next > 0 && next < check.length && check[next] == 0) {
                    queue.add(next);
                    check[next] = check[temp] + 1;
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        subin = sc.nextInt();
        sister = sc.nextInt();

        if (subin == sister) {
            System.out.println(0);
        } else {
            BFS(subin);
        }
    }
}
