//https://www.acmicpc.net/problem/2615
package backjoon.implementation;

import java.io.*;
import java.util.*;

public class Q2615 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    private static final int SIZE = 19;
    private static int[][] map = new int[SIZE][SIZE];
    private static int[] dx = {0, 1, -1, 1, 0, -1, 1, -1};
    private static int[] dy = {1, 1, 1, 0, -1, -1, -1, 0};
    private static boolean[][][] visited = new boolean[SIZE][SIZE][4];
    private static Deque<int[]> deque = new ArrayDeque();

    public static void main(String[] args) throws Exception {
        for (int i = 0; i < SIZE; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < SIZE; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 1 || map[i][j] == 2)
                    deque.add(new int[]{i, j});
            }
        }

        while (!deque.isEmpty()) {
            int[] pos = deque.poll();
            int curX = pos[0];
            int curY = pos[1];

            for (int i = 0; i < 4; i++) {
                int nextX = curX + dx[i];
                int nextY = curY + dy[i];

                if (!isScope(nextX, nextY)) continue;

                if (!visited[nextX][nextY][i] && countFive(nextX, nextY, i, map[curX][curY])) {
                    if (!isScope(curX + dx[i + 4], curY + dy[i + 4])) {
                        System.out.println(map[curX][curY]);
                        System.out.print((curX + 1) + " " + (curY + 1));
                        return;
                    }
                    if (isScope(curX + dx[i + 4], curY + dy[i + 4]) && map[curX + dx[i + 4]][curY + dy[i + 4]] != map[nextX][nextY]) {
                        System.out.println(map[curX][curY]);
                        System.out.print((curX + 1) + " " + (curY + 1));
                        return;
                    }
                }
            }
        }
        System.out.println(0);
    }

    private static boolean countFive(int x, int y, int dir, int color) {
        if (color == 0) return false;
        int cnt = 1;
        while (map[x][y] == color) {
            cnt++;
            visited[x][y][dir] = true;
            x += dx[dir];
            y += dy[dir];

            if (!isScope(x, y)) break;
        }
        return cnt == 5;
    }

    private static boolean isScope(int nx, int ny) {
        return nx >= 0 && nx < SIZE && ny >= 0 && ny < SIZE;
    }
}