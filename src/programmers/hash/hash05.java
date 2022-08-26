package programmers.hash;

import java.util.*;

/*
베스트앨범

스트리밍 사이트에서 장르 별로 가장 많이 재생된 노래를 두 개씩 모아 베스트 앨범을 출시하려 합니다.
노래는 고유 번호로 구분하며, 노래를 수록하는 기준은 다음과 같습니다.

속한 노래가 많이 재생된 장르를 먼저 수록합니다.
장르 내에서 많이 재생된 노래를 먼저 수록합니다.
장르 내에서 재생 횟수가 같은 노래 중에서는 고유 번호가 낮은 노래를 먼저 수록합니다.
노래의 장르를 나타내는 문자열 배열 genres와 노래별 재생 횟수를 나타내는 정수 배열 plays가 주어질 때,
베스트 앨범에 들어갈 노래의 고유 번호를 순서대로 return 하도록 solution 함수를 완성하세요.
 */
public class hash05 {

    public int[] solution(String[] genres, int[] plays) {
        int[] answer;
        ArrayList<Integer> temp = new ArrayList<>();

        HashMap<String, Integer> type = new HashMap<>();
        HashMap<String, HashMap<Integer, Integer>> music = new HashMap<>();
        for (int i = 0; i < genres.length; i++) {
            if(!type.containsKey(genres[i])) {
                HashMap<Integer, Integer> map = new HashMap<>();
                map.put(i, plays[i]);
                music.put(genres[i], map);
                type.put(genres[i], plays[i]);
            } else {
                music.get(genres[i]).put(i, plays[i]);
                type.put(genres[i], type.get(genres[i]) + plays[i]);
            }
        }

        // 정렬
        List<String> keySet = new ArrayList(type.keySet());
        Collections.sort(keySet, (s1, s2) -> type.get(s2) - (type.get(s1)));

        for(String key : keySet) {
            HashMap<Integer, Integer> map = music.get(key);
            List<Integer> genre_key = new ArrayList(map.keySet());

            Collections.sort(genre_key, (s1, s2) -> map.get(s2) - (map.get(s1)));

            temp.add(genre_key.get(0));
            if(genre_key.size() > 1)
                temp.add(genre_key.get(1));
        }

        answer = new int[temp.size()];
        for (int i = 0; i < temp.size(); i++) {
            answer[i] = temp.get(i);
        }

        return answer;
    }

    public static void main(String[] args) {
        hash05 T = new hash05();

        String[] genres = {"classic", "pop", "classic", "classic", "pop"};
        int[] plays = {500, 600, 150, 800, 2500};
        int[] answer = T.solution(genres, plays);

        for(int a : answer){
            System.out.println(a);
        }

    }
}
