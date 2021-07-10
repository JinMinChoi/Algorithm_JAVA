package backjoon.level.shortestpath;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q1504 {
    private static int n, e;
    private static List<Node>[] lists;
    private static final int INF = 20_000_000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());

        lists = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++) {
            lists[i] = new ArrayList<>();
        }

        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            lists[a].add(new Node(b, c));
            lists[b].add(new Node(a, c));
        }

        st = new StringTokenizer(br.readLine());
        int v1 = Integer.parseInt(st.nextToken());
        int v2 = Integer.parseInt(st.nextToken());

        int result1 = getShortestPath(1, v1);
        result1 += getShortestPath(v1, v2);
        result1 += getShortestPath(v2, n);

        int result2 = getShortestPath(1, v2);
        result2 += getShortestPath(v2, v1);
        result2 += getShortestPath(v1, n);

        int ans = (result1 >= INF && result2 >= INF) ? -1 : Math.min(result1, result2);

        System.out.println(ans);
    }

    private static int getShortestPath(int s, int e) {
        boolean[] visit = new boolean[n + 1];
        int[] dist = new int[n + 1];
        Arrays.fill(dist, INF);
        Arrays.fill(visit, false);

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(s, 0));
        dist[s] = 0;

        while (!pq.isEmpty()) {
            Node node = pq.poll();
            int curNode = node.next;

            if (!visit[curNode]) {
                visit[curNode] = true;

                for (Node nextNode : lists[curNode]) {
                    if (!visit[nextNode.next] && dist[nextNode.next] > dist[curNode] + nextNode.cost) {
                        dist[nextNode.next] = dist[curNode] + nextNode.cost;
                        pq.add(new Node(nextNode.next, dist[nextNode.next]));
                    }
                }
            }
        }

        return dist[e];
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
