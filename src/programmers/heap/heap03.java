package programmers.heap;

import java.util.Comparator;
import java.util.PriorityQueue;

/*
이중우선순위 큐

이중 우선순위 큐는 다음 연산을 할 수 있는 자료구조를 말합니다.
명령어        수신 탑(높이)
I 숫자       큐에 주어진 숫자를 삽입합니다.
D 1         큐에서 최댓값을 삭제합니다.
D -1	    큐에서 최솟값을 삭제합니다.

이중 우선순위 큐가 할 연산 operations가 매개변수로 주어질 때, 모든 연산을 처리한 후
큐가 비어있으면 [0,0] 비어있지 않으면 [최댓값, 최솟값]을 return 하도록 solution 함수를 구현해주세요.
 */
public class heap03 {

    public int[] solution(String[] operations) {
        int[] answer = {0, 0};

        PriorityQueue<Integer> queueMax = new PriorityQueue<>(Comparator.reverseOrder());
        PriorityQueue<Integer> queueMin = new PriorityQueue<>();

        for (String o : operations) {
            String[] splits = o.split(" ");

            if (splits[0].equals("I")) {
                queueMax.add(Integer.parseInt(splits[1]));
                queueMin.add(Integer.parseInt(splits[1]));
            }

            if (splits[0].equals("D")) {
                if (!queueMax.isEmpty()) {
                    if (splits[1].equals("1")) {
                        int max = queueMax.peek();
                        queueMax.poll();
                        queueMin.remove(max);
                    } else {
                        int min = queueMin.peek();
                        queueMin.poll();
                        queueMax.remove(min);
                    }
                }
            }
        }

        if (!queueMax.isEmpty()) {
            answer[0] = queueMax.peek();
            answer[1] = queueMin.peek();
        }

        return answer;
    }

    public static void main(String[] args) {
        heap03 T = new heap03();

        System.out.println(T.solution(new String[]{"I 16", "I -5643", "D -1", "D 1", "D 1", "I 123", "D -1"}));
        System.out.println(T.solution(new String[]{"I -45", "I 653", "D 1", "I -642", "I 45", "I 97", "D 1", "D -1", "I 333"}));

    }
}
