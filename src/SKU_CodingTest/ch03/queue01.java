package SKU_CodingTest.ch03;

/*
공주 구하기
        정보 왕국의 이웃 나라 외동딸 공주가 숲속의 괴물에게 잡혀갔습니다.
        정보 왕국에는 왕자가 N명이 있는데 서로 공주를 구하러 가겠다고 합니다. 정보왕국의 왕은
        다음과 같은 방법으로 공주를 구하러 갈 왕자를 결정하기로 했습니다.
        왕은 왕자들을 나이 순으로 1번부터 N번까지 차례로 번호를 매긴다. 그리고 1번 왕자부터 N
        번 왕자까지 순서대로 시계 방향으로 돌아가며 동그랗게 앉게 한다. 그리고 1번 왕자부터 시
        계방향으로 돌아가며 1부터 시작하여 번호를 외치게 한다. 한 왕자가 K(특정숫자)를 외치면 그
        왕자는 공주를 구하러 가는데서 제외되고 원 밖으로 나오게 된다. 그리고 다음 왕자부터 다시
        1부터 시작하여 번호를 외친다.
        이렇게 해서 마지막까지 남은 왕자가 공주를 구하러 갈 수 있다.
*/

import java.util.LinkedList;
import java.util.Queue;

public class queue01 {

    public int solution(int n, int k) {

        int answer=0;

        Queue<Integer> queue = new LinkedList<>();

        for (int i = 1; i <= n; i++) {
            queue.offer(i);
        }

        while (queue.size() != 1) {
            for (int i = 0; i < k; i++) {
                //3번째이면 삭제
                if (i == k - 1) {
                    queue.poll();
                }
                // 3번째가 아니면 Queue에서 맨앞에 있던 값 다시 Queue의 뒤에 넣어주기
                else {
                    queue.offer(queue.poll());
                }
            }
        }

        answer = queue.peek();
        return answer;

    }

    public static void main(String[] args) {
        queue01 T = new queue01();

        System.out.println(T.solution(8, 3));
    }
}
