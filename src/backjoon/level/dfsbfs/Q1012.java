package backjoon.level.dfsbfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q1012 {
    private static int m, n, k;
    private static int[][] map;
    private static boolean[][] visit;
    private static final int[] dx = {-1, 0, 1, 0};
    private static final int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int testCase = Integer.parseInt(br.readLine());

        while ((testCase--) > 0) {
            st = new StringTokenizer(br.readLine());

            m = Integer.parseInt(st.nextToken());
            n = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());

            map = new int[n][m];
            visit = new boolean[n][m];

            while ((k--) > 0) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                map[b][a] = 1;
            }

            int cnt = 0;

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (!visit[i][j] && map[i][j] == 1) {
                        bfs(i, j);
                        cnt++;
                    }
                }
            }

            System.out.println(cnt);
        }
    }

    private static void bfs(int x, int y) {
        Queue<Pos> q = new LinkedList<>();
        q.add(new Pos(x, y));
        visit[x][y] = true;

        while (!q.isEmpty()) {
            int curX = q.peek().x;
            int curY = q.peek().y;

            q.poll();

            for (int dir = 0; dir < 4; dir++) {
                int nextX = curX + dx[dir];
                int nextY = curY + dy[dir];

                if (!isScope(nextX, nextY)) continue;

                if (!visit[nextX][nextY] && map[nextX][nextY] == 1) {
                    visit[nextX][nextY] = true;
                    q.add(new Pos(nextX, nextY));
                }
            }
        }

    }

    private static boolean isScope(int x, int y) {
        return x >= 0 && x < n && y >= 0 && y < m;
    }

    private static class Pos {
        int x;
        int y;

        public Pos(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
