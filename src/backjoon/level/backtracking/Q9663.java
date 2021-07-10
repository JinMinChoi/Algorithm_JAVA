package level.backtracking;

import java.util.Scanner;

public class Q9663 {
    private static int n;
    private static int[] arr;
    private static int cnt;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        arr = new int[n]; //arr = 열의 정보

        nQueen(0); //depth = 행의 정보
        System.out.println(cnt);
    }

    private static void nQueen(int depth) {
        if (depth == n) { //행이 n에 다다랐을 때
            cnt++;
            return;
        }

        for (int i = 0; i < n; i++) {
            arr[depth] = i; // depth 행, i열에 퀸이 놓였다!
            if (isPossible(depth)) { // 놓을 수 있는 경우를 확인하자!
                nQueen(depth + 1); // 놓을 수 있다면 다음 행 확인하러!
            }
        }
    }

    private static boolean isPossible(int col) {
        for (int i = 0; i < col; i++) {
            if(arr[col] == arr[i]) return false; //해당 열의 행과 i열의 행이 같으면 x

            if(Math.abs(col - i) == Math.abs(arr[col] - arr[i])) return false; //대각선에 놓여있다면 x
        }
        return true;
    }
}
