package backjoon.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q3709 {
    private static int n, r;
    private static int[][] map;
    private static int startX, startY;
    private static int[] dx = {1, 0, -1, 0};
    private static int[] dy = {0, -1, 0, 1};
    private static int[] ans = new int[2];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        while ((tc--) > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            r = Integer.parseInt(st.nextToken());
            map = new int[n + 2][n + 2];

            for (int i = 0; i < r; i++) {
                st = new StringTokenizer(br.readLine());
                int mX = Integer.parseInt(st.nextToken());
                int mY = Integer.parseInt(st.nextToken());
                map[mX][mY] = 1;
            }

            st = new StringTokenizer(br.readLine());
            startX = Integer.parseInt(st.nextToken());
            startY = Integer.parseInt(st.nextToken());
            int dir = selectDir(startX, startY);

            dfs(startX, startY, dir, 0);

            System.out.println(ans[0] + " " + ans[1]);
        }
    }

    private static void dfs(int x, int y, int dir, int cnt) {
        if (cnt > n * n) return;

        int nx = x + dx[dir];
        int ny = y + dy[dir];

        if (isEnd(nx, ny)) {
            ans[0] = nx;
            ans[1] = ny;
            return;
        }

        if (map[nx][ny] == 1) {
            dfs(nx, ny, (dir + 1) % 4, cnt + 1);
        } else {
            dfs(nx, ny, dir, cnt);
        }

    }

    private static boolean isEnd(int x, int y) {
        return x < 1 || x > n || y < 1 || y > n;
    }

    private static int selectDir(int startX, int startY) {
        if (startX == n + 1) {
            return 2;
        } else if (startX == 0) {
            return 0;
        } else if (startY == n + 1) {
            return 1;
        } else if (startY == 0) {
            return 3;
        }
        return 0;
    }
}
