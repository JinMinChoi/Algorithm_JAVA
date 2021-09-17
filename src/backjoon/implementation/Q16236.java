//https://www.acmicpc.net/problem/16236
package backjoon.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q16236 {
    private static int N, time, sx, sy, size, count, map[][];
    private static ArrayList<Info> fishes;
    private static int dx[] = {-1, 1, 0, 0};
    private static int dy[] = {0, 0, -1, 1};

    // 상어 또는 물고기의 정보
    private static class Info {
        int x, y, dist;

        public Info(int x, int y, int dist) {
            this.x = x;
            this.y = y;
            this.dist = dist;
        }
    }

    private static boolean isRange(int x, int y) {
        return x < 0 || x >= N || y < 0 || y >= N;
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        size = 2; // 초기 나이 2

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int num = Integer.parseInt(st.nextToken());
                map[i][j] = num;
                if (num == 9) {
                    sx = i;
                    sy = j;
                    map[i][j] = 0;
                }
            }
        }

        while (true) {
            fishes = new ArrayList<>(); // 먹을 수 있는 물고기의 정보
            Queue<Info> q = new LinkedList<>();
            boolean visit[][] = new boolean[N][N];
            q.offer(new Info(sx, sy, 0));
            visit[sx][sy] = true;

            while (!q.isEmpty()) {
                Info shark = q.poll();

                for (int d = 0; d < 4; d++) {
                    int nx = shark.x + dx[d];
                    int ny = shark.y + dy[d];

                    if (isRange(nx, ny)) continue;
                    if (visit[nx][ny]) continue;
                    // 먹이를 찾은 경우
                    if (1 <= map[nx][ny] && map[nx][ny] < size) {
                        q.offer(new Info(nx, ny, shark.dist + 1));
                        fishes.add(new Info(nx, ny, shark.dist + 1));
                        visit[nx][ny] = true;
                    }

                    // 크기만 같아 먹을 수 없고 지나갈 수만 있는 경우
                    else if (map[nx][ny] == size || map[nx][ny] == 0) {
                        q.offer(new Info(nx, ny, shark.dist + 1));
                        visit[nx][ny] = true;
                    }
                }
            }

            if (fishes.size() == 0) {
                System.out.println(time);
                return;
            }

            // 먹을 물고기가 있는 경우
            Info eatingFish = fishes.get(0);
            for (int i = 1; i < fishes.size(); i++) {
                if (fishes.get(i).dist < eatingFish.dist) { // 거리가 최소인 물고기로 갱신
                    eatingFish = fishes.get(i);
                }

                if (eatingFish.dist == fishes.get(i).dist) { // 거리가 같은 경우 X가 작은 물고기
                    if (eatingFish.x > fishes.get(i).x) {
                        eatingFish = fishes.get(i);
                    }
                }
            }

            time += eatingFish.dist;
            count++;
            map[eatingFish.x][eatingFish.y] = 0;

            if (count == size) {
                size++;
                count = 0;
            }

            sx = eatingFish.x;
            sy = eatingFish.y;
        }
    }
}