//https://programmers.co.kr/learn/courses/30/lessons/86971
package programmers.weekly;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Q_9주차 {
    private static ArrayList<Integer>[] lists;
    private static boolean[] visit;

    public static void main(String[] args) {
        Q_9주차 q = new Q_9주차();

        int n = 9;
        int[][] w = {
                {1, 3},
                {2, 3},
                {3, 4},
                {4, 5},
                {4, 6},
                {4, 7},
                {7, 8},
                {7, 9}
        };
        /*int n = 4;
        int[][] w = {
                {1, 2},
                {2, 3},
                {3, 4}
        };*/

        System.out.println(q.solution(n, w));

    }

    public int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;

        lists = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++) {
            lists[i] = new ArrayList<>();
        }

        for (int i = 0; i < wires.length; i++) {
            int a = wires[i][0];
            int b = wires[i][1];

            lists[a].add(b);
            lists[b].add(a);
        }

        for (int i = 0; i < wires.length; i++) {
            int a = wires[i][0];
            int b = wires[i][1];

            visit = new boolean[n + 1];
            int ret = bfs(a, b);
            answer = Math.min(answer, Math.abs((n - ret) - ret));
        }
        return answer;
    }

    private int bfs(int a, int b) {
        lists[a].remove(Integer.valueOf(b));
        lists[b].remove(Integer.valueOf(a));

        Queue<Integer> q = new LinkedList<>();
        visit[a] = true;
        q.add(a);

        int cnt = 1;

        while (!q.isEmpty()) {
            int cur = q.poll();

            for (int next : lists[cur]) {
                if (!visit[next]) {
                    visit[next] = true;
                    cnt++;
                    q.add(next);
                }
            }
        }

        lists[a].add(b);
        lists[b].add(a);

        return cnt;
    }
}
