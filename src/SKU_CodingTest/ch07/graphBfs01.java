package SKU_CodingTest.ch07;

/*
타일 점프
현수의 집에서 상점까지는 자연수가 적혀있는 타일이 깔려있습니다. i번째 탈일에 적힌 수를
Ai라고 한다면 현수는 i번째 타일 위에서 오른쪽으로 Ai이하만큼 점프할 수 있습니다.
예를 들어 현수가 2번째 탈일에 있고, 적힌 수가 3이라면 현수는 3, 4, 5번째 타일로 점프할 수 있다.
현수가 집에서 상점까지 최소 몇 번의 점프로 갈 수 있는지 구하는 프로그램을 작성하세요.

BFS는 더 공부 필요
 */

import java.util.LinkedList;
import java.util.Queue;

public class graphBfs01 {

    public int solution(int[] nums) {
        int n = nums.length;
        int[] ch = new int[n];
        int L = 0;
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);
        ch[0] = 1;

        // queue 에 들어가는 값의 정보는, 현수가 점프한 후의 위치정보가 저장
        while (!queue.isEmpty()) {
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                int x = queue.poll();
                // j는 점프할 수 있는 길이들을 반복문으로 돌리는 변수
                for (int j = 1; j <= nums[x]; j++) {
                    // queue 로 부터 현재 현수가 서있는 위치 정보 + 점프의 길이가
                    // 마지막에 도착하게되면 return
                    if (x + j == (n - 1)) {
                        return L + 1;
                    }
                    // 0으로 표시된 곳으로 점프하는지, 끝을 넘어가는지, 이미 갔던곳은 아닌지 체크
                    // 아니라면 해당 위치의 check 변수를 1로 바꿔주고, queue 에 현재 점프한 위치 정보를 넣어준다
                    if (x + j >= 0 && x + j < n && ch[x + j] == 0) {
                        ch[x + j] = 1;
                        queue.offer(x + j);
                    }
                }
            }
            L++;
        }
        return -1;
    }

    public static void main(String[] args){
        graphBfs01 T = new graphBfs01();
        System.out.println(T.solution(new int[]{2, 2, 0, 2, 1, 1}));
        System.out.println(T.solution(new int[]{1, 0, 1, 1, 3, 1, 2, 1}));
    }
}
