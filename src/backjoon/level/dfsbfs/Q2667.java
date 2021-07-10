package backjoon.level.dfsbfs;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q2667 {
    private static int n, cnt;
    private static int[][] map;
    private static boolean[][] visit;
    private static final int[] dx = {-1, 0, 1, 0};
    private static final int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        visit = new boolean[n][n];
        List<Integer> ans = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            char[] line = br.readLine().toCharArray();
            for (int j = 0; j < n; j++) {
                map[i][j] = line[j] - '0';
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visit[i][j] && map[i][j] == 1) {
                    cnt = 1;
                    bfs(i, j);
                    ans.add(cnt);
                }
            }
        }

        int size = ans.size();
        Collections.sort(ans);
        System.out.println(size);
        for (int value : ans) {
            System.out.println(value);
        }
    }

    private static void bfs(int x, int y) {
        Queue<Pos> q = new LinkedList<>();
        visit[x][y] = true;
        q.add(new Pos(x, y));

        while (!q.isEmpty()) {
            int curX = q.peek().x;
            int curY = q.peek().y;

            q.poll();

            for (int i = 0; i < 4; i++) {
                int nextX = curX + dx[i];
                int nextY = curY + dy[i];

                if (!isScope(nextX, nextY)) continue;

                if (!visit[nextX][nextY] && map[nextX][nextY] != 0) {
                    q.add(new Pos(nextX, nextY));
                    visit[nextX][nextY] = true;
                    cnt++;
                }
            }
        }
    }

    /*private static void dfs(int x, int y) {
        visit[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (!isScope(nx, ny)) continue;

            if (!visit[nx][ny] && map[nx][ny] != 0) {
                cnt++;
                visit[nx][ny] = true;
                dfs(nx, ny);
            }
        }
    }*/

    private static boolean isScope(int x, int y) {
        return (x >= 0) && (x < n) && (y >= 0) && (y < n);
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
