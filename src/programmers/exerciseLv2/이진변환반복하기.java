package programmers.exerciseLv2;

/*
이진 변환 반복하기 - 월간 코드 챌린지 시즌1 lv.2

 */
public class 이진변환반복하기 {

    public int[] solution(String s) {
        int[] answer = new int[2];

        while(s.length() > 1) {

            int cntOne = 0;
            for(int i=0; i<s.length(); i++) {

                if(s.charAt(i) == '0') answer[1]++;
                else cntOne++;
            }

            s = Integer.toBinaryString(cntOne);
            answer[0]++;
        }

        return answer;
    }

    public static void main(String[] args) {
        이진변환반복하기 T = new 이진변환반복하기();

        System.out.println(T.solution("110010101001"));
        System.out.println(T.solution("01110"));
        System.out.println(T.solution("1111111"));
    }
}
