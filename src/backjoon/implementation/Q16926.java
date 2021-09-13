//https://www.acmicpc.net/problem/16926
package backjoon.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q16926 {
    private static int[] dx = {0, 1, 0, -1};
    private static int[] dy = {1, 0, -1, 0};
    private static int[][] map;
    private static int N, M, R;
    private static int depth;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        depth = Math.min(N, M) / 2;

        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < R; i++) {
            for (int d = 0; d < depth; d++) {
                int curX = d;
                int curY = d;

                int temp = map[curX][curY];
                int idx = 0;

                while (idx < 4) {
                    int nextX = curX + dx[idx];
                    int nextY = curY + dy[idx];

                    if (nextX < d || nextY < d || nextX >= N - d || nextY >= M - d) {
                        idx++;
                    } else {
                        map[curX][curY] = map[nextX][nextY];
                        curX = nextX;
                        curY = nextY;
                    }
                }

                map[d+1][d] = temp;
            }
        }

        printMap();
    }

    private static void printMap() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }
}
