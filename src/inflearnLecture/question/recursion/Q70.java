package inflearnLecture.question.recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q70 {
    private static int n,m;
    private static ArrayList<Integer>[] lists;
    private static boolean[] visit;
    private static int[] dist;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        visit = new boolean[n + 1];
        lists = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++) {
            lists[i] = new ArrayList<>();
        }
        dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            lists[from].add(to);
        }

        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        visit[1] = true;
        dist[1] = 0;

        while (!q.isEmpty()) {
            int cur = q.poll();

            for (int next : lists[cur]) {
                if (!visit[next] && dist[next] > dist[cur] + 1) {
                    visit[next] = true;
                    dist[next] = dist[cur] + 1;
                    q.add(next);
                }
            }
        }

        for (int i = 2; i <= n; i++) {
            System.out.println(i + " : " + dist[i]);
        }
    }
}
