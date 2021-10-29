package programmers;

import java.util.LinkedList;
import java.util.Queue;

public class Q_경주로_건설 {
    public static void main(String[] args) {
        int[][] b = {
                {0, 0, 0, 0, 0, 0},
                {0, 1, 1, 1, 1, 0},
                {0, 0, 1, 0, 0, 0},
                {1, 0, 0, 1, 0, 1},
                {0, 1, 0, 0, 0, 1},
                {0, 0, 0, 0, 0, 0}
        };

        Q_경주로_건설 q = new Q_경주로_건설();
        System.out.println(q.solution(b));
    }

    private static int n;
    private static int[] dx = {-1, 0, 1, 0};
    private static int[] dy = {0, 1, 0, -1};
    private static boolean[][] visit;
    private static int cost = Integer.MAX_VALUE;

    public int solution(int[][] board) {
        int answer = 0;
        n = board.length;
        visit = new boolean[n][n];

        Queue<Pos> q = new LinkedList<>();
        q.add(new Pos(0, 0, -1, 0));
        visit[0][0] = true;

        while (!q.isEmpty()) {
            Pos cur = q.poll();

            if (cur.x == n - 1 && cur.y == n - 1) {
                cost = Math.min(cost, cur.cost);
            }

            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];
                int nDir = i;
                int nCost = cur.cost;

                if (!isScope(nx, ny) || board[nx][ny] == 1) continue;

                if (cur.dir == -1) {
                    nCost += 100;
                } else if (cur.dir == nDir) {
                    nCost += 100;
                } else {
                    nCost += 600;
                }

                if (!visit[nx][ny] || board[nx][ny] >= nCost) {
                    visit[nx][ny] = true;
                    board[nx][ny] = nCost;
                    q.add(new Pos(nx, ny, nDir, nCost));
                }
            }
        }

        answer = cost;
        return answer;
    }

    private boolean isScope(int x, int y) {
        return x >= 0 && x < n && y >= 0 && y < n;
    }

    private static class Pos {
        int x;
        int y;
        int dir;
        int cost;

        public Pos(int x, int y, int dir, int cost) {
            this.x = x;
            this.y = y;
            this.dir = dir;
            this.cost = cost;
        }
    }

}
