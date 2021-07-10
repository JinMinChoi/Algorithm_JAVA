package backjoon.level.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q15649 {
    /**
     * 조합
     */
    private static int n, m;
    private static int arr[];
    private static boolean visit[];
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[m];
        visit = new boolean[n];
        backtracking(0);

        System.out.println(sb.toString());
    }

    private static void backtracking(int depth) {
        if (depth == m) {
            //끝에 다다랐을 때, 출력.
            for (int num : arr) {
                sb.append(num).append(" ");
            }
            sb.append('\n');
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!visit[i]) {
                visit[i] = true;
                arr[depth] = i + 1;
                backtracking(depth + 1);
                visit[i] = false;
            }
        }
    }
}
