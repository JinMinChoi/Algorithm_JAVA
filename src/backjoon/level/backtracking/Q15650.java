package level.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q15650 {
    /**
     * 순열
     */
    private static int n, m;
    private static int[] arr;
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[m];

        backtracking(0, 0);
        System.out.println(sb.toString());
    }

    private static void backtracking(int curPoint, int depth) {
        if (depth == m) {
            for (int num : arr) {
                sb.append(num).append(" ");
            }
            sb.append('\n');
            return;
        }

        for (int i = curPoint; i < n; i++) {
            arr[depth] = i + 1;
            backtracking(i + 1, depth + 1);
        }
    }
}
