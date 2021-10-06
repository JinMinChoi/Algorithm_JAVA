//https://www.acmicpc.net/problem/12904
package backjoon.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q12904 {
    private static String s, t;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        s = br.readLine();
        t = br.readLine();

        int answer = 0;

        while (t.length() > 0) {
            if (t.charAt(t.length() - 1) == 'B') {
                t = t.substring(0, t.length() - 1);
                t = reverse(t);
            } else {
                t = t.substring(0, t.length() - 1);
            }

            if(t.equals(s)) answer = 1;
        }

        System.out.println(answer);
    }

    private static String reverse(String s) {
        int len = s.length();
        StringBuilder sb = new StringBuilder();
        for (int i = len - 1; i >= 0; --i) {
            sb.append(s.charAt(i));
        }

        return sb.toString();
    }
}
