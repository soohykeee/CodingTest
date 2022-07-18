package ch01;

/*특정 문자 뒤집기
        영어 알파벳과 특수문자로 구성된 문자열이 주어지면 영어 알파벳만 뒤집고, 특수문자는 자기
        자리에 그대로 있는 문자열을 만들어 반환하는 프로그램을 작성하세요*/
public class string03 {

    public String solution(String s){

        String answer="";
        char [] str=s.toCharArray();
        int left=0;
        int right=s.length()-1;

        while (left < right) {
            char temp;
            if (Character.isAlphabetic(str[left]) && Character.isAlphabetic(str[right])) {
                temp = str[left];
                str[left] = str[right];
                str[right] = temp;

                left++;
                right--;
            } else if (!Character.isAlphabetic(str[left])) {
                left++;
            } else if (!Character.isAlphabetic(str[right])) {
                right--;
            }

        }
        answer= String.valueOf(str);

        return answer;

        }

    public static void main(String[] args) {
        string03 T = new string03();

        System.out.println(T.solution("a#b!GE*T@S"));
        System.out.println(T.solution("###ab*@@Sty"));

    }
}
