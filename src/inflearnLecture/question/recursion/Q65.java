package inflearnLecture.question.recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q65 {
    private static int[][] map;
    private static boolean[][] visit;
    private static int[] dx = {-1, 0, 1, 0};
    private static int[] dy = {0, 1, 0, -1};
    private static int answer;
    private final static int SIZE = 7;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        map = new int[SIZE][SIZE];
        visit = new boolean[SIZE][SIZE];

        for (int i = 0; i < SIZE; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < SIZE; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0, 0);
        System.out.println(answer / 2);
    }

    private static void dfs(int x, int y) {
        if (isEnd(x, y)) {
            answer++;
            return;
        } else {

            for (int i = 0; i < 4; i++) {
                int nextX = x + dx[i];
                int nextY = y + dy[i];

                if (!isScope(nextX, nextY)) continue;

                if (!visit[nextX][nextY] && map[nextX][nextY] == 0) {
                    visit[nextX][nextY] = true;
                    dfs(nextX, nextY);
                    visit[nextX][nextY] = false;
                }
            }
        }
    }

    private static boolean isScope(int x, int y) {
        return x >= 0 && x < SIZE && y >= 0 && y < SIZE;
    }

    private static boolean isEnd(int x, int y) {
        return x == SIZE - 1 && y == SIZE - 1;
    }
}
