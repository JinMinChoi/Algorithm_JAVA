package level.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q2156 {
    private static final int MAX = 10_001;
    private static int[] arr = new int[MAX];
    private static int[] dp = new int[MAX];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        if (n == 1) dp[n] = arr[n];
        else if (n == 2) dp[n] = arr[n] + arr[n - 1];
        else {
            dp[1] = arr[1];
            dp[2] = arr[2] + arr[1];
            dp[3] = Math.max(dp[2], Math.max(arr[2], arr[1]) + arr[3]);
            for (int i = 4; i <= n; i++) {
                dp[i] = Math.max(dp[i - 1], Math.max(dp[i - 2], dp[i - 3] + arr[i - 1]) + arr[i]);
            }
        }

        System.out.println(dp[n]);
    }
}
