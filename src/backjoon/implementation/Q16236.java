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

    // 상어 또는 물고기의 위치와 거리를 담을 클래스
    private static class Info {
        int x, y, dist;

        public Info(int x, int y, int dist) {
            this.x = x;
            this.y = y;
            this.dist = dist;
        }
    }

    // 맵 범위 체크 메소드
    private static boolean isRange(int x, int y) {
        return x < 0 || x >= N || y < 0 || y >= N;
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        size = 2; // 초기 나이 2로 셋팅

        // 입력으로 주어진 값을 받고 상어가 있는 위치 0으로 초기화
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                int num = Integer.parseInt(st.nextToken());
                map[i][j] = num;
                if(num == 9) {
                    sx = i;
                    sy = j;
                    map[i][j] = 0;
                }
            }
        }

        while(true) {
            fishes = new ArrayList<>(); // 먹을 수 있는 물고기의 정보를 담을 수 있는 ArrayList 생성
            Queue<Info> q = new LinkedList<>(); // bfs 수행을 위한 큐 생성
            boolean visit[][] = new boolean[N][N]; // 방문 표시를 하기 위한 boolean 타입의 2차원 배열 생성
            q.offer(new Info(sx, sy, 0)); // 상어의 위치 q에 삽입, 물고기를 먹었으므로 0으로 거리 갱신
            visit[sx][sy] = true; // 방문 표시

            while(!q.isEmpty()) {
                Info shark = q.poll();

                for(int d = 0; d < 4; d++) {
                    int nx = shark.x + dx[d];
                    int ny = shark.y + dy[d];

                    if(isRange(nx, ny)) continue;
                    if(visit[nx][ny]) continue;
                    // 먹이를 찾은 경우(0보다 크고 상어의 사이즈보다 작은 경우만 먹을 수 있다는 조건)
                    if(1 <= map[nx][ny] && map[nx][ny] < size) {
                        q.offer(new Info(nx, ny, shark.dist + 1));
                        fishes.add(new Info(nx, ny, shark.dist + 1));
                        visit[nx][ny] = true;
                    }

                    // 먹을 수는 없지만 지나갈 수 있는 경우(0이거나 상어의 사이즈와 같은 경우 지나갈 수 있다는 조건)
                    else if(map[nx][ny] == size || map[nx][ny] == 0) {
                        q.offer(new Info(nx, ny, shark.dist + 1));
                        visit[nx][ny] = true;
                    }
                }
            }

            // 사이즈가 0인 경우 먹을 수 있는 물고기가 없는 경우이므로 출력
            if(fishes.size() == 0) {
                System.out.println(time);
                return;
            }

            // 먹을 물고기가 있는 경우
            Info eatingFish = fishes.get(0);
            for(int i = 1; i < fishes.size(); i++){
                if(fishes.get(i).dist < eatingFish.dist) { // 거리가 최소인 물고기로 갱신
                    eatingFish = fishes.get(i);
                }

                if(eatingFish.dist == fishes.get(i).dist) { // 거리가 같은 경우 X가 작은 물고기가 우선순위가 되므로 갱신
                    if(eatingFish.x > fishes.get(i).x){
                        eatingFish = fishes.get(i);
                    }
                }
            }

            time += eatingFish.dist;
            count++;
            map[eatingFish.x][eatingFish.y] = 0;

            if(count == size) {
                size++;
                count = 0;
            }

            sx = eatingFish.x;
            sy = eatingFish.y;
        }
    }
}