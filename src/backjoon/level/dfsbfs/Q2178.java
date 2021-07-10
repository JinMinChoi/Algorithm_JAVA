package backjoon.level.dfsbfs;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q2178 {
    private static int n, m;
    private static int[][] map;
    private static boolean[][] visit;

    private static final int[] dx = {-1, 0, 1, 0};
    private static final int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        visit = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = line.charAt(j) - '0';
            }
        }

        Queue<Pos> q = new LinkedList<>();
        q.add(new Pos(0, 0));
        visit[0][0] = true;

        while (!q.isEmpty()) {
            int x = q.peek().x;
            int y = q.peek().y;

            q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (!inScope(nx, ny)) {
                    continue;
                }

                if (!visit[nx][ny] && map[nx][ny] != 0) {
                    map[nx][ny] = map[x][y] + 1;
                    visit[nx][ny] = true;
                    q.add(new Pos(nx, ny));
                }
            }
        }

        System.out.println(map[n - 1][m - 1]);
    }

    private static boolean inScope(int x, int y) {
        return x >= 0 && y >= 0 && x < n && y < m;
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
