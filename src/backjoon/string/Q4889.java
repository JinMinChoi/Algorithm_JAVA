package backjoon.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Q4889 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int idx = 1;

        while (true) {
            String s = br.readLine();
            if (s.contains("-")) break;

            int cnt = 0;
            Stack<Character> stack = new Stack<>();

            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (c == '{') {
                    stack.push(c);
                } else {
                    if (stack.isEmpty()) {
                        stack.push('{');
                        cnt++;
                    } else {
                        stack.pop();
                    }
                }
            }

            System.out.println((idx++) + ". " + (cnt + (stack.size() / 2)));
        }
    }
}