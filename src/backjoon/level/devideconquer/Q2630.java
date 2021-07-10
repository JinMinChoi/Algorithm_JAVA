package backjoon.level.devideconquer;

import java.io.IOException;
import java.util.Scanner;

public class Q2630 {
    private static int n;
    private static int[][] map;
    private static int w, b;

    public static void main(String[] args) throws IOException {
        /*BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;*/

        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        map = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j] = sc.nextInt();
            }
        }
        getWB(0, n, 0, n);

        System.out.println(w + "\n" + b);

    }

    private static void getWB(int row, int endRow, int col, int endCol) {
        int sum = 0;

        for (int i = row; i < endRow; i++) {
            for (int j = col; j < endCol; j++) {
                sum += map[i][j];
            }
        }

        if (sum == 0) {
            w++;
            return;
        } else if (sum == (endRow - row) * (endCol - col)) {
            b++;
            return;
        }

        getWB(row, (row + endRow) / 2, (col + endCol) / 2, endCol); // 1사분면
        getWB(row, (row + endRow) / 2, col, (col + endCol) / 2); // 2사분면
        getWB((row + endRow) / 2, endRow, col, (col + endCol) / 2); // 3사분면
        getWB((row + endRow) / 2, endRow, (col + endCol) / 2, endCol); // 4사분면

    }
}
