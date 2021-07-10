package backjoon.level.dp;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q9251 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String a = br.readLine();
        String b = br.readLine();

        int lengthOfA = a.length();
        int lengthOfB = b.length();

        int[][] dp = new int[lengthOfA + 1][lengthOfB + 1];

        for (int i = 1; i <= lengthOfA; i++) {
            for (int j = 1; j <= lengthOfB; j++) {
                if (a.charAt(i - 1) == b.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        System.out.println(dp[lengthOfA][lengthOfB]);
    }
}
