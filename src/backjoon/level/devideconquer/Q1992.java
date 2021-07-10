package backjoon.level.devideconquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q1992 {
    private static int n;
    private static int[][] map;
    private static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(String.valueOf(str.charAt(j)));
            }
        }

        getQuadTree(0, 0, n);
        System.out.println(sb.toString());

    }

    private static void getQuadTree(int row, int col, int size) {

        if (check(row, col, size)) {
            sb.append(map[row][col]);
        } else {
            sb.append("(");

            int half = size / 2;

            /*getQuadTree(row, col, half);
            getQuadTree(row, col + half, half);
            getQuadTree(row + half, col, half);
            getQuadTree(row + half, col + half, half);*/

            for (int i = row; i <= row + half; i += half) {
                for (int j = col; j <= col + half; j += half) {
                    getQuadTree(i, j, half);
                }
            }

            sb.append(")");
        }
    }

    private static boolean check(int row, int col, int size) {
        int temp = map[row][col];

        for (int i = row; i < row + size; i++) {
            for (int j = col; j < col + size; j++) {
                if (temp != map[i][j]) {
                    return false;
                }
            }
        }

        return true;
    }
}
