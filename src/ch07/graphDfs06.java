package ch07;

import java.util.ArrayList;

/*
바둑대회
엘리트 기원은 팀전으로 치러지는 바둑대회를 참가할 예정이다. 이 대회는 총 N(짝수)명이 출
전하며 흰 돌로 출전하는 선수 N/2명, 검은 돌로 출전하는 선수 N/2명 해서 총 N 명이다.
한 선수는 흰돌의 선수로 나가든지, 아니면 검은 돌의 선수로 나가든지 해야만 한다.
한 선수가 둘 다 출전할 수 없다.
각 선수들의 흰돌로 했을 때 능력과 검은돌로 했을 때 능력이 주어지면 최상의 선택으로 흰돌 N/2명,
검은 돌 N/2명, 총 N명의 선수를 뽑아야 한다.
여기서 최상의 선택이란 흰돌팀과검은돌팀의 능력차가 최소가 되게 하는 것이다.
흰돌팀의 능력치는 흰돌팀 N/2명 선수들의 흰돌로 했을 때의 능력치의 총합니다.
검은돌팀의 능력치도 흰돌팀과 같은 방법입니다.
 */
public class graphDfs06 {
    int n, answer = Integer.MAX_VALUE;
    int[] ch;

    public void DFS(int L, int S, int[][] cans) {
        ArrayList<Integer> white = new ArrayList<>();
        ArrayList<Integer> black = new ArrayList<>();

        // 총 검정 3, 흰 3 으로 나눠져 담겨질 경우 check 배열을 통해 검, 흰을 구별해서
        // ArrayList에 저장하고 그 능력치의 총 합을 answer와 비교하며 최솟값을 찾는다.
        if (L == (n / 2)) {
            for (int i = 0; i < n; i++) {
                if (ch[i] == 1) {
                    white.add(i);
                } else {
                    black.add(i);
                }
            }

            int whiteSum = 0;
            int blackSum = 0;
            for (int i = 0; i < L; i++) {
                whiteSum += cans[white.get(i)][0];
                blackSum += cans[black.get(i)][1];
            }
            answer = Math.min(answer, Math.abs(blackSum - whiteSum));
        } else {
            // L == (n/2) 될때까지, 즉 3개가 담길때까지 반복문을 돌리며 모든 경우의 수를 체크
            for (int i = S; i < n; i++) {
                ch[i] = 1;
                DFS(L + 1, i + 1, cans);
                ch[i] = 0;
            }
        }
    }

    public int solution(int[][] cans) {
        n = cans.length;
        ch = new int[n];
        DFS(0, 0, cans);

        return answer;
    }

    public static void main(String[] args) {
        graphDfs06 T = new graphDfs06();
        System.out.println(T.solution(new int[][]{{87, 84}, {66, 78}, {94, 94}, {93, 87}, {72, 92}, {78, 63}}));
    }
}
