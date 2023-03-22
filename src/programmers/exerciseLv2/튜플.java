package programmers.exerciseLv2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

/*
튜플 - 2019 카카오 개발자 겨울 인턴십

 */
public class 튜플 {

    public ArrayList solution(String s) {
        ArrayList<Integer> list = new ArrayList<>();

        s = s.substring(2, s.length() - 2);
        s = s.replace("},{", "-");
        String[] str = s.split("-");
        Arrays.sort(str, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return Integer.compare(o1.length(), o2.length());
            }
        });

        for (int i = 0; i < str.length; i++) {
            String[] temp = str[i].split(",");

            for (int j = 0; j < temp.length; j++) {
                if (!list.contains(Integer.parseInt(temp[j]))) {
                    list.add(Integer.parseInt(temp[j]));
                }
            }
        }

        return list;
    }

    public static void main(String[] args) {
        튜플 T = new 튜플();

        System.out.println(T.solution("{{2},{2,1},{2,1,3},{2,1,3,4}}"));
        System.out.println(T.solution("{{1,2,3},{2,1},{1,2,4,3},{2}}"));
        System.out.println(T.solution("{{20,111},{111}}"));
        System.out.println(T.solution("{{123}}"));
        System.out.println(T.solution("{{4,2,3},{3},{2,3,4,1},{2,3}}"));
    }
}
