package inflearnLecture.question.recursion2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q80 {
    private static int n ,m;
    private static int[] dist;
    private static ArrayList<Node>[] graphs;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        init();

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            graphs[from].add(new Node(to, cost));
        }

        Queue<Node> q = new LinkedList<>();
        q.add(new Node(1, 0));

        while (!q.isEmpty()) {
            Node cur = q.poll();

            for (Node next : graphs[cur.node]) {
                if (dist[next.node] > dist[cur.node] + next.cost) {
                    dist[next.node] = dist[cur.node] + next.cost;
                    q.add(new Node(next.node, dist[next.node]));
                }
            }
        }

        for (int i = 2; i <= n; i++) {
            System.out.print(i + " : ");
            if (dist[i] != Integer.MAX_VALUE) {
                System.out.print(dist[i]);
            } else {
                System.out.print("impossible");
            }
            System.out.println();
        }
    }

    private static void init() {
        dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        graphs = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++) {
            graphs[i] = new ArrayList<>();
        }
        dist[1] = 0;
    }

    private static class Node implements Comparable<Node> {
        int node;
        int cost;

        public Node(int node, int cost) {
            this.node = node;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return this.cost - o.cost;
        }
    }
}
