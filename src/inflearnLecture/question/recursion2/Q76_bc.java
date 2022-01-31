package inflearnLecture.question.recursion2;

import java.util.Scanner;

public class Q76_bc {
    private static int[][] dp;
    private static int[][] dpBottomUp;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int r = sc.nextInt();


        int firstAns = factorial(n) / (factorial(n - r) * factorial(r));

        int secondAns = bc(n, r);

        dp = new int[n + 1][r + 1];
        int thirdAns = topDown(n, r);

        int forthAns = bottomUp(n, r);
        System.out.println(forthAns);
    }

    //팩토리얼
    private static int factorial(int n) {
        if (n == 0) {
            return 1;
        }
        return n * factorial(n - 1);
    }

    //이항계수 성질
    private static int bc(int n, int r) {
        if (n == r || r == 0) {
            return 1;
        }

        return bc(n - 1, r - 1) + bc(n - 1, r);
    }

    //이항계수 성질과 동적 계획법
    //top-down = 메모이제이션 + 재귀
    private static int topDown(int n, int r) {
        if (dp[n][r] > 0) {
            return dp[n][r];
        }

        if (n == r || r == 0) {
            dp[n][r] = 1;
        }

        return dp[n][r] = bc(n - 1, r - 1) + bc(n - 1, r);
    }

    //bottom-up = 초기화
    private static int bottomUp(int n, int r) {
        dpBottomUp = new int[n + 1][r + 1];

        for (int i = 0; i <= r; i++) {
            dpBottomUp[i][i] = 1;
        }

        for (int i = 0; i <= n; i++) {
            dpBottomUp[i][0] = 1;
        }

        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= r; j++) {
                dpBottomUp[i][j] = dpBottomUp[i - 1][j - 1] + dpBottomUp[i - 1][j];
            }
        }

        return dpBottomUp[n][r];
    }
}
