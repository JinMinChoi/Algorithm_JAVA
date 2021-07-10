package level.shortestpath;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q1753 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int v = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(br.readLine());

        List<Node>[] infoList = new ArrayList[v + 1];
        for (int i = 0; i <= v; i++) {
            infoList[i] = new ArrayList<>();
        }

        boolean[] visit = new boolean[v + 1];
        int[] dist = new int[v + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());

            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            infoList[from].add(new Node(to, cost));
        }

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(start, 0));
        dist[start] = 0;

        while (!pq.isEmpty()) {
            Node curNode = pq.poll();
            int cur = curNode.next;

            if (!visit[cur]) {
                visit[cur] = true;
            }

            for (Node nextNode : infoList[cur]) {
                if (dist[nextNode.next] > dist[cur] + nextNode.cost) {
                    dist[nextNode.next] = dist[cur] + nextNode.cost;
                    pq.add(new Node(nextNode.next, dist[nextNode.next]));
                }
            }
        }

        for (int i = 1; i <= v; i++) {
            if (dist[i] == Integer.MAX_VALUE) {
                System.out.println("INF");
            } else {
                System.out.println(dist[i]);
            }
        }
    }

    private static class Node implements Comparable<Node> {
        int next;
        int cost;

        public Node(int next, int cost) {
            this.next = next;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return this.cost - o.cost;
        }
    }
}
