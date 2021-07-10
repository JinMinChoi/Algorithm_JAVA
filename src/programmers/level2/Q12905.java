//https://programmers.co.kr/learn/courses/30/lessons/12905
package programmers.level2;

public class Q12905 {
    public static void main(String[] args) {

        int[][] arr = {
                {0}
        };

        System.out.println(solution(arr));
    }

    static int[][] dp;

    static int solution(int[][] board) {
        int answer = 0;

        int n = board.length;
        int m = board[0].length;

        dp = new int[n][m];

        for (int i = 0; i < n; i++) {
            dp[i][0] = board[i][0];
        }

        for (int j = 0; j < m; j++) {
            dp[0][j] = board[0][j];
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (board[i][j] == 1) {
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j - 1], dp[i - 1][j]), dp[i][j - 1]) + 1;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                answer = Math.max(answer, dp[i][j]);
            }
        }
        return answer * answer;
    }
}
