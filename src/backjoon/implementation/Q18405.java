//https://www.acmicpc.net/problem/18405
package backjoon.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q18405 {
    private static int[] dx = {-1, 1, 0, 0};
    private static int[] dy = {0, 0, -1, 1};
    private static int[][] map;
    private static int n, k, s, needX, needY;

    private static PriorityQueue<Pos> pq = new PriorityQueue<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        map = new int[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] != 0) {
                    pq.add(new Pos(i, j, 0, map[i][j]));
                }
            }
        }

        st = new StringTokenizer(br.readLine());
        s = Integer.parseInt(st.nextToken());
        needX = Integer.parseInt(st.nextToken()) - 1;
        needY = Integer.parseInt(st.nextToken()) - 1;

        while (!pq.isEmpty()) {
            Pos curVirus = pq.poll();
            int x = curVirus.x;
            int y = curVirus.y;
            int time = curVirus.time;
            int virus = curVirus.virus;

            if (time == s) {
                break;
            }

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (!isScope(nx, ny) || map[nx][ny] != 0) continue;

                if (map[nx][ny] == 0) {
                    map[nx][ny] = virus;
                    pq.add(new Pos(nx, ny, time + 1, virus));
                }
            }
        }

        System.out.println(map[needX][needY]);
    }

    private static boolean isScope(int x, int y) {
        return x >= 0 && x < n && y >= 0 && y < n;
    }

    private static class Pos implements Comparable<Pos> {
        int x;
        int y;
        int time;
        int virus;

        public Pos(int x, int y, int time, int virus) {
            this.x = x;
            this.y = y;
            this.time = time;
            this.virus = virus;
        }

        @Override
        public int compareTo(Pos o) {
            if (this.time == o.time) {
                return this.virus - o.virus;
            }
            return this.time - o.time;
        }
    }
}
