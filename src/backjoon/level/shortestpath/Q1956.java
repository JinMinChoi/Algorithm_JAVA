package level.shortestpath;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q1956 {
    private static final int INF = 400 * 10_001; // 모든 간선이 10_000이라면?
    private static int v, e;
    private static int[][] dist;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        v = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());

        dist = new int[v + 1][v + 1];

        for (int i = 1; i <= v; i++) {
            for (int j = 1; j <= v; j++) {
                dist[i][j] = INF;
            }
        }

        for (int line = 0; line < e; line++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            dist[a][b] = Math.min(dist[a][b], c);
        }

        //floydWarshall
        for (int k = 1; k <= v; k++) {
            for (int i = 1; i <= v; i++) {
                for (int j = 1; j <= v; j++) {
                    dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                }
            }
        }
        int ans = INF;
        //print
        for (int i = 1; i <= v; i++) {
            ans = Math.min(ans, dist[i][i]);
        }

        if(ans == INF) System.out.println(-1);
        else System.out.println(ans);
    }
}
