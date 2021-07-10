//https://programmers.co.kr/learn/courses/30/lessons/12913
package programmers.level2;

public class Q12913 {

    static int[][] dp;

    public static void main(String[] args) {
        int[][] land = {
                {1, 2, 3, 5},
                {5, 6, 7, 8},
                {4, 3, 2, 1}
        };

        System.out.println(solution(land));
    }

    static int solution(int[][] land) {
        int answer = 0;

        int iSize = land.length;
        int jSize = land[0].length;

        dp = new int[iSize][jSize];

        for (int j = 0; j < jSize; j++) {
            dp[0][j] = land[0][j];
        }

        for (int i = 1; i < iSize; i++) {
            dp[i][0] = land[i][0] + Math.max(Math.max(dp[i - 1][1], dp[i - 1][2]), dp[i - 1][3]);
            dp[i][1] = land[i][1] + Math.max(Math.max(dp[i - 1][0], dp[i - 1][2]), dp[i - 1][3]);
            dp[i][2] = land[i][2] + Math.max(Math.max(dp[i - 1][0], dp[i - 1][1]), dp[i - 1][3]);
            dp[i][3] = land[i][3] + Math.max(Math.max(dp[i - 1][0], dp[i - 1][1]), dp[i - 1][2]);
        }

        for (int j = 0; j < jSize; j++) {
            answer = Math.max(answer, dp[iSize - 1][j]);
        }

        return answer;
    }
}
