package backjoon.level.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Q9012 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testCase = Integer.parseInt(br.readLine());

        while ((testCase--) > 0) {
            String str = br.readLine();

            System.out.println(vps(str));
        }
    }

    private static String vps(String s) {
        Stack<Character> st = new Stack();

        for (char c : s.toCharArray()) {
            if (c == '(') {
                st.push(c);
            } else {
                if (st.isEmpty()) return "NO";

                if (st.peek() == '(') st.pop();
            }
        }

        if(!st.isEmpty()) return "NO";

        return "YES";
    }
}
