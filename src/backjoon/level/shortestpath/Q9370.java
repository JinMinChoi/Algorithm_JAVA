package level.shortestpath;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q9370 {
    private static int n, m, t;
    private static int s, g, h;
    private static List<Node>[] lists;
    private static int[] dist;
    private static boolean[] visit;

    private static List<Integer> destinations;
    private static final int INF = 50_000_000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int tc = Integer.parseInt(br.readLine());

        while ((tc--) > 0) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken()); // 정점
            m = Integer.parseInt(st.nextToken()); // 간선
            t = Integer.parseInt(st.nextToken()); // 목적지 갯수

            lists = new ArrayList[n + 1];
            for (int i = 0; i <= n; i++) {
                lists[i] = new ArrayList<>();
            }
            dist = new int[n + 1];
            visit = new boolean[n + 1];

            st = new StringTokenizer(br.readLine());
            s = Integer.parseInt(st.nextToken()); // 시작점
            g = Integer.parseInt(st.nextToken()); // 무조건 지나가는 정점 1
            h = Integer.parseInt(st.nextToken()); // 무조건 지나가는 정점 2

            while ((m--) > 0) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int cost = Integer.parseInt(st.nextToken());

                /**
                 * 무조건 지나가는 정점에 해당하는 간선이면 가중치를 홀수로,
                 * 그렇지 않다면 가중치를 짝수로
                 */
                if ((a == g && b == h) || (a == h && b == g)) {
                    lists[a].add(new Node(b, cost * 2 - 1));
                    lists[b].add(new Node(a, cost * 2 - 1));
                } else {
                    lists[a].add(new Node(b, cost * 2));
                    lists[b].add(new Node(a, cost * 2));
                }
            }

            destinations = new ArrayList<>(t);
            while ((t--) > 0) {
                destinations.add(Integer.parseInt(br.readLine()));
            }

            /**
             * 다익스트라 알고리즘을 통해서 시작점으로부터의 최단경로의 dist[]를 구하고
             * 목적지 후보가 되는 곳들의 dist[목적지]가 홀 수 일때 정답
             */
            getAns(s);

            Collections.sort(destinations);

            for (Integer destination : destinations) {
                if(dist[destination] % 2 != 0) System.out.println(destination);
            }
        }
    }

    private static void getAns(int s) {
        Arrays.fill(dist, INF);
        Arrays.fill(visit, false);

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(s, 0));
        dist[s] = 0;

        while (!pq.isEmpty()) {
            Node node = pq.poll();
            int cur = node.next;

            if (!visit[cur]) visit[cur] = true;

            for (Node nNode : lists[cur]) {
                if (!visit[nNode.next] && dist[nNode.next] > dist[cur] + nNode.cost) {
                    dist[nNode.next] = dist[cur] + nNode.cost;
                    pq.add(new Node(nNode.next, dist[nNode.next]));
                }
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
