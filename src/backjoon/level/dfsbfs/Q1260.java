package backjoon.level.dfsbfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q1260 {
    private static int n, m, v;
    private static boolean[][] map;
    private static boolean[] dfsVisit, bfsVisit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        v = Integer.parseInt(st.nextToken());

        map = new boolean[n + 1][n + 1];

        dfsVisit = new boolean[n + 1];
        bfsVisit = new boolean[n + 1];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            map[a][b] = map[b][a] = true;
        }

        dfs(v);
        System.out.println();
        bfs(v);

    }

    private static void dfs(int start) {
        dfsVisit[start] = true;

        System.out.print(start + " ");

        for (int i = 1; i <= n; i++) {
            if (!dfsVisit[i] && map[start][i]) {
                dfs(i);
            }
        }
    }

    private static void bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        bfsVisit[start] = true;

        System.out.print(start + " ");

        while (!q.isEmpty()) {
            int cur = q.poll();

            for (int i = 1; i <= n; i++) {
                if (!bfsVisit[i] && map[cur][i]) {
                    q.add(i);
                    System.out.print(i + " ");
                    bfsVisit[i] = true;
                }
            }
        }
    }
}
