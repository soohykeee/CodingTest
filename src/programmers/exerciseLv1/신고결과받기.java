package programmers.exerciseLv1;

import java.util.HashMap;

/*
신고 결과 받기 - 2022 KAKAO BLIND RECRUCITMENT

 */
public class 신고결과받기 {

    public int[] solution(String[] id_list, String[] report, int k) {
        int totalUser = id_list.length;

        int[] answer = new int[totalUser];              // 정답
        int[][] board = new int[totalUser][totalUser];  // 신고 board
        int[] result = new int[totalUser];              // 제재된 유저

        HashMap<String, Integer> map = new HashMap<>();
        int temp=0;
        for (String str : id_list) {
            map.put(str, temp++);
        }

        for (int i = 0; i < report.length; i++) {
            String[] user = report[i].split(" ");
            int user0 = map.get(user[0]);
            int user1 = map.get(user[1]);

            if (board[user0][user1] == 0) {
                board[user0][user1] = 1;
            } else {
                continue;
            }
        }

        for (int i = 0; i < board.length; i++) {
            int total = 0;
            for (int j = 0; j < board.length; j++) {
                total += board[j][i];
            }
            if (total >= k) {
                result[i] = 1;
            }
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (board[i][j] == 1 && result[j] == 1) {
                    answer[i]++;
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        신고결과받기 T = new 신고결과받기();

        System.out.println(T.solution(new String[]{"muzi", "frodo", "apeach", "neo"}, new String[]{"muzi frodo", "apeach frodo", "frodo neo", "muzi neo", "apeach muzi"}, 2));
        System.out.println(T.solution(new String[]{"con", "ryan"}, new String[]{"ryan con", "ryan con", "ryan con", "ryan con"}, 3));

    }
}
