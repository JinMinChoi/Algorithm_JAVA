package inflearnLecture.question.recursion2;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Q88 {
    private static final int SIZE = 7;
    private static int[][] map;
    private static int[] dx = {-1, 0, 1, 0};
    private static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        map = new int[SIZE][SIZE];

        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                int input = sc.nextInt();
                if (input == 1) {
                    map[i][j] = -1;
                } else {
                    map[i][j] = input;
                }
            }
        }

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0, 0});

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int cx = cur[0];
            int cy = cur[1];

            if (cx == SIZE - 1 && cy == SIZE - 1) {
                break;
            }

            for (int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if (!Scope(nx, ny)) continue;

                if (map[nx][ny] != -1) {
                    map[nx][ny] = map[cx][cy] + 1;
                    q.add(new int[]{nx, ny});
                }
            }
        }

        int answer = map[SIZE - 1][SIZE - 1];
        if (answer == 0) {
            answer = -1;
        }
        System.out.println(answer);
    }

    private static boolean Scope(int x, int y) {
        return x >= 0 && y >= 0 && x < SIZE && y < SIZE;
    }

}
