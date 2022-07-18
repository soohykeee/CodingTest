package ch02;

/*
키보드
        당신은 키보드의 자판 중에서 스페이스바 외에 n개의 자판만 사용할 수 있습니다.
        만약 n=5이면, 당신은 “time to time"이라는 문장을 완성할 수 있습니다.
        만약 “Time to Time"라는 문장을 완성하려면 대문자 ‘T'를 써야 하는데 이 때는 shift키와 소
        문자 't'키를 누르면 됩니다. 그래서 “Time to Time"문장을 완성하기 위해서는 n=6이어야 가능
        합니다.
        하나의 문장을 n개의 키로 완성할 수 있으면 그 문장에 쓰인 문자개수만큼 점수를 얻을 수 있
        습니다. “Time to Time" 문장을 완성했을 경우 12점을 얻을 수 있습니다.
        매개변수에 하나의 문장을 담은 s문자열 변수와 사용 가능한 키의 개수인 n이 주어지면 여러
        분이 얻을 수 있는 점수를 리턴하는 함수를 작성하세요.
        만약 문장을 완성할 수 없다면 -1을 리턴합니다.
*/

public class array07 {

    public int solution(String s, int n) {

        int[] arr = new int[27];

        for (int x : s.toCharArray()) {
            if (x >= 97 && x <= 122) {
                arr[x - 97] = 1;
            } else if (x >= 65 && x <= 90) {
                arr[x - 65] = 1;
                arr[26] = 1;
            }
        }

        int count=0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 1) {
                count++;
            }
        }

        if (count <= n) {
            return s.length();
        } else {
            return -1;
        }
    }

    public static void main(String[] args) {
        array07 T = new array07();

        System.out.println(T.solution("time to time", 5));
        System.out.println(T.solution("time to study", 7));
        System.out.println(T.solution("Big Life is Good", 10));
        System.out.println(T.solution("Life is Good", 7));

    }
}
