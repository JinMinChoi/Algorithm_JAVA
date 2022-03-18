package backjoon.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q2344 {
    private static int[][] box;
    private static int[] dx = {-1, 0, 1, 0};
    private static int[] dy = {0, -1, 0, 1};
    private static int n, m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        box = new int[n + 2][m + 2];

        //거울 채우기
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= m; j++) {
                box[i][j] = Integer.parseInt(st.nextToken());
                if (box[i][j] == 1) {
                    box[i][j] = -1;
                }
            }
        }

        //레이저 채우기
        for (int i = 1; i <= n; i++) { //좌측, 우측
            box[i][0] = i;
            box[n - i + 1][m + 1] = n + m + i;
        }

        for (int i = 1; i <= m; i++) { //아래, 위
            box[n + 1][i] = n + i;
            box[0][i] = n * 2 + m * 2 + 1 - i;
        }

        /*for (int i = 0; i < box.length; i++) {
            for (int j = 0; j < box[0].length; j++) {
                System.out.print(box[i][j] + " ");
            }
            System.out.println();
        }*/

        // 레이저 쏘기
        // 왼쪽 레이저부터
        for (int i = 1; i <= n; i++) {
            System.out.print(dfs(i, 0, 3) + " ");
        }

        // 아래쪽 레이저부터
        for (int i = 1; i <= m; i++) {
            System.out.print(dfs(n + 1, i, 0) + " ");
        }

        //오른쪽 레이저부터
        for (int i = 1; i <= n; i++) {
            System.out.print(dfs(n - i + 1, m + 1, 1) + " ");
        }

        //위쪽 레이저부터
        for (int i = m; i >= 1; i--) {
            System.out.print(dfs(0, i, 2) + " ");
        }

    }

    private static int dfs(int x, int y, int dir) {
        int nx = x + dx[dir];
        int ny = y + dy[dir];

        if (box[nx][ny] >= 1) {
            return box[nx][ny];
        }

        if (box[nx][ny] == -1) {
            return dfs(nx, ny, changeDir(dir));
        }
        return dfs(nx, ny, dir);
    }

    private static int changeDir(int dir) {
        if (dir == 0) return 3;
        else if (dir == 1) return 2;
        else if (dir == 2) return 1;
        return 0;
    }
}
