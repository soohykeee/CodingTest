package SKU_CodingTest.ch04;

/*
사과
        현수는 사과나무 밑에 있습니다. 현수는 한 번의 점프로 사과나무에서 여러개의 사과를 딸수
        있습니다. 현수는 매초 점프를 합니다. 그리고 우리는 현수가 매초 점프 할 때의 얻을 수 있는
        사과의 개수를 미리 알고 있습니다. 그런데 현수는 어떤 초에는 에너지가 없어 점프를 할 수
        없습니다. 하지만 우리에게는 현수가 에너지가 없어도 M초 동안은 무조건 점프를 해서 사과를
        딸 수 있게 하는 부스트 기술이 있습니다.
        현수가 1초부터 N초까지 매초 차례대로 딸 수 있는 사과의 개수 정보가 주어지고, 1초부터 N
        초까지 매초 에너지의 상태가 주어지면 부스트 기술까지 사용해서 딸 수 있는 사과의 최대 총
        개수를 출력하는 프로그램을 작성하세요.

        어렵네요이잉...
*/

public class timeComplexity08 {

    public int solution(int[] apples, int[] power, int m) {

        int answer=0;
        int sum=0;

        // 초기값 설정
        for(int i=0; i<apples.length; i++){
            if(power[i]==1) sum+=apples[i];
        }
        for(int i=0; i<m; i++){
            if(power[i]==0) sum+=apples[i];
        }

        answer=sum;
        int left=0;
        //슬라이딩 활용하여, right=0이면 더해주고, left=0이면 빼주고
        for(int right=m; right<apples.length; right++){
            if(power[right]==0) sum+=apples[right];
            if(power[left]==0) sum-=apples[left];
            left++;
            answer=Math.max(answer, sum);
        }

        return answer;

    }

    public static void main(String[] args) {
        timeComplexity08 T = new timeComplexity08();

        int apples1[] = {3, 2, 1, 2, 1, 3};
        int power1[] = {1, 0, 0, 1, 0, 0};
        System.out.println(T.solution(apples1, power1, 3));

        int apples2[] = {3, 2, 3, 2, 1, 3};
        int power2[] = {1, 0, 0, 1, 0, 0};
        System.out.println(T.solution(apples2, power2, 3));

    }
}
