//https://www.acmicpc.net/problem/3190
package backjoon.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q3190 {
    private static int map[][], n, k, l;
    private static int[] dx = {0, 1, 0, -1};
    private static int[] dy = {1, 0, -1, 0}; // 우하좌상
    private static Deque<Pos> dq = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int time = 1;

        HashMap<Integer, String> rotateInfoMap = new HashMap<>();

        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        k = Integer.parseInt(br.readLine());
        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int appleX = Integer.parseInt(st.nextToken());
            int appleY = Integer.parseInt(st.nextToken());

            map[appleX - 1][appleY - 1] = 1; // 사과는 1
        }
        l = Integer.parseInt(br.readLine());
        for (int i = 0; i < l; i++) {
            st = new StringTokenizer(br.readLine());
            int rotateTime = Integer.parseInt(st.nextToken());
            String rotateDir = st.nextToken();

            rotateInfoMap.put(rotateTime, rotateDir);
        }

        dq.add(new Pos(0, 0));
        int dir = 0;

        while (true) {
            Pos pos = dq.getLast();
            int nextX = pos.x + dx[dir];
            int nextY = pos.y + dy[dir];

            if (!isScope(nextX, nextY) || includeXY(nextX, nextY)) break;

            dq.add(new Pos(nextX, nextY));
            if (map[nextX][nextY] != 1) {
                dq.pollFirst();
            } else {
                map[nextX][nextY] = 0;
            }

            if (rotateInfoMap.containsKey(time)) {
                String newDir = rotateInfoMap.get(time);

                dir = convertDir(dir, newDir);
            }
            time++;
        }

        System.out.println(time);
    }

    private static boolean includeXY(int x, int y) {
        for (Pos pos : dq) {
            if (pos.x == x && pos.y == y) return true;
        }
        return false;
    }

    private static void printDq() {
        for (Pos pos : dq) {
            System.out.println(pos.x + " " + pos.y);
        }
    }

    private static int convertDir(int dir, String newDir) {
        int temp = dir;
        if (newDir.equals("D")) {
            if (temp == 3) {
                temp = 0;
            } else {
                temp++;
            }
        } else if (newDir.equals("L")) {
            if (temp == 0) {
                temp = 3;
            } else {
                temp--;
            }
        }
        return temp;
    }

    private static boolean isScope(int x, int y) {
        return x >= 0 && y >= 0 && x < n && y < n;
    }

    private static class Pos {
        int x;
        int y;

        public Pos(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
