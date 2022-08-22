package SKU_CodingTest.ch03;

/*
교육과정 설계
        현수는 1년 과정의 수업계획을 짜야 합니다.
        수업중에는 필수과목이 있습니다. 이 필수과목은 반드시 이수해야 하며, 그 순서도 정해져 있
        습니다.
        만약 총 과목이 A, B, C, D, E, F, G가 있고, 여기서 필수과목이 CBA로 주어지면 필수과목은
        C, B, A과목이며 이 순서대로 꼭 수업계획을 짜야 합니다.
        여기서 순서란 B과목은 C과목을 이수한 후에 들어야 하고, A과목은 C와 B를 이수한 후에 들
        어야 한다는 것입니다.
        현수가 C, B, D, A, G, E로 수업계획을 짜면 제대로 된 설계이지만
        C, G, E, A, D, B 순서로 짰다면 잘 못 설계된 수업계획이 됩니다.
        수업계획은 그 순서대로 앞에 수업이 이수되면 다음 수업을 시작하다는 것으로 해석합니다.
        수업계획서상의 각 과목은 무조건 이수된다고 가정합니다.
        필수과목순서가 주어지면 현수가 짠 N개의 수업설계가 잘된 것이면 “YES", 잘못된 것이면
        ”NO“를 출력하는 프로그램을 작성하세요.
*/

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class queue02 {

    public ArrayList<String> solution(String need, ArrayList<String> plans) {

        ArrayList<String> answer = new ArrayList<>();
        Queue<Character> queue = new LinkedList<>();

        for (int i = 0; i < plans.size(); i++) {
            // queue에 need에 있는 값들 char로 변환하여 넣어주기
            for (char ch : need.toCharArray()) {
                queue.offer(ch);
            }

            // plans에서 앞에서부터 문자를 가져와서 queue에 저장된 값에 포함됐는지 확인
            // 포함되어있으면 queue에 저장된 맨 앞과 비교해서 선행대로 신청했는지 확인(확인하면서 queue의 맨앞은 삭제)
            // 아니라면 NO
            // queue가 전부 지워져서 empty 가 되면 선행대로 신청이 잘 되었다는 뜻
            // 따라서 해당경우에는 YES
            for (char ch : plans.get(i).toCharArray()) {
                if (queue.contains(ch)) {
                    if (queue.poll() != ch) {
                        answer.add(i, "NO");
                    }
                }
            }
            if (queue.isEmpty()) {
                answer.add(i, "YES");
            }
            queue.clear();
        }

        return answer;
    }

    public static void main(String[] args) {
        queue02 T = new queue02();

        ArrayList<String> list = new ArrayList<>();
        list.add("CBDAGE");
        list.add("FGCDAB");
        list.add("CTSBDEA");
        System.out.println(T.solution("CBA", list));
    }
}
