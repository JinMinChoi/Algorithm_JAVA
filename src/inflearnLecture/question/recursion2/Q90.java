package inflearnLecture.question.recursion2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Q90 {
    private static int n;
    private static int[][] map;
    private static boolean[][] visit;
    private static int ans;
    private static int[] dx = {-1, 0, 1, 0};
    private static int[] dy = {0, -1, 0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        visit = new boolean[n][n];

        PriorityQueue<Info> pq = new PriorityQueue<>();
        Simba simba = new Simba();

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 9) {
                    simba.x = i;
                    simba.y = j;
                    simba.size = 2;
                    simba.eatCnt = 0;
                    map[i][j] = 0;
                }
            }
        }

        pq.add(new Info(simba.x, simba.y, 0));

        while (!pq.isEmpty()) {
            Info cur = pq.poll();

            //먹는 과정
            if (map[cur.x][cur.y] != 0 && map[cur.x][cur.y] < simba.size) {
                map[cur.x][cur.y] = 0;
                simba.eatCnt++;

                simba.x = cur.x;
                simba.y = cur.y;

                if (simba.eatCnt == simba.size) {
                    simba.levelUp();
                }

                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        visit[i][j] = false;
                    }
                }

                while (!pq.isEmpty()) {
                    pq.poll();
                }

                ans = cur.dist;
            }

            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if (isScope(nx, ny) && !visit[nx][ny]
                        && map[nx][ny] <= simba.size) {
                    visit[nx][ny] = true;
                    pq.add(new Info(nx, ny, cur.dist + 1));
                }
            }
        }

        System.out.println(ans);
    }

    private static boolean isScope(int x, int y) {
        return x >= 0 && y >= 0 && x < n && y < n;
    }

    private static class Simba {
        int x;
        int y;
        int size;
        int eatCnt;

        void levelUp() {
            size++;
            eatCnt = 0;
        }
    }

    private static class Info implements Comparable<Info> {
        int x;
        int y;
        int dist;

        public Info(int x, int y, int dist) {
            this.x = x;
            this.y = y;
            this.dist = dist;
        }

        @Override
        public int compareTo(Info o) {
            if (dist == o.dist) {
                if (x == o.x) {
                    return y - o.y;
                }
                return x - o.x;
            }
            return dist - o.dist;
        }
    }
}