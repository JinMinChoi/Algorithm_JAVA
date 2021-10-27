package backjoon.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q8972 {

    private static int r, c;
    private static char[][] map;
    private static int[] dx = {1, 1, 1, 0, 0, 0, -1, -1, -1};
    private static int[] dy = {-1, 0, 1, -1, 0, 1, -1, 0, 1};
    private static int[] command;
    private static Pos myPos;
    private static Queue<Pos> crazyPos = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        map = new char[r][c];

        for (int i = 0; i < r; i++) {
            String line = br.readLine();
            for (int j = 0; j < c; j++) {
                map[i][j] = line.charAt(j);
                if (map[i][j] == 'I') {
                    myPos = new Pos(i, j);
                } else if (map[i][j] == 'R') {
                    crazyPos.add(new Pos(i, j));
                }
            }
        }

        String[] commandStr = br.readLine().split("");
        command = Arrays.stream(commandStr)
                .mapToInt(Integer::parseInt)
                .toArray();

        int moveCnt = 0;

        for (int i = 0; i < command.length; i++) {
            if (command[i] != 5) {
                if (!moveMe(command[i] - 1)) {
                    moveCnt = i + 1;
                    break;
                }
            }

            if (!moveCrazy()) {
                moveCnt = i + 1;
                break;
            }

            newMap();
        }

        if (moveCnt != 0) {
            System.out.print("kraj" + " " + moveCnt);
        } else {
            printMap();
        }
    }

    private static void newMap() {
        map = new char[r][c];

        for (int i = 0; i < r; i++) {
            Arrays.fill(map[i], '.');
        }

        map[myPos.x][myPos.y] = 'I';

        for (Pos crazyOne : crazyPos) {
            map[crazyOne.x][crazyOne.y] = 'R';
        }
    }

    private static boolean moveCrazy() {
        int[][] temp = new int[r][c];

        int size = crazyPos.size();
        for (int i = 0; i < size; i++) {
            Pos crazyOne = crazyPos.poll();

            int min = Integer.MAX_VALUE;
            int minX = 0;
            int minY = 0;

            for (int dir = 0; dir < 9; dir++) {
                if(dir == 4) continue;

                int nx = crazyOne.x + dx[dir];
                int ny = crazyOne.y + dy[dir];

                if(!isScope(nx, ny)) continue;

                int minDistance = Math.abs(myPos.x - nx) + Math.abs(myPos.y - ny);
                if (minDistance < min) {
                    min = minDistance;
                    minX = nx;
                    minY = ny;
                }
            }

            if (minX == myPos.x && minY == myPos.y) {
                return false;
            }

            temp[minX][minY] += 1;
        }

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (temp[i][j] == 1) {
                    crazyPos.add(new Pos(i, j));
                }
            }
        }
        return true;
    }

    private static boolean isScope(int nx, int ny) {
        return nx >= 0 && nx < r && ny >= 0 && ny < c;
    }

    private static boolean moveMe(int i) {
        int nx = myPos.x + dx[i];
        int ny = myPos.y + dy[i];

        if (map[nx][ny] == 'R') {
            return false;
        }
        myPos.x = nx;
        myPos.y = ny;
        return true;
    }

    private static void printMap() {
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                System.out.print(map[i][j]);
            }
            System.out.println();
        }
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
