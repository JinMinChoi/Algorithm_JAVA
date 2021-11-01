//https://www.acmicpc.net/problem/17144
package backjoon.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q17144 {
    private static int r, c, t, map[][];
    private static int[] dx = {-1, 0, 1, 0};
    private static int[] dy = {0, 1, 0, -1};
    private static Queue<Pos> q;
    private static int[] clean = new int[2];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        t = Integer.parseInt(st.nextToken());
        map = new int[r][c];
        int idx = 0;

        for (int i = 0; i < r; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < c; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());

                if (map[i][j] == -1) {
                    clean[idx++] = i;
                }
            }
        }

        for (int i = 0; i < t; i++) {
            checkDust();
            spread();
            operate();
        }

        System.out.println(cal());
    }

    private static void operate() {
        int top = clean[0];
        int down = clean[1];

        // 공기 청정기 위
        // ↓
        for (int i = top - 1; i > 0; i--) {
            map[i][0] = map[i - 1][0];
        }
        // →
        for (int i = 0; i < c - 1; i++) {
            map[0][i] = map[0][i + 1];
        }
        // ↑
        for (int i = 0; i < top; i++) {
            map[i][c - 1] = map[i + 1][c - 1];
        }
        // ←
        for (int i = c - 1; i > 1; i--) {
            map[top][i] = map[top][i - 1];
            if (i == 2) map[top][i - 1] = 0;
        }

        map[top][0] = -1;

        // 공기 청정기 아래
        // ↑
        for (int i = down + 1; i < r - 1; i++) {
            map[i][0] = map[i + 1][0];
        }
        // ←
        for (int i = 0; i < c - 1; i++) {
            map[r - 1][i] = map[r - 1][i + 1];
        }
        // ↓
        for (int i = r - 1; i > down; i--) {
            map[i][c - 1] = map[i - 1][c - 1];
        }
        // →
        for (int i = c - 1; i > 1; i--) {

            map[down][i] = map[down][i - 1];
            if (i == 2) map[down][i - 1] = 0;
        }
        map[down][0] = -1;
    }

    private static int cal() {
        int allDust = 0;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (map[i][j] >= 1) {
                    allDust += map[i][j];
                }
            }
        }

        return allDust;
    }

    private static void checkDust() {
        q = new LinkedList<>();

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (map[i][j] != 0 && map[i][j] != -1) {
                    q.add(new Pos(i, j, map[i][j]));
                }
            }
        }
    }

    private static void spread() {
        while (!q.isEmpty()) {
            Pos curDust = q.poll();

            if (curDust.dust < 5) continue;

            int spreadAmount = curDust.dust / 5;
            int cnt = 0;

            for (int dir = 0; dir < 4; dir++) {
                int nx = curDust.x + dx[dir];
                int ny = curDust.y + dy[dir];

                if (!isScope(nx, ny) || map[nx][ny] == -1) continue;

                map[nx][ny] += spreadAmount;
                ++cnt;
            }

            map[curDust.x][curDust.y] -= spreadAmount * cnt;
        }
    }

    private static boolean isScope(int x, int y) {
        return x >= 0 && x < r && y >= 0 && y < c;
    }

    private static class Pos {
        int x;
        int y;
        int dust;

        public Pos(int x, int y, int dust) {
            this.x = x;
            this.y = y;
            this.dust = dust;
        }

        public Pos(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
