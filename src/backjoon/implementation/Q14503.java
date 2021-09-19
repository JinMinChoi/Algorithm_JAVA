//https://www.acmicpc.net/problem/14503
package backjoon.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q14503 {
    private static int N, M;
    private static int[][] map;
    private static int[] dx = {-1, 0, 1, 0};
    private static int[] dy = {0, 1, 0, -1};
    private static int r, c;
    private static int cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];

        st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        int firstDir = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        clean(r, c, firstDir);

        System.out.println(cnt);
    }

    private static void clean(int x, int y, int dir) {
        // 청소
        if (map[x][y] == 0) {
            map[x][y] = 2;
            cnt++;
        }

        // 왼쪽방향 탐색
        boolean flag = false;
        int initDir = dir;
        for (int i = 0; i < 4; i++) {
            int nextDir = (dir + 3) % 4;
            int nextX = x + dx[nextDir];
            int nextY = y + dy[nextDir];

            if (isScope(nextX, nextY)) {
                if (map[nextX][nextY] == 0) {
                    clean(nextX, nextY, nextDir);
                    flag = true;
                    break;
                }
            }
            dir = (dir + 3) % 4;
        }

        // 후진
        if (!flag) {
            int backDir = (initDir + 2) % 4;
            int backX = x + dx[backDir];
            int backY = y + dy[backDir];

            if (isScope(backX, backY)) {
                if (map[backX][backY] != 1) {
                    clean(backX, backY, initDir);
                }
            }
        }
    }

    private static boolean isScope(int x, int y) {
        return x >= 0 && y >= 0 && x < N && y < M;
    }
}
