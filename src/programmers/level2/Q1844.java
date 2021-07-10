//https://programmers.co.kr/learn/courses/30/lessons/1844
package programmers.level2;

import java.util.LinkedList;
import java.util.Queue;

public class Q1844 {

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static boolean[][] visit;
    static int[][] newMap;
    static int maxX, maxY;

    static class Pos {
        int x;
        int y;

        public Pos(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static Queue<Pos> q;

    public static void main(String[] args) {
        int[][] maps = {
                {1, 0, 1, 1, 1},
                {1, 0, 1, 0, 1},
                {1, 0, 1, 1, 1},
                {1, 1, 1, 0, 1},
                {0, 0, 0, 0, 1}
        };

        System.out.println(solution(maps));
    }

    public static int solution(int[][] maps) {
        int answer = 0;
        maxX = maps.length;
        maxY = maps[0].length;

        newMap = maps;

        visit = new boolean[maxX][maxY];

        bfs(0, 0);
        answer = newMap[maxX - 1][maxY - 1];


        return answer > 1? answer : -1;
    }

    private static void bfs(int i, int j) {
        q = new LinkedList<>();
        q.add(new Pos(i, j));
        visit[i][j] = true;

        while (!q.isEmpty()) {
            Pos cur = q.poll();
            int x = cur.x;
            int y = cur.y;

            for (int dir = 0; dir < 4; dir++) {
                int nx = x + dx[dir];
                int ny = y + dy[dir];

                if (nx < 0 || nx >= maxX || ny < 0 || ny >= maxY) {
                    continue;
                }

                if (!visit[nx][ny] && newMap[nx][ny] != 0) {
                    newMap[nx][ny] = newMap[x][y] + 1;
                    q.add(new Pos(nx, ny));
                    visit[nx][ny] = true;
                }
            }
        }

    }
}
