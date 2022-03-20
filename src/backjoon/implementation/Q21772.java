package backjoon.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q21772 {
    private static char[][] map;
    private static int n, m, t;
    private static int[] dx = {0, 1, 0, -1};
    private static int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        t = Integer.parseInt(st.nextToken());

        map = new char[n][m];

        int s_x = 0;
        int s_y = 0;

        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = s.charAt(j);
                if (map[i][j] == 'G') {
                    s_x = i;
                    s_y = j;
                }
            }
        }

        System.out.println(dfs(s_x, s_y, t));
    }

    private static int dfs(int x, int y, int time) {
        if (time == 0) {
            return 0;
        }

        int ret = 0;
        char pre;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            int eat_cnt;

            if (!isOut(nx, ny)) continue;
            if (map[nx][ny] == '#') continue;

            eat_cnt = map[nx][ny] == 'S' ? 1 : 0;
            System.out.println(nx + " " + ny + " " + eat_cnt);

            pre = map[nx][ny];
            map[nx][ny] = '.'; //고구마를 먹으면 고구마를 없앤다.
            ret = Math.max(ret, dfs(nx, ny, time - 1) + eat_cnt);
            map[nx][ny] = pre;
        }
        return ret;
    }

    private static boolean isOut(int x, int y) {
        return x >= 0 && x < n && y >= 0 && y < m;
    }
}
