package ch06;

/*
이진트리 순회(깊이우선탐색 : DFS)
        아래 그림과 같은 이진트리를 전위순회와 후위순회를 연습해보세요.
        전위순회 출력 : 1 2 4 5 3 6 7
        중위순회 출력 : 4 2 5 1 6 3 7
        후위순회 출력 : 4 5 2 6 7 3 1
        아래 코드는 위에 있는 이진트리를 전위순회한 것입니다. 여러분이 아래 코드를 분석해보고,
        중위순회, 후위순회를 출력해보세요. 그리고 스택에 스택프레임을 만들면서 분석도 해보세요.

전위순회 : 현재 노드->왼쪽->오른쪽
중위순회 : 왼쪽->현재 노드->오른
후위순회 : 왼쪽->오른쪽->현재 노드

        참고 : https://foxtrotin.tistory.com/187
*/

public class dfs_ex {
    public void DFS(int v) {
        if (v > 7) {
            return;
        } else {
            System.out.print(v + " ");
            DFS(v * 2);
            DFS(v * 2 + 1);
        }
    }

    public static void main(String[] args) {
        dfs_ex T = new dfs_ex();

        T.DFS(1);

    }
}
