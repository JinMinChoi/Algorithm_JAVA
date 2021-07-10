package backjoon.level.numbertheory;


import java.util.Scanner;

public class Q11051 {

    private static int[][] memo;
    private static final int NUM = 10_007;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();

        memo = new int[1001][1001];

        for (int i = 0; i <= n; i++) {
            memo[i][0] = 1;
            memo[i][i] = 1;
        }

        for (int i = 2; i <= n; i++) {
            for (int j = 0; j <= i; j++) {
                if (i == j || j == 0) {
                    memo[i][j] = 1;
                } else {
                    memo[i][j] = memo[i-1][j] + memo[i-1][j-1];
                }

                memo[i][j] %= NUM;
            }
        }

        System.out.println(memo[n][k]);
    }
}
