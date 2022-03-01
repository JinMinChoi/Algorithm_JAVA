package backjoon.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q12919 {
    private static String s, t;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        s = br.readLine();
        t = br.readLine();

        System.out.println(dfs(s, t));
    }

    private static int dfs(String s, String t) {
        if (s.length() == t.length()) {
            if (s.equals(t)) {
                return 1;
            }
            return 0;
        }

        int ans = 0;

        if (t.charAt(t.length() - 1) == 'A') {
            ans += dfs(s, t.substring(0, t.length() - 1));
        }

        if (t.charAt(0) == 'B') {
            String newStr = new StringBuilder(t.substring(1, t.length())).reverse().toString();
            ans += dfs(s, newStr);
        }

        return ans > 0 ? 1 : 0;
    }
}
