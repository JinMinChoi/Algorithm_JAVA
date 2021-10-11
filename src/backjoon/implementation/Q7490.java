//https://www.acmicpc.net/problem/7490
package backjoon.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q7490 {
    private static int n;
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());

        while ((tc--) > 0) {
            n = Integer.parseInt(br.readLine());
            dfs(1, 0, 1, 1, "1");
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }

    private static void dfs(int depth, int sum, int num, int sign, String str) {
        if (depth == n) {
            sum += (num * sign);
            if (sum == 0) {
                sb.append(str + "\n");
            }
            return;
        }

        dfs(depth + 1, sum, num * 10 + (depth + 1), sign, str + " " + (depth + 1));
        dfs(depth + 1, sum + (sign * num), depth + 1, 1, str + "+" + (depth + 1));
        dfs(depth + 1, sum + (sign * num), depth + 1, -1, str + "-" + (depth + 1));

    }
}
