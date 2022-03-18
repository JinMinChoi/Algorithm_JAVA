package backjoon.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q21737 {
    private static long answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String s = br.readLine();
        StringBuilder ans = new StringBuilder();
        StringBuilder temp = new StringBuilder();

        char op = 'P';
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (isNum(c)) {
                temp.append(c);
            } else {
                calc(Integer.parseInt(temp.toString()), op);
                op = c;
                if (c == 'C') {
                    ans.append(answer + " ");
                } else {
                    temp = new StringBuilder();
                }
            }
        }

        if (ans.length() == 0) {
            System.out.println("NO OUTPUT");
        } else {
            System.out.println(ans);
        }
    }

    private static void calc(int n, char op) {
        if (op == 'P') {
            answer += n;
        } else if (op == 'S') {
            answer -= n;
        } else if (op == 'M') {
            answer *= n;
        } else if (op == 'U') {
            answer /= n;
        }
        return;
    }

    private static boolean isNum(char c) {
        return c >= '0' && c <= '9';
    }
}
