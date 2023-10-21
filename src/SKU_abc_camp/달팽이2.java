//package SKU_abc_camp;
//
//public class 달팽이2 {
//
//    /*
//    풀이 방법 2
//        n=7  일 때,
//        7,      14
//        6, 6,   13,12
//        5, 5,   11,10
//        4, 4,   9,8
//        3, 3,   7,6
//        2, 2,   5,4
//        1, 1    3,2
//
//        7 - arr[0][0] -> [1][0] -> ... [6][0] 까지 1씩 감소
//        6 - arr[6][1] -> [6][2] -> ... [6][6] 까지 1씩 감소
//        6 - arr[5][6] -> [4][6] -> ... [0][6] 까지 1씩 감소
//        5 - arr[0][5] -> [0][4] -> ... [0][1] 까지 1씩 감소
//        5 - arr[1][1] -> [2][1] -> ... [5][1] 까지 1씩 감소
//        ....
//
//         */
//
//    public int[] solution(int n, int find) {
//        int[] answer = new int [2];
//
//        int[][] snail = new int[n][n];
//
//        int[] count = new int[n * 2 - 1];
//        for (int i = 0; i < n * 2 - 1; i++) {
//            count[i] = (n * 2 - i) / 2;
//            System.out.print(count[i] + " ");
//        }
//
//        int x = 0, y = 0, max = n * n;
//        for (int i = 0; i < n * n; i++) {
//            for (int j = 0; j < count.length; j++) {
//                if (j % 4 == 0) {
//                    snail[x++][y] = max--;
//                } else if (i % 4 == 1) {
//                    snail[x][y++] = max--;
//                }
//            }
//        }
//
//        return answer;
//    }
//
//    public static void main(String[] args) {
//        달팽이2 T = new 달팽이2();
//
//        System.out.println(T.solution(7, 35));
//
//    }
//}
