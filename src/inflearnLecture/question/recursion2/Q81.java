package inflearnLecture.question.recursion2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q81 {
    private static class Node {
        int from;
        int to;
        int cost;

        public Node(int from, int to, int cost) {
            this.from = from;
            this.to = to;
            this.cost = cost;
        }
    }

    private static int n, m, answer;
    private static int[] dist;
    private static Node[] lists;
    private static final int INF = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        dist = new int[n + 1];
        Arrays.fill(dist, INF);
        lists = new Node[m];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            lists[i] = new Node(from, to, cost);
        }

        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        if (!bellmanFord(start, end)) {
            System.out.println("-1");
        } else {
            System.out.println(answer);
        }
    }

    private static boolean bellmanFord(int start, int end) {
        dist[start] = 0;

        //최소 간선의 갯수는 n-1
        //모든 간선의 정보를 다 탐색해야한다.
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < m; j++) {
                Node node = lists[j];

                if (dist[node.from] != INF && dist[node.to] > dist[node.from] + node.cost) {
                    dist[node.to] = dist[node.from] + node.cost;
                }
            }
        }

        for (int i = 0; i < m; i++) {
            Node node = lists[i];

            if (dist[node.from] != INF && dist[node.to] > dist[node.from] + node.cost) {
                return false;
            }
        }

        answer = dist[end];
        return true;
    }
}
