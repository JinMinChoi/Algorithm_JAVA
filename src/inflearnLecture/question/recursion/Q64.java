package inflearnLecture.question.recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Q64 {
    private static int n, m;
    private static ArrayList<Integer>[] lists;
    private static boolean[] visit;
    private static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        lists = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            lists[i] = new ArrayList<>();
        }
        visit = new boolean[n + 1];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            lists[x].add(y);
        }

        dfs(1);
        System.out.println(answer);
    }

    private static void dfs(int cur) {
        if (cur == n) {
            answer++;
            visit[cur] = false;
            return;
        }

        for (int next : lists[cur]) {
            if (!visit[next]) {
                visit[next] = true;
                dfs(next);
                visit[next] = false;
            }
        }
    }
}
