package backjoon.level.dp;


import java.util.Scanner;

public class Q1463 {
    private static final int MAX = 1_000_001;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] dp = new int[MAX];

        dp[1] = 0;

        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + 1;
            if (i % 2 == 0) dp[i] = Math.min(dp[i / 2] + 1, dp[i]);
            if (i % 3 == 0) dp[i] = Math.min(dp[i / 3] + 1, dp[i]);
        }

        System.out.println(dp[n]);
    }
}
