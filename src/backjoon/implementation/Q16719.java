package backjoon.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q16719 {
    private static boolean[] visit;
    private static StringBuilder answer = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        visit = new boolean[str.length()];

        bfs(0, str.length() - 1, str);

        System.out.println(answer.toString());
    }

    private static void bfs(int left, int right, String str) {
        if (left > right) return;

        int minIdx = left;

        for (int i = left; i <= right; i++) {
            if (str.charAt(minIdx) > str.charAt(i)) {
                minIdx = i;
            }
        }

        visit[minIdx] = true;

        for (int i = 0; i < str.length(); i++) {
            if (visit[i]) {
                answer.append(str.charAt(i));
            }
        }
        answer.append("\n");

        bfs(minIdx + 1, right, str);
        bfs(left, minIdx - 1, str);
    }
}
