package programmers.exerciseLv2;

import java.util.ArrayList;
import java.util.HashMap;

/*
오픈채팅방 - 2019 KAKAO BLIND RECRUITMENT

 */
public class 오픈채팅방 {

    public String[] solution(String[] record) {
        String[] answer = {};

        // 사용자 ID, 닉네임
        HashMap<String, String> user = new HashMap<>();

        for (int i = 0; i < record.length; i++) {
            String[] temp;
            temp = record[i].split(" ");

            if (temp[0].equals("Enter") || temp[0].equals("Change")) {
                user.put(temp[1], temp[2]);
            }
        }

        ArrayList<String> arrayList = new ArrayList<>();

        for (int i = 0; i < record.length; i++) {
            String[] temp;
            temp = record[i].split(" ");

            if (temp[0].equals("Enter")) {
                String userNickname = user.get(temp[1]);
                arrayList.add(userNickname + "님이 들어왔습니다.");
            }

            if (temp[0].equals("Leave")) {
                String userNickname = user.get(temp[1]);
                arrayList.add(userNickname + "님이 나갔습니다.");
            }
        }

        answer = new String[arrayList.size()];
        for (int i = 0; i < arrayList.size(); i++) {
            answer[i] = arrayList.get(i);
        }

        return answer;
    }

    public static void main(String[] args) {
        오픈채팅방 T = new 오픈채팅방();

        System.out.println(T.solution(new String[]{"Enter uid1234 Muzi", "Enter uid4567 Prodo", "Leave uid1234", "Enter uid1234 Prodo", "Change uid4567 Ryan"}));
    }


}
