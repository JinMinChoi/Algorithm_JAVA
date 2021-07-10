package backjoon.level.dfsbfs;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q2206 {
    private static int n, m, ans;
    private static int[][] map;
    /**
     * 3차원이라고 생각하지말고 2차원의 'visit'을 2개를 가지고 있다고 생각하자.
     * 1번째 2차원 visit[x][y][0] : 벽을 부순적 없는 세계의 2차원 visit
     * 2번째 2차원 visit[x][y][1] : 벽을 이미 한 번 허문 세계의 2차원 visit
     */
    private static boolean[][][] visit;

    private static final int[] dx = {-1, 0, 1, 0};
    private static final int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        ans = n * m;
        map = new int[n][m];
        visit = new boolean[n][m][2];

        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = line.charAt(j) - '0';
            }
        }

        bfs(0, 0, 0, 0);

        if (ans == n * m) {
            System.out.println(-1);
        } else {
            System.out.println(ans + 1);
        }
    }

    private static boolean inScope(int x, int y) {
        return x >= 0 && y >= 0 && x < n && y < m;
    }

    private static void bfs(int x, int y, int cntP, int cntC) {
        Queue<Pos> q = new LinkedList<>();
        q.add(new Pos(x, y, cntP, cntC));
        visit[x][y][cntC] = true;

        while (!q.isEmpty()) {
            Pos pos = q.poll();

            int curX = pos.x;
            int curY = pos.y;
            int cnt = pos.cntPass;
            int crushed = pos.cntCrush;

            if (curX == n - 1 && curY == m - 1) {
                ans = Math.min(ans, cnt);
                break;
            }

            for (int i = 0; i < 4; i++) {
                int nextX = curX + dx[i];
                int nextY = curY + dy[i];

                if (!inScope(nextX, nextY)) continue;

                if (crushed == 1) { // 벽을 이미 하나 허물었을 때, 방문하면서 횟수 증가
                    if (!visit[nextX][nextY][crushed] && map[nextX][nextY] == 0) {
                        visit[nextX][nextY][crushed] = true;
                        q.add(new Pos(nextX, nextY, cnt + 1, crushed));
                    }
                } else { // 벽을 허문적 없을 때
                    if (map[nextX][nextY] == 1) { //벽일 때,
                        if (!visit[nextX][nextY][crushed + 1]) { // 방문한적 없는 벽이면 부수고 나간다.
                            visit[nextX][nextY][crushed + 1] = true;
                            q.add(new Pos(nextX, nextY, cnt + 1, crushed + 1));
                        }
                    } else { // 벽이 아닐 때,
                        if (!visit[nextX][nextY][crushed]) {
                            visit[nextX][nextY][crushed] = true;
                            q.add(new Pos(nextX, nextY, cnt + 1, crushed));
                        }
                    }
                }
            }
        }
    }

    private static class Pos {
        int x;
        int y;
        int cntPass;
        int cntCrush;

        public Pos(int x, int y, int cntPass, int cntCrush) {
            this.x = x;
            this.y = y;
            this.cntPass = cntPass;
            this.cntCrush = cntCrush;
        }
    }
}
