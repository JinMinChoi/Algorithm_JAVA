package inflearnLecture.question.recursion2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q85 {
    private static int n;
    private static int[] numbers;
    private static int[] oper = new int[4];
    private static int MAX = Integer.MIN_VALUE, MIN = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        numbers = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            oper[i] = Integer.parseInt(st.nextToken());
        }

        dfs(1, numbers[0]);

        System.out.println(MAX + "\n" + MIN);
    }

    private static void dfs(int idx, int sum) {
        if (idx >= n) {
            MAX = Math.max(sum, MAX);
            MIN = Math.min(sum, MIN);
            return;
        }

        for (int i = 0; i < 4; i++) {
            if (oper[i] == 0) continue;

            oper[i]--;
            if (i == 0) {
                dfs(idx + 1, sum + numbers[idx]);
            } else if (i == 1) {
                dfs(idx + 1, sum - numbers[idx]);
            } else if (i == 2) {
                dfs(idx + 1, sum * numbers[idx]);
            } else {
                dfs(idx + 1, sum / numbers[idx]);
            }
            oper[i]++;
        }
    }

}
