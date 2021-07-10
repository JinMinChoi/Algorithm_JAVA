package backjoon.level.dfsbfs;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q2606 {
    private static int n, m;
    private static boolean[][] list;
    private static boolean[] visit;
    private static int ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        list = new boolean[n + 1][n + 1];
        visit = new boolean[n + 1];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            list[a][b] = list[b][a] = true;
        }

        dfs(1);

        System.out.println(ans);
    }

    private static void dfs(int start) {
        visit[start] = true;

        for (int i = 1; i <= n; i++) {
            if (!visit[i] && list[start][i]) {
                ans++;
                dfs(i);
            }
        }
    }
}
