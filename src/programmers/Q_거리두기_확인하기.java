//https://programmers.co.kr/learn/courses/30/lessons/81302#fn1
package programmers;

public class Q_거리두기_확인하기 {
    private static final int SIZE = 5;
    private static int[] dx = {-1, 0, 1, 0};
    private static int[] dy = {0, 1, 0, -1};
    private static String[] map;
    private static int[] ddx = {-2, 0, 2, 0};
    private static int[] ddy = {0, 2, 0, -2};

    private static int[] dddx = {-1, 1, 1, -1};
    private static int[] dddy = {1, 1, -1, -1};

    public static void main(String[] args) {
        Q_거리두기_확인하기 q = new Q_거리두기_확인하기();

        String[][] p = {
                {"POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"},
                {"POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"},
                {"PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"},
                {"OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"},
                {"PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"}
        };

        int[] ret = q.solution(p);

        for (int i : ret) {
            System.out.print(i + " ");
        }
    }

    public int[] solution(String[][] places) {
        int[] answer = new int[places.length];

        for (int i = 0; i < SIZE; i++) {
            map = places[i];
            boolean flag = false;

            for (int j = 0; j < SIZE; j++) {
                for (int k = 0; k < SIZE; k++) {
                    char c = map[j].charAt(k);
                    if (c == 'P') {
                        if (isPerfect(j, k)) {
                            flag = true;
                            break;
                        }
                    }
                }
                if (flag) {
                    answer[i] = 0;
                    break;
                }
            }

            if(!flag) answer[i] = 1;
        }

        return answer;
    }

    private boolean isPerfect(int x, int y) {
        int curX = x;
        int curY = y;

        for (int i = 0; i < 4; i++) {
            int nextX = curX + dx[i];
            int nextY = curY + dy[i];

            if (!isScope(nextX, nextY)) continue;

            if (map[nextX].charAt(nextY) == 'P') return true;
        }

        for (int i = 0; i < 4; i++) {
            int nextX = curX + ddx[i];
            int nextY = curY + ddy[i];

            if (!isScope(nextX, nextY)) continue;

            if (map[nextX].charAt(nextY) == 'P') {
                if (map[(nextX + curX) / 2].charAt((nextY + curY) / 2) != 'X') return true;
            }
        }

        for (int i = 0; i < 4; i++) {
            int nextX = curX + dddx[i];
            int nextY = curY + dddy[i];

            if (!isScope(nextX, nextY)) continue;

            if (map[nextX].charAt(nextY) == 'P') {
                if (!(map[curX].charAt(nextY) == 'X' && map[nextX].charAt(curY) == 'X')) {
                    return true;
                }
            }
        }

        return false;
    }

    private static boolean isScope(int x, int y) {
        return x >= 0 && y >= 0 && x < SIZE && y < SIZE;
    }
}
