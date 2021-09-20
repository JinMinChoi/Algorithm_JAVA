//https://www.acmicpc.net/problem/15685
package backjoon.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q15685 {
    private static int n, m, map[][], visit[][];
    private static int ans;
    private static int[] dx = {-1, 0, 1, 0};
    private static int[] dy = {0, 1, 0, -1};
    private static boolean isEmptyCheeze;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        visit = new int[n][m];

        for (int i = 0; i < n; i++) {
            String[] line = br.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(line[j]);
            }
        }

        while (!isEmptyCheeze) {
            clearVisit();
            bfs();
            isEmptyCheeze = true;
            ans++;

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (map[i][j] != 0) {
                        isEmptyCheeze = false;
                        break;
                    }
                }
            }
        }

        System.out.println(ans);
    }

    private static void clearVisit() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                visit[i][j] = 0;
            }
        }
    }

    private static void bfs() {
        Queue<Pos> q = new LinkedList<>();
        q.add(new Pos(0, 0));

        while (!q.isEmpty()) {
            Pos pos = q.poll();

            for (int i = 0; i < 4; i++) {
                int nextX = pos.x + dx[i];
                int nextY = pos.y + dy[i];

                if(!isScope(nextX, nextY)) continue;

                if (map[nextX][nextY] == 0 && visit[nextX][nextY] == 0) {
                    visit[nextX][nextY] = 1;
                    q.add(new Pos(nextX, nextY));
                }

                if (map[nextX][nextY] == 1) {
                    visit[nextX][nextY]++;
                    if (visit[nextX][nextY] >= 2) {
                        map[nextX][nextY] = 0;
                    }
                }
            }
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
