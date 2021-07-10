//https://www.acmicpc.net/problem/3986
package backjoon.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Q3986 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int cnt = 0;

        while ((n--) > 0) {
            String str = br.readLine();

            Stack<Character> st = new Stack<>();

            for (int i = 0; i < str.length(); i++) {
                char ab = str.charAt(i);

                if (st.isEmpty()) {
                    st.add(ab);
                } else {
                    if (st.peek() == ab) {
                        st.pop();
                    } else {
                        st.add(ab);
                    }
                }
            }

            if (st.isEmpty()) cnt++;
        }

        System.out.println(cnt);
    }
}
