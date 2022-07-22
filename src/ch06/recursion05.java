package ch06;

/*
가장 가까운 큰수
        자연수 N이 주어지면, N과 구성이 같으면서 N보다 큰 수 중 가장 작은 수를 출력하는 프로그
        램을 작성하세요.
        구성이 같다는 말은 각 자릿수가 같은 숫자들로 이루어졌다는 의미입니다. 예를 들어 123과
        231은 서로 구성이 같습니다. 하지만 123과 215는 구성이 다릅니다.
*/

import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

public class recursion05 {

    int answer = 0, target, m;
    ArrayList<Integer> nums = new ArrayList<>();
    Stack<Integer> stack = new Stack<>();
    int[] ch;
    boolean flag = false;

    public void DFS(int L) {
        if(flag) return;
        if (L == m) {
            answer = 0;
            for (int x : stack) answer = answer * 10 + x;
            if (answer > target) flag = true;
        } else {
            for (int i = 0; i < m; i++) {
                if (ch[i] == 0) {
                    ch[i] = 1;
                    stack.push(nums.get(i));
                    DFS(L + 1);
                    ch[i] = 0;
                    stack.pop();
                }
            }
        }
    }

    public int solution(int n) {

        target = n;
        int temp = n;
        while (temp > 0) {
            int t = temp % 10;
            nums.add(t);
            temp = temp / 10;
        }
        Collections.sort(nums);

        m = nums.size();
        ch = new int[m];
        DFS(0);

        if (!flag) return -1;
        return answer;
    }

    public static void main(String[] args) {
        recursion05 T = new recursion05();

        System.out.println(T.solution(123));

    }

}
