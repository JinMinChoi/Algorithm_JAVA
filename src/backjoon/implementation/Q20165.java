package backjoon.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q20165 {
    private static int n, m, round;
    private static int[][] arr;
    private static char[][] state;
    private static int ans;
    private static int[] dx = {0, 1, 0, -1};
    private static int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        round = Integer.parseInt(st.nextToken());

        arr = new int[n][m];
        state = new char[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                state[i][j] = 'S';
            }
        }

        for (int r = 0; r < round; r++) {
            st = new StringTokenizer(br.readLine());
            int ax = Integer.parseInt(st.nextToken()) - 1;
            int ay = Integer.parseInt(st.nextToken()) - 1;
            int dir = charToInt(st.nextToken().charAt(0));
            attack(ax, ay, dir);

            st = new StringTokenizer(br.readLine());
            int dx = Integer.parseInt(st.nextToken()) - 1;
            int dy = Integer.parseInt(st.nextToken()) - 1;
            depend(dx, dy);
        }

        System.out.println(ans);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(state[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static void depend(int x, int y) {
        if (state[x][y] == 'F') {
            state[x][y] = 'S';
        }
    }

    private static void attack(int x, int y, int dir) {
        if (state[x][y] == 'F') { // 넘어져 있는 경우 공격중지
            return;
        }

        int domino_size = arr[x][y] - 1; // 도미노 크기 = 넘어뜨릴 갯수
        state[x][y] = 'F';
        ans++;

        while (domino_size > 0) { // 넘어뜨리는 과정
            int nx = x + dx[dir];
            int ny = y + dy[dir];

            if (!isScope(nx, ny)) break;

            if (state[nx][ny] == 'F') { // 과정 중 이미 넘어진 도미노가 존재할 때
                x = nx;
                y = ny;
                domino_size--;
                continue;
            }

            state[nx][ny] = 'F';
            domino_size--;
            ans++;
            int new_domino_size = arr[nx][ny] - 1;
            x = nx;
            y = ny;

            domino_size = Math.max(new_domino_size, domino_size);
        }

    }

    private static boolean isScope(int x, int y) {
        return x >= 0 && y >= 0 && x < n && y < m;
    }

    private static int charToInt(char c) {
        if (c == 'E') {
            return 0;
        } else if (c == 'S') {
            return 1;
        } else if (c == 'W') {
            return 2;
        } else if (c == 'N') {
            return 3;
        }
        return 0;
    }
}
