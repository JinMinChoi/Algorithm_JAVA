//https://www.acmicpc.net/problem/2636
package backjoon.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q2636 {
    private static int n, m;
    private static int[][] map;
    private static boolean[][] visit;
    private static int cheeseCnt, cnt, lastCheese;
    private static int[] dx = {-1, 0, 1, 0};
    private static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];

        for (int i = 0; i < n; i++) {
            String[] line = br.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(line[j]);
                if (map[i][j] == 1) {
                    cheeseCnt++;
                }
            }
        }

        while (cheeseCnt != 0) {
            cnt++;
            lastCheese = cheeseCnt;
            bfs();
        }

        System.out.println(cnt + "\n" + lastCheese);

    }

    private static void bfs() {
        Queue<Pos> q = new LinkedList<>();
        visit = new boolean[n][m];

        q.add(new Pos(0, 0));
        visit[0][0] = true;

        while (!q.isEmpty()) {
            Pos pos = q.poll();

            for (int i = 0; i < 4; i++) {
                int nextX = pos.x + dx[i];
                int nextY = pos.y + dy[i];

                if (!isScope(nextX, nextY) || visit[nextX][nextY]) continue;

                if (map[nextX][nextY] == 1) {
                    map[nextX][nextY] = 0;
                    cheeseCnt--;
                } else {
                    q.add(new Pos(nextX, nextY));
                }
                visit[nextX][nextY] = true;
            }
            printMap();
        }
    }

    private static void printMap() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    private static boolean isScope(int nextX, int nextY) {
        return (nextX >= 0 && nextY >= 0 && nextX < n && nextY < m);
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
