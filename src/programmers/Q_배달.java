//https://programmers.co.kr/learn/courses/30/lessons/12978
package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Q_배달 {
    private static int[] dist;
    private static ArrayList<Node>[] maps;
    private static boolean[] visit;

    public static void main(String[] args) {
        Q_배달 q = new Q_배달();

        int n = 5;
        int[][] road = {
                {1, 2, 1},
                {2, 3, 3},
                {5, 2, 2},
                {1, 4, 2},
                {5, 3, 1},
                {5, 4, 2}
        };
        int k = 3;

        System.out.println(q.solution(n, road, k));
    }

    public int solution(int N, int[][] road, int K) {
        int answer = 0;

        dist = new int[N + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        visit = new boolean[N + 1];

        maps = new ArrayList[N + 1];
        for (int i = 0; i <= N; i++) {
            maps[i] = new ArrayList<>();
        }

        for (int i = 0; i < road.length; i++) {
            int a = road[i][0];
            int b = road[i][1];
            int cost = road[i][2];

            maps[a].add(new Node(b, cost));
            maps[b].add(new Node(a, cost));
        }

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(1, 0));
        dist[1] = 0;

        while (!pq.isEmpty()) {
            Node curNode = pq.poll();

            if (!visit[curNode.node]) {
                visit[curNode.node] = true;
            }

            for (Node nextNode : maps[curNode.node]) {
                if (!visit[nextNode.node] && dist[nextNode.node] > dist[curNode.node] + nextNode.cost) {
                    dist[nextNode.node] = dist[curNode.node] + nextNode.cost;
                    pq.add(new Node(nextNode.node, dist[nextNode.node]));
                }
            }
        }

        for (int value : dist) {
            System.out.print(value + " ");
            if (value <= K) {
                answer++;
            }
        }
        System.out.println();
        return answer;
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
