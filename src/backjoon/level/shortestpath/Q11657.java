package level.shortestpath;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q11657 {
    private static int n, m;
    private static Info[] infos;
    private static Long[] dist;
    private static final Long INF = Long.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        infos = new Info[m];
        dist = new Long[n + 1];
        Arrays.fill(dist, INF);

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            infos[i] = new Info(a, b, c);
        }

        if (!bellmanFord()) {
            System.out.println(-1);
        } else {
            for (int i = 2; i <= n; i++) {
                System.out.println(dist[i].equals(INF) ? -1 : dist[i]);
            }
        }
    }

    private static boolean bellmanFord() {
        dist[1] = 0L;

        /**
         * 최단 경로가 나올 수 있는 최대 간선 갯수는 N-1개이다.
         * 벨만-포드 알고리즘은 시간 복잡도가 O(VE)이다.
         * 모든 간선의 경우를 다 따져야 한다.
         */
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < m; j++) {
                Info info = infos[j];

                if (dist[info.s] != INF && dist[info.e] > dist[info.s] + info.cost) {
                    dist[info.e] = dist[info.s] + info.cost;
                }
            }
        }

        for (int i = 0; i < m; i++) {
            Info info = infos[i];

            if (dist[info.s] != INF && dist[info.e] > dist[info.s] + info.cost) {
                return false;
            }
        }

        return true;
    }

    private static class Info {
        int s;
        int e;
        int cost;

        public Info(int s, int e, int cost) {
            this.s = s;
            this.e = e;
            this.cost = cost;
        }
    }
}
