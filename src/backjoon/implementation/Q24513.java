package backjoon.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q24513 {
    private static int n, m;
    private static int[][] map;
    private static int[][] visit;
    private static int[] dx = {-1, 0, 1, 0};
    private static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        visit = new int[n][m];

        Queue<Virus> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 1 || map[i][j] == 2) {
                    q.add(new Virus(i, j));
                    visit[i][j] = 1;
                }
            }
        }

        while (!q.isEmpty()) {
            Virus cur = q.poll();

            //printMap();
            //System.out.println();
            if (map[cur.x][cur.y] == 1) {
                for (int i = 0; i < 4; i++) {
                    int nx = cur.x + dx[i];
                    int ny = cur.y + dy[i];

                    if (!isOut(nx, ny)) continue;
                    if (map[nx][ny] == -1) continue;

                    if (map[nx][ny] == 0) {
                        map[nx][ny] = 1;
                        visit[nx][ny] = visit[cur.x][cur.y] + 1;
                        q.add(new Virus(nx, ny));
                    } else if (map[nx][ny] == 2 && visit[nx][ny] == visit[cur.x][cur.y] + 1) {
                        map[nx][ny] = 3;
                    }
                }
            }

            if (map[cur.x][cur.y] == 2) {
                for (int i = 0; i < 4; i++) {
                    int nx = cur.x + dx[i];
                    int ny = cur.y + dy[i];

                    if (!isOut(nx, ny)) continue;
                    if (map[nx][ny] == -1) continue;

                    if (map[nx][ny] == 0) {
                        map[nx][ny] = 2;
                        visit[nx][ny] = visit[cur.x][cur.y] + 1;
                        q.add(new Virus(nx, ny));
                    } else if (map[nx][ny] == 1 && visit[nx][ny] == visit[cur.x][cur.y] + 1) {
                        map[nx][ny] = 3;
                    }
                }
            }
        }

        int one = 0, two = 0, three = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 1) one++;
                if (map[i][j] == 2) two++;
                if (map[i][j] == 3) three++;
            }
        }
        System.out.println(one + " " + two + " " + three);
    }

    private static void printMap() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static boolean isOut(int x, int y) {
        return x >= 0 && x < n && y >= 0 && y < m;
    }

    private static class Virus {
        int x;
        int y;

        public Virus(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
