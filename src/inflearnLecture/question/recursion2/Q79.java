package inflearnLecture.question.recursion2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Q79 {
    private static int v, e;
    private static PriorityQueue<Node> pq = new PriorityQueue<>();
    private static ArrayList<Node>[] lists;
    private static boolean[] visit;
    private static int answer, count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        v = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());

        lists = new ArrayList[v + 1];
        for (int i = 0; i <= v; i++) {
            lists[i] = new ArrayList<>();
        }
        visit = new boolean[v + 1];

        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            lists[a].add(new Node(b, c));
            lists[b].add(new Node(a, c));
        }

        pq.add(new Node(1, 0));

        while (!pq.isEmpty()) {
            Node cur = pq.poll();

            if (visit[cur.next]) continue;
            visit[cur.next] = true;

            answer += cur.cost;

            for (Node node : lists[cur.next]) {
                if (!visit[node.next]) {
                    pq.add(node);
                }
            }

            count++; //방문한 노드의 수 추가
            if(count == v) break;
        }

        System.out.println(answer);
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
