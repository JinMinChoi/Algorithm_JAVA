package level.dfsbfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Q1697 {
    private static int n, k;
    private static boolean[] map;
    private static final int MAX = 100_001;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        k = sc.nextInt();

        map = new boolean[MAX];

        Queue<Info> q = new LinkedList<>();
        q.add(new Info(n, 0));
        map[n] = true;

        while (!q.isEmpty()) {
            int cur = q.peek().x;
            int cnt = q.peek().cnt;

            q.poll();

            if (cur == k) {
                System.out.println(cnt);
                break;
            }

            for (int i = 0; i < 3; i++) {
                int next;
                if (i == 0) {
                    next = cur - 1;
                } else if (i == 1) {
                    next = cur + 1;
                } else {
                    next = 2 * cur;
                }

                if (!inScope(next)) continue;

                if (!map[next]) {
                    q.add(new Info(next, cnt + 1));
                    map[next] = true;
                }
            }
        }
    }

    private static boolean inScope(int num) {
        return num >= 0 && num < MAX;
    }

    private static class Info {
        int x;
        int cnt;

        public Info(int x, int cnt) {
            this.x = x;
            this.cnt = cnt;
        }
    }
}
