//https://www.acmicpc.net/problem/5567
package backjoon.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q5567 {
    private static int n, m;
    private static ArrayList<Integer>[] lists;
    private static boolean[] visit;
    private static Queue<Node> q = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        lists = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            lists[i] = new ArrayList<>();
        }
        visit = new boolean[m + 1];

        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            lists[a].add(b);
            lists[b].add(a);
        }

        q.add(new Node(1, 0));
        visit[1] = true;

        int cnt = 0;

        while (!q.isEmpty()) {
            Node curNode = q.poll();
            if (curNode.cost > 2) break;

            for (Integer next : lists[curNode.idx]) {
                if (!visit[next]) {
                    visit[next] = true;
                    q.add(new Node(next, curNode.cost + 1));
                    if (curNode.cost + 1 <= 2) {
                        cnt++;
                    }
                }
            }
        }

        System.out.println(cnt);
    }

    private static class Node {
        int idx;
        int cost;

        public Node(int idx, int cost) {
            this.idx = idx;
            this.cost = cost;
        }
    }
}
