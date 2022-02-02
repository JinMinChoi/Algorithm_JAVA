package inflearnLecture.question.recursion2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q77 {
    private static int n, m, target1, target2;
    private static int[] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        graph = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            graph[i] = i;
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            union(a, b);
        }

        st = new StringTokenizer(br.readLine());
        target1 = Integer.parseInt(st.nextToken());
        target2 = Integer.parseInt(st.nextToken());

        target1 = find(target1);
        target2 = find(target2);

        if(target1 == target2) System.out.println("YES");
        else System.out.println("NO");
    }

    private static int find(int n) {
        if (graph[n] == n) {
            return n;
        }

        return graph[n] = find(graph[n]);
    }

    private static void union(int a, int b) {
        int f_a = find(a);
        int f_b = find(b);

        if (f_a != f_b) {
            graph[f_b] = f_a;
        }
    }
}
