package inflearnLecture.question.recursion2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q89 {
    private static int n, m;
    private static int[][] map;
    private static boolean[][] visit;
    private static int[] dx = {-1, 0, 1, 0};
    private static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        visit = new boolean[n][m];
        Queue<Pos> q = new LinkedList<>();

        int oneCnt = 0;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());

                if (map[i][j] == 1) {
                    oneCnt++;
                    q.add(new Pos(i, j));
                }
            }
        }

        if (oneCnt == n * m) {
            System.out.println(0);
            return;
        }

        while (!q.isEmpty()) {
            Pos cur = q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if (!isScope(nx, ny)) continue;

                if (!visit[nx][ny] && map[nx][ny] != -1) {
                    visit[nx][ny] = true;
                    map[nx][ny] = map[cur.x][cur.y] + 1;
                    q.add(new Pos(nx, ny));
                }
            }
        }

        int zeroCnt = 0;
        int max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 0) {
                    zeroCnt++;
                }

                max = Math.max(max, map[i][j]);
            }
        }

        if (zeroCnt > 0) {
            System.out.println("-1");
        } else {
            System.out.println(max - 1);
        }
    }

    private static boolean isScope(int x, int y) {
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
