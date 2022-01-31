package backjoon.level.dfsbfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Q1325 {
    private static int n, m;
    private static ArrayList<Integer>[] lists;
    private static boolean[] visit;
    private static int[] ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        lists = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++) {
            lists[i] = new ArrayList<>();
        }
        ans = new int[n + 1];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            lists[a].add(b);
        }

        for (int i = 1; i <= n; i++) {
            visit = new boolean[n + 1];
            dfs(i);
        }

        StringBuffer sb = new StringBuffer();
        int max = 0;

        for (int i = 1; i < ans.length; i++) {
            if(ans[i] > max) max = ans[i];
        }
        for (int i = 1; i < ans.length; i++) {
            if (ans[i] == max) {
                sb.append(i + " ");
            }
        }

        System.out.println(sb.toString().trim());
    }

    private static void dfs(int i) {
        visit[i] = true;

        for (int next : lists[i]) {
            if (!visit[next]) {
                ans[next]++;
                dfs(next);
            }
        }
    }
}
