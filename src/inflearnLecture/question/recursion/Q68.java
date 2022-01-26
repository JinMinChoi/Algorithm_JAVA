package inflearnLecture.question.recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Q68 {
    private static int n, m;
    private static ArrayList<Graph>[] nodes;
    private static boolean[] visit;
    private static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        nodes = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++) {
            nodes[i] = new ArrayList<>();
        }
        visit = new boolean[n + 1];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            nodes[start].add(new Graph(end, cost));
        }
        //visit[1] = true;
        dfs(1, 0);
        System.out.println(min);
    }

    private static void dfs(int depth, int sum) {
        if (depth == n) {
            min = Math.min(min, sum);
        }

        for (Graph graph : nodes[depth]) {
            if (!visit[graph.next]) {
                visit[graph.next] = true;
                dfs(graph.next, sum + graph.cost);
                visit[graph.next] = false;
            }
        }
    }

    private static class Graph {
        int next;
        int cost;

        public Graph(int next, int cost) {
            this.next = next;
            this.cost = cost;
        }
    }
}
